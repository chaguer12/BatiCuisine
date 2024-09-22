package cuisine.services.interfaces;

import cuisine.entities.Client;

public interface ClientServiceInterface {
    void addClient(Client client);
    void getAllClients();
    Client getClientById(int id);

}
