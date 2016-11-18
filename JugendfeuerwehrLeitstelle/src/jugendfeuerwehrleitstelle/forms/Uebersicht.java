/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugendfeuerwehrleitstelle.forms;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jugendfeuerwehrleitstelle.impl.EinsatzListRenderer;
import jugendfeuerwehrleitstelle.impl.FahrzeugTableRenderer;
import jugendfeuerwehrleitstelle.impl.FahrzeugeAktualisieren;
import jugendfeuerwehrleitstelle.objects.Einsatz;

/**
 *
 * @author Timo
 */
public class Uebersicht extends javax.swing.JFrame {

    private boolean _isAdmin = false;
    private final String SQLHost = "localhost";
    private final String SQLUser = "root";
    private final String SQLPassword = "";
    private final String SQLPort = "3306";
    private final String SQLDatabase = "leitstelle";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String[] columnNames = {
        "Nr", "Fahrzeug", "Funkrufname", "Status"
    };

    private String[][] fhz;

    private DefaultTableModel model;
    private ArrayList<ArrayList<String>> fahrzeuge;

    private FahrzeugeAktualisieren fa;

    private ArrayList<Einsatz> einsaetze;

    /**
     * Creates new form uebersicht
     */
    public Uebersicht() {
        initComponents();
    }

    public Uebersicht(boolean isAdmin) {
        initComponents();

        _isAdmin = isAdmin;

        if (_isAdmin) {
            jLabel1.setText("Administrator");
        } else {
            jLabel1.setText("Kein Administrator");
        }
        fahrzeuge = new ArrayList<>();
        einsaetze = new ArrayList<>();

        try {
            connect = DriverManager.getConnection("jdbc:mysql://" + SQLHost + "/" + SQLDatabase + "?"
                    + "user=" + SQLUser + "&password=" + SQLPassword);

            statement = connect.createStatement();

            resultSet = statement.executeQuery("select * from fahrzeuge");

            while (resultSet.next()) {
                ArrayList<String> help = new ArrayList<>();

                help.add(resultSet.getString(1));
                help.add(resultSet.getString(2));
                help.add(resultSet.getString(3));
                help.add(resultSet.getString(4));

                fahrzeuge.add(help);
            }

            resultSet = statement.executeQuery("select * from einsaetze");

            while (resultSet.next()) {
                Einsatz e = new Einsatz();

                e.setId(resultSet.getInt(1));
                e.setAnruferName(resultSet.getString(2));
                e.setAnruferTelefon(resultSet.getString(3));
                e.setAnruferStraße(resultSet.getString(4));
                e.setAnruferOrt(resultSet.getString(5));

                e.setEinsatzStraße(resultSet.getString(6));
                e.setEinsatzHausnummer(resultSet.getString(7));
                e.setEinsatzPLZ(resultSet.getString(8));
                e.setEinsatzOrt(resultSet.getString(9));
                e.setEinsatzKreuzung(resultSet.getString(10));

                int stichwort = resultSet.getInt(11);

                System.out.println(stichwort);

                Statement s = connect.createStatement();

                ResultSet rs = s.executeQuery("select * from stichworte where stichworteID=" + stichwort);

                if (rs.next()) {
                    e.setStichwort(rs.getString(2));
                }

                e.setBeschreibung(resultSet.getString(12));
                e.setEinsatzDatum(resultSet.getDate(13));
                e.setEinsatzZeit(resultSet.getTime(14));

                int status = resultSet.getInt(15);

                Statement s1 = connect.createStatement();

                ResultSet rs1 = s1.executeQuery("select * from einsatzstatus where einsatzStatusID=" + status);

                if (rs1.next()) {
                    e.setEinsatzStatus(rs1.getString(2));
                }
                
                e.setEinsatzLage(resultSet.getString(16));

                einsaetze.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Uebersicht.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.buildTable(fahrzeuge, jTable1);

        System.out.println();

        jTable1.setDefaultRenderer(Object.class, new FahrzeugTableRenderer());

        DefaultListModel<Einsatz> model = new DefaultListModel<Einsatz>();

        for (Einsatz s : einsaetze) {
            model.addElement(s);
        }

        lEinsatz.setCellRenderer(new EinsatzListRenderer());

        lEinsatz.setModel(model);

        this.pack();

        this.setVisible(true);

        fa = new FahrzeugeAktualisieren(jTable1, fahrzeuge);
        fa.setRun(true);

        fa.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bNeuerEinsatz = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lEinsatz = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fahrzeugübersicht"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("jLabel1");

        bNeuerEinsatz.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bNeuerEinsatz.setText("Neuer Einsatz");
        bNeuerEinsatz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNeuerEinsatzActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Einsatzübersicht"));

        lEinsatz.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lEinsatz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEinsatzMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lEinsatz);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jMenu2.setText("Programm");

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);
        jMenu2.add(jSeparator1);

        jMenuItem2.setText("Programm beenden");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Einstellungen");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(bNeuerEinsatz, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(bNeuerEinsatz, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login log = new Login();

        Image icon = new ImageIcon("img/icon.png").getImage();

        log.setIconImage(icon);

        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.setFocusable(true);

        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fa.setRun(false);
    }//GEN-LAST:event_formWindowClosing

    private void bNeuerEinsatzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNeuerEinsatzActionPerformed
        NeuerEinsatz ne = new NeuerEinsatz(this);

        Image icon = new ImageIcon("img/icon.png").getImage();

        ne.setIconImage(icon);

        this.setEnabled(false);

        ne.setLocationRelativeTo(null);
        ne.setVisible(true);
        ne.setFocusable(true);
    }//GEN-LAST:event_bNeuerEinsatzActionPerformed

    private void lEinsatzMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEinsatzMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2) {
            int index = list.locationToIndex(evt.getPoint());

            Einsatz e = (Einsatz) list.getSelectedValue();

            EinsatzDetails ed = new EinsatzDetails(this, e);

            Image icon = new ImageIcon("img/icon.png").getImage();

            ed.setIconImage(icon);

            ed.setLocationRelativeTo(null);
            ed.setVisible(true);
            this.setEnabled(false);
            ed.requestFocus();

        }
    }//GEN-LAST:event_lEinsatzMouseClicked

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
            java.util.logging.Logger.getLogger(Uebersicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Uebersicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Uebersicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Uebersicht.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Uebersicht().setVisible(true);
            }
        });
    }

    private void buildTable(ArrayList<ArrayList<String>> list, JTable table) {
        fhz = new String[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            fhz[i][0] = list.get(i).get(0);
            fhz[i][1] = list.get(i).get(1);
            fhz[i][2] = list.get(i).get(2);
            fhz[i][3] = list.get(i).get(3);
        }

        DefaultTableModel dtm = new DefaultTableModel(fhz, columnNames);
        table.setModel(dtm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNeuerEinsatz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JList lEinsatz;
    // End of variables declaration//GEN-END:variables
}
