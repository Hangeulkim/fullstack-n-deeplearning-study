import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(name = "TenServlet", value = "/ten")
public class TenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TenServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request 는 요청 response는 응답으로 돌려줌
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<h1>1-10까지 출력!!<h1>");
        for(int i=1;i<=10;i++){
            out.print(i+"<br>");
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
