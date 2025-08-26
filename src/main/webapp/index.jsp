<%-- 
    Document   : index
    Created on : 24/08/2025, 9:24:35 a. m.
    Author     : manja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca Nacional de Colombia | Acceso al Sistema</title>
        <link href="Public/css/style.css" rel="stylesheet" type="text/css"/>
        <!-- LINEARICONS -->
        <link rel="stylesheet" href="Public/fonts/linearicons/style.css">
    </head>
    <body>
        <div class="wrapper">
            <div class="inner">
                <img src="Public/img/image-1.png" alt="" class="image-1">
                <form action="LoginServlet" method="post">
                    <h4 style="margin-bottom: 4%;"><center>Biblioteca Nacional de Colombia | Acceso</center></h4>
                    <div class="form-holder">
                        <span class="lnr lnr-user"></span>
                        <input type="text" class="form-control" placeholder="Digite nombre de usuario" id="usuario" name="usuario" required="">
                    </div>

                    <div class="form-holder">
                        <span class="lnr lnr-lock"></span>
                        <input type="password" class="form-control" placeholder="Digite clave de usuario" id="clave" name="clave" required="">
                    </div>
                    <button type="submit">
                        <span>Login</span>
                    </button>
                    <p class="message">Not registered? <a href="Public/web/register.jsp">Create an account</a></p>
                    <%-- Mostrar mensaje de error si existe --%>
                    <% if (request.getParameter("error") != null) { %>
                    <p class="error">Usuario o contraseña incorrectos.</p>
                    <br>
                    <br>
                    <% } else if (request.getParameter("estado") != null && request.getParameter("estado").equals("cerrado")) { %>
                    <p class="exito">¡Has cerrado la sesión correctamente!</p>
                    <% } else if (request.getParameter("estado") != null && request.getParameter("estado").equals("registrado")) { %>
                    <p class="exito">¡Tu cuenta ha sido creada exitosamente! Ahora inicia sesión.</p>
                    <% }%>


                </form>

                <br />
                <img src="Public/img/image-2.png" alt="" class="image-2">
            </div>

        </div>

        <script src="Public/js/jquery-3.3.1.min.js"></script>
        <script src="Public/js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</body>
</html>