/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cosca;

import Utilities.Year;
import classes.EncodeCommunitySurveyData;
import dbdao.CommunityAnswerDAO;
import dbdao.CommunityFamilyDAO;
import dbdao.CommunityMembersDAO;
import dbdao.PersonAnswerDAO;
import dbentities.AnswerEntity;
import dbentities.CommunityFamilyEntity;
import dbentities.CommunityMembersEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class ChildSurvey extends HttpServlet {

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
                EncodeCommunitySurveyData surveyData = (EncodeCommunitySurveyData) session.getAttribute("SurveyData");
                ArrayList<String> childname = new ArrayList();
                ArrayList<Integer> childpersonId = new ArrayList();

                CommunityMembersDAO membersDAO = new CommunityMembersDAO();
                int lastMemeber_id = membersDAO.getNewMemberId();

                for (int x = 0; x < surveyData.getNumOfFamilyMem().length; x++) {
                    if (Double.parseDouble(surveyData.getAge()[x]) >= 0 && Double.parseDouble(surveyData.getAge()[x]) <= 5) {
                        childname.add(surveyData.getName()[x]);
                        childpersonId.add(lastMemeber_id + x + 1);
                    }
                }

                request.setAttribute("childname", childname);
                request.setAttribute("childpersonId", childpersonId);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sysCOSCA/ChildSurvey.jsp");
                dispatcher.forward(request, response);
            } else if (request.getMethod().equals("POST")) {
                HttpSession session = request.getSession();
                EncodeCommunitySurveyData surveyData = (EncodeCommunitySurveyData) session.getAttribute("SurveyData");

                ArrayList<String> childname = new ArrayList();
                ArrayList<Integer> childpersonId = new ArrayList();
                ArrayList<Integer> childSurveyIndex = new ArrayList();
                ArrayList<Double> childage = new ArrayList();

                CommunityMembersDAO membersDAO = new CommunityMembersDAO();
                int lastMemeber_id = membersDAO.getNewMemberId();

                for (int x = 0; x < surveyData.getNumOfFamilyMem().length; x++) {
                    if (Double.parseDouble(surveyData.getAge()[x]) >= 0 && Double.parseDouble(surveyData.getAge()[x]) <= 5) {
                        childname.add(surveyData.getName()[x]);
                        childpersonId.add(lastMemeber_id + x + 1);
                        childSurveyIndex.add(x);
                        childage.add(Double.parseDouble(surveyData.getAge()[x]));
                    }
                }

                //<editor-fold>
                String community_id = surveyData.getCommunity_id();
                String community_name = surveyData.getCommunity_name();
                String action = request.getParameter("action");
                switch (action) {
                    case "ChildSurveySubmitted":
                        //Get Values
                        String year = surveyData.getYear();
                        Calendar surveyYear = surveyData.getSurveyYear();
                        String familyName = surveyData.getFamilyName();
                        String address = surveyData.getAddress();
                        String yearsInCommunity = surveyData.getYearsInCommunity();
                        String relegionOfFather = surveyData.getRelegionOfFather();
                        String relegionOfMother = surveyData.getRelegionOfMother();
                        String typeOfFamily = surveyData.getTypeOfFamily();
                        String[] numOfFamilyMem = surveyData.getNumOfFamilyMem();
                        String[] name = surveyData.getName();
                        String[] age = surveyData.getAge();
                        String[] gender = surveyData.getGender();
                        String[] civilStatus = surveyData.getCivilStatus();
                        String[] positionInFamily = surveyData.getPositionInFamily();
                        String[] eduactionalAttainment = surveyData.getEducationalAttainment();
                        String[] work = surveyData.getWork();
                        ArrayList<String[]> healthHistory = surveyData.getHealthHistory();
                        ArrayList<String[]> illnesses = surveyData.getIllnesses();
                        ArrayList<String[]> familyImmunization = surveyData.getFamilyImmunization();
                        String battered = surveyData.getBattered();
                        String fights = surveyData.getFights();
                        String childabuse = surveyData.getChildabuse();
                        String puttingoff = surveyData.getPuttingoff();
                        String inappropriateword = surveyData.getInappropriateword();
                        String income = surveyData.getIncome();
                        String sourceincome = surveyData.getSourceincome();
                        String[] needs = surveyData.getNeeds();
                        String hasLot = surveyData.getHasLot();
                        String hasHouse = surveyData.getHasHouse();
                        String typeOfHouse = surveyData.getTypeOfHouse();
                        String typeOfGarbageDisposal = surveyData.getTypeOfGarbageDisposal();
                        String typeOfToilet = surveyData.getTypeOfToilet();
                        String typeOfDrainage = surveyData.getTypeOfDrainage();
                        String sourceOfWater = surveyData.getSourceOfWater();
                        String sourceOfDrinkingWater = surveyData.getSourceOfDrinkingWater();
                        String drinkingWaterStorage = surveyData.getDrinkingWaterStorage();
                        String foodStorage = surveyData.getFoodStorage();
//                        String pestsPresence = request.getParameter("pestsPresence");
                        String breedingSite = surveyData.getBreedingSite();
                        String[] typeOfPests = surveyData.getTypeOfPests();
                        String[] typeOfPets = surveyData.getTypeOfPets();
                        String typeofhazards = surveyData.getTypeofhazards();
                        String mealsPerDay = surveyData.getMealsPerDay();
                        String[] healthPerson = surveyData.getHealthPerson();
                        String[] nonHealthPerson = surveyData.getNonHealthPerson();
                        String adequateRest = surveyData.getAdequateRest();
                        String exercise = surveyData.getExercise();
                        String relaxation = surveyData.getRelaxation();
                        String stressManagement = surveyData.getStressManagement();

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
                            CommunityMembersEntity members;
                            for (int x = 0; x < numOfFamilyMem.length; x++) {
                                members = new CommunityMembersEntity();
                                members.setFamily_id(newfamily_id);
                                members.setGivenname(name[x]);
                                members.setAge((int)Double.parseDouble(age[x]));
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
                                    if (healthHistory.get(0) != null) {
                                        
                                        for (int y = 0; y < healthHistory.get(x).length; y++) {
                                            answer.setQuestion_id(34);
                                            answer.setOfferedanswer_id(Integer.parseInt(healthHistory.get(x)[y]));
                                            personAns = new PersonAnswerDAO();
                                            upDB = personAns.insertAnswer(answer);
                                        }
                                    }

                                    //Recent Illnesses
                                    if (illnesses.get(0) != null) {
                                        for (int y = 0; y < illnesses.get(x).length; y++) {
                                            answer.setQuestion_id(35);
                                            answer.setOfferedanswer_id(Integer.parseInt(illnesses.get(x)[y]));
                                            personAns = new PersonAnswerDAO();
                                            upDB = personAns.insertAnswer(answer);
                                        }
                                    }

                                    //Immunization
                                    if (familyImmunization.get(0) != null) {
                                        for (int y = 0; y < familyImmunization.get(x).length; y++) {
                                            answer.setQuestion_id(27);
                                            answer.setOfferedanswer_id(Integer.parseInt(familyImmunization.get(x)[y]));
                                            personAns = new PersonAnswerDAO();
                                            upDB = personAns.insertAnswer(answer);
                                        }
                                    }

                                    //Age
                                    answer.setQuestion_id(39);
                                    answer.setOfferedanswer_id(ageAnswer((int)Double.parseDouble(age[x])));
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
                                answer.setOfferedanswer_id(Integer.parseInt(sourceOfDrinkingWater));
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
                                if (typeOfPets != null) {
                                    for (int x = 0; x < typeOfPests.length; x++) {
                                        answer.setQuestion_id(20);
                                        answer.setOfferedanswer_id(Integer.parseInt(typeOfPests[x]));
                                        communityAns = new CommunityAnswerDAO();
                                        upDB = communityAns.insertAnswer(answer);
                                    }
                                }

                                //typeOfPets
                                if (typeOfPets != null) {
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
                                if (healthPerson != null) {
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

                                //adequateExcercise
                                answer.setQuestion_id(29);
                                answer.setOfferedanswer_id(Integer.parseInt(exercise));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //adequateRelaxation
                                answer.setQuestion_id(30);
                                answer.setOfferedanswer_id(Integer.parseInt(relaxation));
                                communityAns = new CommunityAnswerDAO();
                                upDB = communityAns.insertAnswer(answer);

                                //adequateStressmanagement
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
                        //</editor-fold>

                        if (!childSurveyIndex.isEmpty()) {
                            for (int x = 0; x < childSurveyIndex.size(); x++) {
                                AnswerEntity answer;
                                PersonAnswerDAO personAns;

                                //Specific Age
                                answer = new AnswerEntity();
                                answer.setSurvey_id(5);
                                answer.setQuestion_id(71);
                                answer.setOfferedanswer_id(AnswerId(childage.get(x)));
                                answer.setId(childpersonId.get(x));
                                answer.setDate_answered(surveyYear);
                                answer.setOtheranswer(" ");
                                personAns = new PersonAnswerDAO();
                                upDB = personAns.insertAnswer(answer);
                                
                                String heightS = request.getParameter("height-" + childpersonId.get(x));
                                String weightS = request.getParameter("weight-" + childpersonId.get(x));

                                //Height
                                answer.setQuestion_id(72);
                                answer.setOfferedanswer_id(82);
                                answer.setOtheranswer(heightS);
                                personAns = new PersonAnswerDAO();
                                upDB = personAns.insertAnswer(answer);

                                //Weight
                                answer.setQuestion_id(73);
                                answer.setOfferedanswer_id(82);
                                answer.setOtheranswer(weightS);
                                personAns = new PersonAnswerDAO();
                                upDB = personAns.insertAnswer(answer);

                                double height = Double.parseDouble(heightS);
                                double weight = Double.parseDouble(weightS);
                                double bmi = (weight / (height * height)) * 703;
                                int bmi_category = bmi_category(bmi);
                                
                                //BMI
                                answer.setQuestion_id(77);
                                answer.setOfferedanswer_id(bmi_category);
                                answer.setOtheranswer(""+bmi);
                                personAns = new PersonAnswerDAO();
                                upDB = personAns.insertAnswer(answer);
                                
                                //Vitamins
                                String[] vitamins = request.getParameterValues("vitamins-" + childpersonId.get(x));
                                if (vitamins != null) {
                                    for (String vitamin : vitamins) {
                                        answer.setQuestion_id(74);
                                        answer.setOfferedanswer_id(Integer.parseInt(vitamin));
                                        answer.setOtheranswer(" ");
                                        personAns = new PersonAnswerDAO();
                                        upDB = personAns.insertAnswer(answer);
                                    }
                                }

                                //Screening
                                answer.setQuestion_id(75);
                                answer.setOfferedanswer_id(Integer.parseInt(request.getParameter("screening-" + childpersonId.get(x))));
                                answer.setOtheranswer(" ");
                                personAns = new PersonAnswerDAO();
                                upDB = personAns.insertAnswer(answer);

                                //Vaccination
                                String[] vaccines = request.getParameterValues("vaccine-" + childpersonId.get(x));
                                if (vaccines != null) {
                                    for (String vaccine : vaccines) {
                                        answer.setQuestion_id(76);
                                        answer.setOfferedanswer_id(Integer.parseInt(vaccine));
                                        answer.setOtheranswer(" ");
                                        personAns = new PersonAnswerDAO();
                                        upDB = personAns.insertAnswer(answer);
                                    }
                                }
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

    private int structureAnswer(String str) {
        int ans = 82;
        if (str.equals("Nuclear")) {
            ans = 13;
        } else if (str.equals("Single Parent")) {
            ans = 14;
        } else if (str.equals("Extended")) {
            ans = 15;
        } else if (str.equals("Childless")) {
            ans = 16;
        } else if (str.equals("Step Family")) {
            ans = 167;
        } else if (str.equals("Grand Family")) {
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
    
     private int bmi_category(double bmi) {
        int ans;
        if (bmi < 18.5) {
            ans = 234;
        } else if (bmi >= 18.5 && bmi <=24.9) {
            ans = 235;
        } else if (bmi >= 25 && bmi <= 29.9) {
            ans = 236;
        } else {
            ans = 237;
        }

        return ans;
    }
     
    private int AnswerId(double age) {
        if(age >= 0 &&  age <= 0.03){
            return 207;
        }else if(age >= 0.04 &&  age <= 0.06){
            return 208;
        }else if(age >= 0.07 &&  age <= 0.09){
            return 209;
        }else if(age >= 0.10 &&  age <= 0.11){
            return 210;
        }else if(age == 1 ){
            return 211;
        }else if(age == 2 ){
            return 212;
        }else if(age == 3 ){
            return 213;
        }else if(age == 4 ){
            return 214;
        }else if(age == 5 ){
            return 215;
        }else{
            return 207;
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
