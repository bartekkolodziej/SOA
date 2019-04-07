package theater.beans;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class FreeSeats {
    public FreeSeats() { }

    @EJB
    private
    SingletonEJB singletonEJB;

    public boolean isSeatFree(int number) {
        return singletonEJB.getSeatList().get(number).isTaken();
    }
}
