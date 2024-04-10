package org.hibernate.service;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.*;
import java.util.Scanner;

public class FindPanCardByPersonPhoneNo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Person Phone No: ");
        long phone = scanner.nextLong();

        Query qry = entityManager.createQuery("SELECT p FROM Person p JOIN p.panCard pc WHERE p.personPhoneNo = ?1");
        qry.setParameter(1, phone);

        try {
            Person person = (Person) qry.getSingleResult();
            PanCard panCard = person.getPanCard(); // Access the associated PanCard object

           // System.out.println("PERSON ID \t PERSON NAME \t\t PAN-CARD NO\t\tDOB\t\tPIN CODE \t\tPHONE NO");
            System.out.println("Pan Card of This \t"+person.getPersonPhoneNo()+"\tis :"+panCard.getPanCardNumber());
        } catch (NoResultException e) {
            System.out.println("No records found for the given Pan Card ID.");
        }
    }
}
