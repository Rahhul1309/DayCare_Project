package edu.neu.csye6200;

import edu.neu.csye6200.controller.StudentController;
import edu.neu.csye6200.controller.TeacherController;
import edu.neu.csye6200.controller.VaccinationController;
import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.service.ClassroomFactory;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClassesPanel extends javax.swing.JPanel {

    @Autowired
    TeacherController teacherController;
    @Autowired
    StudentController studentController;
    @Autowired
    VaccinationController vaccinationController;
    @Autowired
    ClassroomFactory classroomFactory;
    
    public ClassesPanel() {
        initComponents();
        populateClassesInfo();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableClassroom = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(800, 720));

        jLabel3.setBackground(new java.awt.Color(153, 255, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tableClassroom.setBackground(new java.awt.Color(204, 255, 204));
        tableClassroom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableClassroom.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableClassroom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class ID", "Age Group", "Teachers", "Students"
            }
        ));
        tableClassroom.setRowHeight(25);
        jScrollPane4.setViewportView(tableClassroom);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("CLASSES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void populateClassesInfo(){
        List<ClassRoom> clsrooms = classroomFactory.readAllClassRooms();
            DefaultTableModel model = (DefaultTableModel) tableClassroom.getModel();
            model.setRowCount(0);
            
            clsrooms.forEach(t -> {
                            model.addRow(new Object[]{t.getClassId(), t.getMin_age()+"-"+t.getMax_age(), Arrays.toString(t.getTeacherIdList().toArray()), Arrays.toString(t.getStudentIdList().toArray())});
                        });
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableClassroom;
    // End of variables declaration//GEN-END:variables
}
