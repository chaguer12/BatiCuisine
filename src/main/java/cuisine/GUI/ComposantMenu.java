package cuisine.GUI;

import cuisine.entities.Composant;
import cuisine.entities.MainOuev;
import cuisine.entities.Projet;
import cuisine.services.MainOuevService;
import cuisine.services.ProjetService;

import java.util.Scanner;

public class ComposantMenu {
    private static Scanner sc = new Scanner(System.in);
    private static ProjetService projetService = new ProjetService();
    private static MainOuevService mainOuevService = new MainOuevService();
    public static void addMainOuev(){
        int id = 0;
        String reponse = "";
        System.out.println("====\tVOUS ETES ENTRAIN D'AJOUTER UN OUVRIER\t===");
        System.out.println("====>VEUILLER ENTRER UN ID DE PROJET:");
        id = sc.nextInt();
        Projet projet = projetService.getProjetById(id);
        System.out.println("vous avez choisi => "+ id);
        sc.nextLine();
        do{
            System.out.println("====>ENTRER LE NOM D'OUVRIER:");
            String nom = sc.nextLine();
            System.out.println("====>ENTRER LE TAUX HORAIRE:");
            double taux = sc.nextDouble();
            System.out.println("====>ENTRER LES HEURES DE TRAVAIL:");
            double heures = sc.nextDouble();
            System.out.println("====>ENTRER LE COEFF DE PRODUCTIVITE:");
            double coef = sc.nextDouble();
            sc.nextLine();
            System.out.println("====>Voulez-vous ajouter un autre? (y/n):");
            reponse = sc.nextLine();
            Composant mainOuev= new MainOuev();
            mainOuev.setNom(nom);
            mainOuev.setType(mainOuev.getType());
            ((MainOuev) mainOuev).setTaux_horaire(taux);
            ((MainOuev) mainOuev).setHeures_travail(heures);
            ((MainOuev) mainOuev).setCoeff_prod(coef);
            mainOuevService.addMainOuev((MainOuev) mainOuev,projet);
        }while(reponse.equals("y")||reponse.equals("Y"));


    }
    public static void addMateriel(){
        
    }
}
