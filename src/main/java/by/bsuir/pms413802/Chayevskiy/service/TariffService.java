package main.java.by.bsuir.pms413802.Chayevskiy.service;

import main.java.by.bsuir.pms413802.Chayevskiy.DAO.TariffDAO;
import main.java.by.bsuir.pms413802.Chayevskiy.entity.Tariff;
import main.java.by.bsuir.pms413802.Chayevskiy.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class TariffService extends SessionUtil implements TariffDAO {

    @Override
    public void add(Tariff tariff) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(tariff);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Tariff> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Tariff";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Tariff.class);
        List<Tariff> tariffList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return tariffList;
    }

    @Override
    public Tariff getById(int id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM Tariff WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Tariff.class);
        query.setParameter("id", id);

        Tariff tariff = (Tariff) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return tariff;
    }

    @Override
    public void update(Tariff tariff) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(tariff);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void remove(Tariff tariff) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(tariff);

        //close session with a transaction
        closeTransactionSession();
    }
}
