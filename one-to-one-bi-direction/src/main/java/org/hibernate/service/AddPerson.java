package org.hibernate.service;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;

public class AddPerson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        System.out.print("Enter Person Name :");
        person.setPersonName(scanner.next());
        System.out.print("Enter Person Phone No. :");
        person.setPersonPhoneNo(scanner.nextLong());

        PanCard panCard = new PanCard();
        System.out.print("Enter Person Pan Card No. :");
       panCard.setPanCardNumber(scanner.next());

        System.out.print("Enter Person DOB :");
        panCard.setDob(LocalDate.parse(scanner.next()));

        System.out.print("Enter Person Pin Code :");
        panCard.setPinCode(scanner.nextLong());
        person.setPanCard(panCard);
        entityManager.persist(person);
        entityManager.persist(panCard);
        entityTransaction.begin();
        entityTransaction.commit();
        System.out.println("Record Added Successfully...!");

    }
}
