/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cosca;

import Utilities.Year;
import classes.EncodeCommunitySurveyData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class EncodeCommunitySurvey extends HttpServlet {

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
                String community_id = (String) session.getAttribute("community_id");
                String community_name = (String) session.getAttribute("community_name");

                request.setAttribute("community_id", community_id);
                request.setAttribute("community_name", community_name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/EncodeCommunitySurvey.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                EncodeCommunitySurveyData surveyData = new EncodeCommunitySurveyData();
                
                HttpSession session = request.getSession();
                surveyData.setCommunity_id((String) session.getAttribute("community_id"));
                surveyData.setCommunity_name((String) session.getAttribute("community_name"));
                
                String action = request.getParameter("action");
                switch (action) {
                    case "SurveySubmitted":
                        //Get Values
                        String year = request.getParameter("yearOfSurvey");
                        surveyData.setYear(request.getParameter("yearOfSurvey"));
                        if (Integer.parseInt(year) == Year.getCurrentYear()) {
                            surveyData.setSurveyYear(Year.getCurrentDateinCalendar());
                        } else {
                            surveyData.setSurveyYear(Year.getPreviousDateinCalendar());
                        }
                        surveyData.setFamilyName(request.getParameter("familyName"));
                        surveyData.setAddress(request.getParameter("address"));
                        surveyData.setAddress(request.getParameter("address"));
                        surveyData.setYearsInCommunity(request.getParameter("yearsInCommunity"));
                        surveyData.setRelegionOfFather(request.getParameter("relegionOfFather"));
                        surveyData.setRelegionOfMother(request.getParameter("relegionOfMother"));
                        surveyData.setTypeOfFamily(request.getParameter("typeOfFamily"));
                        surveyData.setNumOfFamilyMem(request.getParameterValues("numOfFamilyMem"));
                        surveyData.setName(request.getParameterValues("name"));
                        surveyData.setAge(request.getParameterValues("age"));
                        surveyData.setGender(request.getParameterValues("gender"));
                        surveyData.setCivilStatus(request.getParameterValues("civilStatus"));
                        surveyData.setPositionInFamily(request.getParameterValues("positionInFamily"));
                        surveyData.setEducationalAttainment(request.getParameterValues("eduactionalAttainment"));
                        surveyData.setWork(request.getParameterValues("work"));
                        surveyData.setBattered(request.getParameter("battered"));
                        surveyData.setFights(request.getParameter("fights"));
                        surveyData.setChildabuse(request.getParameter("childabuse"));
                        surveyData.setPuttingoff(request.getParameter("puttingoff"));
                        surveyData.setInappropriateword(request.getParameter("inappropriateword"));
                        surveyData.setIncome(request.getParameter("income"));
                        surveyData.setSourceincome(request.getParameter("sourceincome"));
                        surveyData.setNeeds(request.getParameterValues("needs"));
                        surveyData.setHasLot(request.getParameter("hasLot"));
                        surveyData.setHasHouse(request.getParameter("hasHouse"));
                        surveyData.setTypeOfHouse(request.getParameter("typeOfHouse"));
                        surveyData.setTypeOfGarbageDisposal(request.getParameter("typeOfGarbageDisposal"));
                        surveyData.setTypeOfToilet(request.getParameter("typeOfToilet"));
                        surveyData.setTypeOfDrainage(request.getParameter("typeOfDrainage"));
                        surveyData.setSourceOfWater(request.getParameter("sourceOfWater"));
                        surveyData.setSourceOfDrinkingWater(request.getParameter("sourceOfDrinkingWater"));
                        surveyData.setDrinkingWaterStorage(request.getParameter("drinkingWaterStorage"));
                        surveyData.setFoodStorage(request.getParameter("foodStorage"));
                        surveyData.setBreedingSite(request.getParameter("breedingSite"));
                        surveyData.setTypeOfPests(request.getParameterValues("typeOfPests"));
                        surveyData.setTypeOfPets(request.getParameterValues("typeOfPets"));
                        surveyData.setTypeofhazards(request.getParameter("typeofhazards"));
                        surveyData.setMealsPerDay(request.getParameter("mealsPerDay"));                        
                        surveyData.setHealthPerson(request.getParameterValues("healthPerson"));
                        surveyData.setNonHealthPerson(request.getParameterValues("nonHealthPerson"));
                        surveyData.setAdequateRest(request.getParameter("adequateRest"));
                        surveyData.setExercise(request.getParameter("exercise"));
                        surveyData.setRelaxation(request.getParameter("relaxation"));
                        surveyData.setStressManagement(request.getParameter("stressManagement"));
                        
                        
                        String[] numOfFamilyMem = request.getParameterValues("numOfFamilyMem");
                        String[] healthHistory;
                        String[] illnesses;
                        String[] familyImmunization;
                        ArrayList<String[]> healthHistoryAl = new ArrayList();
                        ArrayList<String[]> illnessesAl = new ArrayList();
                        ArrayList<String[]> familyImmunizationAl = new ArrayList();
                        for (int x = 0; x < numOfFamilyMem.length; x++) {
                            healthHistory = request.getParameterValues("healthHistory-" + (x+1));
                            illnesses = request.getParameterValues("illnesses-" + (x+1));
                            familyImmunization = request.getParameterValues("familyImmunization-immunization-" + (x+1));
                            
                            healthHistoryAl.add(healthHistory);
                            illnessesAl.add(illnesses);
                            familyImmunizationAl.add(familyImmunization);
                        }
                        surveyData.setHealthHistory(healthHistoryAl);
                        surveyData.setIllnesses(illnessesAl);
                        surveyData.setFamilyImmunization(familyImmunizationAl);
                               
                        session.setAttribute("SurveyData", surveyData);
                        response.sendRedirect("ChildSurvey");
                        break;
                    case "CommunitySurvey":
                        response.sendRedirect("CommunitySurvey");
                        break;
                }
            }
        } finally {
            out.close();
        }
    }
    
    private int structureAnswer(String str){
        int ans = 82;
        if(str.equals("Nuclear")){
            ans = 13;
        }else if(str.equals("Single Parent")){
            ans = 14;
        }else if(str.equals("Extended")){
            ans = 15;
        }else if(str.equals("Childless")){
            ans = 16;
        }else if(str.equals("Step Family")){
            ans = 167;
        }else if(str.equals("Grand Family")){
            ans = 168;
        }
        return ans;
    }

    private int ageAnswer(int age) {
        int ans;
        if (age >= 0 && age <= 3) {
            ans = 151;
        } else if (age >= 4 && age <= 5) {
            ans = 152;
        } else if (age >= 6 && age <= 10) {
            ans = 153;
        } else if (age >= 11 && age <= 14) {
            ans = 154;
        } else if (age >= 15 && age <= 17) {
            ans = 155;
        } else if (age >= 18 && age <= 20) {
            ans = 156;
        } else if (age >= 21 && age <= 40) {
            ans = 157;
        } else if (age >= 41 && age <= 60) {
            ans = 158;
        } else {
            ans = 159;
        }

        return ans;
    }

    private int famSizeAnswer(int size) {
        int ans;
        if (size <= 2) {
            ans = 160;
        } else if (size == 3) {
            ans = 161;
        } else if (size == 4) {
            ans = 162;
        } else if (size == 5) {
            ans = 163;
        } else if (size == 6) {
            ans = 164;
        } else if (size == 7) {
            ans = 165;
        } else {
            ans = 166;
        }

        return ans;
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
