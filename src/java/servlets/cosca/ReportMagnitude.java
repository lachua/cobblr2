/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.cosca;

import Utilities.Converter;
import dbdao.ReportMagnitudeDAO;
import dbentities.ReportMagnitudeEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class ReportMagnitude extends HttpServlet {

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
                String datestart = request.getParameter("magdatestart");
                String dateend = request.getParameter("magdateend");
                String disease = request.getParameter("disease");
                String[] questionAnswer = disease.split("-");

                Calendar calstart = new GregorianCalendar();
                Calendar calend = new GregorianCalendar();

                calstart.set(Calendar.YEAR, Integer.parseInt(datestart));
                calend.set(Calendar.YEAR, Integer.parseInt(dateend));

                ReportMagnitudeDAO dao = new ReportMagnitudeDAO();
                List<ReportMagnitudeEntity> report = dao.getReportMagnitudeEntity(Integer.parseInt(questionAnswer[0]),Integer.parseInt(questionAnswer[1]),Converter.toDate(calstart), Converter.toDate(calend));

                HttpSession session = request.getSession();
                session.setAttribute("report", report);
                session.setAttribute("datestart", datestart);
                session.setAttribute("dateend", dateend);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/ReportMagnitude.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {

                response.sendRedirect("PrintMagnitude");
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
