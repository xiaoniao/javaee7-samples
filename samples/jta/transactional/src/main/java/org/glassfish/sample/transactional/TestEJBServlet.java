/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassfish.sample.transactional;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arungup
 */
@WebServlet(urlPatterns = {"/TestEJBServlet"})
public class TestEJBServlet extends HttpServlet {

    @Inject MySessionBean mySessionBean;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestEJBServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestEJBServlet at " + request.getContextPath() + "</h1>");
            
            out.println("EJB calling bean with Transactional.TxType.REQUIRED</br>");
            try {
                mySessionBean.requiredOuter();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
            out.println("No stack trace, right ?<p/>");
            
            out.println("EJB calling bean with Transactional.TxType.REQUIRES_NEW</br>");
            try {
                mySessionBean.requiredOuter();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
            out.println("No stack trace, right ?<p/>");
            
            out.println("EJB calling bean with Transactional.TxType.MANDATORY</br>");
            try {
                mySessionBean.mandatoryOuter();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
            out.println("No stack trace, right ?<p/>");
            
            out.println("EJB calling bean with Transactional.TxType.SUPPORTS</br>");
            try {
                mySessionBean.supportsOuter();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
            out.println("No stack trace, right ?<p/>");
            
            out.println("EJB calling bean with Transactional.TxType.NOT_SUPPORTED</br>");
            try {
                mySessionBean.notSupportedOuter();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
            out.println("No stack trace, right ?<p/>");
            
            out.println("EJB calling bean with Transactional.TxType.NEVER</br>");
            try {
                mySessionBean.neverOuter();
            } catch (Exception e) {
                out.println(e.getMessage() + "<br>");
            }
            out.println("Got exception message, right ?<p/>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
