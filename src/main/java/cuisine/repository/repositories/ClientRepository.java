package cuisine.repository.repositories;

import cuisine.entities.Client;
import cuisine.repository.interfaces.ClientInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientRepository implements ClientInterface {
    private static Connection conn;
    public ClientRepository(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(Client client) {
        String query = "insert into clients (nom_complet,adresse,telephone) values (?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, client.getNom_complet());
            ps.setString(2, client.getAdresse());
            ps.setString(3,client.getTel());
            ps.executeUpdate();

        }catch(SQLException e) {
            System.out.println("insertion gone wrong => " + e.getMessage());
        }

    }
}
