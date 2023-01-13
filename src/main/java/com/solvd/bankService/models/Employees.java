package com.solvd.bankService.models;

import java.util.Objects;

public class Employees {
    private Long id;
    private Long bankId;
    private Long personId;
    private String position;
    private String department;
    private String jobExperience;
    private String education;
    private String salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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
