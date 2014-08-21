/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.cosca;

import Utilities.Year;
import dbdao.ChildAgeDAO;
import dbdao.CommunityListDAO;
import dbdao.FilterDAO;
import dbentities.CommunityListEntity;
import dbentities.FilterEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class MapFilters extends HttpServlet {

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
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/MapFilters.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                String filterValue = request.getParameter("filter");
                int year = Integer.parseInt(request.getParameter("year"));
                if(filterValue.equals("0-0")){
                    CommunityListDAO clDAO = new CommunityListDAO();
                    List<CommunityListEntity> comlist = clDAO.getAllRealCommunity();

                    request.setAttribute("comlist", comlist);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/MapCommunity.jsp");
                    dispatcher.forward(request, response);
                }else{
                    int question_id = Integer.parseInt(filterValue.split("-")[0]);
                    int offeredanswer_id = Integer.parseInt(filterValue.split("-")[1]);
                    
                    FilterDAO filterDAO = new FilterDAO();
                    List<FilterEntity> filterList = filterDAO.getFilterData(question_id, offeredanswer_id, year);
                                        
                    CommunityListDAO clDAO;
                    CommunityListEntity clEntity;
                    List<CommunityListEntity> comlist = new ArrayList();
                    for(int x = 0; x < filterList.size(); x++){
                        clDAO = new CommunityListDAO();
                        clEntity = clDAO.getCommunity(filterList.get(x).getCommunity_id());
                        comlist.add(clEntity);
                    }
                    
                    request.setAttribute("comlist", comlist);                    
                    request.setAttribute("filterList", filterList);
                    request.setAttribute("offeredanswer_id", offeredanswer_id);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/MapCommunity.jsp");
                    dispatcher.forward(request, response);
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
