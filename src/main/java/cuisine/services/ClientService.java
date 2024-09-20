package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Client;
import cuisine.repository.interfaces.ClientInterface;
import cuisine.repository.repositories.ClientRepository;

import java.sql.Connection;
import java.util.List;

public class ClientService {
    private final Connection conn = DatabaseConnection.getConnection();
    private ClientInterface clientRepo = new ClientRepository(conn);
    public void addClient(Client client){
        clientRepo.save(client);
    }
    public  void getAllClients(){
        List<Client> clients = clientRepo.findAll();
        clients.stream().forEach(c -> System.out.println("Id: " + c.getId()+", Nom complet: " + c.getNom_complet() + ", Adresse: "+c.getAdresse() + ", Tel: " + c.getTel() ));

    }
    public Client getClientById(int id){
        Client client = clientRepo.findById(id);
        return client;
    }


}
