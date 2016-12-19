package it.navigator.service;

import it.navigator.entity.Client;
import it.navigator.entity.ClientEntity;

import java.util.List;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
public interface ClientService {
    public List<Client> getAllClient();

    public void update(Client client);

    public void updateAll(List<Client> list);
}
