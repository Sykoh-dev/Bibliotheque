package Bibliotheque.data_access;

import Bibliotheque.model.Clients;
import java.util.List;

public interface ClientsDAO {

    // CREATE
    boolean insert(Clients client);

    // READ
    Clients getOne(String titre);
    List<Clients> getAll();

    // UPDATE
    //void update (Section section);
    // ou
    boolean update(Clients client);

    // DELETE
    boolean delete(String client_id);
}
