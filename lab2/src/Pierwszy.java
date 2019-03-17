import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Pierwszy")
public class Pierwszy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("imie");
        int age = Integer.parseInt(request.getParameter("wiek"));
        out.println("<html>");
        out.println("<head><title>Pierwszy Servlet</title></head>");
        out.println("<body>");
        out.println("<p>Witaj, " + name + ", masz " + age + " lat</p>");
        if (age > 18) {
            out.println("<a href='/doradcaPiwnyForm.html'>Doradca Piwny</a> ");
        } else {
            out.println("<p>Sorry mordo, nie masz 18 lat i nie możesz skorzystać z usług Doradcy Piwnego</p>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
