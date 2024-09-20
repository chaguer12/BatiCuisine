package cuisine.repository.interfaces;

import cuisine.entities.Client;

import java.util.List;

public interface ClientInterface {
    void save(Client client);
    List<Client> findAll();
    Client findById(int id);

}
