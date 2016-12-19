package it.navigator.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
public class ClientEntityPK implements Serializable {
    private int idClient;
    private int telefoneid;

    @Column(name = "idClient")
    @Id
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Column(name = "telefoneid")
    @Id
    public int getTelefoneid() {
        return telefoneid;
    }

    public void setTelefoneid(int telefoneid) {
        this.telefoneid = telefoneid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntityPK that = (ClientEntityPK) o;

        if (idClient != that.idClient) return false;
        if (telefoneid != that.telefoneid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + telefoneid;
        return result;
    }
}
