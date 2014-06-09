/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cosca;

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
public class ProjectsAccomplished extends HttpServlet {

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
                List<UnavailableProjectEntity> closedProj = unavailableProjDAO.getAllProjectsType(ProjectCharterDAO.ACCOMPLISHED);
                unavailableProjDAO = new UnavailableProjectDAO();
                List<UnavailableProjectEntity> closedProjList = unavailableProjDAO.getAllProjectsTypeCommunity(ProjectCharterDAO.ACCOMPLISHED);

                session.removeAttribute("isOnGoing");
                request.setAttribute("closedProj", closedProj);
                request.setAttribute("closedProjList", closedProjList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/ProjectsAccomplished.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                if (request.getParameter("ViewFullProjectCharter") != null) {
                    String project_id = request.getParameter("ViewFullProjectCharter");
                    HttpSession session = request.getSession();
                    session.setAttribute("project_id", project_id);
                    response.sendRedirect("ViewFullProjectCharterCOSCA");
                } else if (request.getParameter("WorkStructure") != null) {
                    String project_id = request.getParameter("WorkStructure");
                    String[] id_type = project_id.split("-");
                    HttpSession session = request.getSession();
                    session.setAttribute("project_id", id_type[0]);
                    if (id_type[1].equals("Seminar")) {
                        session.setAttribute("typeOfStructure", "seminar");
                        response.sendRedirect("WorkStructure_SeminarCOSCA");
                    } else {
                        session.setAttribute("typeOfStructure", "health");
                        response.sendRedirect("WorkStructure_HealthCOSCA");
                    }
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
