package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Composant;
import cuisine.entities.Devis;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.DevisInterface;
import cuisine.repository.repositories.DevisRepository;
import cuisine.services.interfaces.DevisServiceInterface;

import java.sql.Connection;

public class DevisService implements DevisServiceInterface {
    private final Connection conn = DatabaseConnection.getConnection();
    private DevisInterface devisService = new DevisRepository(conn);
    @Override
    public void save(Devis devis, Projet projet) {
        devisService.save(devis, projet);

    }
    @Override
    public void acceptDevis(Devis devis) {
        devisService.acceptDevis(devis);
    }

}
