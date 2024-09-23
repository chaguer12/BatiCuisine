package cuisine.services;

import cuisine.GUI.Menu;
import cuisine.config.DatabaseConnection;
import cuisine.entities.Projet;
import cuisine.repository.repositories.ProjetRepository;
import cuisine.repository.interfaces.ProjetInterface;
import cuisine.services.interfaces.ProjetServiceInteface;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;



public class ProjetService implements ProjetServiceInteface {
    private final Connection conn = DatabaseConnection.getConnection();
    private final ProjetInterface projetRepo = new ProjetRepository(conn);

    public void addProjet(Projet projet) {
        projetRepo.save(projet);
    }

    public Optional<List<Projet>> getAllProjets() {
        Optional<List<Projet>> Optionalprojets = Optional.of(projetRepo.findAll());
        Optionalprojets.ifPresentOrElse(
                projets -> projets.forEach(p->System.out.printf("id: %d, nom: %s, marge: %.2f, etat: %s%n",
                        p.getId(),
                        p.getNom(),
                        p.getMarge_benefique(),
                        p.getEtat_projet())),
                () ->System.out.println("ZERO PROJETS TROUVE")
                        );
        return Optionalprojets;


    }
    public Projet getProjetById(int id) {
        Projet projet = projetRepo.findById(id);
        return projet;
    }

}
