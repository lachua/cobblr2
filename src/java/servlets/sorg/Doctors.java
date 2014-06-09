/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.sorg;

import dbdao.ProjectTaskDAO;
import dbdao.TaskDetailsDAO;
import dbentities.ProjectTaskEntity;
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
public class Doctors extends HttpServlet {

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

                TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                List<TaskDetailsEntity> medicalProfessionalList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.MEDICAL_PROFESSIONAL);

                request.setAttribute("medicalProfessionalList", medicalProfessionalList);

                if (request.getParameter("action").equals("add")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/DoctorsAdd.jsp");
                    dispatcher.forward(request, response);
                } else if (request.getParameter("action").equals("edit")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/DoctorsEdit.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                int project_id = Integer.parseInt((String) session.getAttribute("project_id"));
                String[] action = request.getParameter("action").split("-");

                if (request.getParameter("action").equals("add")) {
                    ProjectTaskEntity task = new ProjectTaskEntity();
                    task.setProj_id(project_id);
                    task.setTitle(request.getParameter("title"));
                    task.setTargetcount(Integer.parseInt(request.getParameter("targetcount")));
                    task.setUnit("doctors");
                    task.setResource_type(ProjectTaskDAO.MEDICAL_PROFESSIONAL);

                    ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                    Boolean addDB = taskDAO.insertTask(task);

                    if (addDB) {
                        TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                        List<TaskDetailsEntity> medicalProfessionalList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.MEDICAL_PROFESSIONAL);

                        request.setAttribute("medicalProfessionalList", medicalProfessionalList);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/DoctorsAdd.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("ErrorInDB.jsp");
                    }
                } else if (action[0].equals("update")) {
                    int index = Integer.parseInt(action[1]);
                    int task_id = Integer.parseInt(request.getParameter("task_id-" + index));

                    ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                    ProjectTaskEntity task = taskDAO.getTask(task_id);

                    task.setTargetcount(Integer.parseInt(request.getParameter("targetcount-" + index)));

                    taskDAO = new ProjectTaskDAO();
                    boolean addDB = taskDAO.updateTask(task);

                    if (addDB) {
                        TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                        List<TaskDetailsEntity> medicalProfessionalList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.MEDICAL_PROFESSIONAL);

                        request.setAttribute("medicalProfessionalList", medicalProfessionalList);
                        request.setAttribute("isUpdated", request.getParameter("title-" + index));
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/DoctorsEdit.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("ErrorInDB");
                    }
                } else if (action[0].equals("delete")) {
                    int index = Integer.parseInt(action[1]);
                    int task_id = Integer.parseInt(request.getParameter("task_id-" + index));
                    int count = Integer.parseInt(request.getParameter("currentcount-" + index));

                    boolean addDB;
                    if (count == 0) {
                        ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                        addDB = taskDAO.deleteTask(task_id);
                    } else {

                        ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                        addDB = taskDAO.deletePledgeNTask(task_id);
                    }

                    if (addDB) {
                        TaskDetailsDAO detailsDAO = new TaskDetailsDAO();
                        List<TaskDetailsEntity> medicalProfessionalList = detailsDAO.getAllTask(project_id, ProjectTaskDAO.MEDICAL_PROFESSIONAL);

                        request.setAttribute("medicalProfessionalList", medicalProfessionalList);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/DoctorsEdit.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("ErrorInDB");
                    }
                } else if (action[0].equals("increase")) {
                    int index = Integer.parseInt(action[1]);
                    int task_id = Integer.parseInt(request.getParameter("task_id-" + index));

                    session.setAttribute("task_id", task_id);
                    session.setAttribute("title", request.getParameter("title-" + index));
                    session.setAttribute("action", "increase");
                    response.sendRedirect("DoctorsIncDec");
                } else if (action[0].equals("decrease")) {
                    int index = Integer.parseInt(action[1]);
                    int task_id = Integer.parseInt(request.getParameter("task_id-" + index));

                    session.setAttribute("task_id", task_id);
                    session.setAttribute("title", request.getParameter("title-" + index));
                    session.setAttribute("action", "decrease");
                    response.sendRedirect("DoctorsIncDec");
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
