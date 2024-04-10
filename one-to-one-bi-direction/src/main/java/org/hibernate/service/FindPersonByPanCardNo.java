package org.hibernate.service;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.*;
import java.util.Scanner;

public class FindPersonByPanCardNo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Pan Card Number: ");
        String panCardNo = scanner.next();

        Query qry = entityManager.createQuery("SELECT p FROM Person p JOIN p.panCard pc WHERE pc.panCardNumber = ?1");
        qry.setParameter(1, panCardNo);

        try {
            Person person = (Person) qry.getSingleResult();
            PanCard panCard = person.getPanCard(); // Access the associated PanCard object

            System.out.println("PERSON ID \t PERSON NAME t\tDOB\t\tPIN CODE \t\tPHONE NO");
            System.out.println(person.getPersonId() + "\t\t\t\t" + person.getPersonName() +  "\t\t" + panCard.getDob() + "\t\t" +
                    panCard.getPinCode() + "\t\t" + person.getPersonPhoneNo());
        } catch (NoResultException e) {
            System.out.println("No records found for the given Pan Card Number.");
        }
    }
}
