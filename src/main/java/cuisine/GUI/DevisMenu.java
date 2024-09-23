package cuisine.GUI;

import cuisine.entities.*;
import cuisine.services.MainOuevService;
import cuisine.services.MaterielService;
import cuisine.services.ProjetService;
import cuisine.services.interfaces.MainOuevServiceInterface;
import cuisine.services.interfaces.MaterielServiceInterface;
import cuisine.services.interfaces.ProjetServiceInteface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DevisMenu {
    private static ProjetServiceInteface projetService = new ProjetService();
    private static MainOuevServiceInterface mainOuevService = new MainOuevService();
    private static MaterielServiceInterface materielService = new MaterielService();
    public static void generateDevis(Scanner scanner) {
        System.out.println("====\tDEVIS\t====");
        Optional<List<Projet>> OptionalProjetsCalcs = projetService.getAllProjets();
        if (OptionalProjetsCalcs.stream().count() < 1) {
            System.out.println("Aucun projet trouvé. Arrêt du programme.");
            return;
        }
        System.out.println("===>VEUILLER SELECTIONER UN PROJET:");
        int id = scanner.nextInt();
        Projet projet = projetService.getProjetById(id);
        System.out.println("En cours de calculations...");
        System.out.println("====\tMONTANTS\t====");
        List<MainOuev> mains = mainOuevService.getAllMainOuev(projet);
        List<Materiel> materiaux = materielService.getAllMateriel(projet);
        System.out.println("====>VOULEZ VOUS APPLIQUER UNE MARGE BENEFICIERE? (y/n)");
        String reponse = scanner.nextLine();
        LocalDate date = LocalDate.now();
        System.out.println("====>DATE D'EMISSION EST: " + date);

    }
}
