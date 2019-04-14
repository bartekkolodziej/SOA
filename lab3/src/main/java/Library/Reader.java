package Library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String first_name;


    @Column(name = "second_name", nullable = false)
    private String second_name;

    public Reader() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }
}
