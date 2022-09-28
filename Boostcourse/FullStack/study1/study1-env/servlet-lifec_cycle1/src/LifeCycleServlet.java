import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifeCycleServlet", value = "/life")
public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet(){
        System.out.println("LifecycleServlet 생성!");
    }

    public void init(ServletConfig config) throws ServletException{
        System.out.println("init test 호출!");
        //메모리에 없을시에만 호출
    }

    public void destroy(){
        System.out.println("destroy 호출!");
        //servlet 수정시 호출
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head");
        out.println("<body>");
        out.println("<form method='post' action='/servlet_lifec_cycle1_war_exploded/life'>");
        out.println("name : <input type='text' name='name'><br>");
        out.println("<input type='submit' value='ok'><br>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        out.println("<h1> hello "+name+"</h1>");
        out.close();
    }
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        System.out.println("service 호출!");
//        //새로고침이나 홈페이지 로딩시 실행
//    }
}
