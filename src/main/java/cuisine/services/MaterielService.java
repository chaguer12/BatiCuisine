package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Materiel;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MaterielInterface;
import cuisine.repository.repositories.MaterielRepository;
import cuisine.services.interfaces.MaterielServiceInterface;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MaterielService implements MaterielServiceInterface {
    private final Connection conn = DatabaseConnection.getConnection();
    private MaterielInterface materielInterface = new MaterielRepository(conn);
    @Override
    public void addMateriel(Materiel materiel , Projet projet){
        materielInterface.saveMateriel(materiel, projet);
    }
    @Override
    public double getAllMateriel(Projet projet){
        List<Double> totals = new ArrayList<>();
        List<Double> HT = new ArrayList<>();
        System.out.println("====\tMATERIAUX\t====");
        List<Materiel> materiaux = materielInterface.findAll(projet);
        materiaux.forEach(materiel -> {
            double total = calculateTotal(materiel);
            totals.add(total);
            double prix_ht = calculHorsTaxes(materiel);
            HT.add(prix_ht);
            String output = String.format("Nom: %s, Cout unitaire: %.2f, Quantite: %.2f,Cout transport: %.2f,Coeff qualite: %.2f, TVA: %.2f,Total: %.2f, Prix HT: %.2f",
                    materiel.getNom(),
                    materiel.getCout_unt(),
                    materiel.getQty(),
                    materiel.getCout_trnspr(),
                    materiel.getCoeff_qlt(),
                    materiel.getTva(),
                    total,
                    prix_ht
                    );

            System.out.println(output);
        });
        double total_ttc = totalTTC(totals);
        double total_ht = totalHT(HT);
        System.out.println("====>MONTANT HORS TAXES: "+total_ht);
        System.out.println("====>MONTANT TTC: "+total_ttc);
        return total_ttc;
    }
    @Override
    public double calculateTotal(Materiel materiel){
        return ((materiel.getCout_unt()*materiel.getQty()*materiel.getCoeff_qlt())*(1+(materiel.getTva())/100))+ materiel.getCout_trnspr();
    }
    @Override
    public double calculHorsTaxes(Materiel materiel){
        return ((materiel.getCout_unt()*materiel.getQty()*materiel.getCoeff_qlt())+ materiel.getCout_trnspr());

    }
    @Override
    public double totalHT(@NotNull List<Double> totals) {
        return totals.stream().mapToDouble(Double::doubleValue).sum();

    }
    @Override
    public double totalTTC(@NotNull List<Double> ttc){
        return ttc.stream().mapToDouble(Double::doubleValue).sum();

    }
}
