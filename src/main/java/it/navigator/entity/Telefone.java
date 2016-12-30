package it.navigator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 13.12.2016.
 */
@Entity
@JsonIgnoreProperties({"client"})
@Table(name = "Telefone", schema = "itNavigator")
public class Telefone {
    @Id
    @Column(name = "idTelefone")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTelefone;
    @Basic
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "comment")
    private String comment;

    @OneToOne(mappedBy = "telefone")
    private Client client;

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telefone telefone = (Telefone) o;

        if (idTelefone != telefone.idTelefone) return false;
        if (number != null ? !number.equals(telefone.number) : telefone.number != null) return false;
        if (type != null ? !type.equals(telefone.type) : telefone.type != null) return false;
        if (comment != null ? !comment.equals(telefone.comment) : telefone.comment != null) return false;
        return client != null ? client.equals(telefone.client) : telefone.client == null;

    }

    @Override
    public int hashCode() {
        int result = idTelefone;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "idTelefone=" + idTelefone +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", comment='" + comment + '\'' +
                ", client=" + client +
                '}';
    }
}
