package it.navigator.dao;

import it.navigator.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
@Repository
public class ClientDAOImpl implements ClientDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Client> getAllClient() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> list = session.createQuery("from Client").list();
        return list;
    }

    public void update(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
    }

    public void updateAll(List<Client> list) {
        Session session = sessionFactory.getCurrentSession();
        list.forEach(client->{
            session.update(client);
        });
    }
}
