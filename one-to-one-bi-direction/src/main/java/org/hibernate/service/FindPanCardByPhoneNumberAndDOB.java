package org.hibernate.service;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FindPanCardByPhoneNumberAndDOB {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Person Phone No: ");
        long phone = scanner.nextLong();

        System.out.print("Enter Person Dob (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.next());

        Query qry = entityManager.createQuery("SELECT p FROM Person p JOIN p.panCard pc WHERE p.personPhoneNo = :phone AND pc.dob = :dob");
        qry.setParameter("phone", phone);
        qry.setParameter("dob", dob);

        try {
            List<Person> resultList = qry.getResultList();
            if (!resultList.isEmpty()) {
                for (Person person : resultList) {
                    PanCard panCard = person.getPanCard(); // Access the associated PanCard object

                    System.out.println("PERSON ID \t PERSON NAME \t\t PAN-CARD NO\t\tDOB\t\tPIN CODE \t\tPHONE NO");
                    System.out.println(person.getPersonId() + "\t\t\t\t" + person.getPersonName() + "\t\t" +
                            panCard.getPanCardNumber() + "\t\t" + panCard.getDob() + "\t\t" +
                            panCard.getPinCode() + "\t\t" + person.getPersonPhoneNo());
                }
            } else {
                System.out.println("No records found for the given DOB and Phone No.");
            }
        } catch (NoResultException e) {
            System.out.println("No records found for the given DOB and Phone No.");
        }
    }
}
