/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Felicia
 */
public class LihatData {
    JFrame frame;
    JPanel panel;
    JLabel labelCategory;
    JButton btnBack;
    JScrollPane sp;
    JTable table;
    
    Controller c = new Controller();

    public LihatData(int selectedCB) {
        
        // Frame
        frame = new JFrame("Lihat Data Menu");
        frame.setSize(700, 700);

        // Panel
        panel = new JPanel();
        panel.setSize(700, 700);
        panel.setBackground(Color.cyan);
        
        // Label
        labelCategory = new JLabel("Category yang dicari adalah : ");
        labelCategory.setBounds(50, 30, 300, 30);
        
        ArrayList<User> listUsers = c.getUsersByCategory(selectedCB);
        String [] column = {"ID", "Name", "Email", "Password", "idCategory", "Photo"};
        String[][] dataComplete = new String[listUsers.size()][column.length];
        
        for (int i = 0; i < listUsers.size(); i++) {
            String[] data = {String.valueOf(listUsers.get(i).getId()), listUsers.get(i).getName(), 
                listUsers.get(i).getEmail(), listUsers.get(i).getPassword(), String.valueOf(listUsers.get(i).getIdCategory()),
                listUsers.get(i).getPhoto()};
            
            dataComplete[i] = data;
        }
        
        table = new JTable(dataComplete, column);
        table.setBounds(50, 80, 500, 300);
        table.setBackground(Color.cyan);
        
        sp = new JScrollPane(table);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(180, 400, 200, 50);
        btnBack.setBackground(Color.yellow);
        btnBack.setFont(new Font("Serif", Font.BOLD, 20));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new MainMenu();
            }
        });
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        // Add
        panel.add(labelCategory);
        panel.add(btnBack);
        panel.add(table);
        panel.add(sp);
        frame.add(panel);
        
        
    }
    public static void main(String[] args) {
        new LihatData(1);
    }
}
