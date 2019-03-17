package KsiegaGosci;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "DodajWpis")
public class DodajWpis extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletConfig().getInitParameter("sesja");
        Vector<Wpis> previousFeedback = (Vector<Wpis>) request.getSession().getAttribute("feedback");

        if(previousFeedback != null){
            previousFeedback.add(new Wpis(request.getParameter("name"), request.getParameter("mail"), request.getParameter("comment")));
            request.getSession().setAttribute("feedback", previousFeedback);
        } else {
            Vector<Wpis> feedback = new Vector<>();
            feedback.add(new Wpis(request.getParameter("name"), request.getParameter("mail"), request.getParameter("comment")));
            request.getSession().setAttribute("feedback", feedback);
        }

        response.sendRedirect("ksiegaGosci.jsp");
    }
}
