package Losowanie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "Losowanie")
@RequestScoped
public class Losowanie {

    private String userName;
    private String pesel;
    private String age;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String wyslij() {
        this.setUserName(this.userName);
        this.setAge(this.age);
        this.setPesel(this.pesel);

        if (Math.random() < 0.2) {
            return "OK";
        } else {
            return "NOT_OK";
        }
    }
}
