/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import static projetjava.MysqlConnect.ConnectDb;

/**
 *
 * @author ester maria
 */
public class MysqlConnect {
    
    Connection conn = null;    
    
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
            // JOptionPane.showMessageDialog(null, "Connexion Etablie !");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        return null;
        }
        
    }
  /*
    public void getDataEtudiant(){
        Connection conn = ConnectDb();
        
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM etudiants");
            ResultSet rs = ps.executeQuery();
            
            
        } catch (Exception e) {
        }
    }
      
    public static ObservableList<Etudiant> getDataEtudiant(){
        Connection conn = ConnectDb();
        ObservableList<Etudiant> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM etudiants");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){                
                list.add(new Etudiant(Integer.parseInt(rs.getString("matricule")),rs.getString("nom"), rs.getString("prenom"),rs.getString("groupe"),rs.getString("tel"), rs.getString("adresse"), rs.getString("mail"), rs.getString("filiere")));
            }
        } catch (Exception e) {
        }
    return list;
    }*/
}
