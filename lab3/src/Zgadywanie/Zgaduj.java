package Zgadywanie;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "Zgaduj")
@ApplicationScoped
public class Zgaduj {

    private int randomNumber = (int)(Math.random() * 5 + 1);

    private int odwiedziny1;
    private int odwiedziny2;
    private int odwiedziny3;
    private int odwiedziny4;
    private int odwiedziny5;

    public int getOdwiedziny1() {
        return odwiedziny1;
    }

    public int getOdwiedziny2() {
        return odwiedziny2;
    }

    public int getOdwiedziny3() {
        return odwiedziny3;
    }

    public int getOdwiedziny4() {
        return odwiedziny4;
    }

    public int getOdwiedziny5() {
        return odwiedziny5;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public String losuj(){
        this.randomNumber = (int)(Math.random() * 5 + 1);
        return "Zgadywanie";
    }

    public String wyslij(int number) {

        if(number == this.randomNumber){
            return "trafiony";
        }

        switch (number){
            case 1:
                this.odwiedziny1++;
                return "1";
            case 2:
                this.odwiedziny2++;
                return "2";
            case 3:
                this.odwiedziny3++;
                return "3";
            case 4:
                this.odwiedziny4++;
                return "4";
            case 5:
                this.odwiedziny5++;
                return "5";
            default:
                return"asd";

        }
    }
}
