package Bibliotheque.data_access;

import Bibliotheque.model.Livres;
import java.util.List;

public interface LivresDAO{

    // CREATE
    boolean insert(Livres livres);

    // READ
    Livres getOne(String titre);
    List<Livres> getAll();

    // UPDATE
    //void update (Section section);
    // ou
    boolean update(Livres Livres);

    // DELETE
    boolean delete(String ISBN);

}