import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

@WebServlet(name = "SredniaZad1")
public class SredniaZad1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int[] integers = new int[5];

        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        integers[0] = Integer.parseInt(request.getParameter("first"));
        integers[1] = Integer.parseInt(request.getParameter("second"));
        integers[2] = Integer.parseInt(request.getParameter("third"));
        integers[3] = Integer.parseInt(request.getParameter("fourth"));
        integers[4] = Integer.parseInt(request.getParameter("fifth"));

        double mean = IntStream.of(integers).sum() / 5.0;

        out.println("<html>");
        out.println("<head><title>Srednia</title></head>");
        out.println("<body>");
        out.println("<p>Średnia: </p>" + mean);
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
