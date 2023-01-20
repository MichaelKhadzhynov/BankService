package com.solvd.bankService.services;

import com.solvd.bankService.dao.mySQL.AddressDAO;
import com.solvd.bankService.dao.mySQL.ClientsDAO;
import com.solvd.bankService.dao.mySQL.PersonsDAO;
import com.solvd.bankService.models.Address;
import com.solvd.bankService.models.Clients;
import com.solvd.bankService.models.Persons;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class ClientCreation {
    private static final Logger LOGGER = Logger.getLogger(ClientCreation.class);

    private static final String country = "Ukraine";
    private static final String city = "Kyiv";
    private static final String homeAddress = "street 3 ap 3";
    private static final int postalCode = 11180;
    private static final long phoneNumber = 38095846254L;

    private static final String firstName = "Michael";
    private static final String lastName = "Khadzhynov";
    private static final int passportNumber = 12396;
    private static final String email = "emailM@gmail.com";


    public static void clientCreate() {

        List<Persons> personsList = PersonsDAO.getInstance().getPersonsList();


        List<Address> addressesList = AddressDAO.getInstance().getAddressList();


        Address address = new Address(country, city, homeAddress, postalCode, phoneNumber);

        if (addressesList.stream().noneMatch(e -> e.getCity().equals(city) &&
                                                  e.getHomeAddress().equals(homeAddress))) {
            AddressDAO.getInstance().createEntity(address);
        } else {
            List<Address> createdAddresses = addressesList.stream().filter(e -> e.getCity().equals(city) &&
                                                                                e.getHomeAddress().equals(homeAddress))
                    .collect(Collectors.toList());
            address = AddressDAO.getInstance().getEntityById(createdAddresses.get(0).getId());
            LOGGER.info("Address already exist");
        }

        Persons persons = new Persons(firstName, lastName, passportNumber, email,
                AddressDAO.getInstance().getEntityById(address.getId()));



        if (personsList.stream().noneMatch(e -> e.getPassportNumber().equals(persons.getPassportNumber()))) {

            PersonsDAO.getInstance().createEntity(persons);

            Clients clients = new Clients(
                    PersonsDAO.getInstance().getEntityById(persons.getId()),
                    "Physical person");

            ClientsDAO.getInstance().createEntity(clients);
        } else {
            LOGGER.info("Client already exist");
            AddressDAO.getInstance().removeEntity(address.getId());
        }
    }
}
