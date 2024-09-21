package cuisine.entities;

public abstract class Composant {
    private int id;
    private String nom;
    private String type;
    private Projet projet;


    public Composant(String nom, String type, Projet projet) {
        this.nom = nom;
        this.type = type;
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
}
