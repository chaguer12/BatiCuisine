package cuisine.repository.repositories;

import cuisine.entities.Enums.EtatProjet;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.ProjetInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetRepository implements ProjetInterface {
    private static Connection conn;

    public ProjetRepository(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(Projet projet){
        String query= "insert into projets (nom,marge_bénèfique,etat,client_id) values (?,?,?::etat_projet,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, projet.getNom());
            stmt.setDouble(2,projet.getMarge_benefique());
            stmt.setString(3,EtatProjet.EN_COURS.toString());
            stmt.setInt(4,projet.getClient().getId());
            stmt.executeUpdate();
            System.out.println("projet insérer avec succés");



        } catch (SQLException e) {
            System.out.println("insertion gone wrong => " + e.getMessage());
        }

    }
    public void saveCoutTotal(Projet projet){
        String query = "update projets set cout_total = ? where id = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1,projet.getCout_total());
            ps.setInt(2,projet.getId());
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("INSERTING GONE WRONG=> " + e.getMessage());
        }
    }
    @Override
    public List<Projet> findAll(){
        List<Projet> projets = new ArrayList<>();
        String query = "select * from projets";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Projet projet = converter(rs);
                projets.add(projet);
                }
        }catch(SQLException e) {
            System.out.println("Fetching gone wrong => " + e.getMessage());
        }
        return projets;
    }
    @Override
    public Projet findById(int id){
        String query = "select * from projets where id=?";
        Projet projet = null;
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                projet = converter(rs);
            }

        }catch(SQLException e){
            System.out.println("Fetching gone wrong => " + e.getMessage());
        }
        return projet;
    }

    public Projet converter(ResultSet rs) throws SQLException {
        Projet projet = new Projet();
        projet.setId(rs.getInt("id"));
        projet.setNom(rs.getString("nom"));
        projet.setMarge_benefique(rs.getDouble("marge_bénèfique"));
        projet.setEtat_projet(EtatProjet.valueOf(rs.getString("etat")));
        return projet;

    }

}
