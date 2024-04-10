package org.hibernate.service;

import org.hibernate.entity.Merchant;
import org.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class SaveMerchantAndProduct {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Scanner scanner = new Scanner(System.in);

        Merchant merchant = new Merchant();
        System.out.print("Enter Merchant Name: ");
        merchant.setName(scanner.next());
        System.out.print("Enter Merchant GST NO: ");
        merchant.setGstNO(scanner.next());
        System.out.print("Enter Merchant Phone: ");
        merchant.setPhone(scanner.nextLong());
        System.out.print("Enter Merchant Password: ");
        merchant.setPassword(scanner.next());

        System.out.println("-----------Enter product details--------------");

        while (true) {
            Product product = new Product();

            System.out.print("Enter Product Name: ");
            product.setName(scanner.next());

            System.out.print("Enter Product Brand: ");
            product.setBrand(scanner.next());

            System.out.print("Enter Product Category: ");
            product.setCategory(scanner.next());

            System.out.print("Enter Product Description: ");
            product.setDescription(scanner.nextLine());
            scanner.nextLine();

            System.out.print("Enter Product Price: ");
            product.setCost(scanner.nextDouble());

            product.setMerchant(merchant);

            System.out.print("Do you want to enter more products? (Y/N): ");
            String choice = scanner.next().toUpperCase();
            if (!choice.equals("Y")) {
                break;
            }
        }

        entityTransaction.begin();
        entityManager.persist(merchant);
        entityTransaction.commit();

        System.out.println("Merchant and product(s) saved successfully.");

        entityManager.close();
        entityManagerFactory.close();
        scanner.close();
    }
}
