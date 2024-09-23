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
    private ProjetInterface projetInterface = new ProjetRepository(conn);
    @Override
    public void addMainOuev(MainOuev mainOuev, Projet projet) {
        mainOuevInterface.save(mainOuev ,projet);

    }
    @Override
    public List<MainOuev> getAllMainOuev(Projet projet) {
        List<MainOuev> mains = mainOuevInterface.findAll(projet);

        mains.forEach(main -> {

            double total = calculateTotal(main);
            String output = String.format("Nom: %s, Taux_horaire: %.2f, Heures de travail: %.2f, TVA: %.2f,Coeff: %.2f, Montant total: %.2f",main.getNom(),main.getTaux_horaire(),main.getHeures_travail(),main.getTva(),main.getCoeff_prod(),total);
            System.out.println(output);
        });
        return mains;


    }
    private double calculateTotal(@NotNull MainOuev main){
        return (main.getHeures_travail()*main.getTaux_horaire()*main.getCoeff_prod())*(1+(main.getTva()/100));
    }

}
