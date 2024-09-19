package cuisine.repository;

import cuisine.entities.Enums.EtatProjet;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.ProjetInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProjetRepository implements ProjetInterface {
    private static Connection conn;

    public ProjetRepository(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(Projet projet){
        String query= "insert into projets (nom,marge_bénèfique,etat) values (?,?,?::etat_projet)";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, projet.getNom());
            stmt.setDouble(2,projet.getMarge_benefique());
            stmt.setString(3,EtatProjet.EN_COURS.toString());
            stmt.executeUpdate();
            System.out.println("projet insérer avec succés");



        } catch (Exception e) {
            System.out.println("insertion gone wrong => " + e.getMessage());
        }

    }
}
