<%-- 
    Document   : index
    Created on : 25/08/2025, 5:38:08 p. m.
    Author     : manja
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Proteger la página: si no hay sesión, redirigir al login
    Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario");
    if (usuarioLogueado == null || usuarioLogueado.getRol() != 2) {
        response.sendRedirect(request.getContextPath()+"/index.jsp?error=acceso");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Bienvenido, estudiante: <%= usuarioLogueado.getNombre() %>
        <a  href="<%= request.getContextPath() %>/LogoutServlet">Cerrar Sesión</a>
    </body>
</html>
