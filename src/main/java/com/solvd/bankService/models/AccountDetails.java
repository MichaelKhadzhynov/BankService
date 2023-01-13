package com.solvd.bankService.models;

import java.util.Objects;

public class AccountDetails {
    private Long id;
    private Long iban;
    private Long bankId;

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

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
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
