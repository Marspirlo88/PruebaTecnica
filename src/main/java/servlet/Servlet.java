/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import api.Api;
import api.Constructor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.BusinessQueryManager;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author marco
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Constructor> lista = new Api().cone();
        System.out.println("lista : " + lista);
        req.setAttribute("lista", lista);

        RequestDispatcher rd = req.getRequestDispatcher("Mostrar.jsp");
        rd.forward(req, res);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
     
        if (nombre.isEmpty()){ 
            //nombre==null||nombre.equals("")||nombre.equals(" ")
            String error = "Ingrese un valor para la busqueda";
            req.setAttribute("vacio", error);
              RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
        rs.forward(req, res);
        
        }
        else{

        Constructor nuevo = new Constructor();

        nuevo.setBuscador(nombre);
        System.out.println("Nombre parametro : " + nombre);
        List<Constructor> lista2 = new Api().buscar(nombre);
            if (lista2.isEmpty()) {
                String error = "No existe Personaje o valor nullo";
               req.setAttribute("vacio", error); 
               RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
               rs.forward(req, res);
            }else{
        req.setAttribute("lista2", lista2);
        RequestDispatcher rs = req.getRequestDispatcher("Mostrar.jsp");
        rs.forward(req, res);
        }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
