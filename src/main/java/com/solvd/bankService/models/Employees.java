package com.solvd.bankService.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "employee")
public class Employees {

    private Long id;

    private Bank bankId;

    private Persons personId;

    private String position;

    private String department;

    private String jobExperience;

    private String education;

    private Integer salary;

    public Employees(Long id, Bank bankId, Persons personId, String position, String department, String jobExperience, String education, Integer salary) {
        this.id = id;
        this.bankId = bankId;
        this.personId = personId;
        this.position = position;
        this.department = department;
        this.jobExperience = jobExperience;
        this.education = education;
        this.salary = salary;
    }

    public Employees() {
    }

    @XmlAttribute(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "bank")
    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    @XmlElement(name = "person")
    public Persons getPersonId() {
        return personId;
    }

    public void setPersonId(Persons personId) {
        this.personId = personId;
    }

    @XmlElement(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlElement(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @XmlElement(name = "jobExperience")
    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    @XmlElement(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @XmlElement(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", bankId=" + bankId +
                ", personId=" + personId +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", jobExperience='" + jobExperience + '\'' +
                ", education='" + education + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Objects.equals(id, employees.id)
                && Objects.equals(bankId, employees.bankId)
                && Objects.equals(personId, employees.personId)
                && Objects.equals(position, employees.position)
                && Objects.equals(department, employees.department)
                && Objects.equals(jobExperience, employees.jobExperience)
                && Objects.equals(education, employees.education)
                && Objects.equals(salary, employees.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankId, personId, position, department, jobExperience, education, salary);
    }
}
