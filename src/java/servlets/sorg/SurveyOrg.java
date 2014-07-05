/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.sorg;

import Utilities.Year;
import dbdao.CommunityMembersDAO;
import dbdao.OrgAnswerDAO;
import dbdao.PersonAnswerDAO;
import dbdao.ProjectCharterDAO;
import dbdao.ProjectCharterDateDAO;
import dbdao.SurveyQuestionAnswerDAO;
import dbdao.UnavailableProjectDAO;
import dbdao.UserEntityDAO;
import dbentities.CommunityMembersEntity;
import dbentities.OrgAnswerEntity;
import dbentities.UnavailableProjectEntity;
import dbentities.UserEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
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
public class SurveyOrg extends HttpServlet {

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
                Integer project_id = Integer.parseInt((String) session.getAttribute("project_id"));

                UnavailableProjectDAO unavailableProjDAO = new UnavailableProjectDAO();
                UnavailableProjectEntity closedProj = unavailableProjDAO.getUnavailableProject(project_id);

                request.setAttribute("closedProj", closedProj);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysOrg/SurveyOrg.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                String username = session.getAttribute("USERNAME").toString();
                UserEntityDAO userDAO = new UserEntityDAO();
                UserEntity thisUser = userDAO.getUserDetails(username);
                Integer org_id = thisUser.getId();
                Integer project_id = Integer.parseInt((String) session.getAttribute("project_id"));

                //Org Survey
                boolean orgDB = true;
                ArrayList<String> answers = new ArrayList();
                answers.add(request.getParameter("Q-51"));
                answers.add(request.getParameter("Q-52"));
                answers.add(request.getParameter("Q-53"));
                answers.add(request.getParameter("Q-54"));
                answers.add(request.getParameter("Q-55"));
                answers.add(request.getParameter("Q-56"));
                answers.add(request.getParameter("Q-57"));
                String comments = request.getParameter("comments");

                SurveyQuestionAnswerDAO surveyQADAO;

                int question_id = 51;
                for (int x = 0; x < answers.size(); x++) {
                    OrgAnswerDAO orgDAO = new OrgAnswerDAO();
                    OrgAnswerEntity answer = new OrgAnswerEntity();
                    answer.setSurvey_id(3);
                    answer.setQuestion_id(question_id);
                    answer.setOfferedanswer_id(Integer.parseInt(answers.get(x)));
                    answer.setOrg_id(org_id);
                    answer.setProject_id(project_id);
                    answer.setDate_answered(Calendar.getInstance());
                    answer.setOtheranswer("");
                    orgDAO.insertAnswer(answer);
                    question_id++;

                    if (!orgDB) {
                        break;
                    }
                }

                if (orgDB) {
                    //Beneficiary Survey
                    Part filePart = request.getPart("surveyFile");
                    InputStream filecontent = filePart.getInputStream();

                    int chars;
                    int counter = 0;
                    String sqlLine = "";
                    while ((chars = filecontent.read()) != -1) {
                        if (chars != 59) {
                            sqlLine = sqlLine + (char) chars;
                        } else {
                            if (counter == 0) {
                                CommunityMembersDAO membersDAO = new CommunityMembersDAO();
                                orgDB = membersDAO.insertMember(sqlLine);
                                sqlLine = "";
                            } else {
                                CommunityMembersDAO membersDAO = new CommunityMembersDAO();
                                List<CommunityMembersEntity> membersList = membersDAO.getAllMembers();
                                CommunityMembersEntity members = membersList.get(membersList.size() - 1);

                                PersonAnswerDAO personDAO = new PersonAnswerDAO();
                                orgDB = personDAO.insertAnswer(members.getPerson_id(), sqlLine, project_id);
                                sqlLine = "";
                                if (counter == 8) {
                                    counter = -1;
                                }
                            }
                            counter++;
                        }
                        if (!orgDB) {
                            break;
                        }
                    }
                }

                if (orgDB) {
                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                    charterDAO.updateProjectStatus(project_id, ProjectCharterDAO.ACCOMPLISHED);
                    ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                    project_date.setDateClosed(project_id);
                }

                if (orgDB) {
                    response.sendRedirect("SurveyClosed");
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
