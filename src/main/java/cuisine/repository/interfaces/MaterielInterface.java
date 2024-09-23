package cuisine.repository.interfaces;

import cuisine.entities.Materiel;
import cuisine.entities.Projet;

import java.util.List;

public interface MaterielInterface {
    void saveMateriel(Materiel materiel, Projet projet);
    List<Materiel> findAll(Projet projet);
}
