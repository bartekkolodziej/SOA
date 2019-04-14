package Library;

import Books.BookDB;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Vector;

@ManagedBean(name = "RentalList")
@ApplicationScoped
public class RentalList {

    private List<Rental> rentalList;
    private List<Book> books;
    private int book_id;
    private String book_title;

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    private Vector<Reader> readersThatReads;

    public RentalList() {
        this.rentalList = this.getRentalListFromDB();
        this.books = this.getBooksFromDb();
    }

    public List getRentalList() {
        return rentalList;
    }

    public void setRentalList(Vector<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getAuthor_id_filter() {
        return book_id;
    }

    public void setAuthor_id_filter(int book_id) {
        this.book_id = book_id;
    }

    public void setRentalList(List rentalList) {
        this.rentalList = rentalList;
    }

    public List getBooks() {
        return books;
    }

    public void setBooks(List books) {
        this.books = books;
    }

    private List getRentalListFromDB() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        List rentals = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            rentals = manager.createQuery("SELECT s FROM Rental s", Rental.class).getResultList();

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

        return rentals;
    }

    public Vector<Reader> getReadersThatReads() {
        return readersThatReads;
    }

    public void setReadersThatReads(Vector<Reader> readersThatReads) {
        this.readersThatReads = readersThatReads;
    }

    private List getBooksFromDb() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        List rentals = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            rentals = manager.createQuery("SELECT s FROM Book s", Book.class).getResultList();

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

        return rentals;

    }

    public void getAllReadersBy(String filter) {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        Vector<Reader> readers = new Vector<>();

        if(filter.equals("author_id")){
            for(Rental r: this.rentalList ){
                if(r.getBook_id() == this.book_id)
                    readers.add(manager.find(Reader.class, r.getReader_id()));
            }
        } else {
            for(Rental r: this.rentalList ){
                if(manager.find(Book.class, r.getBook_id()).getTitle().equals(this.book_title)) {
                    readers.add(manager.find(Reader.class, r.getReader_id()));
                }
            }
        }

        System.out.println("asdfgjkl ");
        this.readersThatReads = readers;

    }


}
