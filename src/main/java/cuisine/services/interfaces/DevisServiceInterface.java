package cuisine.services.interfaces;

import cuisine.entities.Devis;
import cuisine.entities.Projet;

public interface DevisServiceInterface {
    void save(Devis devis , Projet projet);
    void acceptDevis(Devis devis);
}
