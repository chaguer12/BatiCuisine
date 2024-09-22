package cuisine.repository.interfaces;

import cuisine.entities.MainOuev;
import cuisine.entities.Projet;

import java.util.List;

public interface MainOuevInterface {


    void save(MainOuev mainOuev, Projet projet);
    List<MainOuev> findAll(Projet projet);
}
