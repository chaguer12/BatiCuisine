package cuisine.services.interfaces;

import cuisine.entities.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjetServiceInteface {
    void addProjet(Projet projet);
    Projet getProjetById(int id);
    Optional<List<Projet>> getAllProjets();
    void saveCoutTotal(Projet projet);
}
