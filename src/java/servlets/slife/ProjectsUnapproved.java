/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.slife;

import dbdao.ProjectCharterDAO;
import dbdao.ProjectTaskDAO;
import dbdao.UnavailableProjectDAO;
import dbentities.ProjectCharterEntity;
import dbentities.ProjectTaskEntity;
import dbentities.UnavailableProjectEntity;
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
public class ProjectsUnapproved extends HttpServlet {

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
                UnavailableProjectDAO unavailableProjDAO = new UnavailableProjectDAO();
                List<UnavailableProjectEntity> currentProj = unavailableProjDAO.getPreactsProjects(UnavailableProjectDAO.UNAPPROVED);
                unavailableProjDAO = new UnavailableProjectDAO();
                List<UnavailableProjectEntity> currentProjList = unavailableProjDAO.getPreactsProjectsCommunity(UnavailableProjectDAO.UNAPPROVED);

                HttpSession session = request.getSession();
                session.setAttribute("isOnGoing", true);
                request.setAttribute("currentProj", currentProj);
                request.setAttribute("currentProjList", currentProjList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysSLife/ProjectsUnapproved.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                if (request.getParameter("Approve") != null) {
                    int project_id = Integer.parseInt(request.getParameter("Approve"));
                    ProjectTaskDAO taskdao  = new ProjectTaskDAO();
                    boolean addDB = taskdao.setCompleted(project_id, "pre-acts", true);
                    ProjectCharterDAO projdao = new ProjectCharterDAO();
                    ProjectCharterEntity proj = projdao.getProjectCharter(project_id);
                    
                    request.setAttribute("projapprove", proj.getTitle());
                    
                    UnavailableProjectDAO unavailableProjDAO = new UnavailableProjectDAO();
                    List<UnavailableProjectEntity> currentProj = unavailableProjDAO.getPreactsProjects(UnavailableProjectDAO.UNAPPROVED);
                    unavailableProjDAO = new UnavailableProjectDAO();
                    List<UnavailableProjectEntity> currentProjList = unavailableProjDAO.getPreactsProjectsCommunity(UnavailableProjectDAO.UNAPPROVED);

                    HttpSession session = request.getSession();
                    session.setAttribute("isOnGoing", true);
                    request.setAttribute("currentProj", currentProj);
                    request.setAttribute("currentProjList", currentProjList);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysSLife/ProjectsUnapproved.jsp");
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
