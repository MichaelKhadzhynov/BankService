package com.solvd.bankService.models;

import java.util.Objects;

public class Persons {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer passportNumber;
    private String email;
    private Long addressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNumber=" + passportNumber +
                ", email='" + email + '\'' +
                ", addressId=" + addressId +
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
                && Objects.equals(addressId, persons.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, passportNumber, email, addressId);
    }
}
