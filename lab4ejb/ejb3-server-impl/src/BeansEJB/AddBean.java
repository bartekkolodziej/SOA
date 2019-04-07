package BeansEJB;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class AddBean {

    public int add(int a, int b) {
        return a + b;
    }
}
