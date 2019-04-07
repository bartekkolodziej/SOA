package Books;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

@ManagedBean(name = "Library")
@ApplicationScoped
public class Library {

    private HashMap<String, Double> exchangeRate = new HashMap<>();

    private Vector<Book> books = new Vector<>();
    private Vector<Book> selectedBooks = new Vector<>();
    private double minPrice = 0;
    private double maxPrice = 999999;
    private String type = "";
    private String title = "";
    private String author = "";
    private String currency = "PLN";

    public String getCurrency() {
        return currency;
    }

    public Library() {

        this.exchangeRate.put("PLN", 1.0);
        this.exchangeRate.put("USD", 3.7966);
        this.exchangeRate.put("EUR", 4.2978);
        this.exchangeRate.put("RUB", 0.0591);
        this.exchangeRate.put("JPY", 0.034446);

        for (int i = 0; i < 30; i++) {
            String[] type = new String[]{"Fantasy", "Westerns", "Thriller", "Mystery", "Detective", "Dystopia", "Romance"};
            HashMap<String, Double> currencyPrice = new HashMap<>();
            for(int j=0; j<4; j++){
                double randomPrice = (Math.random() * 200 );
                currencyPrice.put("PLN", BigDecimal.valueOf(randomPrice).setScale(2, RoundingMode.HALF_UP).doubleValue());
                currencyPrice.put("USD", BigDecimal.valueOf(randomPrice / 3.7966).setScale(2, RoundingMode.HALF_UP).doubleValue());
                currencyPrice.put("EUR", BigDecimal.valueOf(randomPrice / 4.2978).setScale(2, RoundingMode.HALF_UP).doubleValue());
                currencyPrice.put("RUB", BigDecimal.valueOf(randomPrice / 0.0591).setScale(2, RoundingMode.HALF_UP).doubleValue());
                currencyPrice.put("JPY", BigDecimal.valueOf(randomPrice / 0.034446).setScale(2, RoundingMode.HALF_UP).doubleValue());
            }
            this.books.add(new Book(this.getRandomString(), this.getRandomString(), type[(int) (Math.random() * 6)], currencyPrice, (int) (Math.random() * 200 + 1)));
        }

    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public String getType() {
        return type;
    }

    public Vector<Book> getSelectedBooks() {
        return selectedBooks;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public void setBooks(Vector<Book> books) {
        this.books = books;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSelectedBooks(Vector<Book> selectedBooks) {
        this.selectedBooks = selectedBooks;
    }

    public void setMaxPrice(double maxPrice) {
        if(maxPrice == 0)
            maxPrice = 99999;
        this.maxPrice = maxPrice;

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

    public void addBook(Book book) {
        for (int i = 0; i < this.books.size(); i++)
            if (this.books.get(i).getTitle().equals(book.getTitle()))
                this.books.remove(i);

        this.selectedBooks.add(book);
    }

    public Vector<Book> getBooks() {
        Vector<Book> books = new Vector<>();
        for (Book b : this.books) {
            if (b.getCurrencyPrice().get(this.currency) > this.minPrice && b.getCurrencyPrice().get(this.currency) < this.maxPrice && ( this.type.equals("") || this.type.equals(" ") || b.getType().toLowerCase().equals(this.type.toLowerCase()) )
                    && (b.getTitle().toLowerCase().contains(this.title.toLowerCase()) || this.title.equals(""))
                    && (b.getAuthor().toLowerCase().contains(this.author.toLowerCase()) || this.author.equals(""))) {
                books.add(b);
            }
        }

        return books;
    }

    public String getBooksSummary(){
        double cost = 0;
        for(Book b : this.selectedBooks)
            cost += b.getCurrencyPrice().get(this.currency);

        cost = BigDecimal.valueOf(cost).setScale(2, RoundingMode.HALF_UP).doubleValue();

        return "You've ordered " + this.selectedBooks.size() + " books that cost " + cost + " " + this.currency;
    }

}
