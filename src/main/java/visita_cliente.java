import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "visita_cliente",urlPatterns = {"/visita_cliente"})
public class visita_cliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        
        Cookie[] cooki = request.getCookies();
        
        if (cooki != null) {
            for (Cookie c : cooki) {
                if (c.getName().equals("visita")) {
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        contador ++;
        Cookie c = new Cookie("visita", Integer.toString(contador));
        c.setMaxAge(120);
        response.addCookie(c);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (contador == 1) {
            out.print("Bienvenído a nuestro sitio web");
        }else{
            out.print("Gracias por visitarnos nuevamente");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
