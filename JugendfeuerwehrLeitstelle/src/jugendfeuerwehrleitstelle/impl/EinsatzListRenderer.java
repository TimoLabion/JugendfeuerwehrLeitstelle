/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugendfeuerwehrleitstelle.impl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import jugendfeuerwehrleitstelle.objects.Einsatz;

/**
 *
 * @author Timo
 */
public class EinsatzListRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        
        Color selecdedColor = new Color(51,153,255);

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Einsatz e = (Einsatz) value;

        if (!isSelected) {
            if (e.getEinsatzStatus().equals("neu")) {
                setBackground(Color.red);
            } else {
                if (e.getEinsatzStatus().equals("läuft")) {
                    setBackground(Color.yellow);
                }
            }
        } else{
            setBackground(selecdedColor);
        } 

        return this;
    }

}
