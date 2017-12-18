package main.java.by.bsuir.pms413802.Chayevskiy.service;

import main.java.by.bsuir.pms413802.Chayevskiy.DAO.RelationDAO;
import main.java.by.bsuir.pms413802.Chayevskiy.entity.Relation;
import main.java.by.bsuir.pms413802.Chayevskiy.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class RelationService extends SessionUtil implements RelationDAO {
    @Override
    public void add(Relation relation) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(relation);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Relation> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM UserTariffRelation";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Relation.class);
        List<Relation> relationList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return relationList;
    }

    @Override
    public Relation getById(int id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM UserTariffRelation WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Relation.class);
        query.setParameter("id", id);

        Relation relation = (Relation) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return relation;
    }

    @Override
    public void update(Relation relation) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(relation);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void remove(Relation relation) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(relation);

        //close session with a transaction
        closeTransactionSession();
    }
}
