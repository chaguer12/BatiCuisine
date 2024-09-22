package cuisine.repository.interfaces;

import cuisine.entities.Materiel;
import cuisine.entities.Projet;

public interface MaterielInterface {
    void saveMateriel(Materiel materiel, Projet projet);
}
