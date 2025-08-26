/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author manja
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        UsuarioDao dao = new UsuarioDao();
        Usuario usuarioValidado = dao.validar(usuario, clave);
        if (usuarioValidado != null) {
            // Si el usuario es válido, creamos la sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioValidado);

            // Redirigir según el rol
            switch (usuarioValidado.getRol()) {
                case 1: // accede a la interfaz de Administrador en la cual tiene diversos permisos de acceso
                    response.sendRedirect(request.getContextPath() + "/Vista/admin/index.jsp");
                    break;
                case 2: // Estudiante
                    response.sendRedirect(request.getContextPath() + "/Vista/estudiante/index.jsp");
                    break;
                case 3: // Docente
                    response.sendRedirect(request.getContextPath() + "/Vista/docente/index.jsp");
                    break;
                case 4: // Funcionario
                     response.sendRedirect(request.getContextPath() + "/Vista/funcionario/index.jsp");
                    break;
                default: // Rol no reconocido
                    response.sendRedirect("index.jsp?error=rol");
                    break;
            }
        } else {
            // Si el usuario no es válido, redirigir al login con un error
            response.sendRedirect("index.jsp?error=1");
        }
    }
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */