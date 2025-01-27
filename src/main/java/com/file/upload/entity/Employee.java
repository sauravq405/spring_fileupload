package com.file.upload.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "role")
    private String role;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "city")
    private String city;

    @Column(name = "education")
    private String education;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    // Constructors, getters, and setters

    public Employee() {}

    public Employee(Integer employeeId, String name, String department, String role, BigDecimal salary, String city, String education, String joiningDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.city = city;
        this.education = education;
        this.joiningDate = LocalDate.parse(joiningDate, DateTimeFormatter.ofPattern("dd/MM/yy"));
    }

    // Getters and Setters
    public Integer getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Employee setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Employee setRole(String role) {
        this.role = role;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee setSalary(String salary) {
        BigDecimal bd = new BigDecimal(salary);
        if (bd.precision() > 10) {
            // Option 1: Truncate the number to 10 significant digits
            bd = bd.round(new MathContext(10, RoundingMode.HALF_UP));

            // Option 2: Throw an exception if the precision exceeds 10 digits
            // throw new IllegalArgumentException("Salary precision exceeds the allowed 10 digits: " + salary);
        }

        this.salary = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return this;
    }

    public String getCity() {
        return city;
    }

    public Employee setCity(String city) {
        this.city = city;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public Employee setEducation(String education) {
        this.education = education;
        return this;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public Employee setJoiningDate(String joiningDate) {
        this.joiningDate = LocalDate.parse(joiningDate, DateTimeFormatter.ofPattern("dd/MM/yy"));
        return this;
    }
}