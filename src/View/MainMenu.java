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
    JButton btnLogin, btnRegist, btnLihatData;

    public MainMenu() {

        frame = new JFrame("Main Menu");
        frame.setSize(600, 300);
        frame.setBackground(Color.yellow);

//        BufferedImage image = null;
//        image = ImageIO.read(getClass().getResource("/resources/icon.gif"));
        btnLogin = new JButton("Login Pengguna");
        btnLogin.setBounds(90, 50, 400, 40);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.white);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LoginPenggunaMenu();
            }
        });

        btnRegist = new JButton("Registrasi Pengguna Baru");
        btnRegist.setBounds(90, 110, 400, 40);
        btnRegist.setBackground(Color.BLACK);
        btnRegist.setForeground(Color.white);
        btnRegist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new RegistrasiPenggunaBaruMenu();
            }
        });

        btnLihatData = new JButton("Lihat Data Berdasarkan Kategori Dipilih");
        btnLihatData.setBounds(90, 170, 400, 40);
        btnLihatData.setBackground(Color.BLACK);
        btnLihatData.setForeground(Color.white);
        btnLihatData.addActionListener(new ActionListener() {
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
        frame.add(btnRegist);
        frame.add(btnLihatData);
//        frame.setIconImage(image);

    }

}
