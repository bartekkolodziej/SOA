package theater.beans;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

@Stateful
@Local
public class ReserveSeat {

    public ReserveSeat() { }

    @EJB

    private
    SingletonEJB singletonEJB;
    @EJB
    private
    ClientBean clientBean;

    void reserveSeat(int number) {
        if (!singletonEJB.getSeatList().get(number).isTaken()) {
            singletonEJB.getSeatList().get(number).setTaken(true);
            clientBean.setCash(clientBean.getCash() - singletonEJB.getSeatList().get(number).getPrice());
        }
    }
}
