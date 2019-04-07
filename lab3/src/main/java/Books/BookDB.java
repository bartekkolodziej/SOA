package Books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "book")
public class BookDB {
    @Id
    @Column(name = "book_id", unique = true)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author_first_name", nullable = false)
    private String author_first_name;

    @Column(name = "author_second_name", nullable = false)
    private String author_second_name;

    @Column(name = "ISBN", nullable = false)
    private int isbn;

    @Column(name = "publication_date", nullable = false)
    private int publication_date;

    @Column(name = "price", nullable = false)
    private int price;

    public BookDB() {
        super();
    }

    public BookDB(int id, String title, String author_first_name, String author_second_name, int isbn, int publication_date, int price) {
        this.id = id;
        this.title = title;
        this.author_first_name = author_first_name;
        this.author_second_name = author_second_name;
        this.isbn = isbn;
        this.publication_date = publication_date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
