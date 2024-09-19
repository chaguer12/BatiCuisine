package cuisine.GUI;

import cuisine.entities.Projet;
import cuisine.services.ProjetService;

import java.util.Scanner;

public class Menu {
    private static ProjetService projetService = new ProjetService();
    private static Scanner scanner = new Scanner(System.in);
    public static void MainMenu() throws Exception {
        int choice = 0;
        do {
            System.out.println("====\tBONJOUR!\t====");
            Thread.sleep(300);
            System.out.println("[1]. Ajouter un projet.");
            System.out.println("[2]. Afficher les projets existants.");
            System.out.println("[3]. Calculer les couts d'un projet.");
            System.out.println("[4]. Ajouter un client.");
            System.out.println("[5]. Sortir.");
            System.out.println("====\tENTRER UN NUMERO ->:");


            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch(Exception e){
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    MenuAjoutProjet();
                    break;
                case 2:
                    projetService.getAllProjets();
                    break;
                case 3:
                    //Calcul();
                    break;
                case 4:
                    MenuAjoutClient();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }


        } while (choice != 4);
    }
    public void MenuAjoutProjet() {
        System.out.println("====\tVOUS ETES ENTRAIN D'AJOUTER UN PROJET\t===");
        System.out.println("====>ENTRER LE NOM DU PROJET:");
        String nom = scanner.nextLine();
        System.out.println("====>ENTRER LA MARGE BENEFIQUE EN (%):");
        double marge = scanner.nextDouble();
        Projet projet = new Projet();
        projet.setNom(nom);
        projet.setMarge_benefique(marge);
        projetService.addProjet(projet);


    }
    public void MenuAjoutClient(){
        boolean est_pro;
        System.out.println("====\tVOUS ETES ENTRAIN D'AJOUTER UN CLIENT\t===");
        System.out.println("====>ENTRER LE NOM COMPLET DU CLIENT:");
        String nom = scanner.nextLine();
        System.out.println("====>ENTRER L'ADRESSE DU CLIENT:");
        String adresse = scanner.nextLine();
        System.out.println("====>ENTRER LE TELEPHONE:");
        String telephone = scanner.nextLine();
        System.out.println("====>EST CE QU'IL EST PRO? (O/N):");
        if(scanner.nextLine().equals("O") || scanner.nextLine().equals("o")){
            est_pro = true;
        } else if (scanner.nextLine().equals("N") || scanner.nextLine().equals("n")) {
            est_pro = false;
        }


    }
}
