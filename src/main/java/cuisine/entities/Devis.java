package cuisine.entities;

import java.sql.Date;

public class Devis {
    private int id;
    private double montant_estime;
    private Date date_emission;
    private Date date_expiration;
    private boolean accepte;
    private Projet projet;
    public Devis(double montant_estime, Date date_emission, Date date_expiration, boolean accepte, Projet projet) {
        this.montant_estime = montant_estime;
        this.date_emission = date_emission;
        this.date_expiration = date_expiration;
        this.accepte = accepte;
        this.projet = projet;
    }

    public int getId() {
        return id;
    }


    public double getMontant_estime() {
        return montant_estime;
    }

    public void setMontant_estime(double montant_estime) {
        this.montant_estime = montant_estime;
    }

    public Date getDate_emission() {
        return date_emission;
    }

    public void setDate_emission(Date date_emission) {
        this.date_emission = date_emission;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public boolean isAccepte() {
        return accepte;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
