package cuisine.repository.interfaces;

import cuisine.entities.Devis;
import cuisine.entities.Projet;

public interface DevisInterface {
    void save(Devis devis, Projet projet);
    void acceptDevis(Devis devis);
}
