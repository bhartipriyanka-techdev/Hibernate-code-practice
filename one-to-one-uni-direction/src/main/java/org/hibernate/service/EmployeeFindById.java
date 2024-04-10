package org.hibernate.service;

import org.hibernate.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class EmployeeFindById {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Department Id :");
        int id = scanner.nextInt();

       // Query qry = entityManager.createQuery("select d.emps from Department where d.id = ?1");

        System.out.println("EMPLOYEE ID \t EMPLOYEE NAME \t\t EMPLOYEE DESIGNATION\t\tSALARY\t\tCITY");

       /* if(employee != null){


        }
        else{
            System.out.println("Entered Id is Invalid");
        }*/
    }
}
