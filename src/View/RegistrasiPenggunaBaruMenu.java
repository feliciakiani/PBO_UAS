/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.CategoryUser;
import Model.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Felicia
 */
public class RegistrasiPenggunaBaruMenu {

    JFrame frame;
    JPanel panel;
    JTextField fieldEmail, fieldNama;
    JPasswordField fieldPassword;
    JLabel labelEmail, labelPassword, labelPathFoto, labelCategoryUser, labelFoto, labelNama;
    JComboBox cbCategoryUser;
    JButton btnRegist, btnBack;
    JMenuItem open;
    File file;

    Controller c = new Controller();

    public RegistrasiPenggunaBaruMenu() {

        // Frame
        frame = new JFrame("Registrasi");
        frame.setSize(600, 600);

        // Panel
        panel = new JPanel();
        panel.setSize(600, 600);
        panel.setBackground(Color.cyan);

        // Label
        labelNama = new JLabel("Nama");
        labelNama.setBounds(50, 30, 300, 30);
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 80, 300, 30);
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(50, 130, 300, 30);
        labelCategoryUser = new JLabel("Category User");
        labelCategoryUser.setBounds(50, 180, 300, 30);
        labelFoto = new JLabel("Foto");
        labelFoto.setBounds(50, 230, 300, 30);
        labelPathFoto = new JLabel("");
        labelPathFoto.setBounds(300, 230, 300, 30);
//        labelPathFoto.setVisible(false);

        fieldNama = new JTextField();
        fieldNama.setBounds(150, 30, 300, 30);
        fieldEmail = new JTextField();
        fieldEmail.setBounds(150, 80, 300, 30);
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(150, 130, 300, 30);

        // ComboBox
        ArrayList<CategoryUser> listCategoryUser = c.getAllCategoryUser();
        String[] arrCategoryUserString = new String[listCategoryUser.size()];
        for (int i = 0; i < listCategoryUser.size(); i++) {
            arrCategoryUserString[i] = listCategoryUser.get(i).getName();
        }
        cbCategoryUser = new JComboBox(arrCategoryUserString);
        cbCategoryUser.setBounds(150, 180, 300, 30);

        open = new JMenuItem("Pilih Foto");
        open.setBounds(150, 230, 130, 30);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == open) {
                    JFileChooser choose = new JFileChooser();
                    int approve = choose.showOpenDialog(null);
                    if (approve == JFileChooser.APPROVE_OPTION) {
                        file = choose.getSelectedFile();
                        labelPathFoto.setText(file.getPath());
                        labelPathFoto.setVisible(true);
                    }
                }
            }
        });

        btnRegist = new JButton("Registrasi");
        btnRegist.setBounds(80, 300, 200, 50);
        btnRegist.setBackground(Color.yellow);
        btnRegist.setFont(new Font("Serif", Font.BOLD, 20));
        btnRegist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pass = String.valueOf(fieldPassword.getPassword());
                Random rand = new Random();
                int upperbound = 100;
                int int_random = rand.nextInt(upperbound);
                if (!fieldEmail.getText().equals("")) {
                    if (!pass.equals("")) {
                        if (!fieldNama.getText().equals("")) {
                            if (!labelPathFoto.getText().equals("")) {

                                User userBaru = new User(int_random, fieldNama.getText(), fieldEmail.getText(), pass, cbCategoryUser.getSelectedIndex(), labelPathFoto.getText());

                                boolean inserted = c.insertNewData(userBaru);

                                if (inserted) {
                                    frame.setVisible(false);
                                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Registrasi", JOptionPane.INFORMATION_MESSAGE);
                                    new LihatDataMenu();
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Anda belum memilih foto!", "Registrasi", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Anda belum menulis nama!", "Registrasi", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Anda belum menulis password!", "Registrasi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Anda belum menulis Email!", "Registrasi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBack = new JButton("Back");
        btnBack.setBounds(330, 300, 200, 50);
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
        panel.add(labelNama);
        panel.add(labelEmail);
        panel.add(labelPassword);
        panel.add(labelCategoryUser);
        panel.add(labelFoto);
        panel.add(fieldPassword);
        panel.add(fieldEmail);
        panel.add(fieldNama);
        panel.add(cbCategoryUser);
        panel.add(btnRegist);
        panel.add(btnBack);
        panel.add(open);
        frame.add(panel);
    }

}
