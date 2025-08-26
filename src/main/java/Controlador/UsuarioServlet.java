/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author manja
 */
public class UsuarioServlet extends HttpServlet {
 private final UsuarioDao usuarioDao = new UsuarioDao();
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
        String accion = request.getParameter("accion");
        switch(accion){
            case "nuevacuenta":
                NuevaCuentaUsuario(request,response);
                break;
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
       processRequest(request, response);
        
       
    }

    private void NuevaCuentaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Usuario users = new Usuario();
        users.setNombre(request.getParameter("nombre"));
        users.setUsuario(request.getParameter("usuario"));
        users.setCorreo(request.getParameter("correo"));
        users.setClave(request.getParameter("clave"));
        users.setRol(Integer.parseInt(request.getParameter("rol")));
        int result = usuarioDao.NuevaCuenta(users);
        if(result >0){
            response.sendRedirect("index.jsp?estado=registrado");
        }else{
            response.sendRedirect(request.getContextPath()+ "/Public/web/register.jsp?error=registro");
        }
    }
    }