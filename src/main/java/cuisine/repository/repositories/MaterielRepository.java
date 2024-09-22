package cuisine.repository.repositories;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Materiel;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MaterielInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterielRepository implements MaterielInterface {
    private static Connection conn ;
    public MaterielRepository(Connection conn) {
        this.conn = conn;
    }
   @Override
    public void saveMateriel(Materiel materiel , Projet projet) {
        String query = "insert into materiaux(nom,type_composant,projet_id,cout_unt,quantite,cout_transport,coeff_qlt) values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, materiel.getNom());
            ps.setString(2, materiel.getType());
            ps.setInt(3,projet.getId());
            ps.setDouble(4,materiel.getCout_unt());
            ps.setDouble(5,materiel.getQty());
            ps.setDouble(6,materiel.getCout_trnspr());
            ps.setDouble(7,materiel.getCoeff_qlt());
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("INSERTION GONE WRONG => " +e.getMessage());
        };
    }
}
