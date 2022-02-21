import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@WebServlet(name = "TodayServlet", value = "/today")
public class TodayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>now_time</title></head>");
        out.println("<body>");

        out.println("<a href=\"index.jsp\">메인화면<a>");

        out.println("<div style=\"text-align:center; padding-top: 30%;\">");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("현재시간 : yyyy/M/d hh:mm");
        String time= now.format(dateTimeFormatter);

        out.println("<h1>"+time+"</h1>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
