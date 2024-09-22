package cuisine.repository.repositories;

import cuisine.entities.MainOuev;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MainOuevInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MainOuevRepository implements MainOuevInterface {
    private static Connection conn;
    public MainOuevRepository(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(MainOuev mainOuev, Projet projet) {
        System.out.println("le type est => " +mainOuev.getType());
        String query = "insert into main_ouevre (nom,type_composant,projet_id,taux_horaire,heures_travail,coeff_productivite,tva) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, mainOuev.getNom());
            stmt.setString(2, mainOuev.getType());
            stmt.setInt(3,projet.getId());
            stmt.setDouble(4,mainOuev.getTaux_horaire());
            stmt.setDouble(5,mainOuev.getHeures_travail());
            stmt.setDouble(6,mainOuev.getCoeff_prod());
            stmt.setDouble(7,mainOuev.getTva());
            stmt.executeUpdate();
            System.out.println("main ouevre insérer avec succés");


        }catch(SQLException e) {
            System.out.println("INSERTING GONE WRONG => "+ e.getMessage());
        }
    }
}
