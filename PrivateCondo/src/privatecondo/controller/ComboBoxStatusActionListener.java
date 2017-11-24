/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import privatecondo.view.Home;

/**
 *
 * @author January
 */
public class ComboBoxStatusActionListener implements ActionListener{
    private JComboBox item;
    private Home page;

    public ComboBoxStatusActionListener(JComboBox item,Home page) {
        this.item = item;
        this.page = page;
    }

    public void actionPerformed(ActionEvent e) {
        page.setCb(item.getSelectedIndex());
    }
    
}
