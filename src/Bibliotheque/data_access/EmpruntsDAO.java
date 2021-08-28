package Bibliotheque.data_access;

import Bibliotheque.model.Clients;
import Bibliotheque.model.Emprunts;

import java.util.List;

public interface EmpruntsDAO {


    // CREATE
    boolean insert(Emprunts emprunts);

    // READ
    Emprunts getOne(String titre);
    List<Emprunts> getAll();

    // UPDATE
    //void update (Section section);
    // ou
    boolean update(Emprunts emprunts);

    // DELETE
    boolean delete(String emprunt_id);

}
