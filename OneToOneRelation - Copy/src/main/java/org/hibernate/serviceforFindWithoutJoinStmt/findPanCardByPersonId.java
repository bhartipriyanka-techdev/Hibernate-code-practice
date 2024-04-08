package org.hibernate.serviceforFindWithoutJoinStmt;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.*;
import java.util.Scanner;

public class findPanCardByPersonId {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Person Id To Find PanCard No");
        int personId = scanner.nextInt();
        Query query = entityManager.createQuery("select p.panCard from Person p where p.personId = ?1");
        query.setParameter(1,personId);
        try {
           // Person person = (Person) query.getSingleResult();
            PanCard panCard = (PanCard)query .getSingleResult(); // Access the associated PanCard object

            System.out.println("PanCard No of ID\t"+personId+"\tis :"+panCard.getPanCardNumber());
        } catch (NoResultException e) {
            System.out.println("No records found for the given Pan Card ID.");
        }
    }


}
