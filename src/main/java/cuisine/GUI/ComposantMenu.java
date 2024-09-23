package cuisine.GUI;

import cuisine.entities.Composant;
import cuisine.entities.MainOuev;
import cuisine.entities.Materiel;
import cuisine.entities.Projet;
import cuisine.services.MainOuevService;
import cuisine.services.MaterielService;
import cuisine.services.ProjetService;
import cuisine.services.interfaces.MainOuevServiceInterface;
import cuisine.services.interfaces.MaterielServiceInterface;
import cuisine.services.interfaces.ProjetServiceInteface;

import java.util.Scanner;

public class ComposantMenu {
    private static Scanner sc = new Scanner(System.in);
    private static ProjetServiceInteface projetService = new ProjetService();
    private static MainOuevServiceInterface mainOuevService = new MainOuevService();
    private static MaterielServiceInterface materielService = new MaterielService();
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
            System.out.println("====>ENTRER LE TAUX DE TVA:");
            double tva = sc.nextDouble();
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
            mainOuev.setTva(tva);
            ((MainOuev) mainOuev).setTaux_horaire(taux);
            ((MainOuev) mainOuev).setHeures_travail(heures);
            ((MainOuev) mainOuev).setCoeff_prod(coef);
            mainOuevService.addMainOuev((MainOuev) mainOuev,projet);

        }while(reponse.equals("y")||reponse.equals("Y"));
        addMateriel(projet);


    }
    public static void addMateriel(Projet projet){
        String reponse = "";
        System.out.println("====>VOUS ETES ENTRAIN D'AJOUTER UN MATERIEL:");
        do{
            System.out.println("ENTRER LE NOM DE MATERIEL:");
            String nom = sc.nextLine();
            System.out.println("ENTRER LE COUT UNITAIRE EN (DH):");
            double cout = sc.nextDouble();
            System.out.println("ENTRER LA QUANTITE:");
            double qty = sc.nextDouble();
            System.out.println("ENTRER LE COUT DE TRANSPORT:");
            double cout_trnspr = sc.nextDouble();
            System.out.println("====>ENTRER LE TAUX DE TVA:");
            double tva = sc.nextDouble();
            System.out.println("ENTRER LE COEFF QUALITE:");
            double coeff = sc.nextDouble();
            sc.nextLine();
            System.out.println("====>Voulez-vous ajouter un autre? (y/n):");
            reponse = sc.nextLine();
            Composant materiel= new Materiel();
            materiel.setNom(nom);
            materiel.setType(materiel.getType());
            materiel.setProjet(projet);
            materiel.setTva(tva);
            ((Materiel) materiel).setCout_unt(cout);
            ((Materiel) materiel).setQty(qty);
            ((Materiel)materiel).setCout_trnspr(cout_trnspr);
            ((Materiel)materiel).setCoeff_qlt(coeff);
            materielService.addMateriel((Materiel) materiel,projet);
        }while(reponse.equals("y")||reponse.equals("Y"));




    }
}
