/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CategoryUser;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Felicia
 */
public class Controller {
    static DBHandler conn = new DBHandler();

    public Controller() {
        conn.connect();
    }
    
    public boolean cekLogin(String _email, String _pass){
        User user = new User();
        String query = "SELECT * FROM user WHERE Email='" + _email  + "'&&Password='" + _pass + "'";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
                user.setPhoto(rs.getString("photo"));
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    public static ArrayList<CategoryUser> getAllCategoryUser() {
        ArrayList<CategoryUser> list = new ArrayList<>();
        String query = "SELECT * FROM categoryUser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser category = new CategoryUser();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (list);
    } 
    
    public static ArrayList<User> getUsersByCategory(int selectedCategory) {
        ArrayList<User> listUser = new ArrayList<>();
        String query = "SELECT * FROM user WHERE idCategory='" + selectedCategory + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
                user.setPhoto(rs.getString("photo"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listUser);
    } 
    
    
    public boolean insertNewData(User user){
        String query = "INSERT INTO user(id, name, email, password, idCategory, photo) VALUES (?,?,?,?,?,?);";
        
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getIdCategory());
            stmt.setString(6, user.getPhoto());
            stmt.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    
    
}
