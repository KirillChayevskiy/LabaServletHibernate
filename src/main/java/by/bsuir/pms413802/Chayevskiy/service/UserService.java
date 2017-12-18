package main.java.by.bsuir.pms413802.Chayevskiy.service;

import main.java.by.bsuir.pms413802.Chayevskiy.DAO.UserDAO;
import main.java.by.bsuir.pms413802.Chayevskiy.entity.User;
import main.java.by.bsuir.pms413802.Chayevskiy.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserService  extends SessionUtil implements UserDAO {

    @Override
    public void add(User user) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(user);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<User> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM User";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        List<User> userList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return userList;
    }

    @Override
    public User getById(int id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM User WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        query.setParameter("id", id);

        User user = (User) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(user);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void remove(User user) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(user);

        //close session with a transaction
        closeTransactionSession();
    }
}
