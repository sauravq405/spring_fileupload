package com.file.upload.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeCsvRepresentation {

    @CsvBindByName(column = "Employee ID")
    private String employeeId;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Department")
    private String department;

    @CsvBindByName(column = "Role")
    private String role;

    @CsvBindByName(column = "Salary")
    private String salary;

    @CsvBindByName(column = "City")
    private String city;

    @CsvBindByName(column = "Education")
    private String education;

    @CsvBindByName(column = "Joining Date")
    private String joiningDate;

    public EmployeeCsvRepresentation() {
    }

    public EmployeeCsvRepresentation(String employeeId, String name, String department, String role, String salary, String city, String education, String joiningDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.city = city;
        this.education = education;
        this.joiningDate = joiningDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public String getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public String getEducation() {
        return education;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public EmployeeCsvRepresentation setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeCsvRepresentation setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeCsvRepresentation setDepartment(String department) {
        this.department = department;
        return this;
    }

    public EmployeeCsvRepresentation setRole(String role) {
        this.role = role;
        return this;
    }

    public EmployeeCsvRepresentation setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeCsvRepresentation setCity(String city) {
        this.city = city;
        return this;
    }

    public EmployeeCsvRepresentation setEducation(String education) {
        this.education = education;
        return this;
    }

    public EmployeeCsvRepresentation setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
        return this;
    }

    // Optional: Method to build the final object or for other operations
    public EmployeeCsvRepresentation build() {
        return this;  // Or you might want to return a new instance or perform some validation
    }
}
