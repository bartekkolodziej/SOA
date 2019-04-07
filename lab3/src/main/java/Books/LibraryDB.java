package Books;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;
import java.util.Vector;

@ManagedBean(name = "LibraryDB")
@ApplicationScoped
public class LibraryDB {

    private Vector<BookDB> books = new Vector<>();
    private Vector<BookDB> selectedBooks = new Vector<>();

    public LibraryDB() {

        for (int i = 0; i < 30; i++) {
            this.books.add(new BookDB(i,
                    this.getRandomString()
                    , this.getRandomString(),
                    this.getRandomString(),
                    (int) (Math.random() * 9999),
                    (int) (Math.random() * 2019 + 1900),
                    (int) (Math.random() * 200 )));
        }

        this.selectBooksFromDB();
    }

    public Vector<BookDB> getBooks() {
        return books;
    }

    public Vector<BookDB> getSelectedBooks() {
        return selectedBooks;
    }

    private void selectBooksFromDB() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        List books = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Books
            books = manager.createQuery("SELECT s FROM BookDB s", BookDB.class).getResultList();

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

        if(books != null)
            this.selectedBooks = new Vector<BookDB>(books);
    }


    public void addBookDB(BookDB book) {
        this.selectedBooks = new Vector<>();
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new BookDB object
            BookDB newBook = new BookDB();
            newBook.setId(book.getId());
            newBook.setAuthor_first_name(book.getAuthor_first_name());
            newBook.setAuthor_second_name(book.getAuthor_second_name());
            newBook.setTitle(book.getTitle());
            newBook.setIsbn(book.getIsbn());
            newBook.setPublication_date(book.getPublication_date());
            newBook.setPrice(book.getPrice());

            // Save the book object
            manager.persist(newBook);

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

        this.selectBooksFromDB();
    }


    private String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }


}
