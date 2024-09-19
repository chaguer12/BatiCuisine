package cuisine.entities;

import cuisine.entities.Enums.EtatProjet;

public class Projet {
    private int id;
    private String nom;
    private double marge_benefique;
    private double cout_total;
    private Enum<EtatProjet> etat_projet;
    private int client_id;

    public Projet(String nom, double marge_benefique, double cout_total, EtatProjet etat_projet,int client_id) {

        this.nom = nom;
        this.marge_benefique = marge_benefique;
        this.cout_total = cout_total;
        this.etat_projet = etat_projet;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMarge_benefique() {
        return marge_benefique;
    }

    public void setMarge_benefique(double marge_benefique) {
        this.marge_benefique = marge_benefique;
    }

    public double getCout_total() {
        return cout_total;
    }

    public void setCout_total(double cout_total) {
        this.cout_total = cout_total;
    }

    public Enum<EtatProjet> getEtat_projet() {
        return etat_projet;
    }

    public void setEtat_projet(Enum<EtatProjet> etat_projet) {
        this.etat_projet = etat_projet;
    }
}
