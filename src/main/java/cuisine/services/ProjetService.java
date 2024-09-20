package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Projet;
import cuisine.repository.repositories.ProjetRepository;
import cuisine.repository.interfaces.ProjetInterface;

import java.sql.Connection;
import java.util.List;

public class ProjetService {
    private final Connection conn = DatabaseConnection.getConnection();
    private final ProjetInterface projetRepo = new ProjetRepository(conn);

    public void addProjet(Projet projet) {
        projetRepo.save(projet);
    }

    public void getAllProjets() {
        List<Projet> projets = projetRepo.findAll();
        projets.stream().forEach(projet -> System.out.println("id: "+ projet.getId()+", nom: " + projet.getNom() + ", marge: " + projet.getMarge_benefique() + ", etat: "+ projet.getEtat_projet()));

    }
    public Projet getProjetById(int id) {
        Projet projet = projetRepo.findById(id);
        return projet;
    }

}
