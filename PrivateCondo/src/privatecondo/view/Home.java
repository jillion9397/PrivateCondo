package privatecondo.view;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import privatecondo.controller.ComboBoxStatusActionListener;
import privatecondo.model.DBManagement;
import privatecondo.model.News;
import privatecondo.model.Problem;
import privatecondo.model.User;

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

    private User activeUser;
    private DBManagement dbm;
    private int cb = 0;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        homePrivateCondo.setVisible(true);
        adminPrivateCondo.setVisible(false);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelHeadMenu.setVisible(false);
        jLabelRoomSV.setVisible(false);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(false);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(false);
        jPanelRoomSV.setVisible(false);
        jPanelReportProList.setVisible(false);
        jPanelSelectRoomSV.setVisible(false);
        dbm = new DBManagement();
    }

    public void tableNewUser(ArrayList<News> news) {
        JPanel[] jPanelNewList = new JPanel[news.size()];
        JLabel[] jLabelTopicNew = new JLabel[news.size()];
        JLabel[] jLabelDetailNew = new JLabel[news.size()];
        JLabel[] jLabelPicSetting = new JLabel[news.size()];
        int y = 20;

        for (int i = 0; i < news.size(); i++) {
            jPanelNewList[i] = new JPanel();
            jPanelNewList[i].setBackground(new java.awt.Color(255, 255, 255));
            jPanelNewList[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabelDetailNew[i] = new JLabel();
            jLabelDetailNew[i].setFont(new java.awt.Font("Leelawadee", 0, 12));
            jLabelDetailNew[i].setForeground(new java.awt.Color(71, 82, 94));
            jLabelDetailNew[i].setText(news.get(i).getDescription());
            jPanelNewList[i].add(jLabelDetailNew[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 450, 50));

            jLabelTopicNew[i] = new JLabel();
            jLabelTopicNew[i].setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
            jLabelTopicNew[i].setForeground(new java.awt.Color(71, 82, 94));
            jLabelTopicNew[i].setText(news.get(i).getTopic());
            jPanelNewList[i].add(jLabelTopicNew[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 380, 20));

            jLabelPicSetting[i] = new JLabel();
            jLabelPicSetting[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/002-settings.png"))); // NOI18N
            jPanelNewList[i].add(jLabelPicSetting[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

            jPanelDynamicNewUser.add(jPanelNewList[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, y, 500, 100));
            y += 120;

            jPanelNewsHome.add(jScrollPaneNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));
        }
        jScrollPaneNewUser.setViewportView(jPanelDynamicNewUser);
    }

    public void tableListNewsAdmin(ArrayList<News> news) {

        JPanel[] jPanelListsNewAdmin = new JPanel[news.size()];
        JLabel[] jLabelTopicNewAdmin = new JLabel[news.size()];
        JTextArea[] jTextAreaDetailNewAdmin = new JTextArea[news.size()];
        JLabel[] jLabelPicSettingAdmin = new JLabel[news.size()];
        JButton[] jButtonEditNewsAdmin = new JButton[news.size()];
        JScrollPane[] jScrollPaneTextFile = new JScrollPane[news.size()];
        JButton[] jButtonDeleteNewsAdmin = new JButton[news.size()];
        int y = 20;

        for (int i = 0; i < news.size(); i++) {
            News n = new News();

            jPanelListsNewAdmin[i] = new JPanel();
            jPanelListsNewAdmin[i].setBackground(new java.awt.Color(255, 255, 255));
            jPanelListsNewAdmin[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabelPicSettingAdmin[i] = new JLabel();
            jLabelPicSettingAdmin[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/002-settings.png"))); // NOI18N
            jPanelListsNewAdmin[i].add(jLabelPicSettingAdmin[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

            jLabelTopicNewAdmin[i] = new JLabel();
            jLabelTopicNewAdmin[i].setText(news.get(i).getTopic());
            jLabelTopicNewAdmin[i].setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
            jLabelTopicNewAdmin[i].setForeground(new java.awt.Color(71, 82, 94));
            jPanelListsNewAdmin[i].add(jLabelTopicNewAdmin[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 400, 30));

            jTextAreaDetailNewAdmin[i] = new JTextArea();
            jTextAreaDetailNewAdmin[i].setText(news.get(i).getDescription());
            jTextAreaDetailNewAdmin[i].setEditable(false);
            jTextAreaDetailNewAdmin[i].setColumns(20);
            jTextAreaDetailNewAdmin[i].setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
            jTextAreaDetailNewAdmin[i].setForeground(new java.awt.Color(71, 82, 94));
            jTextAreaDetailNewAdmin[i].setRows(5);
            jTextAreaDetailNewAdmin[i].setAutoscrolls(false);

            jScrollPaneTextFile[i] = new JScrollPane();
            jScrollPaneTextFile[i].setViewportView(jTextAreaDetailNewAdmin[i]);

            jPanelListsNewAdmin[i].add(jScrollPaneTextFile[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 400, 60));

            jButtonEditNewsAdmin[i] = new JButton();
            jButtonEditNewsAdmin[i].setText("Edit");
            jPanelListsNewAdmin[i].add(jButtonEditNewsAdmin[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));
            jButtonEditNewsAdmin[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    setPanel();
                    editNews(n);
                }
            });

            jButtonDeleteNewsAdmin[i] = new JButton();
            jButtonDeleteNewsAdmin[i].setText("Delete");
            jPanelListsNewAdmin[i].add(jButtonDeleteNewsAdmin[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));
            jButtonDeleteNewsAdmin[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteNews(n);
                }
            });

            n.setTopic(news.get(i).getTopic());
            n.setDescription(news.get(i).getDescription());
            n.setAnnounceDate(news.get(i).getAnnounceDate());
            n.setNewsId(news.get(i).getNewsId());

            jPanelListNewsAdmin.add(jPanelListsNewAdmin[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, y, 500, 140));
            y += 160;
            jPanelNewAdmin.add(jScrollPaneNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 320));
        }
        jScrollPaneNewAdmin.setViewportView(jPanelListNewsAdmin);
    }

    public void deleteNews(News news) {
        jTextFieldDeleteTopicNew.setText(news.getTopic());
        jTextAreaNewsContentNew.setText(news.getDescription());
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(false);
        jPanelAddNew.setVisible(false);
        jPanelNewAdmin.setVisible(false);
        jPanelDeleteNews.setVisible(true);
        jPanelReportAdmin.setVisible(false);
        jPanelRoomServiceAdmin.setVisible(false);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(false);
        jLabelAddNew.setVisible(false);
        jLabelDeleteNew.setVisible(true);
        jLabelEditNew.setVisible(false);
        jLabelReport.setVisible(false);
        jLabelRoomSVadmin.setVisible(false);

        jButtonDeleteConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    dbm.createConnection();
                    dbm.deleteNews(news);
                    dbm.disconnect();

                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void editNews(News news) {
        jTextFieldEditTopicNew.setText(news.getTopic());
        jTextAreaEditContentNew.setText(news.getDescription());

        jButtonEditNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    dbm.createConnection();
                    news.setTopic(jTextFieldEditTopicNew.getText());

                    news.setDescription(jTextAreaEditContentNew.getText());

                    System.out.println(news.toString());
                    dbm.editNews(news);
                    dbm.disconnect();

                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void setPanel() {
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(true);
        jPanelAddNew.setVisible(false);
        jPanelNewAdmin.setVisible(false);
        jPanelDeleteNews.setVisible(false);
        jPanelReportAdmin.setVisible(false);
        jPanelRoomServiceAdmin.setVisible(false);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(false);
        jLabelAddNew.setVisible(false);
        jLabelDeleteNew.setVisible(false);
        jLabelEditNew.setVisible(true);
        jLabelReport.setVisible(false);
        jLabelRoomSVadmin.setVisible(false);
        userNameAdmin.setText(activeUser.getFname());
    }

    public void tableListReportForUser(ArrayList<Problem> p) {
        JPanel[] jPanelListProblemSmall = new JPanel[p.size()];
        JLabel[] jLabelDetailProblem = new JLabel[p.size()];
        int y = 20;

        for (int i = 0; i < p.size(); i++) {
            jPanelListProblemSmall[i] = new JPanel();
            jPanelListProblemSmall[i].setBackground(new java.awt.Color(255, 255, 255));
            jPanelListProblemSmall[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabelDetailProblem[i] = new JLabel();
            jLabelDetailProblem[i].setText("<html><body>" + "Topic: " + p.get(i).getTopic() + "<br>" + "Description: "
                    + p.get(i).getDescription() + "<br>" + "Stutus: " + p.get(i).getStatusTypeStr() + "</body></html>");
            jLabelDetailProblem[i].setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
            jPanelListProblemSmall[i].add(jLabelDetailProblem[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 5, 510, 80));

            jPanelListProblem.add(jPanelListProblemSmall[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10, y, 510, 90));
            y += 70;
            jPanelReportProList.add(jScrollPaneListProblem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 330));
        }
        jScrollPaneListProblem.setViewportView(jPanelListProblem);
    }

    public int getCb() {
        return cb;
    }

    public void setCb(int cb) {
        this.cb = cb;
    }

    public void tableReportListAdmin(ArrayList<Problem> p) {

        JPanel[] jPanelListReportSmall = new JPanel[p.size()];
        JLabel[] jLabelDetailReport = new JLabel[p.size()];
        JLabel[] jLabelStatus = new JLabel[p.size()];
        JComboBox[] jComboBoxStatus = new JComboBox[p.size()];
        JButton[] jButtonSave = new JButton[p.size()];
        int y = 30;

        for (int i = 0; i < p.size(); i++) {
            Problem pro = new Problem();
            jPanelListReportSmall[i] = new JPanel();
            jPanelListReportSmall[i].setBackground(new java.awt.Color(255, 255, 255));
            jPanelListReportSmall[i].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabelDetailReport[i] = new JLabel();
            jLabelDetailReport[i].setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
            jLabelDetailReport[i].setForeground(new java.awt.Color(71, 82, 94));
            String report = new String();
            report = "<html><body>" + p.get(i).getReporter().getFname() + "      วันที่แจ้ง : " + p.get(i).getReportDate()
                    + "<br>Topic: " + p.get(i).getTopic() + "<br>Description: " + p.get(i).getDescription() + "</body></html>";
            jLabelDetailReport[i].setText(report);
            jPanelListReportSmall[i].add(jLabelDetailReport[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 430, 80));

            jLabelStatus[i] = new JLabel();
            jLabelStatus[i].setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
            jLabelStatus[i].setForeground(new java.awt.Color(71, 82, 94));
            jLabelStatus[i].setText("Status : ");
            jPanelListReportSmall[i].add(jLabelStatus[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

            jComboBoxStatus[i] = new JComboBox();
            jComboBoxStatus[i].setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
            jComboBoxStatus[i].setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Not Done", "In Processing", "Done"}));
            jComboBoxStatus[i].setSelectedIndex(p.get(i).getStatusType());
            jComboBoxStatus[i].addActionListener(new ComboBoxStatusActionListener(jComboBoxStatus[i], this));

            jPanelListReportSmall[i].add(jComboBoxStatus[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 210, 30));

            pro.setProblemId(p.get(i).getProblemId());

            jButtonSave[i] = new JButton();
            jButtonSave[i].setText("Save");
            jButtonSave[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    System.out.println("cb: " + cb);
                    try {
                        editStatus(pro, cb);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            jPanelListReportSmall[i].add(jButtonSave[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

            jPanelListReportAdmin.add(jPanelListReportSmall[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(20, y, 480, 160));
            y += 190;
        }
        jScrollPaneReportAdmin.setViewportView(jPanelListReportAdmin);
    }

    private void editStatus(Problem p, int status) throws ClassNotFoundException, SQLException {
        if (status == 0) {
            System.out.println("ไม่สามารถทำได้");
        } else {
            System.out.println(status);
            try {
                // TODO add your handling code here:
                dbm.createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbm.updateStatusProblem(p, status, activeUser.getUserId());
            try {
                dbm.disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminPrivateCondo = new javax.swing.JPanel();
        jPanelLeftMenuAdmin = new javax.swing.JPanel();
        jButtonRoomServiceAdmin = new javax.swing.JButton();
        jButtonHomeAdmin = new javax.swing.JButton();
        jButtonReportAdmin = new javax.swing.JButton();
        jPanelHeadMenuAdmin = new javax.swing.JPanel();
        jLabelUserProfileAdmin = new javax.swing.JLabel();
        jButtonLogoutAdmin = new javax.swing.JButton();
        jLabelNewAdmin = new javax.swing.JLabel();
        jLabelDeleteNew = new javax.swing.JLabel();
        jLabelAddNew = new javax.swing.JLabel();
        jLabelEditNew = new javax.swing.JLabel();
        jLabelReport = new javax.swing.JLabel();
        jLabelRoomSVadmin = new javax.swing.JLabel();
        userTypeAdmin = new javax.swing.JLabel();
        userNameAdmin = new javax.swing.JLabel();
        jPanelAdmin = new javax.swing.JPanel();
        jPanelDeleteNews = new javax.swing.JPanel();
        jLabelDeteteNewTopic = new javax.swing.JLabel();
        jLabelDeleteNewDescription = new javax.swing.JLabel();
        jTextFieldDeleteTopicNew = new javax.swing.JTextField();
        jScrollPaneNewsDes = new javax.swing.JScrollPane();
        jTextAreaNewsContentNew = new javax.swing.JTextArea();
        jButtonDeleteConfirm = new javax.swing.JButton();
        jButtonPreviousToNewAdmin = new javax.swing.JButton();
        jPanelReportAdmin = new javax.swing.JPanel();
        jScrollPaneReportAdmin = new javax.swing.JScrollPane();
        jPanelListReportAdmin = new javax.swing.JPanel();
        jLabelNotDo = new javax.swing.JLabel();
        jLabelCountNotDo = new javax.swing.JLabel();
        jPanelNewAdmin = new javax.swing.JPanel();
        jScrollPaneNewAdmin = new javax.swing.JScrollPane();
        jPanelListNewsAdmin = new javax.swing.JPanel();
        jButtonAddNewsAdmin = new javax.swing.JButton();
        jPanelAddNew = new javax.swing.JPanel();
        jLabelNewDescription = new javax.swing.JLabel();
        jLabelNewTopic = new javax.swing.JLabel();
        jTextFieldTopicNew = new javax.swing.JTextField();
        jScrollPaneReportDes1 = new javax.swing.JScrollPane();
        jTextAreaContentNew = new javax.swing.JTextArea();
        jButtonAddNews = new javax.swing.JButton();
        jPanelEditNew = new javax.swing.JPanel();
        jLabelEditNewTopic = new javax.swing.JLabel();
        jLabelEditNewDescription = new javax.swing.JLabel();
        jTextFieldEditTopicNew = new javax.swing.JTextField();
        jScrollPaneReportDes2 = new javax.swing.JScrollPane();
        jTextAreaEditContentNew = new javax.swing.JTextArea();
        jButtonEditNews = new javax.swing.JButton();
        jButtonPreviousToNews = new javax.swing.JButton();
        jPanelRoomServiceAdmin = new javax.swing.JPanel();
        userPrivateCondo = new javax.swing.JPanel();
        jPanelHeadMenu = new javax.swing.JPanel();
        jLabelHome = new javax.swing.JLabel();
        jLabelUserProfile = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelReportList = new javax.swing.JLabel();
        jLabelReport1 = new javax.swing.JLabel();
        jLabelRoomSV = new javax.swing.JLabel();
        userType = new javax.swing.JLabel();
        userNameUser = new javax.swing.JLabel();
        jPanelLeftMenu = new javax.swing.JPanel();
        jButtonRoomService = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jButtonReport = new javax.swing.JButton();
        user = new javax.swing.JPanel();
        jPanelNewsHome = new javax.swing.JPanel();
        jScrollPaneNewUser = new javax.swing.JScrollPane();
        jPanelDynamicNewUser = new javax.swing.JPanel();
        jPanelReport = new javax.swing.JPanel();
        jLabelReportDescription = new javax.swing.JLabel();
        jLabelReportTopic = new javax.swing.JLabel();
        jTextFieldTopic = new javax.swing.JTextField();
        jScrollPaneReportDes = new javax.swing.JScrollPane();
        jTextAreaDesReport = new javax.swing.JTextArea();
        jButtonListReport = new javax.swing.JButton();
        jButtonSendReport = new javax.swing.JButton();
        jPanelReportProList = new javax.swing.JPanel();
        jScrollPaneListProblem = new javax.swing.JScrollPane();
        jPanelListProblem = new javax.swing.JPanel();
        jPanelRoomSV = new javax.swing.JPanel();
        jLabelTime = new javax.swing.JLabel();
        jComboBoxDate = new javax.swing.JComboBox<>();
        jLabelDate = new javax.swing.JLabel();
        jComboBoxTime = new javax.swing.JComboBox<>();
        jButtonSelect = new javax.swing.JButton();
        jLabelDateSelect = new javax.swing.JLabel();
        jPanelSelectRoomSV = new javax.swing.JPanel();
        jButtonPreviousToRoomSV = new javax.swing.JButton();
        login = new javax.swing.JPanel();
        jPanelLeft = new javax.swing.JPanel();
        jPanelLoginHome = new javax.swing.JPanel();
        signin1 = new javax.swing.JButton();
        jLabelLogin = new javax.swing.JLabel();
        sPassG1 = new javax.swing.JLabel();
        warning1 = new javax.swing.JLabel();
        sEmailB1 = new javax.swing.JLabel();
        sEmailG1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        sPassB1 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        homePrivateCondo = new javax.swing.JPanel();
        jPanelHeadHome = new javax.swing.JPanel();
        jButtonLogin = new javax.swing.JButton();
        jPanelFooter = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelPicCondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminPrivateCondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLeftMenuAdmin.setBackground(new java.awt.Color(43, 64, 57));
        jPanelLeftMenuAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRoomServiceAdmin.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonRoomServiceAdmin.setForeground(new java.awt.Color(234, 216, 106));
        jButtonRoomServiceAdmin.setText("Room Service");
        jButtonRoomServiceAdmin.setContentAreaFilled(false);
        jButtonRoomServiceAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoomServiceAdminActionPerformed(evt);
            }
        });
        jPanelLeftMenuAdmin.add(jButtonRoomServiceAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 40));

        jButtonHomeAdmin.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonHomeAdmin.setForeground(new java.awt.Color(234, 216, 106));
        jButtonHomeAdmin.setText("News");
        jButtonHomeAdmin.setContentAreaFilled(false);
        jButtonHomeAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeAdminActionPerformed(evt);
            }
        });
        jPanelLeftMenuAdmin.add(jButtonHomeAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, 40));

        jButtonReportAdmin.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        jButtonReportAdmin.setForeground(new java.awt.Color(234, 216, 106));
        jButtonReportAdmin.setText("Report");
        jButtonReportAdmin.setContentAreaFilled(false);
        jButtonReportAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportAdminActionPerformed(evt);
            }
        });
        jPanelLeftMenuAdmin.add(jButtonReportAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 40));

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

        jLabelNewAdmin.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabelNewAdmin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNewAdmin.setText("NEWS");
        jPanelHeadMenuAdmin.add(jLabelNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelDeleteNew.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabelDeleteNew.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDeleteNew.setText("DELETE NEWS");
        jPanelHeadMenuAdmin.add(jLabelDeleteNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelAddNew.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabelAddNew.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddNew.setText("ADD NEWS");
        jPanelHeadMenuAdmin.add(jLabelAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelEditNew.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabelEditNew.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEditNew.setText("EDIT NEWS");
        jPanelHeadMenuAdmin.add(jLabelEditNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelReport.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabelReport.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReport.setText("REPORT");
        jPanelHeadMenuAdmin.add(jLabelReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelRoomSVadmin.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabelRoomSVadmin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRoomSVadmin.setText("ROOM SERVICE");
        jPanelHeadMenuAdmin.add(jLabelRoomSVadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        userTypeAdmin.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        userTypeAdmin.setForeground(new java.awt.Color(153, 153, 153));
        userTypeAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userTypeAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelHeadMenuAdmin.add(userTypeAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 140, 30));

        userNameAdmin.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        userNameAdmin.setForeground(new java.awt.Color(255, 255, 255));
        userNameAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userNameAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelHeadMenuAdmin.add(userNameAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 190, 30));

        adminPrivateCondo.add(jPanelHeadMenuAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 550, 120));

        jPanelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDeleteNews.setBackground(new java.awt.Color(130, 187, 178));
        jPanelDeleteNews.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeteteNewTopic.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelDeteteNewTopic.setForeground(new java.awt.Color(43, 64, 57));
        jLabelDeteteNewTopic.setText("Topic");
        jPanelDeleteNews.add(jLabelDeteteNewTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabelDeleteNewDescription.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelDeleteNewDescription.setForeground(new java.awt.Color(43, 64, 57));
        jLabelDeleteNewDescription.setText("Description");
        jPanelDeleteNews.add(jLabelDeleteNewDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        jPanelDeleteNews.add(jTextFieldDeleteTopicNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 350, 30));

        jTextAreaNewsContentNew.setColumns(20);
        jTextAreaNewsContentNew.setRows(5);
        jScrollPaneNewsDes.setViewportView(jTextAreaNewsContentNew);

        jPanelDeleteNews.add(jScrollPaneNewsDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 350, 210));

        jButtonDeleteConfirm.setText("Confirm");
        jPanelDeleteNews.add(jButtonDeleteConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));

        jButtonPreviousToNewAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/previous.png"))); // NOI18N
        jButtonPreviousToNewAdmin.setText("Previous");
        jButtonPreviousToNewAdmin.setContentAreaFilled(false);
        jButtonPreviousToNewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousToNewAdminActionPerformed(evt);
            }
        });
        jPanelDeleteNews.add(jButtonPreviousToNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jPanelAdmin.add(jPanelDeleteNews, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

        jPanelReportAdmin.setBackground(new java.awt.Color(130, 187, 178));
        jPanelReportAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListReportAdmin.setBackground(new java.awt.Color(130, 187, 178));
        jPanelListReportAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPaneReportAdmin.setViewportView(jPanelListReportAdmin);

        jPanelReportAdmin.add(jScrollPaneReportAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 330));

        jLabelNotDo.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabelNotDo.setForeground(new java.awt.Color(71, 82, 94));
        jLabelNotDo.setText("จำนวนปัญหาที่ยังไม่ได้จัดการ : ");
        jPanelReportAdmin.add(jLabelNotDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, 20));

        jLabelCountNotDo.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabelCountNotDo.setForeground(new java.awt.Color(51, 51, 51));
        jPanelReportAdmin.add(jLabelCountNotDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 200, 20));

        jPanelAdmin.add(jPanelReportAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

        jPanelNewAdmin.setBackground(new java.awt.Color(130, 187, 178));
        jPanelNewAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListNewsAdmin.setBackground(new java.awt.Color(130, 187, 178));
        jPanelListNewsAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPaneNewAdmin.setViewportView(jPanelListNewsAdmin);

        jPanelNewAdmin.add(jScrollPaneNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 330));

        jButtonAddNewsAdmin.setText("ADD");
        jButtonAddNewsAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewsAdminActionPerformed(evt);
            }
        });
        jPanelNewAdmin.add(jButtonAddNewsAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        jPanelAdmin.add(jPanelNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

        jPanelAddNew.setBackground(new java.awt.Color(130, 187, 178));
        jPanelAddNew.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNewDescription.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelNewDescription.setForeground(new java.awt.Color(43, 64, 57));
        jLabelNewDescription.setText("Description");
        jPanelAddNew.add(jLabelNewDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabelNewTopic.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelNewTopic.setForeground(new java.awt.Color(43, 64, 57));
        jLabelNewTopic.setText("Topic");
        jPanelAddNew.add(jLabelNewTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jTextFieldTopicNew.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldTopicNew.setText("Insert your head new");
        jTextFieldTopicNew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTopicNewFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTopicNewFocusLost(evt);
            }
        });
        jTextFieldTopicNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTopicNewActionPerformed(evt);
            }
        });
        jPanelAddNew.add(jTextFieldTopicNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 350, 30));

        jTextAreaContentNew.setColumns(20);
        jTextAreaContentNew.setRows(5);
        jScrollPaneReportDes1.setViewportView(jTextAreaContentNew);

        jPanelAddNew.add(jScrollPaneReportDes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 350, 210));

        jButtonAddNews.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonAddNews.setText("ADD");
        jButtonAddNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewsActionPerformed(evt);
            }
        });
        jPanelAddNew.add(jButtonAddNews, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 110, 30));

        jPanelAdmin.add(jPanelAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

        jPanelEditNew.setBackground(new java.awt.Color(130, 187, 178));
        jPanelEditNew.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEditNewTopic.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelEditNewTopic.setForeground(new java.awt.Color(43, 64, 57));
        jLabelEditNewTopic.setText("Topic");
        jPanelEditNew.add(jLabelEditNewTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabelEditNewDescription.setFont(new java.awt.Font("Quark", 1, 22)); // NOI18N
        jLabelEditNewDescription.setForeground(new java.awt.Color(43, 64, 57));
        jLabelEditNewDescription.setText("Description");
        jPanelEditNew.add(jLabelEditNewDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        jPanelEditNew.add(jTextFieldEditTopicNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 350, 30));

        jTextAreaEditContentNew.setColumns(20);
        jTextAreaEditContentNew.setRows(5);
        jScrollPaneReportDes2.setViewportView(jTextAreaEditContentNew);

        jPanelEditNew.add(jScrollPaneReportDes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 350, 210));

        jButtonEditNews.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEditNews.setText("EDIT");
        jPanelEditNew.add(jButtonEditNews, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 110, 30));

        jButtonPreviousToNews.setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/previous.png"))); // NOI18N
        jButtonPreviousToNews.setText("Previous");
        jButtonPreviousToNews.setContentAreaFilled(false);
        jButtonPreviousToNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousToNewsActionPerformed(evt);
            }
        });
        jPanelEditNew.add(jButtonPreviousToNews, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jPanelAdmin.add(jPanelEditNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

        jPanelRoomServiceAdmin.setBackground(new java.awt.Color(130, 187, 178));
        jPanelRoomServiceAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelAdmin.add(jPanelRoomServiceAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

        adminPrivateCondo.add(jPanelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        getContentPane().add(adminPrivateCondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        userPrivateCondo.setBackground(new java.awt.Color(130, 187, 178));
        userPrivateCondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeadMenu.setBackground(new java.awt.Color(28, 107, 114));
        jPanelHeadMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHome.setFont(new java.awt.Font("Quark", 1, 36)); // NOI18N
        jLabelHome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHome.setText("HOME");
        jPanelHeadMenu.add(jLabelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabelUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/profile-user.png"))); // NOI18N
        jPanelHeadMenu.add(jLabelUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jButton1.setFont(new java.awt.Font("Quark", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(234, 216, 106));
        jButton1.setText("LOGOUT");
        jButton1.setContentAreaFilled(false);
        jPanelHeadMenu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

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

        userType.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        userType.setForeground(new java.awt.Color(153, 153, 153));
        userType.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanelHeadMenu.add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 90, 30));

        userNameUser.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        userNameUser.setForeground(new java.awt.Color(255, 255, 255));
        userNameUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelHeadMenu.add(userNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 130, 30));

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

        jPanelNewsHome.setBackground(new java.awt.Color(130, 187, 178));
        jPanelNewsHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDynamicNewUser.setBackground(new java.awt.Color(130, 187, 178));
        jPanelDynamicNewUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPaneNewUser.setViewportView(jPanelDynamicNewUser);

        jPanelNewsHome.add(jScrollPaneNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

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
        jTextFieldTopic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTopicFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTopicFocusLost(evt);
            }
        });
        jPanelReport.add(jTextFieldTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 350, 30));

        jTextAreaDesReport.setColumns(20);
        jTextAreaDesReport.setRows(5);
        jScrollPaneReportDes.setViewportView(jTextAreaDesReport);

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
        jButtonSendReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendReportActionPerformed(evt);
            }
        });
        jPanelReport.add(jButtonSendReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 110, 30));

        user.add(jPanelReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        jPanelReportProList.setBackground(new java.awt.Color(130, 187, 178));
        jPanelReportProList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListProblem.setBackground(new java.awt.Color(130, 187, 178));
        jPanelListProblem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPaneListProblem.setViewportView(jPanelListProblem);

        jPanelReportProList.add(jScrollPaneListProblem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 330));

        user.add(jPanelReportProList, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

        jPanelRoomSV.setBackground(new java.awt.Color(130, 187, 178));
        jPanelRoomSV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTime.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabelTime.setText("Select Time");
        jPanelRoomSV.add(jLabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jComboBoxDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDateActionPerformed(evt);
            }
        });
        jPanelRoomSV.add(jComboBoxDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 190, 30));

        jLabelDate.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabelDate.setText("Select Day");
        jPanelRoomSV.add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jComboBoxTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelRoomSV.add(jComboBoxTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 190, 30));

        jButtonSelect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSelect.setText("Select");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });
        jPanelRoomSV.add(jButtonSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 130, 30));

        jLabelDateSelect.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDateSelect.setText("center");
        jLabelDateSelect.setFocusable(false);
        jLabelDateSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelDateSelect.setOpaque(true);
        jPanelRoomSV.add(jLabelDateSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 170, 30));
        jLabelDateSelect.getAccessibleContext().setAccessibleName("");

        user.add(jPanelRoomSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 550, 370));

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

        userPrivateCondo.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        getContentPane().add(userPrivateCondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLeft.setBackground(new java.awt.Color(43, 64, 57));
        jPanelLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        login.add(jPanelLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 500));

        jPanelLoginHome.setBackground(new java.awt.Color(130, 187, 178));
        jPanelLoginHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signin1.setBackground(new java.awt.Color(71, 82, 94));
        signin1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signin1.setForeground(new java.awt.Color(255, 255, 255));
        signin1.setText("Login");
        signin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signin1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signin1MouseExited(evt);
            }
        });
        signin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signin1ActionPerformed(evt);
            }
        });
        jPanelLoginHome.add(signin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 300, 30));

        jLabelLogin.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogin.setText("LOGIN");
        jPanelLoginHome.add(jLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        sPassG1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelLoginHome.add(sPassG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, 10));

        warning1.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        warning1.setForeground(new java.awt.Color(255, 51, 51));
        warning1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warning1.setText("Your username or password is incorrect.");
        jPanelLoginHome.add(warning1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 280, 20));

        sEmailB1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelLoginHome.add(sEmailB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        sEmailG1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelLoginHome.add(sEmailG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        username.setFont(new java.awt.Font("Leelawadee", 0, 15)); // NOI18N
        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setText("Username");
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanelLoginHome.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 240, 30));

        sPassB1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanelLoginHome.add(sPassB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, 10));

        password.setText("Password");
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        jPanelLoginHome.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 240, 30));

        login.add(jPanelLoginHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 540, 490));

        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        homePrivateCondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeadHome.setBackground(new java.awt.Color(43, 64, 57));
        jPanelHeadHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonLogin.setBackground(new java.awt.Color(71, 82, 94));
        jButtonLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanelHeadHome.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 110, 30));

        homePrivateCondo.add(jPanelHeadHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 90));

        jPanelFooter.setBackground(new java.awt.Color(28, 107, 114));
        jPanelFooter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setAlignmentX(3.0F);
        jSeparator1.setAlignmentY(3.0F);
        jPanelFooter.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 730, 50));

        homePrivateCondo.add(jPanelFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 730, 60));

        jLabelPicCondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/privatecondo/view/Picture/img_condominium.jpg"))); // NOI18N
        homePrivateCondo.add(jLabelPicCondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 80, -1, -1));

        getContentPane().add(homePrivateCondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

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
        try {
            dbm.createConnection();
            tableListReportForUser(dbm.queryProblemByUser(activeUser.getUserId()));
            dbm.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonListReportActionPerformed

    private void jButtonRoomServiceAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoomServiceAdminActionPerformed
        // TODO add your handling code here:
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(false);
        jPanelAddNew.setVisible(false);
        jPanelNewAdmin.setVisible(false);
        jPanelDeleteNews.setVisible(false);
        jPanelReportAdmin.setVisible(false);
        jPanelRoomServiceAdmin.setVisible(true);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(false);
        jLabelAddNew.setVisible(false);
        jLabelDeleteNew.setVisible(false);
        jLabelEditNew.setVisible(false);
        jLabelReport.setVisible(false);
        jLabelRoomSVadmin.setVisible(true);
    }//GEN-LAST:event_jButtonRoomServiceAdminActionPerformed

    private void jButtonHomeAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeAdminActionPerformed
        // TODO add your handling code here:
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(false);
        jPanelAddNew.setVisible(false);
        jPanelNewAdmin.setVisible(true);
        jPanelDeleteNews.setVisible(false);
        jPanelReportAdmin.setVisible(false);
        jPanelRoomServiceAdmin.setVisible(false);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(true);
        jLabelAddNew.setVisible(false);
        jLabelDeleteNew.setVisible(false);
        jLabelEditNew.setVisible(false);
        jLabelReport.setVisible(false);
        jLabelRoomSVadmin.setVisible(false);
    }//GEN-LAST:event_jButtonHomeAdminActionPerformed

    private void jButtonReportAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportAdminActionPerformed
        // TODO add your handling code here:
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(false);
        jPanelAddNew.setVisible(false);
        jPanelNewAdmin.setVisible(false);
        jPanelDeleteNews.setVisible(false);
        jPanelReportAdmin.setVisible(true);
        jPanelRoomServiceAdmin.setVisible(false);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(false);
        jLabelAddNew.setVisible(false);
        jLabelDeleteNew.setVisible(false);
        jLabelEditNew.setVisible(false);
        jLabelReport.setVisible(true);
        jLabelRoomSVadmin.setVisible(false);
        try {
            dbm.createConnection();
            tableReportListAdmin(dbm.queryProblem());
            jLabelCountNotDo.setText("" + dbm.countNotDoneProblem());
            dbm.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonReportAdminActionPerformed

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

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        // TODO add your handling code here:
        if (username.getText().equals("Username")) {
            username.setText("");
        }
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // TODO add your handling code here:
        if (username.getText().equals("") || username.getText().length() == 0) {
            username.setText("Username");
        }
    }//GEN-LAST:event_usernameFocusLost

    private void signin1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signin1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_signin1MouseEntered

    private void signin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signin1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_signin1MouseExited

    private void signin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signin1ActionPerformed
        try {
            // TODO add your handling code here:
            dbm.createConnection();
            activeUser = dbm.login(username.getText(), password.getText());

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (activeUser == null) {
            warning1.setVisible(true);
        } else {
            if (activeUser.getUserType() == 1) {//user
                homePrivateCondo.setVisible(false);
                adminPrivateCondo.setVisible(false);
                userPrivateCondo.setVisible(true);
                login.setVisible(false);
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
                userNameUser.setText(activeUser.getFname() + " " + activeUser.getLname());
                userType.setText("Room " + activeUser.getRoomLive().getRoomNumber());
                try {
                    this.tableNewUser(dbm.queryNews());
                    dbm.disconnect();
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                homePrivateCondo.setVisible(false);
                adminPrivateCondo.setVisible(true);
                userPrivateCondo.setVisible(false);
                login.setVisible(false);
                jPanelAdmin.setVisible(true);
                jPanelEditNew.setVisible(false);
                jPanelAddNew.setVisible(false);
                jPanelNewAdmin.setVisible(true);
                jPanelDeleteNews.setVisible(false);
                jPanelReportAdmin.setVisible(false);
                jPanelRoomServiceAdmin.setVisible(false);
                jPanelLeftMenuAdmin.setVisible(true);
                jPanelHeadMenuAdmin.setVisible(true);
                jLabelNewAdmin.setVisible(true);
                jLabelAddNew.setVisible(false);
                jLabelDeleteNew.setVisible(false);
                jLabelEditNew.setVisible(false);
                jLabelReport.setVisible(false);
                jLabelRoomSVadmin.setVisible(false);
                userNameAdmin.setText(activeUser.getFname() + " " + activeUser.getLname());
                userTypeAdmin.setText("Admin");
                try {
                    tableListNewsAdmin(dbm.queryNews());
                    dbm.disconnect();
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_signin1ActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(false);
        userPrivateCondo.setVisible(false);
        login.setVisible(true);
        jPanelHeadMenu.setVisible(false);
        jLabelRoomSV.setVisible(false);
        jLabelReportList.setVisible(false);
        jLabelReport1.setVisible(false);
        jLabelHome.setVisible(false);
        jPanelReport.setVisible(false);
        jPanelNewsHome.setVisible(false);
        jPanelRoomSV.setVisible(false);
        jPanelReportProList.setVisible(false);
        jPanelSelectRoomSV.setVisible(false);
        warning1.setVisible(false);
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        if (password.getText().equals("Password")) {
            password.setText("");
        }
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().equals("") || password.getText().length() == 0) {
            password.setText("Password");
        }
    }//GEN-LAST:event_passwordFocusLost

    private void jTextFieldTopicNewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTopicNewFocusGained
        // TODO add your handling code here:
        if (jTextFieldTopicNew.getText().equals("Insert your head new")) {
            jTextFieldTopicNew.setText("");
            jTextFieldTopicNew.setForeground(new java.awt.Color(71, 82, 94));
        }
    }//GEN-LAST:event_jTextFieldTopicNewFocusGained

    private void jTextFieldTopicNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTopicNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTopicNewActionPerformed

    private void jTextFieldTopicNewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTopicNewFocusLost
        // TODO add your handling code here:
        if (jTextFieldTopicNew.getText().equals("") || jTextFieldTopicNew.getText().length() == 0) {
            jTextFieldTopicNew.setText("Insert your head new");
        }
    }//GEN-LAST:event_jTextFieldTopicNewFocusLost

    private void jButtonAddNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewsActionPerformed
        // TODO add your handling code here:
        News n = new News();
        Date current = new Date();
        n.setTopic(jTextFieldTopicNew.getText());
        n.setDescription(jTextAreaContentNew.getText());
        n.setAnnounceDate(current);
        try {
            dbm.addNews(n, activeUser.getUserId());
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAddNewsActionPerformed

    private void jButtonAddNewsAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewsAdminActionPerformed
        // TODO add your handling code here:
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(false);
        jPanelAddNew.setVisible(true);
        jPanelNewAdmin.setVisible(false);
        jPanelDeleteNews.setVisible(false);
        jPanelReportAdmin.setVisible(false);
        jPanelRoomServiceAdmin.setVisible(false);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(false);
        jLabelAddNew.setVisible(true);
        jLabelDeleteNew.setVisible(false);
        jLabelEditNew.setVisible(false);
        jLabelReport.setVisible(false);
        jLabelRoomSVadmin.setVisible(false);
        userNameAdmin.setText(activeUser.getFname());
    }//GEN-LAST:event_jButtonAddNewsAdminActionPerformed

    private void jTextFieldTopicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTopicFocusGained
        // TODO add your handling code here:
        if (jTextFieldTopic.getText().equals("Insert your head report")) {
            jTextFieldTopic.setText("");
            jTextFieldTopic.setForeground(new java.awt.Color(71, 82, 94));
        }
    }//GEN-LAST:event_jTextFieldTopicFocusGained

    private void jTextFieldTopicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTopicFocusLost
        // TODO add your handling code here:
        if (jTextFieldTopic.getText().equals("") || jTextFieldTopic.getText().length() == 0) {
            jTextFieldTopic.setText("Insert your head new");
        }
    }//GEN-LAST:event_jTextFieldTopicFocusLost

    private void jButtonSendReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendReportActionPerformed
        // TODO add your handling code here:
        Problem p = new Problem();
        p.setTopic(jTextFieldTopic.getText());
        p.setDescription(jTextAreaDesReport.getText());
        Date d = new Date();
        p.setReportDate(d);
        p.setReporter(activeUser);
        try {
            dbm.createConnection();
            dbm.addProblem(p);
            dbm.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Add Report Success");
    }//GEN-LAST:event_jButtonSendReportActionPerformed

    private void jButtonPreviousToNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousToNewsActionPerformed
        // TODO add your handling code here:
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(false);
        jPanelAddNew.setVisible(false);
        jPanelNewAdmin.setVisible(true);
        jPanelDeleteNews.setVisible(false);
        jPanelReportAdmin.setVisible(false);
        jPanelRoomServiceAdmin.setVisible(false);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(true);
        jLabelAddNew.setVisible(false);
        jLabelDeleteNew.setVisible(false);
        jLabelEditNew.setVisible(false);
        jLabelReport.setVisible(false);
        jLabelRoomSVadmin.setVisible(false);
        userNameAdmin.setText(activeUser.getFname() + " " + activeUser.getLname());
    }//GEN-LAST:event_jButtonPreviousToNewsActionPerformed

    private void jComboBoxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDateActionPerformed
        System.out.println("hello");

    }//GEN-LAST:event_jComboBoxDateActionPerformed

    private void jButtonPreviousToNewAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousToNewAdminActionPerformed
        // TODO add your handling code here:
        jPanelNewAdmin.removeAll();
        try {
            dbm.createConnection();
            tableListNewsAdmin(dbm.queryNews());
            dbm.disconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanelNewAdmin.revalidate();
        jPanelNewAdmin.repaint();
        homePrivateCondo.setVisible(false);
        adminPrivateCondo.setVisible(true);
        userPrivateCondo.setVisible(false);
        login.setVisible(false);
        jPanelAdmin.setVisible(true);
        jPanelEditNew.setVisible(false);
        jPanelAddNew.setVisible(false);
        jPanelNewAdmin.setVisible(true);
        jPanelDeleteNews.setVisible(false);
        jPanelReportAdmin.setVisible(false);
        jPanelRoomServiceAdmin.setVisible(false);
        jPanelLeftMenuAdmin.setVisible(true);
        jPanelHeadMenuAdmin.setVisible(true);
        jLabelNewAdmin.setVisible(true);
        jLabelAddNew.setVisible(false);
        jLabelDeleteNew.setVisible(false);
        jLabelEditNew.setVisible(false);
        jLabelReport.setVisible(false);
        jLabelRoomSVadmin.setVisible(false);
    }//GEN-LAST:event_jButtonPreviousToNewAdminActionPerformed

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
    private javax.swing.JPanel homePrivateCondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddNews;
    private javax.swing.JButton jButtonAddNewsAdmin;
    private javax.swing.JButton jButtonDeleteConfirm;
    private javax.swing.JButton jButtonEditNews;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonHomeAdmin;
    private javax.swing.JButton jButtonListReport;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonLogoutAdmin;
    private javax.swing.JButton jButtonPreviousToNewAdmin;
    private javax.swing.JButton jButtonPreviousToNews;
    private javax.swing.JButton jButtonPreviousToRoomSV;
    private javax.swing.JButton jButtonReport;
    private javax.swing.JButton jButtonReportAdmin;
    private javax.swing.JButton jButtonRoomService;
    private javax.swing.JButton jButtonRoomServiceAdmin;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonSendReport;
    private javax.swing.JComboBox<String> jComboBoxDate;
    private javax.swing.JComboBox<String> jComboBoxTime;
    private javax.swing.JLabel jLabelAddNew;
    private javax.swing.JLabel jLabelCountNotDo;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDateSelect;
    private javax.swing.JLabel jLabelDeleteNew;
    private javax.swing.JLabel jLabelDeleteNewDescription;
    private javax.swing.JLabel jLabelDeteteNewTopic;
    private javax.swing.JLabel jLabelEditNew;
    private javax.swing.JLabel jLabelEditNewDescription;
    private javax.swing.JLabel jLabelEditNewTopic;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelNewAdmin;
    private javax.swing.JLabel jLabelNewDescription;
    private javax.swing.JLabel jLabelNewTopic;
    private javax.swing.JLabel jLabelNotDo;
    private javax.swing.JLabel jLabelPicCondo;
    private javax.swing.JLabel jLabelReport;
    private javax.swing.JLabel jLabelReport1;
    private javax.swing.JLabel jLabelReportDescription;
    private javax.swing.JLabel jLabelReportList;
    private javax.swing.JLabel jLabelReportTopic;
    private javax.swing.JLabel jLabelRoomSV;
    private javax.swing.JLabel jLabelRoomSVadmin;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelUserProfile;
    private javax.swing.JLabel jLabelUserProfileAdmin;
    private javax.swing.JPanel jPanelAddNew;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelDeleteNews;
    private javax.swing.JPanel jPanelDynamicNewUser;
    private javax.swing.JPanel jPanelEditNew;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeadHome;
    private javax.swing.JPanel jPanelHeadMenu;
    private javax.swing.JPanel jPanelHeadMenuAdmin;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelLeftMenu;
    private javax.swing.JPanel jPanelLeftMenuAdmin;
    private javax.swing.JPanel jPanelListNewsAdmin;
    private javax.swing.JPanel jPanelListProblem;
    private javax.swing.JPanel jPanelListReportAdmin;
    private javax.swing.JPanel jPanelLoginHome;
    private javax.swing.JPanel jPanelNewAdmin;
    private javax.swing.JPanel jPanelNewsHome;
    private javax.swing.JPanel jPanelReport;
    private javax.swing.JPanel jPanelReportAdmin;
    private javax.swing.JPanel jPanelReportProList;
    private javax.swing.JPanel jPanelRoomSV;
    private javax.swing.JPanel jPanelRoomServiceAdmin;
    private javax.swing.JPanel jPanelSelectRoomSV;
    private javax.swing.JScrollPane jScrollPaneListProblem;
    private javax.swing.JScrollPane jScrollPaneNewAdmin;
    private javax.swing.JScrollPane jScrollPaneNewUser;
    private javax.swing.JScrollPane jScrollPaneNewsDes;
    private javax.swing.JScrollPane jScrollPaneReportAdmin;
    private javax.swing.JScrollPane jScrollPaneReportDes;
    private javax.swing.JScrollPane jScrollPaneReportDes1;
    private javax.swing.JScrollPane jScrollPaneReportDes2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaContentNew;
    private javax.swing.JTextArea jTextAreaDesReport;
    private javax.swing.JTextArea jTextAreaEditContentNew;
    private javax.swing.JTextArea jTextAreaNewsContentNew;
    private javax.swing.JTextField jTextFieldDeleteTopicNew;
    private javax.swing.JTextField jTextFieldEditTopicNew;
    private javax.swing.JTextField jTextFieldTopic;
    private javax.swing.JTextField jTextFieldTopicNew;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel sEmailB1;
    private javax.swing.JLabel sEmailG1;
    private javax.swing.JLabel sPassB1;
    private javax.swing.JLabel sPassG1;
    private javax.swing.JButton signin1;
    private javax.swing.JPanel user;
    private javax.swing.JLabel userNameAdmin;
    private javax.swing.JLabel userNameUser;
    private javax.swing.JPanel userPrivateCondo;
    private javax.swing.JLabel userType;
    private javax.swing.JLabel userTypeAdmin;
    private javax.swing.JTextField username;
    private javax.swing.JLabel warning1;
    // End of variables declaration//GEN-END:variables
}
