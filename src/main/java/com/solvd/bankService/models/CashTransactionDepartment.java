package com.solvd.bankService.models;

import java.util.Objects;

public class CashTransactionDepartment {
    private Long id;
    private Integer cashIn;
    private Integer cashOut;
    private Long employeeId;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Integer getCashIn() {
                return cashIn;
        }

        public void setCashIn(Integer cashIn) {
                this.cashIn = cashIn;
        }

        public Integer getCashOut() {
                return cashOut;
        }

        public void setCashOut(Integer cashOut) {
                this.cashOut = cashOut;
        }

        public Long getEmployeeId() {
                return employeeId;
        }

        public void setEmployeeId(Long employeeId) {
                this.employeeId = employeeId;
        }

        @Override
        public String toString() {
                return "CashTransactionDepartment{" +
                        "id=" + id +
                        ", cashIn=" + cashIn +
                        ", cashOut=" + cashOut +
                        ", employeeId=" + employeeId +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CashTransactionDepartment that = (CashTransactionDepartment) o;
                return Objects.equals(id, that.id)
                        && Objects.equals(cashIn, that.cashIn)
                        && Objects.equals(cashOut, that.cashOut)
                        && Objects.equals(employeeId, that.employeeId);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, cashIn, cashOut, employeeId);
        }
}
