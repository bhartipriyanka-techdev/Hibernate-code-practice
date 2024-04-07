package org.hibernate.service;

import org.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class HibernateLifeCycle {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
            Scanner scanner = new Scanner(System.in);
            User user = new User();
            System.out.print("Enter User Name :");
            user.setName(scanner.next());

            System.out.print("Enter User Phone:");
            user.setPhoneNo(scanner.nextLong());

            System.out.print("Enter User Age :");
            user.setAge(scanner.nextInt());
            entityManager.persist(user);
            entityTransaction.begin();
            entityTransaction.commit();

            //----Updating Record-----------
        System.out.print("Enter User Name :");
        user.setName(scanner.next());

        System.out.print("Enter User Phone:");
        user.setPhoneNo(scanner.nextLong());

        System.out.print("Enter User Age :");
        user.setAge(scanner.nextInt());
        entityManager.persist(user);
        entityTransaction.begin();

        //detaching
        entityManager.detach(user);
        //----Updating Record-----------
        System.out.print("Enter User Name :");
        user.setName(scanner.next());

        System.out.print("Enter User Phone:");
        user.setPhoneNo(scanner.nextLong());

        System.out.print("Enter User Age :");
        user.setAge(scanner.nextInt());
        entityManager.persist(user);
        entityTransaction.begin();



    }
}
