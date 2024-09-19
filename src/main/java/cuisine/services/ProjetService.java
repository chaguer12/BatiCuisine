package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Projet;
import cuisine.repository.ProjetRepository;
import cuisine.repository.interfaces.ProjetInterface;

import java.sql.Connection;

public class ProjetService {
    private final Connection conn = DatabaseConnection.getConnection();
    private final ProjetInterface projetRepo = new ProjetRepository(conn);

    public void addProjet(Projet projet) {
        projetRepo.save(projet);
    }

}
