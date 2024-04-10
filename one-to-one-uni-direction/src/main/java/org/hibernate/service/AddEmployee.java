package org.hibernate.service;

import org.hibernate.entity.Department;
import org.hibernate.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddEmployee {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.print("Enter Employee Name :");
        employee.setEmployeeName(scanner.next());
        System.out.print("Enter Employee Designation :");
        employee.setEmployeeDsg(scanner.next());
        System.out.print("Enter Employee Salary :");
        employee.setEmployeeSalary(scanner.nextLong());

        Department department = new Department();

        System.out.print("Enter Department Name :");
        department.setDepartmentName(scanner.next());

        System.out.print("Enter Department Location :");
        department.setDepartmentLocation(scanner.next());

        List<Employee> emps = new ArrayList<Employee>();
        emps.add(employee);
        department.setEmployeeList(emps);

        entityTransaction.begin();
        entityTransaction.commit();
        System.out.println("Record Added Successfully...!");

    }
}
