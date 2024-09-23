package cuisine.services.interfaces;

import cuisine.entities.Materiel;
import cuisine.entities.Projet;

import java.util.List;

public interface MaterielServiceInterface {
    void addMateriel(Materiel materiel , Projet projet);
    double getAllMateriel(Projet projet);
    double calculateTotal(Materiel materiel);
    double calculHorsTaxes(Materiel materiel);
    double totalHT(List<Double> totals);
    double totalTTC(List<Double> totals);
}
