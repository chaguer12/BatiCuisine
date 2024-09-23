package cuisine.repository.repositories;

import cuisine.entities.Devis;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.DevisInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DevisRepository implements DevisInterface {
    private static Connection conn;
    public DevisRepository(Connection conn) {
        this.conn = conn;

    }
    public void save(Devis devis, Projet projet){
        String query = "insert into devis (montantestime,date_emission,date_expiration,projet_id,accept) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1,devis.getMontant_estime());
            ps.setDate(2,devis.getDate_emission());
            ps.setDate(3,devis.getDate_expiration());
            ps.setInt(4,projet.getId());
            ps.setBoolean(5,devis.isAccepte());


        } catch (SQLException e) {
            System.out.println("INSERTION GONE WRONG => " +e.getMessage());
        }

    }
    @Override
    public void acceptDevis(Devis devis){
        String query = "update devis set accept = true where id = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1,devis.getId());
            ps.executeUpdate();
            System.out.println("Devis accepté");

        } catch (SQLException e) {
            System.out.println("FETCHING GONE WRONG => "+ e.getMessage());
        }
    }

}
