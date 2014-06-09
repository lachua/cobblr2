/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.sorg;

import PreactImageUpload.PreactEntity;
import PreactImageUpload.PreactUploadDAO;
import dbdao.ProjectTaskDAO;
import dbentities.ProjectTaskEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Renliw
 */
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ChangePreActs extends HttpServlet {

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
//        PrintWriter out = response.getWriter();
        try {
            if (request.getMethod().equals("GET")) {
                HttpSession session = request.getSession();
                int project_id = Integer.parseInt((String) session.getAttribute("project_id"));
                ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                ProjectTaskEntity preActs = taskDAO.getAllTasksOfTypeForProject(project_id, ProjectTaskDAO.PRE_ACTS).get(0);

                PreactUploadDAO puiDAO = new PreactUploadDAO();
                PreactEntity pe = puiDAO.getPreact(preActs.getId());

                response.setContentType("application/pdf");

                InputStream is = pe.getInputStream();

                int read = 0;
                byte[] bytes = new byte[1024];
                OutputStream os = response.getOutputStream();

                while ((read = is.read(bytes)) != -1) {
                    os.write(bytes, 0, read);
                }
                is.close();
                os.flush();
                os.close();
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                int project_id = Integer.parseInt((String) session.getAttribute("project_id"));
                String typeOfStructure = (String) session.getAttribute("typeOfStructure");

                ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                ProjectTaskEntity preActs = taskDAO.getAllTasksOfTypeForProject(project_id, ProjectTaskDAO.PRE_ACTS).get(0);
                boolean addDB = false;
                request.getContentType();
                if (preActs.getCompleted() == 0) {
                    //Beneficiary Survey
                    Part filePart = request.getPart("pdfFile");
                    InputStream filecontent = filePart.getInputStream();

                    PreactUploadDAO puiDAO = new PreactUploadDAO();
                    try {
                        addDB = puiDAO.uploadFile(preActs.getId(), preActs.getProj_id(), filecontent);
                    } catch (Exception ex) {
                        Logger.getLogger(ChangePreActs.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    taskDAO = new ProjectTaskDAO();
                    addDB = taskDAO.setCompleted(project_id, ProjectTaskDAO.PRE_ACTS, true);

                } else {

                    //Beneficiary Survey
                    Part filePart = request.getPart("pdfFile");
                    InputStream filecontent = filePart.getInputStream();

                    PreactUploadDAO puiDAO = new PreactUploadDAO();
                    try {
                        addDB = puiDAO.deleteFile(preActs.getId());
                        if (addDB) {
                            puiDAO = new PreactUploadDAO();
                            addDB = puiDAO.uploadFile(preActs.getId(), preActs.getProj_id(), filecontent);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ChangePreActs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (addDB) {
                    if (typeOfStructure.equals("health")) {
                        response.sendRedirect("WorkStructure_Health");
                    } else if (typeOfStructure.equals("seminar")) {
                        response.sendRedirect("WorkStructure_Seminar");
                    }
                } else {
                    response.sendRedirect("ErrorInDB.jsp");
                }
            }
        } finally {
//            out.close();
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
