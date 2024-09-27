package cuisine.repository.repositories;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Client;
import cuisine.entities.Enums.EtatProjet;
import cuisine.entities.Projet;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ProjetRepositoryTest {

    @Test
    void save() {
        Connection conn = DatabaseConnection.getConnection();
        ProjetRepository  projetREpo = new ProjetRepository(conn);
        Projet projet = new Projet("allo",34,34, EtatProjet.EN_COURS,new Client());
        assertEquals(1,projetREpo.save(projet));

    }

}