package com.example.gsb_visite;

import java.util.List;

public class Praticien {
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String rue;
    private String code_postal;
    private String ville;
    private List<Visite> visites;

    public Praticien(String nom, String prenom, String tel, String email, String rue, String code_postal, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }

    public Praticien(String nom, String prenom, String tel, String email, String rue, String code_postal, String ville, List<Visite> visites) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.visites = visites;
    }

    @Override
    public String toString() {
        return "Practicien{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom +
                '}';
    }
}
