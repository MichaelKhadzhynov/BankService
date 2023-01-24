package com.solvd.bankService.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.Objects;

public class CreditCard {

    @JsonProperty(value = "id", index = 1)
    private Long id;
    @JsonProperty("card_number")
    private Long cardNumber;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expiredDate;
    @JsonProperty("cvv")
    private Integer cvv;
    @JsonProperty("clients_id")
    private Clients clientsId;
    @JsonProperty("bank_account_id")
    private BankAccount bankAccountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Clients getClientsId() {
        return clientsId;
    }

    public void setClientsId(Clients clientsId) {
        this.clientsId = clientsId;
    }

    public BankAccount getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccount bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", expiredDate=" + expiredDate +
                ", cvv=" + cvv +
                ", clientsId=" + clientsId +
                ", bankAccountId=" + bankAccountId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id) && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(expiredDate, that.expiredDate) && Objects.equals(cvv, that.cvv) && Objects.equals(clientsId, that.clientsId) && Objects.equals(bankAccountId, that.bankAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, expiredDate, cvv, clientsId, bankAccountId);
    }
}
