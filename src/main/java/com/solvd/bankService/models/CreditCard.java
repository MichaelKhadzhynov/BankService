package com.solvd.bankService.models;

import java.sql.Date;
import java.util.Objects;

public class CreditCard {
    private Long id;
    private Integer cardNumber;
    private Date expiredDate;
    private Integer cvv;
    private Long clientsId;
    private Long bankAccountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
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

    public Long getClientsId() {
        return clientsId;
    }

    public void setClientsId(Long clientsId) {
        this.clientsId = clientsId;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
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
