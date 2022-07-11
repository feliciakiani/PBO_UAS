/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Felicia
 */
public class MainMenu {
    
    JFrame frame;
    JButton btnLogin, btnPencarian, btnExit;

    public MainMenu() {
        
        frame = new JFrame("Main Menu");
        frame.setSize(600, 300);
        frame.setBackground(Color.yellow);
        
        btnLogin = new JButton("Login Pengguna");
        btnLogin.setBounds(90, 50, 400, 40);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.white);
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LoginPenggunaMenu();
            }
        });
        
        
        btnPencarian = new JButton("Registrasi Pengguna Baru");
        btnPencarian.setBounds(90, 110, 400, 40);
        btnPencarian.setBackground(Color.BLACK);
        btnPencarian.setForeground(Color.white);
        btnPencarian.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new RegistrasiPenggunaBaruMenu();
            }
        });
        
        
        btnExit = new JButton("Lihat Data Berdasarkan Kategori Dipilih");
        btnExit.setBounds(90, 170, 400, 40);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.white);
        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LihatDataMenu();
            }
        });
        
        // Init
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        //Add
        frame.add(btnLogin);
        frame.add(btnPencarian);
        frame.add(btnExit);
        
        
}
   
}
