/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.CategoryUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Felicia
 */
public class LihatDataMenu {
    JFrame frame;
    JPanel panel;
    JLabel labelSearch;
    JComboBox cbCategoryUser;
    JButton btnSearch;
    
    Controller c = new Controller();

    public LihatDataMenu() {
        
        // Frame
        frame = new JFrame("Lihat Data Menu");
        frame.setSize(600, 500);

        // Panel
        panel = new JPanel();
        panel.setSize(600, 500);
        panel.setBackground(Color.cyan);
        
        // Label
        labelSearch = new JLabel("Cari berdasarkan : ");
        labelSearch.setBounds(50, 30, 300, 30);
        
        ArrayList<CategoryUser> listCategoryUser = c.getAllCategoryUser();
        String[] arrCategoryUserString = new String[listCategoryUser.size()];
        for (int i = 0; i < listCategoryUser.size(); i++) {
            arrCategoryUserString[i] = listCategoryUser.get(i).getName();
        }
        cbCategoryUser = new JComboBox(arrCategoryUserString);
        cbCategoryUser.setBounds(200, 30, 300, 30);
        
        
        
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(180, 200, 200, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LihatData(cbCategoryUser.getSelectedIndex());
            }
        });
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        // Add
        panel.add(labelSearch);
        panel.add(btnSearch);
        panel.add(cbCategoryUser);
        frame.add(panel);
        
    }
    
}
