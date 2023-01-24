package com.solvd.bankService.utils.JacksonParser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.bankService.dao.mySQL.ClientsDAO;
import com.solvd.bankService.models.Clients;

import java.util.List;
import java.util.Objects;


public class ClientList {

    @JsonProperty("clients")
    private List<Clients> clientList = ClientsDAO.getInstance().getClientsList();


    public List<Clients> getClientList() {
        return clientList;
    }

    public void setClientList(List<Clients> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "ClientList{" +
               "clientList=" + clientList +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientList that = (ClientList) o;
        return Objects.equals(clientList, that.clientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientList);
    }
}
