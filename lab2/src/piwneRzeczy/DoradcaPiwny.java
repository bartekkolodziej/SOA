package piwneRzeczy;

public class DoradcaPiwny {
    private static DoradcaPiwny ourInstance = new DoradcaPiwny("Harnaś");

    public static DoradcaPiwny getInstance() {
        return ourInstance;
    }

    static String piwerko;

    private DoradcaPiwny(String piwerko) {
        DoradcaPiwny.piwerko = piwerko;
    }

    public static void setPiwerko(String piwerko) {
        DoradcaPiwny.piwerko = piwerko;
    }

    public static String getPiwerko() {
        return piwerko;
    }
}
