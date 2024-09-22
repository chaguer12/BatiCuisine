package cuisine.repository.repositories;

import cuisine.entities.Composant;
import cuisine.entities.MainOuev;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MainOuevInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
    @Override
    public List<MainOuev> findAll(Projet projet) {
        List<MainOuev> mainOuevs = new ArrayList<>();
        String query = "select * from main_ouevre where projet_id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,projet.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Composant Mainouev = new MainOuev();
                Mainouev.setNom(rs.getString("nom"));
                Mainouev.setType(rs.getString("type_composant"));
                ((MainOuev)Mainouev).setTaux_horaire(rs.getInt("taux_horaire"));
                ((MainOuev)Mainouev).setHeures_travail(rs.getDouble("heures_travail"));
                ((MainOuev)Mainouev).setCoeff_prod(rs.getDouble("coeff_productivite"));
                ((MainOuev)Mainouev).setTva(rs.getDouble("tva"));
                mainOuevs.add((MainOuev) Mainouev);
            }
        } catch (SQLException e) {
            System.out.println("FETCHING GONE WRONG => "+ e.getMessage());
        }
        return mainOuevs;
    }


}
