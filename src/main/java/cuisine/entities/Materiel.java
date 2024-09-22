package cuisine.entities;

public class Materiel extends Composant{
    private double cout_unt;
    private double qty;
    private double cout_trnspr;
    private double coeff_qlt;
    public Materiel(String nom, String type, double tva, Projet projet){
        super(nom, type, tva, projet);
        this.cout_unt = cout_unt;
        this.qty = qty;
        this.coeff_qlt = coeff_qlt;
        this.cout_trnspr = cout_trnspr;
    }
    public Materiel(){
        setType("meteriel");
    }

    public double getCout_unt() {
        return cout_unt;
    }

    public void setCout_unt(double cout_unt) {
        this.cout_unt = cout_unt;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getCout_trnspr() {
        return cout_trnspr;
    }

    public void setCout_trnspr(double cout_trnspr) {
        this.cout_trnspr = cout_trnspr;
    }

    public double getCoeff_qlt() {
        return coeff_qlt;
    }

    public void setCoeff_qlt(double coeff_qlt) {
        this.coeff_qlt = coeff_qlt;
    }
}
