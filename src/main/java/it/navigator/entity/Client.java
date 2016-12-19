package it.navigator.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 13.12.2016.
 */
@Entity
@Table(name = "Client", schema = "itNavigator")
public class Client {
    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="telefoneid", updatable = false, insertable = false)
    private Telefone telefone;
    @Basic
    @Column(name = "fio")
    private String fio;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

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

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (telefone != null ? !telefone.equals(client.telefone) : client.telefone != null) return false;
        return fio != null ? fio.equals(client.fio) : client.fio == null;

    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", telefone="  +
                ", fio='" + fio + '\'' +
                '}';
    }
}
