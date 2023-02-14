package com.solvd.bankService.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.bankService.dao.mySQL.AddressDAO;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "person")
@JsonRootName(value = "person")
public class Persons {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("passport_number")
    private Integer passportNumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address_id")
    private Address address;


    public Persons() {
    }
    public Persons(String firstName, String lastName, Integer passportNumber, String email, Address address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.email = email;
        this.address = address;
    }


    @XmlAttribute(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlElement(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @XmlElement(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @XmlElement(name = "passport_number")
    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }
    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement(name = "address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Persons{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", passportNumber=" + passportNumber +
               ", email='" + email + '\'' +
               ", addressId=" + address +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return Objects.equals(id, persons.id)
                && Objects.equals(firstName, persons.firstName)
                && Objects.equals(lastName, persons.lastName)
                && Objects.equals(passportNumber, persons.passportNumber)
                && Objects.equals(email, persons.email)
                && Objects.equals(address, persons.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, passportNumber, email, address);
    }
}
