package cuisine.entities;

public class Client {

    private int id;
    private String nom_complet;
    private String adresse;
    private String tel;
    private boolean est_pro;

    public Client(String nom_complet, String adresse, String tel, boolean est_pro) {
        this.nom_complet = nom_complet;
        this.adresse = adresse;
        this.tel = tel;
        this.est_pro = est_pro;
    }

    public int getId() {
        return id;
    }

    public String getNom_complet() {
        return nom_complet;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isEst_pro() {
        return est_pro;
    }

    public void setEst_pro(boolean est_pro) {
        this.est_pro = est_pro;
    }
}
