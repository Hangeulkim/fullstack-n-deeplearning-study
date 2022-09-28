import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontServlet", value = "/front")
public class FrontServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int diceValue = (int)(Math.random() * 6)+1;
        req.setAttribute("dice",diceValue);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/next");
        requestDispatcher.forward(req,resp);
    }
}
