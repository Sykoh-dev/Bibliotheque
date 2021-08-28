package Bibliotheque.data_access;

import Bibliotheque.model.Section;

import java.util.List;

public interface DAO<MODEL, ID> {

    // CREATE
    boolean insert(MODEL model);

    // READ
    MODEL getOne(ID id);
    List<MODEL> getAll();

    // UPDATE
    //void update (Section section);
    // ou
    boolean update(MODEL model);

    // DELETE
    boolean delete(ID id);
}
