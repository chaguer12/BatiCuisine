package cuisine.services.interfaces;

import cuisine.entities.MainOuev;
import cuisine.entities.Projet;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MainOuevServiceInterface {
    void addMainOuev(MainOuev mainOuev, Projet projet);
    List<MainOuev> getAllMainOuev(Projet projet);
    double calculateTotal(@NotNull MainOuev main);
    double calculHorsTaxes(@NotNull MainOuev main);

}
