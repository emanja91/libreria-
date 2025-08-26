<%-- 
    Document   : register
    Created on : 24/08/2025, 11:31:18 a. m.
    Author     : manja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca Nacional de Colombia | Crea cuenta usuario</title>
        <link href="../fonts/linearicons/style.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="inner">
                <img src="../img/image-1.png" alt="" class="image-1">
                <form action="${pageContext.request.contextPath}/UsuarioServlet?accion=nuevacuenta" method="POST">
                    <h4 style="margin-bottom: 4%;"><center>Biblioteca Nacional | Nueva cuenta</center> </h4>
                    <div class="form-holder">
                        <span class="lnr lnr-user"></span>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Digite nombre completo" required="">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-user"></span>
                        <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Digite un nombre de usuario" required="">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-envelope"></span>
                        <input type="text" class="form-control" id="correo" name="correo" placeholder="Digite un correo electronico" required="">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-lock"></span>
                        <input type="password" class="form-control" id="clave" name="clave" placeholder="Password" required="">
                    </div>
                    <input type="hidden" name="rol" value="2">
                    <button type="submit">
                        <span>Register</span>
                    </button>
                </form>
                <%-- Mostrar mensajes si existen --%>
                <% if (request.getParameter("error") != null && request.getParameter("error").equals("registro")) { %>
                <p class="error"> No se pudo crear la cuenta. El usuario o correo ya existe.</p>
                <% }%>
                <img src="../img/image-2.png" alt="" class="image-2">
            </div>

        </div>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="../js/main.js" type="text/javascript"></script>
    </body>
</html>
