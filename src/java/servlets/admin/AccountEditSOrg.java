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
public class AccountEditSOrg extends HttpServlet {

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
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountEditSOrg.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                int type = Integer.parseInt(request.getParameter("type"));
                String coscaAccts = request.getParameter("coscaAccts");
                String studentAccts = request.getParameter("studentAccts");
                String oldpassword = request.getParameter("oldpassword");
                String newpassword = request.getParameter("newpassword");
                StudentOrgDAO studentDAO = new StudentOrgDAO();
                int newID = studentDAO.getLastId()+1;
                boolean addDB = false;
                
                UserEntityDAO userDAO = new UserEntityDAO();
                UserEntity thisUser = userDAO.getUserDetails(studentAccts, oldpassword);
                
                if(type == 1){
                    userDAO = new UserEntityDAO();
                    thisUser = userDAO.getUserDetails(coscaAccts, oldpassword);
                }
                
                if(thisUser != null){
                    userDAO = new UserEntityDAO();
                    if(type == 1){
                        addDB = userDAO.editPass(coscaAccts, newpassword);
                    }else{
                        addDB = userDAO.editPass(studentAccts, newpassword);
                    }
                    
                    if (addDB) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountEdited.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("ErrorInDB.jsp");
                    }
                }else{
                    userDAO = new UserEntityDAO();
                    List<UserEntity> cosca = userDAO.getCOSCAAccounts();
                    userDAO = new UserEntityDAO();
                    List<UserEntity> sorg = userDAO.getSOrgAccounts();
                
                    request.setAttribute("cosca", cosca);
                    request.setAttribute("sorg", sorg);
                    request.setAttribute("isExisting", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountEditSOrg.jsp");
                    dispatcher.forward(request, response);
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
