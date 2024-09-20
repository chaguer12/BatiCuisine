package cuisine.entities;

public class MainOuev extends Composant{
    private double taux_horaire;
    private double heures_travail;
    private double coeff_prod;
    public MainOuev(String nom, String type, Projet projet) {
        super(nom, "mains d'ouevre",projet);
        this.taux_horaire = taux_horaire;
        this.heures_travail = heures_travail;
        this.coeff_prod = coeff_prod;
    }

    public double getTaux_horaire() {
        return taux_horaire;
    }

    public void setTaux_horaire(double taux_horaire) {
        this.taux_horaire = taux_horaire;
    }

    public double getHeures_travail() {
        return heures_travail;
    }

    public void setHeures_travail(double heures_travail) {
        this.heures_travail = heures_travail;
    }

    public double getCoeff_prod() {
        return coeff_prod;
    }

    public void setCoeff_prod(double coeff_prod) {
        this.coeff_prod = coeff_prod;
    }
}
