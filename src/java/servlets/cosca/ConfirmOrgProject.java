/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cosca;

import Utilities.Converter;
import Utilities.Year;
import dbdao.NotificationDAO;
import dbdao.ProjectCharterDAO;
import dbdao.UnavailableProjectDAO;
import dbentities.UnavailableProjectEntity;
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
public class ConfirmOrgProject extends HttpServlet {

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
                String project_id = (String) session.getAttribute("project_id");

                UnavailableProjectDAO unavailableProjDAO = new UnavailableProjectDAO();
                UnavailableProjectEntity unavailableProj = unavailableProjDAO.getPendingProjects(Integer.parseInt(project_id));

                request.setAttribute("unavailableProj", unavailableProj);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/ConfirmOrgProject.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                if (request.getParameter("action").equals("print")) {
                    String printProj_id = request.getParameter("proj_id");
                    HttpSession session = request.getSession();
                    session.setAttribute("printProj_id",printProj_id);
                    response.sendRedirect("PrintCharter");
                } else {
                    HttpSession session = request.getSession();
                    String action = request.getParameter("action");
                    String comments = request.getParameter("comments");
                    if (comments.equals("")) {
                        comments = "N/A";
                    }
                    String org_id = request.getParameter("org_id");
                    String project_id = (String) session.getAttribute("project_id");

                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                    NotificationDAO notifDAO = new NotificationDAO();

                    boolean result = false;

                    if (action.equals("approved")) {
                        result = charterDAO.approvePendingProject(Integer.parseInt(project_id), Converter.toDate(Year.getCurrentDateinCalendar()));
                        if (result) {
                            result = notifDAO.approvePendingProject(Integer.parseInt(project_id), Integer.parseInt(org_id));
                        }
                    } else if (action.equals("disapproved")) {
                        result = charterDAO.disapprovePendingProject(Integer.parseInt(project_id), Integer.parseInt(org_id));
                        if (result) {
                            result = notifDAO.disapprovePendingProject(Integer.parseInt(project_id), Integer.parseInt(org_id), comments);
                        }
                    }

                    if (result != true) {
                        response.sendRedirect("ErrorInDB.jsp");
                    } else if (action.equals("approved") && result) {
                        response.sendRedirect("ApprovedPending");
                    } else if (action.equals("disapproved") && result) {
                        response.sendRedirect("DisapprovedPending");
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
