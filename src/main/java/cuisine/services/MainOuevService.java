package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Composant;
import cuisine.entities.MainOuev;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MainOuevInterface;
import cuisine.repository.interfaces.ProjetInterface;
import cuisine.repository.repositories.MainOuevRepository;
import cuisine.repository.repositories.ProjetRepository;
import cuisine.services.interfaces.MainOuevServiceInterface;
import cuisine.services.interfaces.ProjetServiceInteface;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MainOuevService implements MainOuevServiceInterface {


    private final Connection conn = DatabaseConnection.getConnection();
    private MainOuevInterface mainOuevInterface = new MainOuevRepository(conn);
    @Override
    public void addMainOuev(MainOuev mainOuev, Projet projet) {
        mainOuevInterface.save(mainOuev ,projet);

    }
    @Override
    public List<MainOuev> getAllMainOuev(Projet projet) {
        List<Double> totals = new ArrayList<>();
        List<Double> HT = new ArrayList<>();
        System.out.println("====\tMAIN D'OUEVRE\t====");
        List<MainOuev> mains = mainOuevInterface.findAll(projet);
        mains.forEach(main -> {

            double total = calculateTotal(main);
            totals.add(total);
            double prix_ht = calculHorsTaxes(main);
            HT.add(prix_ht);
            String output = String.format("Nom: %s, Taux_horaire: %.2f, Heures de travail: %.2f, TVA: %.2f,Coeff: %.2f, Montant total: %.2f, Prix HT: %.2f",main.getNom(),main.getTaux_horaire(),main.getHeures_travail(),main.getTva(),main.getCoeff_prod(),total,prix_ht);
            System.out.println(output);
        });
        double total_ttc = totalTTC(totals);
        double total_ht = totalHT(HT);
        System.out.println("====>MONSTANT HORS TAXES: "+total_ht);
        System.out.println("====>MONSTANT TTC: "+total_ttc);
        return mains;
    }
    @Override
    public double calculateTotal(@NotNull MainOuev main){
        return (main.getHeures_travail()*main.getTaux_horaire()*main.getCoeff_prod())*(1+(main.getTva()/100));
    }
    @Override
    public double calculHorsTaxes(@NotNull MainOuev main) {
        return (main.getHeures_travail()*main.getTaux_horaire()*main.getCoeff_prod());
    }
    @Override
    public double totalHT(List<Double> totals) {
        return totals.stream().mapToDouble(Double::doubleValue).sum();

    }
    @Override
    public double totalTTC(List<Double> ttc){
        return ttc.stream().mapToDouble(Double::doubleValue).sum();

    }

}
