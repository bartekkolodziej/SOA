package KsiegaGosci;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "WalidacjaDanych")
public class WalidacjaDanych extends HttpServlet {

    Vector<DaneOsobowe> daneOsobowe = new Vector<>();

    private void dodajRandomoweOsoby() {
        this.daneOsobowe.add(new DaneOsobowe("bartekko", "password", "Bartłomiej", "Kołodziej"));
        for (int i = 0; i < 20; i++) {
            this.daneOsobowe.add(new DaneOsobowe(RandomString.getSaltString(), RandomString.getSaltString(), RandomString.getSaltString(), RandomString.getSaltString()));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.dodajRandomoweOsoby();

        this.daneOsobowe.forEach( e-> {
            if(request.getParameter("login").equals(e.login) && request.getParameter("password").equals(e.password)){
                try {
                    response.sendRedirect("ksiegaGosci.jsp");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        response.sendRedirect("ksiegaGosciForm.jsp?invalid=true");

    }
}
