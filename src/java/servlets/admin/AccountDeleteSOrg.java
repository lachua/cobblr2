/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.admin;

import dbdao.StudentOrgDAO;
import dbdao.UserEntityDAO;
import dbentities.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renliw
 */
public class AccountDeleteSOrg extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            if (request.getMethod().equals("GET")) {
                UserEntityDAO userDAO;
                userDAO = new UserEntityDAO();
                List<UserEntity> cosca = userDAO.getCOSCAAccounts();
                userDAO = new UserEntityDAO();
                List<UserEntity> sorg = userDAO.getSOrgAccounts();
                
                request.setAttribute("cosca", cosca);
                request.setAttribute("sorg", sorg);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountDeleteSOrg.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                int type = Integer.parseInt(request.getParameter("type"));
                String coscaAccts = request.getParameter("coscaAccts");
                String studentAccts = request.getParameter("studentAccts");
                boolean addDB = false;
                
                UserEntityDAO userDAO;
                userDAO = new UserEntityDAO();
                if(type == 1){
                    addDB = userDAO.deleteUser(coscaAccts);
                }else{
                    addDB = userDAO.deleteUser(studentAccts);
                }

                if (addDB) {
                    request.setAttribute("type", "Account");
                    request.setAttribute("action", "Deleted");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountDone.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("ErrorInDB.jsp");
                }
            }
        } finally {
            out.close();
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
