package cuisine.services.interfaces;

import cuisine.entities.Materiel;
import cuisine.entities.Projet;

import java.util.List;

public interface MaterielServiceInterface {
    void addMateriel(Materiel materiel , Projet projet);
    List<Materiel> getAllMateriel(Projet projet);
}
