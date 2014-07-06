/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.cosca;

import Utilities.Year;
import dbdao.NotificationDAO;
import dbdao.ProjectCharterDAO;
import dbdao.ProjectCharterDateDAO;
import dbdao.ProjectTargetDAO;
import dbdao.UnavailableProjectDAO;
import dbentities.NotificationEntity;
import dbentities.ProjectCharterDateEntity;
import dbentities.ProjectCharterEntity;
import dbentities.ProjectTargetEntity;
import dbentities.UnavailableProjectEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renliw
 */
public class WorkStructure_HealthCosca extends HttpServlet {

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
            } else if (request.getMethod().equals("POST")) {
                String project_id = request.getParameter("project_id");
                
                UnavailableProjectDAO ongoingDAO = new UnavailableProjectDAO();
                UnavailableProjectEntity ongoing = ongoingDAO.getUnavailableProject(Integer.parseInt(project_id));
                ProjectCharterDateDAO projectdateDAO = new ProjectCharterDateDAO();
                ProjectCharterDateEntity projectdateEntity = projectdateDAO.getProjectDate(Integer.parseInt(project_id));
                ProjectTargetDAO projecttargetDAO = new ProjectTargetDAO();
                List<ProjectTargetEntity> projecttargetEntity = projecttargetDAO.getAllProjectTarget(Integer.parseInt(project_id));
                
                ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                ProjectCharterEntity charter = charterDAO.getProjectCharter(Integer.parseInt(project_id));
                
                charterDAO = new ProjectCharterDAO();
                boolean DB = charterDAO.updateProjectStatus(Integer.parseInt(project_id), ProjectCharterDAO.CANCELED);
                ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                DB = project_date.setDateCancelled(Integer.parseInt(project_id));
                
                if(DB){
                charterDAO = new ProjectCharterDAO();
                DB = charterDAO.createNewProject(charter);
                charterDAO = new ProjectCharterDAO();
                int newProject_id = charterDAO.getLastId();
                if(DB){
                    projectdateDAO = new ProjectCharterDateDAO();
                    DB = projectdateDAO.insertNewProject(newProject_id, projectdateEntity.getTarget_participant_num());
                }
                for (int x = 0; x < projecttargetEntity.size(); x++) {
                    if (DB) {
                        projecttargetDAO = new ProjectTargetDAO();
                        DB = projecttargetDAO.insertProjectTarget(newProject_id, projecttargetEntity.get(x).getOfferedanswer_id());
                    }
                }
                }
                
                if(DB){
                    NotificationEntity notif = new NotificationEntity();
                    notif.setOrg_id(ongoing.getOrg_id());
                    notif.setNotificationtext("ORG_CancelProject");
                    notif.setProject_id(Integer.parseInt(project_id));
                    notif.setComments(" ");
                    notif.setDate(Year.getCurrentDateinCalendar().getTime());
                    notif.setViewed(1);
                    
                    NotificationDAO notifDAO = new NotificationDAO();
                    DB = notifDAO.insertNotif(notif);
                }
                
                if(DB){
                    HttpSession session = request.getSession();
                    session.setAttribute("ongoing", ongoing);
                    response.sendRedirect("CancelProject");
                }else{
                    response.sendRedirect("ErrorInDB.jsp");
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
