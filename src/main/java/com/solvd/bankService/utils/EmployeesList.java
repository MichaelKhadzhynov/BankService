package com.solvd.bankService.utils;

import com.solvd.bankService.dao.mySQL.EmployeesDao;
import com.solvd.bankService.models.Employees;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "employees")
public class EmployeesList {

    private List<Employees> employees = EmployeesDao.getInstance().getEmployeesList();

    @XmlElement(name ="employee")
    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeesList{" +
                "employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesList that = (EmployeesList) o;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }
}
