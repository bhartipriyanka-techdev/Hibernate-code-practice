package org.hibernate.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Column(nullable = false)
    private String EmployeeName;
    @Column(nullable = false)

    private String employeeDsg;
    @Column(nullable = false)

    private long employeeSalary;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeDsg() {
        return employeeDsg;
    }

    public void setEmployeeDsg(String employeeDsg) {
        this.employeeDsg = employeeDsg;
    }

    public long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
