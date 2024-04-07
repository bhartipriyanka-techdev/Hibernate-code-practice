package org.hibernate.service;

import org.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class deleteUser {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user Id :");
        int id = scanner.nextInt();

        User user = entityManager.find(User.class,id);
        if(user != null){
            entityManager.remove(user);
            entityTransaction.begin();
            entityTransaction.commit();
        }

    }
}
