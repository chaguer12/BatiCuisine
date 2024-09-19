package cuisine.repository.interfaces;

import cuisine.entities.Projet;

import java.util.List;

public interface ProjetInterface {
    void save(Projet projet);
    //Projet find(int id);
    List<Projet> findAll();
}
