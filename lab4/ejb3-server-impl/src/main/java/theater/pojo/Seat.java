package theater.pojo;

public class Seat {

    private int price;
    private boolean taken;
    private int number;

    public Seat(int price, boolean taken, int number) {
        this.price = price;
        this.taken = taken;
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
