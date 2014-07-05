/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.sorg;

import dbdao.ProjectCharterDAO;
import dbdao.ProjectCharterDateDAO;
import dbdao.ProjectTaskDAO;
import dbdao.TaskDetailsDAO;
import dbdao.UnavailableProjectDAO;
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
public class WorkStructure_Seminar extends HttpServlet {

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
                List<TaskDetailsEntity> speakerList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.SPEAKER);

                request.setAttribute("unavailableProj", unavailableProj);
                request.setAttribute("preActs", preActs);
                request.setAttribute("speakerList", speakerList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/WorkStructure_Seminar.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                session.removeAttribute("lackPreacts");
                session.removeAttribute("lackSpeaker");
                int project_id = Integer.parseInt((String) session.getAttribute("project_id"));

                ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                ProjectTaskEntity preActs = taskDAO.getAllTasksOfTypeForProject(project_id, ProjectTaskDAO.PRE_ACTS).get(0);
                TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                List<TaskDetailsEntity> speakerList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.SPEAKER);

                boolean preacts = false;
                boolean speaker = false;

                if (preActs.getCompleted() != 0) {
                    preacts = true;
                }
                for (int x = 0; x < speakerList.size(); x++) {
                    if (speakerList.get(x).getCurrentcount() > 0) {
                        speaker = true;
                        break;
                    }
                }

                if (!preacts) {
                    session.setAttribute("lackPreacts", true);
                }
                if (!speaker) {
                    session.setAttribute("lackSpeaker", true);
                }

                if (!preacts || !speaker ) {
                    response.sendRedirect("WorkStructure_Health");
                } else {
                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                    boolean addDB = charterDAO.updateProjectStatus(project_id, ProjectCharterDAO.IMPLMENTED);
                    if(addDB){
                     ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                     project_date.setDateImplemented(project_id);
                    }

                    if (addDB) {
                        session.removeAttribute("project_id");
                        response.sendRedirect("CloseProjects");
                    } else {
                        response.sendRedirect("ErrorInDB");
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
