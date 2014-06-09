/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbentities.ProjectTaskEntity;
import dbentities.TaskDetailsEntity;
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
public class WorkStructure_HealthCOSCA extends HttpServlet {

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
                ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                ProjectTaskEntity preActs = taskDAO.getAllTasksOfTypeForProject(project_id, ProjectTaskDAO.PRE_ACTS).get(0);
                TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                List<TaskDetailsEntity> medicineList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.MEDICINE);
                detailsDAO = new TaskDetailsDAO();
                List<TaskDetailsEntity> equipmentList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.EQUIPMENT);
                detailsDAO = new TaskDetailsDAO();
                List<TaskDetailsEntity> medicalProfessionalList = detailsDAO.getAllDoctorsSummary(project_id, ProjectTaskDAO.MEDICAL_PROFESSIONAL);

                request.setAttribute("unavailableProj", unavailableProj);
                request.setAttribute("preActs", preActs);
                request.setAttribute("medicineList", medicineList);
                request.setAttribute("equipmentList", equipmentList);
                request.setAttribute("medicalProfessionalList", medicalProfessionalList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/WorkStructure_Health.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
               
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
