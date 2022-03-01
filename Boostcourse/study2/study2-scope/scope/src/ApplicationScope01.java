import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplicationScope01", value = "/ApplicationScope01")
public class ApplicationScope01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        ServletContext application = getServletContext();

        int value=1;
        application.setAttribute("value",value);

        out.println("<h1>value : "+value+"</h1>");
    }
}
