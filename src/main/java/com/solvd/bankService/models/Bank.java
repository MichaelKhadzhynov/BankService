package com.solvd.bankService.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "bank")
public class Bank {

    private Long id;

    private Integer bankNumber;

    private Address addressId;

    @XmlAttribute(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlElement(name = "bank_number")
    public Integer getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(Integer bankNumber) {
        this.bankNumber = bankNumber;
    }
    @XmlElement(name = "address")
    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankNumber=" + bankNumber +
                ", addressId=" + addressId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) && Objects.equals(bankNumber, bank.bankNumber) && Objects.equals(addressId, bank.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankNumber, addressId);
    }
}
