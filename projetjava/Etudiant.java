/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

/**
 *
 * @author ester maria
 */
public class Etudiant {
    
   int matricule;
   String nom, prenom,groupe,tel,adresse,mail,filiere;

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
 public int getMatricule() {
        return matricule;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }
 public String getNom() {
        return nom;
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
 public String getPrenom() {
        return prenom;
    }



    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
    public String getGroupe() {
        return groupe;
    }



    public void setTelephone(String tel) {
        this.tel = tel;
    }
 public String getTel() {
        return tel;
    }



    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
   public String getAdresse() {
        return adresse;
    }



    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getMail() {
        return mail;
    }



    public void setFillier(String filiere) {
        this.fillier = filiere;
    }

    public String getFiliere() {
        return filiere;
    }
   

   

   


   

 


    public Etudiant(int matricule, String nom, String prenom, String groupe, String tel, String adresse, String mail, String filiere) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
        this.tel = tel;
        this.adresse = adresse;
        this.mail = mail;
        this.filiere = filiere;
    }
    
}
