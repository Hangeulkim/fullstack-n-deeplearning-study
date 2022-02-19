import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ParamServlet", value = "/param")
public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        out.println("name : "+name+"<br>");
        out.println("age : "+age+"<br>");

        out.println("</body>");
        out.println("</html>");
    }
}
