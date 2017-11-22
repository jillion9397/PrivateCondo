package privatecondo.view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author January
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        jPanelHeadMenu.setVisible(true);
        jLabelRoomSV.setVisible(false);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(true);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(true);
        jPanelRoomSV.setVisible(false);
        jPanelReportProList.setVisible(false);
        jPanelSelectRoomSV.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPrivateCondo = new javax.swing.JPanel();
        jPanelHeadMenu = new javax.swing.JPanel();
        jLabelHome = new javax.swing.JLabel();
        jLabelUserProfile = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelReportList = new javax.swing.JLabel();
        jLabelReport1 = new javax.swing.JLabel();
        jLabelRoomSV = new javax.swing.JLabel();
        jPanelLeftMenu = new javax.swing.JPanel();
        jButtonRoomService = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jButtonReport = new javax.swing.JButton();
        user = new javax.swing.JPanel();
        jPanelSelectRoomSV = new javax.swing.JPanel();
        jButtonPreviousToRoomSV = new javax.swing.JButton();
        jPanelRoomSV = new javax.swing.JPanel();
        jLabelTime = new javax.swing.JLabel();
        jComboBoxDate = new javax.swing.JComboBox<>();
        jLabelDate = new javax.swing.JLabel();
        jComboBoxTime = new javax.swing.JComboBox<>();
        jButtonSelect = new javax.swing.JButton();
        jPanelNewsHome = new javax.swing.JPanel();
        jPanelReport = new javax.swing.JPanel();
        jLabelReportDescription = new javax.swing.JLabel();
        jLabelReportTopic = new javax.swing.JLabel();
        jTextFieldTopic = new javax.swing.JTextField();
        jScrollPaneReportDes = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonListReport = new javax.swing.JButton();
        jButtonSendReport = new javax.swing.JButton();
        jPanelReportProList = new javax.swing.JPanel();
        adminPrivateCondo = new javax.swing.JPanel();
        jPanelLeftMenuAdmin = new javax.swing.JPanel();
        jButtonRoomService1 = new javax.swing.JButton();
        jButtonHome1 = new javax.swing.JButton();
        jButtonReport1 = new javax.swing.JButton();
        jPanelHeadMenuAdmin = new javax.swing.JPanel();
        jLabelUserProfileAdmin = new javax.swing.JLabel();
        jButtonLogoutAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userPrivateCondo.setBackground(new java.awt.Color(130, 187, 178));
        userPrivateCondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeadMenu.setBackground(new java.awt.Color(28, 107, 114));
        jPanelHeadMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHome.setFont(new java.awt.Font("Quark", 1, 36)); // NOI18N
        jLabelHome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHome.setText("HOME");
        jPanelHeadMenu.add(jLabelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabelUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/profile-user.png"))); // NOI18N
        jPanelHeadMenu.add(jLabelUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jButton1.setFont(new java.awt.Font("Quark", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(234, 216, 106));
        jButton1.setText("LOGOUT");
        jButton1.setContentAreaFilled(false);
        jPanelHeadMenu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jLabelReportList.setFont(new java.awt.Font("Quark", 1, 36)); // NOI18N
        jLabelReportList.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReportList.setText("Problems List");
        jPanelHeadMenu.add(jLabelReportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabelReport1.setFont(new java.awt.Font("Quark", 1, 36)); // NOI18N
        jLabelReport1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReport1.setText("Report");
        jPanelHeadMenu.add(jLabelReport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabelRoomSV.setFont(new java.awt.Font("Quark", 1, 36)); // NOI18N
        jLabelRoomSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRoomSV.setText("Room Service");
        jPanelHeadMenu.add(jLabelRoomSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        userPrivateCondo.add(jPanelHeadMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 550, 120));

        jPanelLeftMenu.setBackground(new java.awt.Color(43, 64, 57));
        jPanelLeftMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRoomService.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonRoomService.setForeground(new java.awt.Color(234, 216, 106));
        jButtonRoomService.setText("Room Service");
        jButtonRoomService.setContentAreaFilled(false);
        jButtonRoomService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoomServiceActionPerformed(evt);
            }
        });
        jPanelLeftMenu.add(jButtonRoomService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 40));

        jButtonHome.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonHome.setForeground(new java.awt.Color(234, 216, 106));
        jButtonHome.setText("Home");
        jButtonHome.setContentAreaFilled(false);
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });
        jPanelLeftMenu.add(jButtonHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, 40));

        jButtonReport.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonReport.setForeground(new java.awt.Color(234, 216, 106));
        jButtonReport.setText("Report");
        jButtonReport.setContentAreaFilled(false);
        jButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportActionPerformed(evt);
            }
        });
        jPanelLeftMenu.add(jButtonReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 40));

        userPrivateCondo.add(jPanelLeftMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 490));

        user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSelectRoomSV.setBackground(new java.awt.Color(130, 187, 178));
        jPanelSelectRoomSV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPreviousToRoomSV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPreviousToRoomSV.setForeground(new java.awt.Color(51, 51, 51));
        jButtonPreviousToRoomSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/previous.png"))); // NOI18N
        jButtonPreviousToRoomSV.setText("Previous");
        jButtonPreviousToRoomSV.setContentAreaFilled(false);
        jButtonPreviousToRoomSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousToRoomSVActionPerformed(evt);
            }
        });
        jPanelSelectRoomSV.add(jButtonPreviousToRoomSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        user.add(jPanelSelectRoomSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        jPanelRoomSV.setBackground(new java.awt.Color(130, 187, 178));
        jPanelRoomSV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTime.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabelTime.setText("Select Time");
        jPanelRoomSV.add(jLabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jComboBoxDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelRoomSV.add(jComboBoxDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 240, 30));

        jLabelDate.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabelDate.setText("Select Day");
        jPanelRoomSV.add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jComboBoxTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelRoomSV.add(jComboBoxTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 240, 30));

        jButtonSelect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSelect.setText("Select");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });
        jPanelRoomSV.add(jButtonSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 130, 30));

        user.add(jPanelRoomSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        jPanelNewsHome.setBackground(new java.awt.Color(130, 187, 178));
        jPanelNewsHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        user.add(jPanelNewsHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        jPanelReport.setBackground(new java.awt.Color(130, 187, 178));
        jPanelReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelReportDescription.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelReportDescription.setForeground(new java.awt.Color(43, 64, 57));
        jLabelReportDescription.setText("Description");
        jPanelReport.add(jLabelReportDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabelReportTopic.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelReportTopic.setForeground(new java.awt.Color(43, 64, 57));
        jLabelReportTopic.setText("Topic");
        jPanelReport.add(jLabelReportTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jTextFieldTopic.setText("Insert your head report");
        jPanelReport.add(jTextFieldTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 350, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPaneReportDes.setViewportView(jTextArea1);

        jPanelReport.add(jScrollPaneReportDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 350, 210));

        jButtonListReport.setBackground(new java.awt.Color(43, 64, 57));
        jButtonListReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonListReport.setText("Problems List");
        jButtonListReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListReportActionPerformed(evt);
            }
        });
        jPanelReport.add(jButtonListReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jButtonSendReport.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSendReport.setText("Send");
        jPanelReport.add(jButtonSendReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 110, 30));

        user.add(jPanelReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        jPanelReportProList.setBackground(new java.awt.Color(130, 187, 178));
        jPanelReportProList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        user.add(jPanelReportProList, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        userPrivateCondo.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        getContentPane().add(userPrivateCondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        adminPrivateCondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLeftMenuAdmin.setBackground(new java.awt.Color(43, 64, 57));
        jPanelLeftMenuAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRoomService1.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonRoomService1.setForeground(new java.awt.Color(234, 216, 106));
        jButtonRoomService1.setText("Room Service");
        jButtonRoomService1.setContentAreaFilled(false);
        jButtonRoomService1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoomService1ActionPerformed(evt);
            }
        });
        jPanelLeftMenuAdmin.add(jButtonRoomService1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 40));

        jButtonHome1.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonHome1.setForeground(new java.awt.Color(234, 216, 106));
        jButtonHome1.setText("Home");
        jButtonHome1.setContentAreaFilled(false);
        jButtonHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHome1ActionPerformed(evt);
            }
        });
        jPanelLeftMenuAdmin.add(jButtonHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, 40));

        jButtonReport1.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonReport1.setForeground(new java.awt.Color(234, 216, 106));
        jButtonReport1.setText("Report");
        jButtonReport1.setContentAreaFilled(false);
        jButtonReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReport1ActionPerformed(evt);
            }
        });
        jPanelLeftMenuAdmin.add(jButtonReport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 40));

        adminPrivateCondo.add(jPanelLeftMenuAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 490));

        jPanelHeadMenuAdmin.setBackground(new java.awt.Color(28, 107, 114));
        jPanelHeadMenuAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUserProfileAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/profile-user.png"))); // NOI18N
        jPanelHeadMenuAdmin.add(jLabelUserProfileAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jButtonLogoutAdmin.setFont(new java.awt.Font("Quark", 1, 12)); // NOI18N
        jButtonLogoutAdmin.setForeground(new java.awt.Color(234, 216, 106));
        jButtonLogoutAdmin.setText("LOGOUT");
        jButtonLogoutAdmin.setContentAreaFilled(false);
        jPanelHeadMenuAdmin.add(jButtonLogoutAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        adminPrivateCondo.add(jPanelHeadMenuAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 550, 120));

        getContentPane().add(adminPrivateCondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        // TODO add your handling code here:
        jPanelSelectRoomSV.setVisible(true);
        jPanelHeadMenu.setVisible(true);
        jLabelRoomSV.setVisible(true);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(false);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(false);
        jPanelRoomSV.setVisible(false);
        jPanelReportProList.setVisible(false);
    }//GEN-LAST:event_jButtonSelectActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        // TODO add your handling code here:
        jPanelHeadMenu.setVisible(true);
        jLabelRoomSV.setVisible(false);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(true);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(true);
        jPanelRoomSV.setVisible(false);
        jPanelReportProList.setVisible(false);
        jPanelSelectRoomSV.setVisible(false);
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportActionPerformed
        // TODO add your handling code here:
        jLabelRoomSV.setVisible(false);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(true);
        jLabelHome.setVisible(false);
        jPanelReport.setVisible(true);
        jPanelNewsHome.setVisible(false);
        jPanelRoomSV.setVisible(false);
        jPanelReportProList.setVisible(false);
        jPanelSelectRoomSV.setVisible(false);
    }//GEN-LAST:event_jButtonReportActionPerformed

    private void jButtonRoomServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoomServiceActionPerformed
        // TODO add your handling code here:
        jLabelRoomSV.setVisible(true);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(false);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(false);
        jPanelRoomSV.setVisible(true);
        jPanelReportProList.setVisible(false);
        jPanelSelectRoomSV.setVisible(false);
    }//GEN-LAST:event_jButtonRoomServiceActionPerformed

    private void jButtonListReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListReportActionPerformed
        // TODO add your handling code here:
        jLabelRoomSV.setVisible(false);
        jLabelReportList.setVisible(true);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(false);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(false);
        jPanelRoomSV.setVisible(false);
        jPanelReportProList.setVisible(true);
        jPanelSelectRoomSV.setVisible(false);
    }//GEN-LAST:event_jButtonListReportActionPerformed

    private void jButtonRoomService1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoomService1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRoomService1ActionPerformed

    private void jButtonHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHome1ActionPerformed

    private void jButtonReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReport1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReport1ActionPerformed

    private void jButtonPreviousToRoomSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousToRoomSVActionPerformed
        // TODO add your handling code here:
        jLabelRoomSV.setVisible(true);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(false);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(false);
        jPanelRoomSV.setVisible(true);
        jPanelReportProList.setVisible(false);
        jPanelSelectRoomSV.setVisible(false);
    }//GEN-LAST:event_jButtonPreviousToRoomSVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPrivateCondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonHome1;
    private javax.swing.JButton jButtonListReport;
    private javax.swing.JButton jButtonLogoutAdmin;
    private javax.swing.JButton jButtonPreviousToRoomSV;
    private javax.swing.JButton jButtonReport;
    private javax.swing.JButton jButtonReport1;
    private javax.swing.JButton jButtonRoomService;
    private javax.swing.JButton jButtonRoomService1;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonSendReport;
    private javax.swing.JComboBox<String> jComboBoxDate;
    private javax.swing.JComboBox<String> jComboBoxTime;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelReport1;
    private javax.swing.JLabel jLabelReportDescription;
    private javax.swing.JLabel jLabelReportList;
    private javax.swing.JLabel jLabelReportTopic;
    private javax.swing.JLabel jLabelRoomSV;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelUserProfile;
    private javax.swing.JLabel jLabelUserProfileAdmin;
    private javax.swing.JPanel jPanelHeadMenu;
    private javax.swing.JPanel jPanelHeadMenuAdmin;
    private javax.swing.JPanel jPanelLeftMenu;
    private javax.swing.JPanel jPanelLeftMenuAdmin;
    private javax.swing.JPanel jPanelNewsHome;
    private javax.swing.JPanel jPanelReport;
    private javax.swing.JPanel jPanelReportProList;
    private javax.swing.JPanel jPanelRoomSV;
    private javax.swing.JPanel jPanelSelectRoomSV;
    private javax.swing.JScrollPane jScrollPaneReportDes;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldTopic;
    private javax.swing.JPanel user;
    private javax.swing.JPanel userPrivateCondo;
    // End of variables declaration//GEN-END:variables
}
