/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.sorg;

import Utilities.Year;
import dbdao.AvailableProjectDAO;
import dbdao.NotificationDAO;
import dbdao.ProjectCharterDAO;
import dbdao.StudentDAO;
import dbdao.UserEntityDAO;
import dbentities.AvailableProjectEntity;
import dbentities.NotificationEntity;
import dbentities.StudentEntity;
import dbentities.UserEntity;
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
public class ContactDetails extends HttpServlet {

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

                AvailableProjectDAO availableDAO = new AvailableProjectDAO();
                AvailableProjectEntity availableProject = availableDAO.getAvailableProject(project_id);

                request.setAttribute("availableProject", availableProject);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/ContactDetails.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                String username = session.getAttribute("USERNAME").toString();
                UserEntityDAO userDAO = new UserEntityDAO();
                UserEntity thisUser = userDAO.getUserDetails(username);
                int project_id = Integer.parseInt((String) session.getAttribute("project_id"));
                
                String[] ids = request.getParameterValues("idno");
                String[] fnames = request.getParameterValues("first_name");
                String[] lnames = request.getParameterValues("last_name");
                String[] positions = request.getParameterValues("position");
                String[] emails = request.getParameterValues("email");
                String[] mobile = request.getParameterValues("mobileno");
                

                StudentEntity student = new StudentEntity();
                student.setIdno(Integer.parseInt(ids[0]));
                student.setOrg_id(thisUser.getId());
                student.setFirstname(fnames[0]);
                student.setLastname(lnames[0]);
                student.setOrg_position(positions[0]);
                student.setEmail(emails[0]);
                student.setMobileno(mobile[0]);

                ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                StudentDAO studentDAO = new StudentDAO();
                boolean result = charterDAO.reserveAvailableProject(project_id, student, studentDAO.isExisting(student.getIdno(), student.getOrg_id()));
                
                if(result){
                    String[] partnerOrgs = request.getParameterValues("partnerOrgs");
                    for (int x = 0; x < partnerOrgs.length; x++){
                        int detailIndex  = x + 1;
                        student = new StudentEntity();
                        student.setIdno(Integer.parseInt(ids[detailIndex]));
                        student.setOrg_id(Integer.parseInt(partnerOrgs[x]));
                        student.setFirstname(fnames[detailIndex]);
                        student.setLastname(lnames[detailIndex]);
                        student.setOrg_position(positions[detailIndex]);
                        student.setEmail(emails[detailIndex]);
                        student.setMobileno(mobile[detailIndex]);
                        
                        charterDAO = new ProjectCharterDAO(); 
                        studentDAO = new StudentDAO();
                        result  =  charterDAO.orgPartnerships(project_id, student, studentDAO.isExisting(student.getIdno(), student.getOrg_id()));
                    }
                }
                
                if(result){
                    NotificationEntity notif = new NotificationEntity();
                    notif.setOrg_id(thisUser.getId());
                    notif.setNotificationtext("COSCA_ProjectReserved");
                    notif.setViewed(2);
                    notif.setProject_id(project_id);
                    notif.setComments(Year.getCurrentDatePlus(2));
                    notif.setDate(Year.getCurrentDateinCalendar().getTime());
                    
                    NotificationDAO notifDAO = new NotificationDAO();
                    result = notifDAO.insertNotif(notif);
                }
                
                
                
                if (result) {
                    response.sendRedirect("ProjectReserved");
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
