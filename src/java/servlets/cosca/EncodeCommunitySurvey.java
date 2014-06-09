/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cosca;

import Utilities.Year;
import dbdao.CommunityAnswerDAO;
import dbdao.CommunityFamilyDAO;
import dbdao.CommunityMembersDAO;
import dbdao.PersonAnswerDAO;
import dbentities.AnswerEntity;
import dbentities.CommunityFamilyEntity;
import dbentities.CommunityMembersEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
                HttpSession session = request.getSession();
                String community_id = (String) session.getAttribute("community_id");
                String community_name = (String) session.getAttribute("community_name");
                String action = request.getParameter("action");
                switch (action) {
                    case "SurveySubmitted":
                        //Get Values
                        String year = request.getParameter("yearOfSurvey");
                        Calendar surveyYear;
                        if (Integer.parseInt(year) == Year.getCurrentYear()) {
                            surveyYear = Year.getCurrentDateinCalendar();
                        } else {
                            surveyYear = Year.getPreviousDateinCalendar();
                        }
                        String familyName = request.getParameter("familyName");
                        String address = request.getParameter("address");
                        String yearsInCommunity = request.getParameter("yearsInCommunity");
                        String relegionOfFather = request.getParameter("relegionOfFather");
                        String relegionOfMother = request.getParameter("relegionOfMother");
                        String typeOfFamily = request.getParameter("typeOfFamily");
                        String[] numOfFamilyMem = request.getParameterValues("numOfFamilyMem");
                        String[] name = request.getParameterValues("name");
                        String[] age = request.getParameterValues("age");
                        String[] gender = request.getParameterValues("gender");
                        String[] civilStatus = request.getParameterValues("civilStatus");
                        String[] positionInFamily = request.getParameterValues("positionInFamily");
                        String[] eduactionalAttainment = request.getParameterValues("eduactionalAttainment");
                        String[] work = request.getParameterValues("work");
                        String[] healthHistory;
                        String[] illnesses;
                        String[] familyImmunization;
                        String battered = request.getParameter("battered");
                        String fights = request.getParameter("fights");
                        String childabuse = request.getParameter("childabuse");
                        String puttingoff = request.getParameter("puttingoff");
                        String inappropriateword = request.getParameter("inappropriateword");
                        String income = request.getParameter("income");
                        String sourceincome = request.getParameter("sourceincome");
                        String[] needs = request.getParameterValues("needs");
                        String hasLot = request.getParameter("hasLot");
                        String hasHouse = request.getParameter("hasHouse");
                        String typeOfHouse = request.getParameter("typeOfHouse");
                        String typeOfGarbageDisposal = request.getParameter("typeOfGarbageDisposal");
                        String typeOfToilet = request.getParameter("typeOfToilet");
                        String typeOfDrainage = request.getParameter("typeOfDrainage");
                        String sourceOfWater = request.getParameter("sourceOfWater");
                        String sourceOfDrnkingWater = request.getParameter("sourceOfDrnkingWater");
                        String drinkingWaterStorage = request.getParameter("drinkingWaterStorage");
                        String foodStorage = request.getParameter("foodStorage");
//                        String pestsPresence = request.getParameter("pestsPresence");
                        String breedingSite = request.getParameter("breedingSite");
                        String[] typeOfPests = request.getParameterValues("typeOfPests");
                        String[] typeOfPets = request.getParameterValues("typeOfPets");
                        String typeofhazards = request.getParameter("typeofhazards");
                        String mealsPerDay = request.getParameter("mealsPerDay");
                        String[] healthPerson = request.getParameterValues("healthPerson");
                        String[] nonHealthPerson = request.getParameterValues("nonHealthPerson");
                        String adequateRest = request.getParameter("adequateRest");
                        String exercise = request.getParameter("exercise");
                        String relaxation = request.getParameter("relaxation");
                        String stressManagement = request.getParameter("stressManagement");

                        //Create Family
                        boolean upDB;
                        CommunityFamilyDAO familyDAO = new CommunityFamilyDAO();
                        int family_id = familyDAO.getLastId();
                        CommunityFamilyEntity family = new CommunityFamilyEntity();
                        family.setId(family_id + 1);
                        family.setSurname(familyName);
                        family.setAddress(address);
                        family.setYears_residency(family_id);
                        family.setCommunity(Integer.parseInt(yearsInCommunity));
                        family.setOrigin_father(relegionOfFather);
                        family.setReligion_mother(relegionOfMother);
                        family.setType_of_family(typeOfFamily);
                        family.setCommunity(Integer.parseInt(community_id));
                        family.setDate_created(surveyYear);
                        familyDAO = new CommunityFamilyDAO();
                        upDB = familyDAO.insertFamily(family);

                        if (upDB) {
                            familyDAO = new CommunityFamilyDAO();
                            int newfamily_id = familyDAO.getLastId();

                            //Family Members
                            CommunityMembersDAO membersDAO;
                            CommunityMembersEntity members;
                            for (int x = 0; x < numOfFamilyMem.length; x++) {
                                members = new CommunityMembersEntity();
                                members.setFamily_id(newfamily_id);
                                members.setGivenname(name[x]);
                                members.setAge(Integer.parseInt(age[x]));
                                members.setGender(gender[x]);
                                members.setPosition(positionInFamily[x]);
                                membersDAO = new CommunityMembersDAO();
                                upDB = membersDAO.insertMember(members);

                                if (upDB) {
                                    membersDAO = new CommunityMembersDAO();
                                    int newMemeber_id = membersDAO.getNewMemberId();

                                    //Person Answers
                                    AnswerEntity answer;
                                    PersonAnswerDAO personAns;

                                    //Civil Status
                                    answer = new AnswerEntity();
                                    answer.setSurvey_id(2);
                                    answer.setQuestion_id(32);
                                    answer.setOfferedanswer_id(Integer.parseInt(civilStatus[x]));
                                    answer.setId(newMemeber_id);
                                    answer.setDate_answered(surveyYear);
                                    answer.setOtheranswer(" ");
                                    personAns = new PersonAnswerDAO();
                                    upDB = personAns.insertAnswer(answer);

                                    //Educational Attainment
                                    answer.setQuestion_id(33);
                                    answer.setOfferedanswer_id(Integer.parseInt(eduactionalAttainment[x]));
                                    personAns = new PersonAnswerDAO();
                                    upDB = personAns.insertAnswer(answer);

                                    //Medical History
                                    healthHistory = request.getParameterValues("healthHistory-" + (x+1));
                                    if(healthHistory != null){
                                    for (int y = 0; y < healthHistory.length ; y++) {
                                        answer.setQuestion_id(34);
                                        answer.setOfferedanswer_id(Integer.parseInt(healthHistory[y]));
                                        personAns = new PersonAnswerDAO();
                                        upDB = personAns.insertAnswer(answer);
                                    }
                                    }

                                    //Recent Illnesses
                                    illnesses = request.getParameterValues("illnesses-" + (x+1));
                                    if(illnesses != null){
                                    for (int y = 0; y < illnesses.length ; y++) {
                                        answer.setQuestion_id(35);
                                        answer.setOfferedanswer_id(Integer.parseInt(illnesses[y]));
                                        personAns = new PersonAnswerDAO();
                                        upDB = personAns.insertAnswer(answer);
                                    }
                                    }

                                    //Immunization
                                    familyImmunization = request.getParameterValues("familyImmunization-immunization-" + (x+1));
                                    if(familyImmunization != null){
                                    for (int y = 0; y < familyImmunization.length ; y++) {
                                        answer.setQuestion_id(27);
                                        answer.setOfferedanswer_id(Integer.parseInt(familyImmunization[y]));
                                        personAns = new PersonAnswerDAO();
                                        upDB = personAns.insertAnswer(answer);
                                    }
                                    }

                                    //Age
                                    answer.setQuestion_id(39);
                                    answer.setOfferedanswer_id(ageAnswer(Integer.parseInt(age[x])));
                                    personAns = new PersonAnswerDAO();
                                    upDB = personAns.insertAnswer(answer);

                                    //Occupation
                                    answer.setQuestion_id(40);
                                    answer.setOfferedanswer_id(82);
                                    answer.setOtheranswer(work[x]);
                                    personAns = new PersonAnswerDAO();
                                    upDB = personAns.insertAnswer(answer);
                                }
                            }

                            if (upDB) {
                                //CommunityAnswers
                                AnswerEntity answer;
                                CommunityAnswerDAO communityAns;

                                //Battered
                                answer = new AnswerEntity();
                                answer.setSurvey_id(1);
                                answer.setQuestion_id(1);
                                answer.setOfferedanswer_id(Integer.parseInt(battered));
                                answer.setId(newfamily_id);
                                answer.setDate_answered(surveyYear);
                                answer.setOtheranswer(" ");
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //Fights
                                answer.setQuestion_id(2);
                                answer.setOfferedanswer_id(Integer.parseInt(fights));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //Abuse
                                answer.setQuestion_id(3);
                                answer.setOfferedanswer_id(Integer.parseInt(childabuse));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //communication
                                answer.setQuestion_id(4);
                                answer.setOfferedanswer_id(Integer.parseInt(puttingoff));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //inappropriateword
                                answer.setQuestion_id(5);
                                answer.setOfferedanswer_id(Integer.parseInt(inappropriateword));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //income
                                answer.setQuestion_id(6);
                                answer.setOfferedanswer_id(Integer.parseInt(income));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //source
                                answer.setQuestion_id(7);
                                answer.setOfferedanswer_id(Integer.parseInt(sourceincome));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //needs
                                if (needs != null) {
                                for (int x = 0; x < needs.length; x++) {
                                    answer.setQuestion_id(8);
                                    answer.setOfferedanswer_id(Integer.parseInt(needs[x]));
                                    communityAns = new CommunityAnswerDAO();
                                    upDB = communityAns.insertAnswer(answer);
                                }
                                }

                                //lot
                                answer.setQuestion_id(9);
                                answer.setOfferedanswer_id(Integer.parseInt(hasLot));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //house
                                answer.setQuestion_id(10);
                                answer.setOfferedanswer_id(Integer.parseInt(hasHouse));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //typeOfHouse
                                answer.setQuestion_id(11);
                                answer.setOfferedanswer_id(Integer.parseInt(typeOfHouse));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //typeOfGarbageDisposal
                                answer.setQuestion_id(12);
                                answer.setOfferedanswer_id(Integer.parseInt(typeOfGarbageDisposal));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //typeOfToilet
                                answer.setQuestion_id(13);
                                answer.setOfferedanswer_id(Integer.parseInt(typeOfToilet));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //typeOfDrainage
                                answer.setQuestion_id(14);
                                answer.setOfferedanswer_id(Integer.parseInt(typeOfDrainage));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //sourceOfWater
                                answer.setQuestion_id(15);
                                answer.setOfferedanswer_id(Integer.parseInt(sourceOfWater));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //sourceOfDrnkingWater
                                answer.setQuestion_id(16);
                                answer.setOfferedanswer_id(Integer.parseInt(sourceOfDrnkingWater));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //drinkingWaterStorage
                                answer.setQuestion_id(17);
                                answer.setOfferedanswer_id(Integer.parseInt(drinkingWaterStorage));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //foodStorage
                                answer.setQuestion_id(18);
                                answer.setOfferedanswer_id(Integer.parseInt(foodStorage));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //breedingSite
                                answer.setQuestion_id(19);
                                answer.setOfferedanswer_id(Integer.parseInt(breedingSite));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //typeOfPests
                                if(typeOfPets != null){
                                for (int x = 0; x < typeOfPests.length; x++) {
                                    answer.setQuestion_id(20);
                                    answer.setOfferedanswer_id(Integer.parseInt(typeOfPests[x]));
                                    communityAns = new CommunityAnswerDAO();
                                    upDB = communityAns.insertAnswer(answer);
                                }
                                }

                                //typeOfPets
                                if(typeOfPets != null){
                                
                                for (int x = 0; x < typeOfPets.length; x++) {
                                    answer.setQuestion_id(21);
                                    answer.setOfferedanswer_id(Integer.parseInt(typeOfPets[x]));
                                    communityAns = new CommunityAnswerDAO();
                                    upDB = communityAns.insertAnswer(answer);
                                }
                                }

                                //typeofhazard
                                answer.setQuestion_id(22);
                                answer.setOfferedanswer_id(Integer.parseInt(typeofhazards));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //mealsPerDay
                                answer.setQuestion_id(23);
                                answer.setOfferedanswer_id(82);
                                answer.setOtheranswer(mealsPerDay);
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);
                                answer.setOtheranswer(" ");

                                //healthPerson
                                if(healthPerson != null){
                                for (int x = 0; x < healthPerson.length; x++) {
                                    answer.setQuestion_id(25);
                                    answer.setOfferedanswer_id(Integer.parseInt(healthPerson[x]));
                                    communityAns = new CommunityAnswerDAO();
                                    upDB = communityAns.insertAnswer(answer);
                                }
                                }

                                //nonHealthPerson
                                if (nonHealthPerson != null) {
                                for (int x = 0; x < nonHealthPerson.length; x++) {
                                    answer.setQuestion_id(26);
                                    answer.setOfferedanswer_id(Integer.parseInt(nonHealthPerson[x]));
                                    communityAns = new CommunityAnswerDAO();
                                    upDB = communityAns.insertAnswer(answer);
                                }
                                }

                                //adequateRest
                                answer.setQuestion_id(28);
                                answer.setOfferedanswer_id(Integer.parseInt(adequateRest));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //adequateRest
                                answer.setQuestion_id(29);
                                answer.setOfferedanswer_id(Integer.parseInt(exercise));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //adequateRest
                                answer.setQuestion_id(30);
                                answer.setOfferedanswer_id(Integer.parseInt(relaxation));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //adequateRest
                                answer.setQuestion_id(31);
                                answer.setOfferedanswer_id(Integer.parseInt(stressManagement));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //relegionOfFather
                                if (!relegionOfFather.isEmpty()) {
                                    answer.setQuestion_id(36);
                                    answer.setOfferedanswer_id(Integer.parseInt(relegionOfFather));
                                    communityAns = new CommunityAnswerDAO();
                                    upDB = communityAns.insertAnswer(answer);
                                }

                                //relegionOfMother
                                if (!relegionOfMother.isEmpty()) {
                                    answer.setQuestion_id(37);
                                    answer.setOfferedanswer_id(Integer.parseInt(relegionOfMother));
                                    communityAns = new CommunityAnswerDAO();
                                    upDB = communityAns.insertAnswer(answer);
                                }

                                //familySize
                                answer.setQuestion_id(38);
                                answer.setOfferedanswer_id(famSizeAnswer(numOfFamilyMem.length));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);
                                
                                //familySize
                                answer.setQuestion_id(70);
                                answer.setOfferedanswer_id(structureAnswer(typeOfFamily));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);
                            }
                        }

                        if (upDB) {
                            session.setAttribute("Year", surveyYear);
                            response.sendRedirect("SurveySubmitted");
                        } else {
                            response.sendRedirect("ErrorInDB.jsp");
                        }
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
