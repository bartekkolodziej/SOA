package Books;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Vector;

@ManagedBean(name = "CatalogDB")
@ApplicationScoped
public class CatalogDB {
    private Vector<BookDB> books = new Vector<>();

    private BookDB bookToEdit;

    private String author_first_name = "";

    private String author_second_name = "";

    private String title = "";

    private int isbn = -1;

    private int publication_date = -1;

    private int price = -1;

    public BookDB getBookToEdit() {
        return bookToEdit;
    }

    public void setBookToEdit(BookDB bookToEdit) {
        this.bookToEdit = bookToEdit;
    }

    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public String getAuthor_second_name() {
        return author_second_name;
    }

    public void setAuthor_second_name(String author_second_name) {
        this.author_second_name = author_second_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(int publication_date) {
        this.publication_date = publication_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CatalogDB() {
        this.updateBooksList();
    }

    public Vector<BookDB> getBooks() {
        return books;
    }


    public void addBook() {
        if(this.author_first_name.equals("") || this.author_second_name.equals("") || this.title.equals("") || this.isbn < 0 || this.price < 0 || this.publication_date < 0) {
            System.out.println("book not complete");
            System.out.println("first name: " + this.author_first_name);
            System.out.println("title: " + this.title);
            System.out.println("price: " + this.price);
            return;
        }

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
            newBook.setId(this.getNextId());
            newBook.setAuthor_first_name(this.author_first_name);
            newBook.setAuthor_second_name(this.author_second_name);
            newBook.setTitle(this.title);
            newBook.setIsbn(this.isbn);
            newBook.setPublication_date(this.publication_date);
            newBook.setPrice(this.price);

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

        this.clearInput();
        this.updateBooksList();
    }

    private void clearInput() {
        this.setAuthor_first_name("");
        this.setAuthor_second_name("");
        this.setTitle("");
        this.setIsbn(-1);
        this.setPublication_date(-1);
        this.setPrice(-1);
    }

    private void updateBooksList() {
        List booksFromDB = getBooksFromDB();
        if (booksFromDB != null) {
            this.books.clear();
            this.books = new Vector<BookDB>(booksFromDB);
        }
    }

    private int getNextId() {
        int nextIt = 1;
        for(BookDB book : this.books){
            if(book.getId() > nextIt)
                nextIt = book.getId();
        }
        return nextIt + 1;
    }

    static List getBooksFromDB() {
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

        return books;
    }

    public void removeBook(BookDB book) {
        removeBookFromDB(book);
        this.updateBooksList();
    }

    static void removeBookFromDB(BookDB book) {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            BookDB bookToRemove = manager.find(BookDB.class, book.getId());

            // Delete the student
            manager.remove(bookToRemove);

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

    public void editBook() {
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
            BookDB newBook = manager.find(BookDB.class, this.bookToEdit.getId());

            // Change the values
            newBook.setTitle(this.bookToEdit.getTitle());
            newBook.setAuthor_first_name(this.bookToEdit.getAuthor_first_name());
            newBook.setAuthor_second_name(this.bookToEdit.getAuthor_second_name());
            newBook.setIsbn(this.bookToEdit.getIsbn());
            newBook.setPublication_date(this.bookToEdit.getPublication_date());
            newBook.setPrice(this.bookToEdit.getPrice());

            // Update the student
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
        this.updateBooksList();
    }
}
