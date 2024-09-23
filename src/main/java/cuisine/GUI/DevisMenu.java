package cuisine.GUI;

import cuisine.entities.*;
import cuisine.services.DevisService;
import cuisine.services.MainOuevService;
import cuisine.services.MaterielService;
import cuisine.services.ProjetService;
import cuisine.services.interfaces.DevisServiceInterface;
import cuisine.services.interfaces.MainOuevServiceInterface;
import cuisine.services.interfaces.MaterielServiceInterface;
import cuisine.services.interfaces.ProjetServiceInteface;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DevisMenu {
    private static ProjetServiceInteface projetService = new ProjetService();
    private static MainOuevServiceInterface mainOuevService = new MainOuevService();
    private static MaterielServiceInterface materielService = new MaterielService();
    private static DevisServiceInterface devisService = new DevisService();
    public static void generateDevis(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
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
        System.out.println("====>VOULEZ VOUS APPLIQUER UNE MARGE BENEFICIERE? (o/n)");
        String reponse = scanner.nextLine();
        if (reponse.equals("o") || reponse.equals("O")) {
            System.out.println("====>UNE MARGE BENEFIQUE DE "+projet.getMarge_benefique()+ "% SERA APPLIQUE");
        }
        scanner.nextLine();
        LocalDate date = LocalDate.now();
        System.out.println("====>DATE D'EMISSION EST: " + date);
        Double mains = mainOuevService.getAllMainOuev(projet);
        Double materiaux = materielService.getAllMateriel(projet);
        System.out.println("====>AJOUTER UNE DATE D'EXPIRATION:(JJ-MM-AAAA)");
        String dateExp = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(dateExp, formatter);
        System.out.println("Date d'expiration ajoutée: " + expirationDate);
        System.out.println("====>VOULEZ VOUS APPLIQUER UNE REMISE? (o/n)");
        String reponse_remise = scanner.nextLine();
        double remise = 20;
        if (reponse_remise.equals("n") || reponse_remise.equals("N")) {
            remise = 0;
        }
        System.out.println("====>EST CE QUE VOUS CONFIRMER CE DEVIS? (o/n)");
        String confirmer = scanner.nextLine();
        projet.setCout_total((mains + materiaux) * (1-remise/100));
        Devis devis = new Devis();
        devis.setMontant_estime((mains+materiaux) * (1+ projet.getMarge_benefique()/100));
        devis.setDate_emission(Date.valueOf(date));
        devis.setDate_expiration(Date.valueOf(expirationDate));
        if (confirmer.equals("o") || confirmer.equals("O")) {
            devis.setAccepte(true);
            devisService.acceptDevis(devis);

        }
        devisService.save(devis,projet);
        projetService.saveCoutTotal(projet);
        System.out.println("====>DEVIS ACCEPTE");
    }
}
