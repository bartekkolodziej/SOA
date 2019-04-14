package Library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "reader_id", nullable = false)
    private int reader_id;

    @Column(name = "book_id", nullable = false)
    private int book_id;

    @Column(name = "rental_date", nullable = false)
    private Date rental_date;

    @Column(name = "return_date")
    private Date return_date;

    public Rental() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
