package com.example.gsb_visite;

import java.util.Date;

public class Visite {
    private Date date_visite;
    private String commentaire;
    private Visiteur visiteur; // Assumant que vous avez une classe Visiteur
    private Praticien praticien; // Assumant que vous avez une classe Praticien
    private String motif;

    public Date getDate_visite() {
        return date_visite;
    }

    public void setDate_visite(Date date_visite) {
        this.date_visite = date_visite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
