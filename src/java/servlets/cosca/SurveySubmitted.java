/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cosca;

import classes.SurveyResults;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
public class SurveySubmitted extends HttpServlet {

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
                Calendar cal = (Calendar) session.getAttribute("Year");
                String community_id = (String) session.getAttribute("community_id");
                String community_name = (String) session.getAttribute("community_name");
                
                SurveyResults surveyResult = new SurveyResults(Integer.parseInt(community_id), cal.getWeekYear());
                surveyResult.getNumFamilies();
                request.setAttribute("surveyResult", surveyResult);
                request.setAttribute("community_name", community_name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/SurveySubmitted.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                session.removeAttribute("community_id");
                session.removeAttribute("community_name");
                session.removeAttribute("Year");

                String communityDetail = (String) session.getAttribute("CommunityDetail");
                String[] communityName = communityDetail.split("-");
                session.setAttribute("community_id", communityName[0]);
                session.setAttribute("community_name", communityName[1]);
                response.sendRedirect("EncodeCommunitySurvey");
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
