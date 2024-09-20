package cuisine.repository.repositories;

import cuisine.entities.Client;
import cuisine.repository.interfaces.ClientInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements ClientInterface {
    private static Connection conn;
    public ClientRepository(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(Client client) {
        String query = "insert into clients (nom_complet,adresse,telephone,est_pro) values (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, client.getNom_complet());
            ps.setString(2, client.getAdresse());
            ps.setString(3,client.getTel());
            ps.setBoolean(4, client.isEst_pro());
            ps.executeUpdate();

        }catch(SQLException e) {
            System.out.println("insertion gone wrong => " + e.getMessage());
        }

    }
    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String query = "select * from clients";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom_complet(rs.getString("nom_complet"));
                client.setAdresse(rs.getString("adresse"));
                client.setTel(rs.getString("telephone"));
                client.setEst_pro(rs.getBoolean("est_pro"));
                clients.add(client);
            }
        }catch(SQLException e){
            System.out.println("Unable to fetch => " + e.getMessage());
        }
        return clients;
    }
    public Client findById(int id) {
        String query = "select * from clients where id=?";
        Client client = null;
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom_complet(rs.getString("nom_complet"));
                client.setAdresse(rs.getString("adresse"));
                client.setTel(rs.getString("telephone"));
                client.setEst_pro(rs.getBoolean("est_pro"));
            }
        }catch(SQLException e){System.out.println("Unable to fetch => " + e.getMessage());}
        return client;
    }

}
