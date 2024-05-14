package pbo.f01;

import pbo.f01.model.Dorm;
import javax.persistence.*;
import java.util.*;


/**
 * 12S22008 - Rahel Simanjuntak
 * 12S22017 - Lenna Febriana
 */

public class App {

   
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        
    factory = Persistence.createEntityManagerFactory("dorm");
    entityManager = factory.createEntityManager();

    displayAlldorm();


    entityManager.close();
    System.out.println();

    }

    private static void displayAlldorm (String id, String name, int entranceYear, String gender) {
     String jpql = "SELECT c FROM Contact c ORDER BYE c.name";
     List<Dorm> dorms = entityManager.createQuery(jpql, Dorm.class)
     .getResultList();


    System.out.println("displayAlldorm");
    for (Dorm c : dorms){
        System.out.println(c);
    }
    }
}