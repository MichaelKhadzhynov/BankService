package com.solvd.bankService.models;

import java.util.Objects;

public class DepositDepartment {
    private Long id;
    private Clients clientId;
    private Integer cash;
    private Integer depositPercent;
    private Employees employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Integer getDepositPercent() {
        return depositPercent;
    }

    public void setDepositPercent(Integer depositPercent) {
        this.depositPercent = depositPercent;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "DepositDepartment{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", cash=" + cash +
                ", depositPercent=" + depositPercent +
                ", employeeId=" + employeeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepositDepartment that = (DepositDepartment) o;
        return Objects.equals(id, that.id)
                && Objects.equals(clientId, that.clientId)
                && Objects.equals(cash, that.cash)
                && Objects.equals(depositPercent, that.depositPercent)
                && Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, cash, depositPercent, employeeId);
    }
}
