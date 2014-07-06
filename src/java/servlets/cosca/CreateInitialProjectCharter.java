/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.cosca;

import dbdao.ProjectCharterDAO;
import dbentities.ProjectCharterEntity;
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
public class CreateInitialProjectCharter extends HttpServlet {

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
                
                ProjectCharterEntity initialCharter = (ProjectCharterEntity) session.getAttribute("initialCharter");

                String projectType = (String) session.getAttribute("projectType");
                String communityDetail = (String) session.getAttribute("CommunityDetail");
                String[] communitySplit = communityDetail.split("-");
                
                ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                ProjectCharterEntity charter = charterDAO.getDefaultCharterTemplate(projectType);

                request.setAttribute("communityName", communitySplit[1]);
                request.setAttribute("projectType", projectType);
                request.setAttribute("charter", charter);
                request.setAttribute("initialCharter", initialCharter);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/CreateInitialProjectCharter.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String preparedby = request.getParameter("preparedby");
                String objective = request.getParameter("objective");
                String scope = request.getParameter("scope");
                String requirements = request.getParameter("requirements");
                String[] target_sickness = request.getParameterValues("target_sickness");
                String target_number = request.getParameter("target_number");
                
                HttpSession session = request.getSession();
                
                String projectType = (String) session.getAttribute("projectType");
                String communityDetail = (String) session.getAttribute("CommunityDetail");
                String[] communitySplit = communityDetail.split("-");
                
                ProjectCharterEntity initialCharter = new ProjectCharterEntity(Integer.parseInt(communitySplit[0]), title, description, preparedby, objective, scope, requirements, projectType);
                
                session.setAttribute("initialCharter", initialCharter);
                session.setAttribute("target_sickness", target_sickness);
                session.setAttribute("target_number", target_number);
                response.sendRedirect("FinalizeInitialProjectCharter");
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
