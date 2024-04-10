package org.hibernate.service;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class FindPersonByPhoneNo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Person Phone No :");
        long phone = scanner.nextLong();

        Query qry = entityManager.createQuery("SELECT p FROM Person p JOIN p.panCard pc WHERE p.personPhoneNo = ?1");
        qry.setParameter(1, phone);
        List<Person> list = qry.getResultList();
        if (list.size() > 0) {
            System.out.println("PERSON ID \t PERSON NAME \t\t PAN-CARD NO\t\tDOB\t\tPIN CODE \t\tPHONE NO");

            for (Person person : list) {
                PanCard panCard = person.getPanCard(); // Access the associated PanCard object
                System.out.println(person.getPersonId() + "\t\t\t\t" + person.getPersonName() + "\t\t" +
                        panCard.getPanCardNumber() + "\t\t" + panCard.getDob() + "\t\t" +
                        panCard.getPinCode() + "\t\t" + person.getPersonPhoneNo());
            }
        }

        else{
            System.out.println("You Entered Invalid Phone No");
        }
    }
}
