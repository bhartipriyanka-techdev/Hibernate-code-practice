package org.hibernate.service;

import org.hibernate.entity.PanCard;
import org.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindPersonById {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("development");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Merchant Id :");
        int id = scanner.nextInt();

        Person person= entityManager.find(Person.class,id);
        PanCard panCard = entityManager.find(PanCard.class,id);
        System.out.println("PERSON ID \t PERSON NAME \t\t PAN-CARD NO\t\tDOB\t\tPIN CODE \t\tPHONE NO");

        if(person != null){
            System.out.println(person.getPersonId()+"\t\t\t\t"+person.getPersonName()+"\t\t"+panCard.getPanCardNumber()+"\t\t"+panCard.getDob()+"\t\t"+panCard.getPinCode()+"\t\t"+person.getPersonPhoneNo());


        }
else{
            System.out.println("Entered Id is Invalid");
        }
    }
}
