package main.java.by.bsuir.pms413802.Chayevskiy.DAO;


import main.java.by.bsuir.pms413802.Chayevskiy.entity.Relation;

import java.sql.SQLException;
import java.util.List;

public interface RelationDAO {
    //create
    void add(Relation relation) throws SQLException;
    //read
    List<Relation> getAll() throws SQLException;

    Relation getById(int id) throws SQLException;

    //update
    void update(Relation relation) throws SQLException;

    //delete
    void remove(Relation relation) throws SQLException;
}
