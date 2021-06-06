/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import static projetjava.MysqlConnect.ConnectDb;

/**
 *
 * @author ester maria
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private TableView<Etudiant> TabEtudiant;

    @FXML
    private TableColumn<Etudiant, Integer> MatriculeCol;

    @FXML
    private TableColumn<Etudiant, String> NomCol;

    @FXML
    private TableColumn<Etudiant, String> PrenomCol;

    @FXML
    private TableColumn<Etudiant, String> GroupeCol;

    @FXML
    private TableColumn<Etudiant, String> NaissanceCol;

    @FXML
    private TableColumn<Etudiant, String> TelephoneCol;

    @FXML
    private TableColumn<Etudiant, String> AdresseCol;

    @FXML
    private TableColumn<Etudiant, String> EmailCol;

    @FXML
    private TableColumn<Etudiant, String>  FillierCol;
    
     @FXML
    private TextField txtMatricule;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtGroupe;

    @FXML
    private TextField txtNaissance;

    @FXML
    private TextField txtTelephone;

    @FXML
    private TextField txtAdresse;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFillier;
    
    @FXML
    private TableView<Professeur> TabProfesseur;

    @FXML
    private TableColumn<Professeur, Integer> MatriculeColProf;

    @FXML
    private TableColumn<Professeur, String> NomColProf;

    @FXML
    private TableColumn<Professeur, String> PrenomColProf;

    @FXML
    private TableColumn<Professeur, String> GroupeColProf;

    @FXML
    private TableColumn<Professeur, String> NaissanceColProf;

    @FXML
    private TableColumn<Professeur, String> TelephoneColProf;

    @FXML
    private TableColumn<Professeur, String> AdresseColProf;

    @FXML
    private TableColumn<Professeur, String> EmailColProf;

    @FXML
    private TableColumn<Professeur, String> FillierColProf;

    @FXML
    private TextField txtMatriculeProf;

    @FXML
    private TextField txtNomProf;

    @FXML
    private TextField txtPrenomProf;

    @FXML
    private TextField txtGroupeProf;

    @FXML
    private TextField txtNaissanceProf;

    @FXML
    private TextField txtTelephoneProf;

    @FXML
    private TextField txtAdresseProf;

    @FXML
    private TextField txtEmailProf;

    @FXML
    private TextField txtRechercheProf;
        
    @FXML
    private TableView<Groupe> TabGroupe;

    @FXML
    private TableColumn<Groupe, Integer> MatriculeColGrp;

    @FXML
    private TableColumn<Groupe, String> NomColGrp;

    @FXML
    private TableColumn<Groupe, String> creationColGrp;

    @FXML
    private TableColumn<Groupe, String> NmbrEtuColGrp;

    @FXML
    private TextField txtMatriculeGrp;

    @FXML
    private TextField txtNomGrp;

    @FXML
    private TextField txtDateCreaGrp;

    @FXML
    private TextField txtRechercheProf1;

    @FXML
    private TextField txtNmbrEtuGrp;
    
    @FXML
    private AnchorPane PaneGroupe;

    
    @FXML
    private AnchorPane PaneEtudiant;
      
    @FXML
    private AnchorPane PaneProfesseur;

    
    public void EtudiantPaneShow(){
    
       PaneEtudiant.setVisible(true);
       PaneProfesseur.setVisible(false);
       PaneGroupe.setVisible(false);
    }
    
    public void ProfesseurPaneShow(){
    
        PaneEtudiant.setVisible(false);
        PaneProfesseur.setVisible(true);
        PaneGroupe.setVisible(false);
    }
    
    public void GroupePaneShow(){
    
        PaneEtudiant.setVisible(false);
        PaneProfesseur.setVisible(false);
        PaneGroupe.setVisible(true);
    }

    Connection conn = null ;
    ResultSet rs = null ;
    PreparedStatement pst  = null ;
    String sql = null;
    String etudiant = null;
    String professeur = null;
    String groupe = null;
    
    ObservableList<Etudiant> data ;
    ObservableList<Etudiant> rech ;
    ObservableList<Professeur> dataProf ;
    ObservableList<Groupe> dataGrp ;
    
    int index = -1;
    /*
    Connection conn = null ;
    ResultSet rs = null ;
    PreparedStatement pst  = null ;
    
    */
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = FXCollections.observableArrayList();
        dataProf = FXCollections.observableArrayList();
        dataGrp = FXCollections.observableArrayList();
        setCellTable();
        getDataEtudiant();
        setCellTableProf();
        getDataProfesseur();
        setCellTableGrp();
        getDataGrp();
    }   
    
     // Ajouter un etudiant
    @FXML
    public void AjoutEtu(){
    
    conn = MysqlConnect.ConnectDb();
    String sql = "INSERT INTO `etudiants`(`Nom`, `Prenom`, `Groupe`, `Tel`, `Adresse`, `Mail`, `Filiere`) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtNom.getText());
            pst.setString(2, txtPrenom.getText());
            pst.setString(3, txtGroupe.getText());
            pst.setString(5, txtTel.getText());
            pst.setString(6, txtAdresse.getText());
            pst.setString(7, txtMail.getText());
            pst.setString(8, txtFiliere.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Ajouté avec succés!");
            ActuListEtu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
          
    }
    
    
    
    
      // Afficher tous les etudiants 
     @FXML
      private void setCellTable(){
      
        MatriculeCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        NomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        PrenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        GroupeCol.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        TelCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        AdresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        MailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
        FiliereCol.setCellValueFactory(new PropertyValueFactory<>("filiere"));
      }
      
     
      private void getDataEtudiant(){
      
          Connection conn = ConnectDb();
         try {
             pst = conn.prepareStatement("Select * from etudiants");
             rs = pst.executeQuery();
             
             while(rs.next()){
             
                 data.add(new Etudiant(Integer.parseInt(rs.getString(1)), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
             }
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
         TabEtudiant.setItems(data);
      }
      
      
  
      // Selectionner un etudiants
    @FXML
    void getselectedEtudiant(){
        index = TabEtudiant.getSelectionModel().getSelectedIndex();
        if(index <= -1){
        
            return;
        }
        txtMatricule.setText(MatriculeCol.getCellData(index).toString());
        txtNom.setText(NomCol.getCellData(index).toString());
        txtPrenom.setText(PrenomCol.getCellData(index).toString());
        txtGroupe.setText(GroupeCol.getCellData(index).toString());
        txtTel.setText(TelCol.getCellData(index).toString());
        txtAdresse.setText(AdresseCol.getCellData(index).toString());
        txtMail.setText(MailCol.getCellData(index).toString());
        txtFiliere.setText(FiliereCol.getCellData(index).toString());
    }
    
     
    // Modification d'un etudiant
    @FXML
    public void EditEtudiant(){
    
        try {
            conn = MysqlConnect.ConnectDb();
            String value1 = txtMatricule.getText();
            String value2 = txtNom.getText();
            String value3 = txtPrenom.getText();
            String value4 = txtGroupe.getText();
            String value5 = txtTelephone.getText();
            String value6 = txtAdresse.getText();
            String value7 = txtMail.getText();
            String value8 = txtFiliere.getText();
            
            
            String sql = "Update etudiants set Matricule ='"+value1+"',Nom ='"+value2+"',"
                    + "Prenom ='"+value3+"',Groupe ='"+value4+"',
                    + "Telephone ='"+value5+"',Adresse ='"+value6+"',Mail ='"+value7+"',"
                    + "Filiere ='"+value8+"' where Matricule = '"+value1+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modifié avec succés ! ");
            ActuListEtu();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtMatricule.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtGroupe.setText("");
        txtTel.setText("");
        txtAdresse.setText("");
        txtMail.setText("");
        txtFiliere.setText("");
    }
    
    
    
    // Actualiser la table Etudiant
    @FXML
    public void ActuListEtu(){
         try {
             data.clear();
             sql = "SELECT * FROM etudiants";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                 data.add(new Etudiant(rs.getInt("Matricule"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Groupe"), rs.getString("Tel"), rs.getString("Adresse"), rs.getString("Mail"), rs.getString("Filiere")));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    // Supprimer un etudiant
    @FXML
    public void DeleteEtudiant(){
        conn = MysqlConnect.ConnectDb();
        try{ 
        String sql = "DELETE FROM `etudiants` WHERE `Matricule` = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtMatricule.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Supprimé avec succés !");
            ActuListEtu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtMatricule.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtGroupe.setText("");
        txtTel.setText("");
        txtAdresse.setText("");
        txtMail.setText("");
        txtFiliere.setText("");
    }
    
    
    
    @FXML
    public void rechercheEtudiant(){
    
       MatriculeCol.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("id"));
       NomCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));
       PrenomCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenom"));
       GroupeCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("groupe"));
       NaissanceCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("naissance"));
       TelephoneCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("telephone"));
       AdresseCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("adresse"));
       EmailCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Email"));
       FillierCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("filliere"));
       
       conn = MysqlConnect.ConnectDb();
       TabEtudiant.setItems(rech);
        FilteredList<Etudiant> filteredData = new FilteredList<>(rech, b -> true);
        txtMatricule.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(personne -> {
                   if(newValue == null || newValue.isEmpty()){
                   return true;
                   }
                   String lowerCaseFilter = newValue.toLowerCase();
                   //filtrer le nom
                   if(personne.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ){return true;}
                   //filtrer le prenom
                   else if(personne.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1 ){return true;}
                   //filtrer le groupe
                   else if(personne.getGroupe().toLowerCase().indexOf(lowerCaseFilter) != -1 ){return true;}
                   //filtrer le telephone
                   else if(personne.getTel().toLowerCase().indexOf(lowerCaseFilter) != -1 ){return true;}
                   //filtrer le Adresse
                   else if(personne.getAdresse().toLowerCase().indexOf(lowerCaseFilter) != -1 ){return true;}
                   //filtrer le mail
                   else if(String.valueOf(personne.getMail()).toLowerCase().indexOf(lowerCaseFilter) != -1 ){return true;}
                   //filtrer la filiere
                   else if(personne.getFiliere().toLowerCase().indexOf(lowerCaseFilter) != -1 ){return true;}
                   
                   // Si cela ne fonctionne pas
                return false;
            
            });
        }));
        SortedList<Etudiant> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(TabEtudiant.comparatorProperty());
        TabEtudiant.setItems(sortedData);
    }
    
    // Ajouter un professeur
    @FXML
    public void AjoutProf(){
    
    conn = MysqlConnect.ConnectDb();
    String sql = "INSERT INTO `profs`(`Nom`, `Prenom`, `Groupe`, `Tel`, `Adresse`, `Mail`) VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtNomProf.getText());
            pst.setString(2, txtPrenomProf.getText());
            pst.setString(3, txtGroupeProf.getText());
            pst.setString(4, txtTeProf.getText());
            pst.setString(5, txtAdresseProf.getText());
            pst.setString(6, txtMailProf.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Ajouté avec succés !");
            ActuListProf();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
          
    }
    
      // Afficher tous les Prof 
     @FXML
      private void setCellTableProf(){
      
        MatriculeColProf.setCellValueFactory(new PropertyValueFactory<>("matriculeProf"));
        NomColProf.setCellValueFactory(new PropertyValueFactory<>("nomProf"));
        PrenomColProf.setCellValueFactory(new PropertyValueFactory<>("prenomProf"));
        GroupeColProf.setCellValueFactory(new PropertyValueFactory<>("groupeProf"));
        TelephoneColProf.setCellValueFactory(new PropertyValueFactory<>("telProf"));
        AdresseColProf.setCellValueFactory(new PropertyValueFactory<>("adresseProf"));
        EmailColProf.setCellValueFactory(new PropertyValueFactory<>("mailProf"));
        
      }
     
      private void getDataProfesseur(){
      
          Connection conn = ConnectDb();
         try {
             pst = conn.prepareStatement("Select * from profs");
             rs = pst.executeQuery();
             
             while(rs.next()){
             
                 dataProf.add(new Professeur(Integer.parseInt(rs.getString(1)),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
             }
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
         TabProfesseur.setItems(dataProf);
      }
      
      // Selectionner un Prof
    @FXML
    void getselectedProf(){
        index = TabProfesseur.getSelectionModel().getSelectedIndex();
        if(index <= -1){
        
            return;
        }
        txtMatriculeProf.setText(MatriculeColProf.getCellData(index).toString());
        txtNomProf.setText(NomColProf.getCellData(index).toString());
        txtPrenomProf.setText(PrenomColProf.getCellData(index).toString());
        txtGroupeProf.setText(GroupeColProf.getCellData(index).toString());
        txtTelephoneProf.setText(TelephoneColProf.getCellData(index).toString());
        txtAdresseProf.setText(AdresseColProf.getCellData(index).toString());
        txtEmailProf.setText(MailColProf.getCellData(index).toString());
    }
    
    // Modification d'un Prof
    @FXML
    public void EditProf(){
    
        try {
            conn = MysqlConnect.ConnectDb();
            String value1 = txtMatriculeProf.getText();
            String value2 = txtNomProf.getText();
            String value3 = txtPrenomProf.getText();
            String value4 = txtGroupeProf.getText();
            String value5 = txtTelProf.getText();
            String value6 = txtAdresseProf.getText();
            String value7 = txtEmailProf.getText();
            
            
            String sql = "UPDATE `professeur` SET `Matricule`= '"+value1+"',`Nom`='"+value2+"',"
                    + "`Prenom`='"+value3+"',`Groupe`='"+value4+"',`Telephone`='"+value5+"',"
                    + "`Adresse`='"+value6+"',`Email`='"+value8    +"' WHERE `Matricule` = '"+value1+"'";
            
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modifié avec succés ! ");
            ActuListProf();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtMatricule.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtGroupe.setText("");
        txtTel.setText("");
        txtAdresse.setText("");
        txtMail.setText("");
    }
    
    // Actualiser la table Professeur
    @FXML
    public void ActuListProf(){
         try {
             dataProf.clear();
             sql = "SELECT * FROM profs";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                 dataProf.add(new Professeur(rs.getInt("Matricule"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Groupe"), rs.getString("Tel"), rs.getString("Adresse"), rs.getString("Mail")));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    // Supprimer un Prof de la table 
    @FXML
    public void DeleteProf(){
        conn = MysqlConnect.ConnectDb();
        try{ 
        String sql = "DELETE FROM `profs` WHERE `Matricule` = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtMatriculeProf.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Supprimé avec succés ! ");
            ActuListProf();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtMatricule.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtGroupe.setText("");
        txtTelephone.setText("");
        txtAdresse.setText("");
        txtMail.setText("");
        txtFiliere.setText("");
    }
    
    // Ajouter un Groupe
    @FXML
    public void AjoutGrp(){
    
    conn = MysqlConnect.ConnectDb();
    String sql = "INSERT INTO `groupe`( `NomGroupe`, `DateCreation`, `NmbrEtu`) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtNomGrp.getText());
            pst.setString(2, txtDateCreaGrp.getText());
            pst.setString(3, txtNmbrEtuGrp.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Ajouté avec succés !");
            ActuListProf();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
          
    }
    
      // Afficher tous les Groupe 
     @FXML
      private void setCellTableGrp(){
      
        MatriculeColGrp.setCellValueFactory(new PropertyValueFactory<>("matriculeGrp"));
        NomColGrp.setCellValueFactory(new PropertyValueFactory<>("nomGrp"));
        creationColGrp.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        NmbrEtuColGrp.setCellValueFactory(new PropertyValueFactory<>("nmbrEtu"));
        
        
      }
     
      private void getDataGrp(){
      
          Connection conn = ConnectDb();
         try {
             pst = conn.prepareStatement("Select * from groupe");
             rs = pst.executeQuery();
             
             while(rs.next()){
             
                 dataGrp.add(new Groupe(Integer.parseInt(rs.getString(1)),rs.getString(2), rs.getString(3), rs.getString(4)));
             }
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
         TabGroupe.setItems(dataGrp);
      }
      
      // Selectionner un groupe
    @FXML
    void getselectedGrp(){
        index = TabGroupe.getSelectionModel().getSelectedIndex();
        if(index <= -1){
        
            return;
        }
        txtMatriculeGrp.setText(MatriculeColGrp.getCellData(index).toString());
        txtNomGrp.setText(NomColGrp.getCellData(index).toString());
        txtDateCreaGrp.setText(creationColGrp.getCellData(index).toString());
        txtGroupeProf.setText(NmbrEtuColGrp.getCellData(index).toString());
    }
    
    // Modification d'un Prof
    @FXML
    public void EditGrp(){
    
        try {
            conn = MysqlConnect.ConnectDb();
            String value1 = txtMatriculeGrp.getText();
            String value2 = txtNomGrp.getText();
            String value3 = txtDateCreaGrp.getText();
            String value4 = txtNmbrEtuGrp.getText();
            
            String sql = "UPDATE `groupe` SET `Matricule`='"+value1+"',`NomGroupe`='"+value2+"',`DateCreation`='"+value3+"',`NmbrEtu`='"+value4+"' WHERE `Matricule` = '"+value1+"'";
            
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modifié avec succés !");
            ActuListProf();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtMatricule.setText("");
        txtNomGrp.setText("");
        txtDateCreaGrp.setText("");
        txtNmbrEtuGrp.setText("");
    }
    
    // Actualiser la table Professeur
    @FXML
    public void ActuListGrp(){
         try {
             dataGrp.clear();
             sql = "SELECT * FROM groupe";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                 dataGrp.add(new Groupe(rs.getInt("Matricule"), rs.getString("NomGroupe"), rs.getString("DateCreation"), rs.getString("NmbrEtu")));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    // Supprimer un Groupe de la table 
    @FXML
    public void DeleteGrp(){
        conn = MysqlConnect.ConnectDb();
        try{ 
        String sql = "DELETE FROM `groupe` WHERE `Matricule` = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtMatriculeGrp.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Supprimé avec succés !");
            ActuListGrp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtMatriculeGrp.setText("");
        txtNomGrp.setText("");
        txtDateCreaGrp.setText("");
        txtNmbrEtuGrp.setText("");
    }
}
