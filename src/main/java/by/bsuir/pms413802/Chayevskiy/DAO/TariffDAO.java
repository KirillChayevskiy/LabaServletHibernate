package main.java.by.bsuir.pms413802.Chayevskiy.DAO;

import main.java.by.bsuir.pms413802.Chayevskiy.entity.Tariff;

import java.sql.SQLException;
import java.util.List;

public interface TariffDAO {
    //create
    void add(Tariff tariff) throws SQLException;
    //read
    List<Tariff> getAll() throws SQLException;

    Tariff getById(int id) throws SQLException;

    //update
    void update(Tariff tariff) throws SQLException;

    //delete
    void remove(Tariff tariff) throws SQLException;
}
