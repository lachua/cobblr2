/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.sorg;

import dbdao.ProjectCharterDAO;
import dbdao.UnavailableProjectDAO;
import dbdao.UserEntityDAO;
import dbentities.UnavailableProjectEntity;
import dbentities.UserEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ConfirmProjects extends HttpServlet {

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
                HttpSession session = request.getSession();
                String username = session.getAttribute("USERNAME").toString();
                UserEntityDAO userDAO = new UserEntityDAO();
                UserEntity thisUser = userDAO.getUserDetails(username);

                UnavailableProjectDAO unavailableProjDAO = new UnavailableProjectDAO();
                List<UnavailableProjectEntity> pendingProj = unavailableProjDAO.getAllProjectsTypeOrg(ProjectCharterDAO.PENDING, thisUser.getId());
                unavailableProjDAO = new UnavailableProjectDAO();
                List<UnavailableProjectEntity> confirmedProj = unavailableProjDAO.getAllProjectsTypeOrg(ProjectCharterDAO.COMFIRMED, thisUser.getId());
                unavailableProjDAO = new UnavailableProjectDAO();
                List<UnavailableProjectEntity> pendingProjList = unavailableProjDAO.getAllProjectsTypeOrgCommunity(ProjectCharterDAO.PENDING, thisUser.getId());
                unavailableProjDAO = new UnavailableProjectDAO();
                List<UnavailableProjectEntity> confirmedProjList = unavailableProjDAO.getAllProjectsTypeOrgCommunity(ProjectCharterDAO.COMFIRMED, thisUser.getId());

                request.setAttribute("pendingProj", pendingProj);
                request.setAttribute("confirmedProj", confirmedProj);
                request.setAttribute("pendingProjList", pendingProjList);
                request.setAttribute("confirmedProjList", confirmedProjList);
                session.removeAttribute("fullCharter");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/ConfirmProjects.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                if (request.getParameter("confirmProject") != null) {
                    String project_id = request.getParameter("confirmProject");
                    HttpSession session = request.getSession();
                    session.setAttribute("project_id", project_id);
                    response.sendRedirect("CreateFullProjectCharter");
                } else if (request.getParameter("pendingProject") != null) {
                    String project_id = request.getParameter("pendingProject");
                    HttpSession session = request.getSession();
                    session.setAttribute("project_id", project_id);
                    response.sendRedirect("ProjectPendingDetails");
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
