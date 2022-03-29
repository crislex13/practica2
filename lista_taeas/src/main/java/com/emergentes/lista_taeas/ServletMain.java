
package com.emergentes.lista_taeas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletMain", urlPatterns = {"/ServletMain"})
public class ServletMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op.equals("eliminar")) {
            int pos =-1;
            int buscado=-1;
            int id = Integer.parseInt(request.getParameter("id"));
             HttpSession ses = request.getSession();
            ArrayList<tarea> lista = (ArrayList<tarea>)ses.getAttribute("lista");
            
            for(tarea p : lista){
                pos++;
                if (p.getId() == id){
                    buscado = pos;
                }                
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }
        HttpSession ses = request.getSession();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");
        tarea tar = new tarea();
        tar.setId(id);
        tar.setTarea(tarea);
        HttpSession ses = request.getSession();
        ArrayList<tarea> lista = (ArrayList<tarea>)ses.getAttribute("lista");
        lista.add(tar);
        response.sendRedirect("index.jsp");
    }

}
