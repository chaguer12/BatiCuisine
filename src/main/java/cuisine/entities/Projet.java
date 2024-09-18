package cuisine.entities;

import cuisine.entities.Enums.EtatProjet;

public class Projet {
    private int id;
    private static int id_starter;
    private String nom;
    private double marge_benefique;
    private double cout_total;
    private Enum<EtatProjet> etat_projet;

}
