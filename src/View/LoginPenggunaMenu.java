/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Felicia
 */
public class LoginPenggunaMenu {
    JFrame frame;
    JPanel panel;
    JTextField fieldEmail;
    JPasswordField fieldPassword;
    JLabel labelEmail, labelPassword;
    JButton btnLogin, btnBack;
    
    Controller c = new Controller();

    public LoginPenggunaMenu() {
        
        // Frame
        frame = new JFrame("Login Menu");
        frame.setSize(600, 500);

        // Panel
        panel = new JPanel();
        panel.setSize(600, 500);
        panel.setBackground(Color.cyan);

        // Label
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 30, 300, 30);
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(50, 80, 300, 30);
        
        
        fieldEmail = new JTextField();
        fieldEmail.setBounds(150, 30, 300, 30);
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(150, 80, 300, 30);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 230, 100, 50);
        btnLogin.setBackground(Color.yellow);
        btnLogin.setFont(new Font("Serif", Font.BOLD, 20));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pass = String.valueOf(fieldPassword.getPassword());
                if(!fieldEmail.getText().equals("")){
                    if(!pass.equals("")){
                        
                        if(c.cekLogin(fieldEmail.getText(), pass)){
                            frame.setVisible(false);
                            System.out.println("Berhasil masuk");
                            new LihatDataMenu();
                        } else {
                            JOptionPane.showMessageDialog(null, "Input email/password Anda salah", "Login", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Anda belum menulis password!", "Login", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Anda belum menulis Email!", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnBack = new JButton("Back");
        btnBack.setBounds(300, 230, 100, 50);
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
        panel.add(labelEmail);
        panel.add(labelPassword);
        panel.add(fieldPassword);
        panel.add(fieldEmail);
        panel.add(btnLogin);
        panel.add(btnBack);
        frame.add(panel);
        
    }
    
}
