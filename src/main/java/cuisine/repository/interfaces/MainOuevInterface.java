package cuisine.repository.interfaces;

import cuisine.entities.MainOuev;
import cuisine.entities.Projet;

public interface MainOuevInterface {
    void save(MainOuev mainOuev, Projet projet);
}
