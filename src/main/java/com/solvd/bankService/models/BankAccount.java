package com.solvd.bankService.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BankAccount {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("account_number")
    private Long accountNumber;
    @JsonProperty("balance")
    private Integer balance;
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("account_details_id")
    private AccountDetails accountDetailsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public AccountDetails getAccountDetailsId() {
        return accountDetailsId;
    }

    public void setAccountDetailsId(AccountDetails accountDetailsId) {
        this.accountDetailsId = accountDetailsId;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", accountDetailsId=" + accountDetailsId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id)
                && Objects.equals(accountNumber, that.accountNumber)
                && Objects.equals(balance, that.balance)
                && Objects.equals(accountType, that.accountType)
                && Objects.equals(accountDetailsId, that.accountDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, balance, accountType, accountDetailsId);
    }
}
