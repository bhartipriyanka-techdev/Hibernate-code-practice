package org.hibernate.service;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.*;
import java.util.Scanner;

public class FindPersonByPanCardId {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Pan Card ID: ");
        int id = scanner.nextInt();

        Query qry = entityManager.createQuery("SELECT p FROM Person p JOIN p.panCard pc WHERE pc.panCardId = ?1");
        qry.setParameter(1, id);

        try {
            Person person = (Person) qry.getSingleResult();
            PanCard panCard = person.getPanCard(); // Access the associated PanCard object

            System.out.println("PERSON ID \t PERSON NAME \t\t PAN-CARD NO\t\tDOB\t\tPIN CODE \t\tPHONE NO");
            System.out.println(person.getPersonId() + "\t\t\t\t" + person.getPersonName() + "\t\t" +
                    panCard.getPanCardNumber() + "\t\t" + panCard.getDob() + "\t\t" +
                    panCard.getPinCode() + "\t\t" + person.getPersonPhoneNo());
        } catch (NoResultException e) {
            System.out.println("No records found for the given Pan Card ID.");
        }
    }
}
