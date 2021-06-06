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
public class Groupe {
    
    int matriculeGrp;
    String nomGrp, dateCreation, nmbrEtu;

    public Groupe(int matriculeGrp, String nomGrp, String dateCreation, String nmbrEtu) {
        this.matriculeGrp = matriculeGrp;
        this.nomGrp = nomGrp;
        this.dateCreation = dateCreation;
        this.nmbrEtu = nmbrEtu;
    }


    public int getMatriculeGrp() {
        return matriculeGrp;
    }

    public void setMatriculeGrp(int matriculeGrp) {
        this.matriculeGrp = matriculeGrp;
    }

    public String getNomGrp() {
        return nomGrp;
    }

    public void setNomGrp(String nomGrp) {
        this.nomGrp = nomGrp;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getNmbrEtu() {
        return nmbrEtu;
    }

    public void setNmbrEtu(String nmbrEtu) {
        this.nmbrEtu = nmbrEtu;
    }
    
    
    
}
