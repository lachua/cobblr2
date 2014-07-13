/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.admin;

import dbdao.StudentOrgDAO;
import dbentities.StudentOrgEntity;
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
public class SOrgAdd extends HttpServlet {

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
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/SOrgAdd.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                String orgType = request.getParameter("orgType");
                String neworg = request.getParameter("neworg");
                StudentOrgDAO studentDAO = new StudentOrgDAO();
                int newID = studentDAO.getLastId()+1;
                boolean addDB = false;
                
                studentDAO = new StudentOrgDAO();
                List<StudentOrgEntity> org = studentDAO.getOrgName(neworg);
                
                if(org == null){
                    studentDAO = new StudentOrgDAO();
                    addDB = studentDAO.insertOrg(newID, neworg, orgType);
                    
                    if (addDB) {
                        request.setAttribute("type", "" + neworg);
                        request.setAttribute("action", "Created");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/AccountDone.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("ErrorInDB.jsp");
                    }
                }else{
                    request.setAttribute("orgType", orgType);
                    request.setAttribute("neworg", neworg);
                    request.setAttribute("isExisting", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysAdmin/SOrgAdd.jsp");
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
