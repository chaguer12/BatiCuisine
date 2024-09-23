package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Materiel;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MaterielInterface;
import cuisine.repository.repositories.MaterielRepository;
import cuisine.services.interfaces.MaterielServiceInterface;

import java.sql.Connection;
import java.util.List;

public class MaterielService implements MaterielServiceInterface {
    private final Connection conn = DatabaseConnection.getConnection();
    private MaterielInterface materielInterface = new MaterielRepository(conn);
    @Override
    public void addMateriel(Materiel materiel , Projet projet){
        materielInterface.saveMateriel(materiel, projet);
    }
    @Override
    public List<Materiel> getAllMateriel(Projet projet){
        List<Materiel> materiaux = materielInterface.findAll(projet);
        materiaux.forEach(materiel -> {
            double total = calculateTotal(materiel);
            String output = String.format("Nom: %s, Cout unitaire: %.2f, Quantite: %.2f,Cout transport: %.2f,Coeff qualite: %.2f, TVA: %.2f,Total: %.2f",
                    materiel.getNom(),
                    materiel.getCout_unt(),
                    materiel.getQty(),
                    materiel.getCout_trnspr(),
                    materiel.getCoeff_qlt(),
                    materiel.getTva(),
                    total
                    );

            System.out.println(output);
        });
        return materiaux;
    }
    private double calculateTotal(Materiel materiel){
        return ((materiel.getCout_unt()*materiel.getQty()*materiel.getCoeff_qlt())*(1+(materiel.getTva())/100))+ materiel.getCout_trnspr();
    }
}
