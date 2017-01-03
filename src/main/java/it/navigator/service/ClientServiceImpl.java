package it.navigator.service;

import it.navigator.dao.ClientDAO;
import it.navigator.dao.ClientDAOImpl;
import it.navigator.entity.Client;
import it.navigator.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
@Component
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDAO dao;
    @Override
    @Transactional(readOnly = true)
    public List<Client> getAllClient() {
        return dao.getAll();
    }

    @Override
    public void update(Client client) {
        dao.update(client);
    }

    @Override
    public void updateAll(List<Client> list) {
        dao.updateAll(list);
    }
}
