package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

public class Main {
    // Create an EntityManagerFactory when you start the application.


    public static void main() {

        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        // Create two Students
        create(11, "das", 242); // Alice will get an id 1
        create(22, "Bdasdob", 202); // Bob will get an id 2
        create(33, "fgfdgdfg", 251); // Charlie will get an id 3

        // Update the age of Bob using the id
        upate(22, "Bob", 25);

        // Delete the Alice from database
        //delete(1);

        // Print all the Students
        List students = readAll();
        System.out.println("Students: ");
        if (students != null) {
            for (Object stu : students) {
                System.out.println(stu);
            }
        }

        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }

    /**
     * Create a new Student.
     *
     * @param name
     * @param age
     */
    public static void create(int id, String name, int age) {
        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Student stu = new Student();
            stu.setId(id);
            stu.setName(name);
            stu.setAge(age);

            // Save the student object
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Read all the Students.
     *
     * @return a List of Students
     */
    public static List readAll() {

        List students = null;

        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            students = manager.createQuery("SELECT s FROM Student s",
                    Student.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    }

    /**
     * Delete the existing Student.
     *
     * @param id
     */
    public static void delete(int id) {
        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            Student stu = manager.find(Student.class, id);

            // Delete the student
            manager.remove(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Update the existing Student.
     *
     * @param id
     * @param name
     * @param age
     */
    public static void upate(int id, String name, int age) {
        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            Student stu = manager.find(Student.class, id);

            // Change the values
            stu.setName(name);
            stu.setAge(age);

            // Update the student
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }
}
