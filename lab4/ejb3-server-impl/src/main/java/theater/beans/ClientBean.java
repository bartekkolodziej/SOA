package theater.beans;

import javax.ejb.Local;
import javax.ejb.Stateful;

@Stateful
@Local
public class ClientBean {
    private double cash;

    public ClientBean() {}

    public ClientBean(double cash) {
        this.cash = cash;
    }

    double getCash() {
        return cash;
    }

    void setCash(double cash) {
        this.cash = cash;
    }
}
