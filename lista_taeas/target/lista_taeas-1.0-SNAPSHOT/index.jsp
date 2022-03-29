<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.lista_taeas.tarea"%>
<%
    if (session.getAttribute("lista")==null){
        ArrayList<tarea> lisaux = new ArrayList<tarea>();
        session.setAttribute("lista",lisaux);
    }
    ArrayList<tarea>listas = (ArrayList<tarea>)session.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>TAREAS PENDIENTES</h1>
        <a href="tareas.jsp">Nuevo</a>
        <form action="ServletMain" method="post">
            <table border="1">
            <tr>
                <th>Id</th>
                <th>Tarea</th>
                <th>Completado</th>
                <th>Borrar</th>
                <th></th>
            </tr>
            <%
                if(listas!=null){
                    for (tarea l: listas){
            %>
            <tr>
                <td><%= l.getId() %></td>
                <td><%= l.getTarea() %></td>
                <th><input type="checkbox" name="tareaaeliminar" value="ON" /></th>
                <td><a href="ServletMain?op=eliminar&id=<%=l.getId()%> ">Borrar</a></td>
            </tr>
            <%        
                }
                
                }
            %>
        </table>
        </form>
    </body>
</html>
