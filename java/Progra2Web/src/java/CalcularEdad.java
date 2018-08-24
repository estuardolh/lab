/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author estuardolh
 */
public class CalcularEdad extends HttpServlet {

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
            out.println("<title>Servlet CalcularEdad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalcularEdad at " + request.getContextPath() + "</h1>");
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
        Object obj_fecha = request.getParameter("fecha");
        String str_fecha = (obj_fecha == null? "": obj_fecha.toString());
        int edad = 0;
        
        try {
            edad = Calculadora.edad(new SimpleDateFormat("dd/mm/yyyy").parse(str_fecha));
        } catch (ParseException ex) {
            //Logger.getLogger(CalcularEdad.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
	String title = "Calculo de Edad";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
        out.println(docType +
                "<html>\n" 
                + "<head><title>" + title + "</title></head>\n" 
                + "<h1 align=\"center\">" + title + "</h1>\n" 
                + "<hr />"
                + "  <h3>Fecha de nacimiento: <b>" + str_fecha + "</b></h3><p/>\n" 
                + "  <h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Edad: <b>" + edad + " años</b></h3>\n" 
                +"<a href=\"/\">Regresar a Inicio</a>"
                +  "</body></html>");
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
