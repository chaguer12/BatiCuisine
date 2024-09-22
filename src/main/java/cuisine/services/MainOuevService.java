package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.MainOuev;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MainOuevInterface;
import cuisine.repository.repositories.MainOuevRepository;
import cuisine.services.interfaces.MainOuevServiceInterface;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MainOuevService implements MainOuevServiceInterface {


    private final Connection conn = DatabaseConnection.getConnection();
    private MainOuevInterface mainOuevInterface = new MainOuevRepository(conn);
    @Override
    public void addMainOuev(MainOuev mainOuev, Projet projet) {
        mainOuevInterface.save(mainOuev ,projet);

    }
    @Override
    public List<MainOuev> getAllMainOuev(Projet projet) {
        List<MainOuev> mains = mainOuevInterface.findAll(projet);
        return mains;


    }
}
