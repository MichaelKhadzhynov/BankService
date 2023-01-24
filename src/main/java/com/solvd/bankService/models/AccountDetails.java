package com.solvd.bankService.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AccountDetails {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("iban_number")
    private Long iban;
    @JsonProperty("bank_id")
    private Bank bankId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIban() {
        return iban;
    }

    public void setIban(Long iban) {
        this.iban = iban;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "id=" + id +
                ", iban=" + iban +
                ", bankId=" + bankId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDetails that = (AccountDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(iban, that.iban) && Objects.equals(bankId, that.bankId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, bankId);
    }
}
