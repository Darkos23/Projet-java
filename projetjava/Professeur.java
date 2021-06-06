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
public class Professeur {
    
    int matriculeProf;
   String nomProf, prenomProf,groupeProf,telProf,adresseProf,mailProf;

    public Professeur(int matriculeProf, String nomProf, String prenomProf, String groupeProf, String naissanceProf, String telephoneProf, String adresseProf, String emailProf) {
        this.matriculeProf = matriculeProf;
        this.nomProf = nomProf;
        this.prenomProf = prenomProf;
        this.groupeProf = groupeProf;
        this.telProf = telProf;
        this.adresseProf = adresseProf;
        this.mailProf = mailProf;
       
    }


    public int getMatriculeProf() {
        return matriculeProf;
    }

    public void setMatriculeProf(int matriculeProf) {
        this.matriculeProf = matriculeProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }

    public String getGroupeProf() {
        return groupeProf;
    }

    public void setGroupeProf(String groupeProf) {
        this.groupeProf = groupeProf;
    }

  

    public String getTelProf() {
        return telProf;
    }

    public void setTelProf(String telProf) {
        this.telProf = telProf;
    }

    public String getAdresseProf() {
        return adresseProf;
    }

    public void setAdresseProf(String adresseProf) {
        this.adresseProf = adresseProf;
    }

    public String getMailProf() {
        return mailProf;
    }

    public void setMailProf(String mailProf) {
        this.mailProf = mailProf;
    }

   
    
   
}
