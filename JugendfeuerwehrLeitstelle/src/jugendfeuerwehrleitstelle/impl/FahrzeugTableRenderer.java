/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugendfeuerwehrleitstelle.impl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Timo
 */
public class FahrzeugTableRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        String status = (String) table.getModel().getValueAt(row, 3);
        
        if ("1".equals(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        } else {
            if ("2".equals(status)) {
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
            } else {
                if ("3".equals(status)) {
                    setBackground(Color.YELLOW);
                    setForeground(Color.BLACK);
                } else {
                    if ("4".equals(status)) {
                        setBackground(Color.BLUE);
                        setForeground(Color.BLACK);
                    } else {
                        if ("5".equals(status)) {
                            setBackground(Color.orange);
                            setForeground(Color.BLACK);
                        } else {
                            if ("6".equals(status)) {
                                setBackground(Color.GRAY);
                                setForeground(Color.BLACK);
                            } else {
                                setBackground(table.getBackground());
                                setForeground(table.getForeground());
                            }
                        }
                    }
                }
            }

        }
        return this;
    }

}
