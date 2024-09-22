package cuisine.services;

import cuisine.config.DatabaseConnection;
import cuisine.entities.Materiel;
import cuisine.entities.Projet;
import cuisine.repository.interfaces.MaterielInterface;
import cuisine.repository.repositories.MaterielRepository;
import cuisine.services.interfaces.MaterielServiceInterface;

import java.sql.Connection;

public class MaterielService implements MaterielServiceInterface {
    private final Connection conn = DatabaseConnection.getConnection();
    private MaterielInterface materielInterface = new MaterielRepository(conn);
    @Override
    public void addMateriel(Materiel materiel , Projet projet){
        materielInterface.saveMateriel(materiel, projet);
    }
}
