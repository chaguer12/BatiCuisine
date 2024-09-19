package cuisine.entities;

import cuisine.entities.Enums.EtatProjet;

public class Projet {
    private int id;
    private static int id_starter = 0;
    private String nom;
    private double marge_benefique;
    private double cout_total;
    private Enum<EtatProjet> etat_projet;

    public Projet(int id,String nom, double marge_benefique, double cout_total, EtatProjet etat_projet) {
        this.id = id_starter++;
        this.nom = nom;
        this.marge_benefique = marge_benefique;
        this.cout_total = cout_total;
        this.etat_projet = etat_projet;
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
