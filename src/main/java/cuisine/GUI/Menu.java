package cuisine.GUI;

import cuisine.entities.Client;
import cuisine.entities.Projet;
import cuisine.services.ClientService;
import cuisine.services.ProjetService;

import java.util.Scanner;

public class Menu {
    private static ProjetService projetService = new ProjetService();
    private static ClientService clientService = new ClientService();
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
                    MainOuevMenu.addMainOuev();
                    break;
                case 3:
                    //Calcul();
                    break;
                case 4:
                    MenuAjoutClient();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }


        } while (choice != 4);
    }
    public static void MenuAjoutProjet() {
        String reponse;
        System.out.println("====\tVOUS ETES ENTRAIN D'AJOUTER UN PROJET\t===");
        System.out.println("====>ENTRER LE NOM DU PROJET:");
        String nom = scanner.nextLine();
        System.out.println("====>ENTRER LA MARGE BENEFIQUE EN (%):");
        double marge = scanner.nextDouble();
        System.out.println("====>ASSIGNER UN CLIENT AU PROJET");
        clientService.getAllClients();
        System.out.println("====>ENTRER UN CLIENT AU PROJET(entrez l'id du client):");
        int id = scanner.nextInt();
        Client client = clientService.getClientById(id);
        Projet projet = new Projet();
        projet.setNom(nom);
        projet.setMarge_benefique(marge);
        projet.setClient(client);
        projetService.addProjet(projet);


    }
    public static void MenuAjoutClient(){
        boolean est_pro = false;
        String reponse;
        System.out.println("====\tVOUS ETES ENTRAIN D'AJOUTER UN CLIENT\t===");
        System.out.println("====>ENTRER LE NOM COMPLET DU CLIENT:");
        String nom = scanner.nextLine();
        System.out.println("====>ENTRER L'ADRESSE DU CLIENT:");
        String adresse = scanner.nextLine();
        System.out.println("====>ENTRER LE TELEPHONE:");
        String telephone = scanner.nextLine();
        do{

            reponse = scanner.nextLine();
            if(reponse.equals("O") || reponse.equals("o")){
                est_pro = true;
                System.out.println("====\t il est pro");
            } else if (reponse.equals("N") || reponse.equals("n")) {
                est_pro = false;
                System.out.println("====\t il n'est pas pro");

            }
        }while(!reponse.equals("O") && !reponse.equals("n") && !reponse.equals("o") && !reponse.equals("N"));
        Client client = new Client();
        client.setNom_complet(nom);
        client.setAdresse(adresse);
        client.setTel(telephone);
        client.setEst_pro(est_pro);
        clientService.addClient(client);


    }
}
