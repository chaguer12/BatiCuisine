package cuisine.services.interfaces;

import cuisine.entities.Projet;

public interface ProjetServiceInteface {
    void addProjet(Projet projet);
    Projet getProjetById(int id);
}
