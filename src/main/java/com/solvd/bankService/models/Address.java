package com.solvd.bankService.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "address")
public class Address {

    private Long id;

    private String country;

    private String city;

    private String homeAddress;

    private Integer postalCode;

    private Long phoneNumber;

    public Address() {
    }

    public Address(String country, String city, String homeAddress, Integer postalCode, Long phoneNumber) {
        this.country = country;
        this.city = city;
        this.homeAddress = homeAddress;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }
    @XmlAttribute(name ="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    @XmlElement(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "home_address")
    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @XmlElement(name = "postal_code")
    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @XmlElement(name = "phone_Number")
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", postalCode=" + postalCode +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(homeAddress, address.homeAddress) && Objects.equals(postalCode, address.postalCode) && Objects.equals(phoneNumber, address.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, homeAddress, postalCode, phoneNumber);
    }
}



