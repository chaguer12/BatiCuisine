package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Client;
import cuisine.repository.interfaces.ClientInterface;
import cuisine.repository.repositories.ClientRepository;

import java.sql.Connection;

public class ClientService {
    private final Connection conn = DatabaseConnection.getConnection();
    private ClientInterface clientRepo = new ClientRepository(conn);
    public void addClient(Client client){
        clientRepo.save(client);
    }


}
