package cuisine.GUI;

import cuisine.entities.Client;
import cuisine.entities.Projet;
import cuisine.services.ClientService;
import cuisine.services.MainOuevService;
import cuisine.services.ProjetService;
import cuisine.services.interfaces.ClientServiceInterface;
import cuisine.services.interfaces.MainOuevServiceInterface;
import cuisine.services.interfaces.ProjetServiceInteface;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;



public class Menu {

    private static ProjetServiceInteface projetService = new ProjetService();
    private static ClientServiceInterface clientService = new ClientService();
    private static MainOuevServiceInterface mainOuevService = new MainOuevService();
    private static Scanner scanner = new Scanner(System.in);
    public static void MainMenu() {


        int choice = 0;
        do {
            System.out.println("====\tBONJOUR!\t====");

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
                    Optional<List<Projet>>OptionalProjets = projetService.getAllProjets();
                    if (OptionalProjets.stream().count() < 1) {
                        System.out.println("Aucun projet trouvé. Arrêt du programme.");
                        return;
                    }
                    ComposantMenu.addMainOuev();


                    break;
                case 3:
                    Optional<List<Projet>>OptionalProjetsCalcs = projetService.getAllProjets();
                    if (OptionalProjetsCalcs.stream().count() < 1) {
                        System.out.println("Aucun projet trouvé. Arrêt du programme.");
                        return;
                    }
                    System.out.println("===>VEUILLER SELECTIONER UN PROJET:");
                    int id = scanner.nextInt();
                    Projet projet = projetService.getProjetById(id);
                    mainOuevService.getAllMainOuev(projet);
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
            System.out.println("====>EST CE QU'IL EST PRO? (o/n):");
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
        Menu.MainMenu();


    }

}
