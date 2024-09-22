package cuisine.entities;

public abstract class Composant {
    private int id;
    private String nom;
    private String type;
    private double tva;
    private Projet projet;


    public Composant(String nom, String type, double tva, Projet projet) {
        this.nom = nom;
        this.type = type;
        this.tva = tva;
        this.projet= projet;
    }
    public Composant() {}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Projet getProject() {
        return this.projet;
    }

    public void setProjet(Projet project) {
        this.projet = projet;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }
}
