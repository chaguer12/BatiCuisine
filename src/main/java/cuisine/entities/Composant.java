package cuisine.entities;

public abstract class Composant {
    private int id;
    private String nom;
    private String type;
    private int project_id;

    public Composant(String nom, String type, int project_id) {
        this.nom = nom;
        this.type = type;
        this.project_id = project_id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
