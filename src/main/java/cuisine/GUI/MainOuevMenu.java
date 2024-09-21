package cuisine.GUI;

import cuisine.entities.MainOuev;
import cuisine.entities.Projet;
import cuisine.services.MainOuevService;
import cuisine.services.ProjetService;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MainOuevMenu {
    private static Scanner sc = new Scanner(System.in);
    private static ProjetService projetService = new ProjetService();
    private static MainOuevService mainOuevService = new MainOuevService();
    public static void addMainOuev(){
        int id = 0;
        System.out.println("====\tVOUS ETES ENTRAIN D'AJOUTER UN OUVRIER\t===");
        System.out.println("====>VEUILLER ENTRER UN ID DE PROJET:");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("vous avez choisi => "+ id);
        System.out.println("====>ENTRER LE NOM D'OUVRIER:");
        String nom = sc.nextLine();
        System.out.println("====>ENTRER LE TAUX HORAIRE:");
        double taux = sc.nextDouble();
        System.out.println("====>ENTRER LES HEURES DE TRAVAIL:");
        double heures = sc.nextDouble();
        System.out.println("====>ENTRER LE COEFF DE PRODUCTIVITE:");
        double coef = sc.nextDouble();
        Projet projet = projetService.getProjetById(id);
        MainOuev mainOuev= new MainOuev();
        mainOuev.setNom(nom);
        mainOuev.setType(mainOuev.getType());
        mainOuev.setTaux_horaire(taux);
        System.out.println("votre projet  =>" + projet.getId());
        mainOuev.setHeures_travail(heures);
        mainOuev.setCoeff_prod(coef);
        mainOuevService.addMainOuev(mainOuev,projet);


    }
}
