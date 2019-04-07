package Books;

import java.util.HashMap;


public class Book {
    private String title;
    private String author;
    private String type;
    private HashMap<String, Double> currencyPrice;
    private int numberOfPages;


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public HashMap<String, Double> getCurrencyPrice() {
        return currencyPrice;
    }

    public String getType() {
        return type;
    }

    public Book(String title, String author, String type, HashMap<String, Double> currencyPrice, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.currencyPrice = currencyPrice;
        this.numberOfPages = numberOfPages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

}
