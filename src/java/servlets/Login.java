/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbdao.UserEntityDAO;
import dbentities.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class Login extends HttpServlet {

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
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getMethod().equals("GET")) {
                Boolean isValid = true, isActive = true;
                request.setAttribute("ValidUser", isValid);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                UserEntityDAO userDAO = new UserEntityDAO();
                UserEntity thisUser = userDAO.getUserDetails(username, password);

                if (thisUser != null) {
                        if (thisUser.getId() == 0) {
                            session.setAttribute("PERMISSION", "admin");
                            session.setAttribute("USERNAME", thisUser.getUsername());
                            session.setAttribute("UserEntity", thisUser);
                            response.sendRedirect("sysAdmin/AdminHome");

                        } else if (thisUser.getId() == 1) {
                            session.setAttribute("PERMISSION", "cosca");
                            session.setAttribute("USERNAME", thisUser.getUsername());
                            session.setAttribute("UserEntity", thisUser);
                            response.sendRedirect("sysCOSCA/COSCAHome");

                        } else {
                            session.setAttribute("PERMISSION", "studentorg");
                            session.setAttribute("USERNAME", thisUser.getUsername());
                            session.setAttribute("UserEntity", thisUser);
                            response.sendRedirect("sysOrg/SOrgHome");
                        }
                } else {
                    Boolean isValid = false;
                    request.setAttribute("ValidUser", isValid);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } finally {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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