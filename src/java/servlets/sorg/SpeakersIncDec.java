/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.sorg;

import dbdao.TaskDetailsDAO;
import dbentities.ResourceDirectoryEntity;
import dbentities.TaskDetailsEntity;
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
public class SpeakersIncDec extends HttpServlet {

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
                int task_id = (Integer) session.getAttribute("task_id");
                String title = (String) session.getAttribute("title");
                String action = (String) session.getAttribute("action");

                TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                List<TaskDetailsEntity> speakerList = detailsDAO.getTask(task_id);

                request.setAttribute("speakerList", speakerList);
                request.setAttribute("title", title);

                if (action.equals("increase")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/SpeakersIncrease.jsp");
                    dispatcher.forward(request, response);
                } else if (action.equals("decrease")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/SpeakersDecrease.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                int task_id = (Integer) session.getAttribute("task_id");
                String title = (String) session.getAttribute("title");
                String[] action = request.getParameter("action").split("-");

                if (request.getParameter("action").equals("add")) {
                    ResourceDirectoryEntity resource = new ResourceDirectoryEntity();
                    resource.setFirstname(request.getParameter("fname"));
                    resource.setLastname(request.getParameter("lname"));
                    resource.setMi(request.getParameter("mi"));
                    resource.setOrganizationname(request.getParameter("orgname"));
                    resource.setAddress(request.getParameter("address"));
                    resource.setIspublic(0);
                    resource.setEmail(request.getParameter("email"));
                    resource.setMobile(request.getParameter("contact"));

                    TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                    boolean addDB = detailsDAO.addProfessional(task_id, title, resource);

                    if (addDB) {
                        detailsDAO = new TaskDetailsDAO();
                        List<TaskDetailsEntity> speakerList = detailsDAO.getTask(task_id);

                        request.setAttribute("speakerList", speakerList);
                        request.setAttribute("title", title);

                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/SpeakersIncrease.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("ErrorInDB.jsp");
                    }

                } else if (action[0].equals("delete")) {
                    TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                    boolean addDB = detailsDAO.deleteProfessional(task_id, Integer.parseInt(action[1]));

                    if (addDB) {
                        detailsDAO = new TaskDetailsDAO();
                        List<TaskDetailsEntity> speakerList = detailsDAO.getTask(task_id);

                        request.setAttribute("speakerList", speakerList);
                        request.setAttribute("title", title);

                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/SpeakersDecrease.jsp");
                        dispatcher.forward(request, response);
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
