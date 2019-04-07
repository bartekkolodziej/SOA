package theater.beans;

import theater.pojo.Seat;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;

@Singleton
@Startup
public class SingletonEJB {


    @EJB
    private
    ReserveSeat reserveSeat;

    private HashMap<Integer, Seat> seats = new HashMap<>();

    @PostConstruct
    public void SingletonEJB() {
        for (int i = 0; i < 44; i++) {
            this.seats.put(i, new Seat((int) (Math.random() * 50), false, i));
        }
    }

    public HashMap<Integer, Seat> getSeatList() {
        return this.seats;
    }

    public int getSeatPrice(int number) {
        return this.seats.get(number).getPrice();
    }

    public void buyTicket(int number) {
        this.reserveSeat.reserveSeat(number);
    }
}
