/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugendfeuerwehrleitstelle.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Timo
 */
public class FahrzeugeAktualisieren extends Thread {

    private String[] columnNames = {
        "Nr", "Fahrzeug", "Funkrufname", "Status"
    };

    private JTable _table = null;
    private ArrayList<ArrayList<String>> _fahrzeuge;

    private final String SQLHost = "localhost";
    private final String SQLUser = "root";
    private final String SQLPassword = "";
    private final String SQLPort = "3306";
    private final String SQLDatabase = "leitstelle";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private boolean _run = false;

    public void setRun(boolean run) {
        this._run = run;
    }

    public FahrzeugeAktualisieren(JTable table, ArrayList<ArrayList<String>> list) {
        this._fahrzeuge = list;
        this._table = table;
    }

    @Override
    public void run() {
        while (_run) {

            try {
                connect = DriverManager.getConnection("jdbc:mysql://" + SQLHost + "/" + SQLDatabase + "?"
                        + "user=" + SQLUser + "&password=" + SQLPassword);

                statement = connect.createStatement();

                resultSet = statement.executeQuery("select * from fahrzeuge");
                
                 ArrayList<ArrayList<String>> fahrzeugeHelper = new ArrayList<>();

                while (resultSet.next()) {
                    ArrayList<String> help = new ArrayList<>();

                    help.add(resultSet.getString(1));
                    help.add(resultSet.getString(2));
                    help.add(resultSet.getString(3));
                    help.add(resultSet.getString(4));

                    fahrzeugeHelper.add(help);
 
                }
                
                if(!fahrzeugeHelper.equals(_fahrzeuge)) {
                    _fahrzeuge = fahrzeugeHelper;
                    this.buildTable(_fahrzeuge, _table);
                }
                
                Thread.sleep(2000);
            } catch (SQLException ex) {
                Logger.getLogger(FahrzeugeAktualisieren.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(FahrzeugeAktualisieren.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void buildTable(ArrayList<ArrayList<String>> list, JTable table) {
        String[][] fhz = new String[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            fhz[i][0] = list.get(i).get(0);
            fhz[i][1] = list.get(i).get(1);
            fhz[i][2] = list.get(i).get(2);
            fhz[i][3] = list.get(i).get(3);
        }

        DefaultTableModel dtm = new DefaultTableModel(fhz, columnNames);
        table.setModel(dtm);
    }
}
