package cuisine.repository.repositories;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Composant;
import cuisine.entities.Materiel;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MaterielInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterielRepository implements MaterielInterface {
    private static Connection conn ;


    public MaterielRepository(Connection conn) {
        this.conn = conn;
    }
   @Override
    public void saveMateriel(Materiel materiel , Projet projet) {
        String query = "insert into materiaux(nom,type_composant,projet_id,cout_unt,quantite,cout_transport,coeff_qlt,tva) values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, materiel.getNom());
            ps.setString(2, materiel.getType());
            ps.setInt(3,projet.getId());
            ps.setDouble(4,materiel.getCout_unt());
            ps.setDouble(5,materiel.getQty());
            ps.setDouble(6,materiel.getCout_trnspr());
            ps.setDouble(7,materiel.getCoeff_qlt());
            ps.setDouble(8,materiel.getTva());
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("INSERTION GONE WRONG => " +e.getMessage());
        };
    }
    @Override
    public List<Materiel> findAll(Projet projet) {
        List<Materiel> materiaux = new ArrayList<>();
        String query = "select * from materiaux where projet_id = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, projet.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Composant Materiel = new Materiel();
                Materiel.setNom(rs.getString("nom"));
                ((Materiel)Materiel).setCout_unt(rs.getDouble("cout_unt"));
                ((Materiel)Materiel).setQty(rs.getDouble("quantite"));
                ((Materiel)Materiel).setCout_trnspr(rs.getDouble("cout_transport"));
                ((Materiel)Materiel).setCoeff_qlt(rs.getDouble("coeff_qlt"));
                ((Materiel)Materiel).setTva(rs.getDouble("tva"));
                materiaux.add((Materiel)Materiel);
            }

        }catch(SQLException e){
            System.out.println("FETCHING GONE WRONG => "+ e.getMessage());
        }
        return materiaux;
    }
}
