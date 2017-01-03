package it.navigator.dao;

import it.navigator.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ClientDAOImpl extends GenericDAOImpl<Client> implements ClientDAO {

}
