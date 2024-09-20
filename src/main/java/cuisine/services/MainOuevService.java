package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.MainOuev;
import cuisine.repository.interfaces.MainOuevInterface;
import cuisine.repository.repositories.MainOuevRepository;

import java.sql.Connection;

public class MainOuevService {
    private final Connection conn = DatabaseConnection.getConnection();
    private MainOuevInterface mainOuevInterface = new MainOuevRepository(conn);
    public void addMainOuev(MainOuev mainOuev) {
        mainOuevInterface.save(mainOuev);

    }
}
