package com.solvd.bankService.models;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

@JsonRootName(value = "clients")
public class Clients {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("person")
    private Persons personId;
    @JsonProperty("client_type")
    private String clientType;


    public Clients() {
    }
    public Clients(Persons personId, String clientType) {
        this.personId = personId;
        this.clientType = clientType;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persons getPersonId() {
        return personId;
    }

    public void setPersonId(Persons personId) {
        this.personId = personId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", personId=" + personId +
                ", clientType='" + clientType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(id, clients.id)
                && Objects.equals(personId, clients.personId)
                && Objects.equals(clientType, clients.clientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personId, clientType);
    }
}
