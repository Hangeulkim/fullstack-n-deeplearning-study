import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplicationScope2", value = "/ApplicationScope2")
public class ApplicationScope2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        ServletContext application = getServletContext();

        try {
            int value = (Integer) application.getAttribute("value");
            value++;
            application.setAttribute("value", value);

            out.println("<h1>value : " + value + "</h1>");
        }catch (NullPointerException e){
            out.println("value값이 설정 되지 않았습니다.");
        }
    }
}
