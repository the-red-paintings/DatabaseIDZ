package it.navigator.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 12.12.2016.
 */
@Entity
@Table(name = "Client", schema = "itNavigator")
@IdClass(ClientEntityPK.class)
public class ClientEntity {
    private int idClient;
    private int telefoneid;
    private String fio;

    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Id
    @Column(name = "telefoneid")
    public int getTelefoneid() {
        return telefoneid;
    }

    public void setTelefoneid(int telefoneid) {
        this.telefoneid = telefoneid;
    }

    @Basic
    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (idClient != that.idClient) return false;
        if (telefoneid != that.telefoneid) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + telefoneid;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "idClient=" + idClient +
                ", telefoneid=" + telefoneid +
                ", fio='" + fio + '\'' +
                '}';
    }
}
