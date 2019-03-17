import com.sun.deploy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "SortowanieZad1")
public class SortowanieZad1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Posortowane liczby</title></head>");
        out.println("<body>");

        Enumeration<String> parameterNames = request.getParameterNames();
        ArrayList<Double> numbers = new ArrayList<>();

        while (parameterNames.hasMoreElements()) {
            String nextParam = request.getParameter(parameterNames.nextElement());
            if (this.isNumeric(nextParam)) {
                numbers.add(Double.parseDouble(nextParam));
            } else {
                out.println("<p>wrong format </p>");
                out.println("</body>");
                out.println("</html>");
                out.close();
                return;
            }
        }

        numbers.sort((a, b) -> a > b ? 1 : (a < b) ? -1 : 0);

        numbers.forEach(e -> out.println("<p>" + e +"</p>" ));
        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
