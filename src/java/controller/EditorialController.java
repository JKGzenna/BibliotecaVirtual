/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EditorialDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Editorial;

/**
 *
 * @author Arranque 4
 */
public class EditorialController extends HttpServlet {

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
            out.println("<title>Servlet EditorialController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditorialController at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);

        String nit=request.getParameter("nit");
        String nombre=request.getParameter("nombre");
        String telefono=request.getParameter("telefono");
        String direccion=request.getParameter("direccion");
        String email=request.getParameter("email");
        String sitioweb=request.getParameter("sitioweb");

        Editorial e = new Editorial();
        
        e.setNit (nit);
        e.setNombre(nombre);
        e.setTelefono(telefono);
        e.setDireccion(direccion);
        e.setEmail(email);
        e.setSitioweb(sitioweb);
        
        if (request.getParameter("Registrar")!=null){
            
            if(EditorialDAO.registrar(e)){
                request.setAttribute("mensaje", "La Editorial se ha registrado correctamente");
                
            }else{
                request.setAttribute("mensaje", "La Editorial no se ha registrado");
            }
        }else if (request.getParameter("Actualizar")!=null){
            if(EditorialDAO.actualizar(e)){
                request.setAttribute("mensaje", "La Editorial se ha actualizado correctamente");
                
            }else{
                request.setAttribute("mensaje", "La Editorial no se ha actualizado");
            }
        }else if (request.getParameter("Eliminar")!=null){
            if(EditorialDAO.eliminar(e)){
                request.setAttribute("mensaje", "La Editorial se ha eliminado correctamente");
                
            }else{
                request.setAttribute("mensaje", "La Editorial no se ha eliminado");
                
            }
        }else {
                    request.setAttribute("mensaje", "Acción Desconocida");
                    }

        request.getRequestDispatcher("registroEditorial.jsp").forward(request, response);


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
