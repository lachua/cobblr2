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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renliw
 */
public class AccountCreateSOrg extends HttpServlet {

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
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountCreateSOrg.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                int type = Integer.parseInt(request.getParameter("type"));
                String orgType = request.getParameter("orgType");
                int usgId = Integer.parseInt(request.getParameter("usgId"));
                int csoId = Integer.parseInt(request.getParameter("csoId"));
                String newusername = request.getParameter("newusername");
                String newpassword = request.getParameter("newpassword");
                boolean addDB = false;
                
                UserEntityDAO userDAO = new UserEntityDAO();
                UserEntity thisUser = userDAO.getUserDetails(newusername);
                
                if(thisUser == null){
                    if(type == 1){
                        userDAO = new UserEntityDAO();
                        addDB = userDAO.insertUser(type, newusername, newpassword);
                    }else if(type == 2){
                        if(orgType.equals("USG")){
                            userDAO = new UserEntityDAO();
                            addDB = userDAO.insertUser(usgId, newusername, newpassword);
                        }else{
                            userDAO = new UserEntityDAO();
                            addDB = userDAO.insertUser(csoId, newusername, newpassword);
                        }
                    }
                    
                    if (addDB) {
                        request.setAttribute("type", "Account");
                        request.setAttribute("action", "Created");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountDone.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("ErrorInDB.jsp");
                    }
                }else{
                    request.setAttribute("type", type);
                    request.setAttribute("orgType", orgType);
                    request.setAttribute("usgId",usgId);
                    request.setAttribute("csoId",csoId);
                    request.setAttribute("newusername", newusername);
                    request.setAttribute("newpassword", newpassword);
                    request.setAttribute("isExisting", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountCreateSOrg.jsp");
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
