package pl.agh.kis.soa;
import theater.beans.SingletonEJB;
import theater.pojo.Seat;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;

@Named
@ViewScoped
public class AllSeats implements Serializable {

    @EJB
    private
    SingletonEJB singletonEJB = new SingletonEJB();


    public AllSeats() {
    }

    public HashMap<Integer, Seat> getSeats(){
        return this.singletonEJB.getSeatList();
    }
}
