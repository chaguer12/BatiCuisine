package cuisine.services.interfaces;

import cuisine.entities.MainOuev;
import cuisine.entities.Projet;

import java.util.List;

public interface MainOuevServiceInterface {
    void addMainOuev(MainOuev mainOuev, Projet projet);
    List<MainOuev> getAllMainOuev(Projet projet);

}
