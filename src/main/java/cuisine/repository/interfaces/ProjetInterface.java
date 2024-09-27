package cuisine.repository.interfaces;

import cuisine.entities.Projet;

import java.util.List;

public interface ProjetInterface {
    short save(Projet projet);
    List<Projet> findAll();
    Projet findById(int id);
    void saveCoutTotal(Projet projet);
}
