/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.sorg;

import Utilities.Converter;
import Utilities.Year;
import dbdao.NotificationDAO;
import dbdao.ProjectCharterDAO;
import dbdao.ProjectCharterDateDAO;
import dbdao.ProjectTargetDAO;
import dbdao.ProjectTaskDAO;
import dbentities.NotificationEntity;
import dbentities.ProjectTaskEntity;
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
public class FinalizeFullProjectCharter extends HttpServlet {

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

                UnavailableProjectEntity fullCharter = (UnavailableProjectEntity) session.getAttribute("fullCharter");
                String[] target_sickness = (String[])session.getAttribute("target_sickness");
                String target_number = (String)session.getAttribute("target_number");

                request.setAttribute("fullCharter", fullCharter);
                request.setAttribute("target_sickness", target_sickness);
                request.setAttribute("target_number", target_number);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/FinalizeFullProjectCharter.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();

                UnavailableProjectEntity fullCharter = (UnavailableProjectEntity) session.getAttribute("fullCharter");
                String[] target_sickness = (String[])session.getAttribute("target_sickness");
                String target_number = (String)session.getAttribute("target_number");
                
                boolean addDB = true;
                ProjectCharterDAO fullCharterDAO;
                if (session.getAttribute("isChangeCharter") == null) {
                    ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                    addDB = project_date.setDateOngoing(fullCharter.getProject_id());
                }
                if(addDB){
                    ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                    addDB = project_date.setNewTargetNum(fullCharter.getProject_id(), Integer.parseInt(target_number));
                }
                if(addDB){
                    ProjectTargetDAO targetDAO = new ProjectTargetDAO();
                    addDB = targetDAO.deleteProjectTarget(fullCharter.getProject_id());
                }
                for (String target_sicknes : target_sickness) {
                    if (addDB) {
                        ProjectTargetDAO target = new ProjectTargetDAO();
                        target.insertProjectTarget(fullCharter.getProject_id(), Integer.parseInt(target_sicknes));
                    }
                }
                if (addDB) {
                    fullCharterDAO = new ProjectCharterDAO();
                    addDB = fullCharterDAO.updateFullCharter(fullCharter);
                }
                
                if (addDB) {
                    NotificationDAO notifDAO = new NotificationDAO();
                    addDB = notifDAO.finalizedFullCharter(fullCharter.getProject_id(), fullCharter.getOrg_id());

                    notifDAO = new NotificationDAO();
                    boolean isExistingCOSCA = notifDAO.isExisting("COSCA_Implementation", fullCharter.getProject_id(), fullCharter.getOrg_id());
                    notifDAO = new NotificationDAO();
                    boolean isExistingORG = notifDAO.isExisting("ORG_Implementation", fullCharter.getProject_id(), fullCharter.getOrg_id());

                    if (addDB) {
                        if (isExistingCOSCA && isExistingORG) {
                            NotificationEntity notif = new NotificationEntity();
                            notif.setOrg_id(fullCharter.getOrg_id());
                            notif.setNotificationtext("COSCA_Implementation");
                            notif.setViewed(2);
                            notif.setProject_id(fullCharter.getProject_id());
                            notif.setComments(Converter.toString(Converter.toCalendar(fullCharter.getMeetingdate())));
                            notif.setDate(Year.getDatePlusinDate(Converter.toCalendar(fullCharter.getMeetingdate()), -3));

                            notifDAO = new NotificationDAO();
                            addDB = notifDAO.updateImplementation(notif);

                            if (addDB) {
                                notif = new NotificationEntity();
                                notif.setOrg_id(fullCharter.getOrg_id());
                                notif.setNotificationtext("ORG_Implementation");
                                notif.setViewed(1);
                                notif.setProject_id(fullCharter.getProject_id());
                                notif.setComments(Converter.toString(Converter.toCalendar(fullCharter.getMeetingdate())));
                                notif.setDate(Year.getDatePlusinDate(Converter.toCalendar(fullCharter.getMeetingdate()), -3));

                                notifDAO = new NotificationDAO();
                                addDB = notifDAO.updateImplementation(notif);
                            }
                        } else {
                            NotificationEntity notif = new NotificationEntity();
                            notif.setOrg_id(fullCharter.getOrg_id());
                            notif.setNotificationtext("COSCA_Implementation");
                            notif.setViewed(2);
                            notif.setProject_id(fullCharter.getProject_id());
                            notif.setComments(Converter.toString(Converter.toCalendar(fullCharter.getMeetingdate())));
                            notif.setDate(Year.getDatePlusinDate(Converter.toCalendar(fullCharter.getMeetingdate()), -3));

                            notifDAO = new NotificationDAO();
                            addDB = notifDAO.insertNotif(notif);

                            if (addDB) {
                                notif = new NotificationEntity();
                                notif.setOrg_id(fullCharter.getOrg_id());
                                notif.setNotificationtext("ORG_Implementation");
                                notif.setViewed(1);
                                notif.setProject_id(fullCharter.getProject_id());
                                notif.setComments(Converter.toString(Converter.toCalendar(fullCharter.getMeetingdate())));
                                notif.setDate(Year.getDatePlusinDate(Converter.toCalendar(fullCharter.getMeetingdate()), -3));

                                notifDAO = new NotificationDAO();
                                addDB = notifDAO.insertNotif(notif);
                            }
                        }
                    }
                    if (session.getAttribute("isChangeCharter") == null) {
                        ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                        ProjectTaskEntity task = new ProjectTaskEntity();

                        int project_id = Integer.parseInt((String) session.getAttribute("project_id"));
                        task = task.setPreActs(task, project_id);

                        addDB = taskDAO.insertTask(task);
                    }
                }

                if (addDB) {
                    session.removeAttribute("fullCharter");
                    session.removeAttribute("project_id");
                    session.removeAttribute("isChangeCharter");
                    response.sendRedirect("CurrentProjects");
                } else {
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
