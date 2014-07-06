/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.sorg;

import dbdao.ProjectCharterDAO;
import dbdao.UnavailableProjectDAO;
import dbentities.ProjectCharterEntity;
import dbentities.UnavailableProjectEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CreateFullProjectCharter extends HttpServlet {

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

                int project_id = Integer.parseInt((String) session.getAttribute("project_id"));

                UnavailableProjectDAO unavailableDAO = new UnavailableProjectDAO();
                UnavailableProjectEntity unavailableProj = unavailableDAO.getUnavailableProject(project_id);
                UnavailableProjectEntity fullCharter = (UnavailableProjectEntity) session.getAttribute("fullCharter");
        
                request.setAttribute("unavailableProj", unavailableProj);
                request.setAttribute("fullCharter", fullCharter);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/CreateFullProjectCharter.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();

                int project_id = Integer.parseInt((String) session.getAttribute("project_id"));

                UnavailableProjectDAO unavailableDAO = new UnavailableProjectDAO();
                UnavailableProjectEntity unavailableProj = unavailableDAO.getUnavailableProject(project_id);

                unavailableProj.setTitle(request.getParameter("title"));
                unavailableProj.setDescription(request.getParameter("description"));
                unavailableProj.setPreparedby(request.getParameter("preparedby"));
                unavailableProj.setObjectives(request.getParameter("objective"));
                unavailableProj.setScope(request.getParameter("scope"));
                unavailableProj.setRequirements(request.getParameter("requirements"));
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
                java.sql.Date datesql = new java.sql.Date(date.getTime());
                unavailableProj.setMeetingdate(datesql);
                
                String[] target_sickness = request.getParameterValues("target_sickness");
                String target_number = request.getParameter("target_number");

                session.setAttribute("fullCharter", unavailableProj);
                session.setAttribute("target_sickness", target_sickness);
                session.setAttribute("target_number", target_number);
                response.sendRedirect("FinalizeFullProjectCharter");
            }
        } catch (ParseException ex) {
            Logger.getLogger(CreateFullProjectCharter.class.getName()).log(Level.SEVERE, null, ex);
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
