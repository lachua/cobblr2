/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.cosca;

import dbdao.ResourceDirectoryDAO;
import dbentities.ResourceDirectoryEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renliw
 */
public class MedicalSuppliersCOSCA extends HttpServlet {

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
                ResourceDirectoryDAO resourceDAO = new ResourceDirectoryDAO();
                List<ResourceDirectoryEntity> resource = resourceDAO.getAllMaterialResourceDirectory();
                
                request.setAttribute("resource", resource);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/MedicalSuppliers.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                if (request.getParameter("add") != null) {
                    ResourceDirectoryEntity resource = new ResourceDirectoryEntity();
                    resource.setFirstname(request.getParameter("fname"));
                    resource.setLastname(request.getParameter("lname"));
                    resource.setMi(request.getParameter("mi"));
                    resource.setOrganizationname(request.getParameter("orgname"));
                    resource.setDescription(request.getParameter("desc"));
                    resource.setAddress(request.getParameter("address"));
                    resource.setIspublic(2);
                    resource.setEmail(request.getParameter("email"));
                    resource.setMobile(request.getParameter("contact"));

                    ResourceDirectoryDAO resourceDAO = new ResourceDirectoryDAO();
                    boolean addDB = resourceDAO.insertDirectory(resource);
                    if (addDB) {
                        response.sendRedirect("MedicalSuppliersCOSCA");
                    } else {
                        response.sendRedirect("ErrorInDB.jsp");
                    }
                } else if (request.getParameter("delete") != null) {
                    String resource = request.getParameter("delete");

                    ResourceDirectoryDAO resourceDAO = new ResourceDirectoryDAO();
                    boolean addDB = resourceDAO.deleteDirectory(Integer.parseInt(resource));
                    if (addDB) {
                        response.sendRedirect("MedicalSuppliersCOSCA");
                    } else {
                        response.sendRedirect("ErrorInDB.jsp");
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
