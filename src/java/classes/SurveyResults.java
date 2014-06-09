/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dbdao.AnswerTallyDAO;
import dbdao.OfferedAnswerDAO;
import dbdao.PersonAnswerDAO;
import dbdao.QuestionDAO;
import dbentities.AnswerTallyEntity;
import dbentities.OfferedAnswerEntity;
import dbentities.QuestionEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author user
 */
public class SurveyResults {

    private int survey_id;
    private int community_id;
    private int survey_year;
    private int numFamilies;
    private int numIndividuals;
    private int numMales;
    private int numFemales;
    private HashMap<Integer, QuestionAnswerSet> surveyResults; //where Integer is Question_id and QuestionAnswerSet is a set of answers

    public SurveyResults(int community_id, int survey_year) {
        this.survey_id = 1; //Default survey id for communities
        this.community_id = community_id;
        this.survey_year = survey_year;
        this.numFamilies = 0;
        this.numIndividuals = 0;
        this.numMales = 0;
        this.numFemales = 0;
        this.surveyResults = new HashMap<>();

        loadResults(community_id, survey_year);
    }

    private void loadResults(int community_id, int survey_year) {

        AnswerTallyDAO atDAO = new AnswerTallyDAO();
        this.numFamilies = atDAO.countFamilies(community_id, survey_year);

        if (numFamilies >= 0) {

            //Get number of males
            PersonAnswerDAO paDAO = new PersonAnswerDAO();
            this.numMales = paDAO.countMalesSurveyed(community_id, survey_year);

            //Get number of females
            paDAO = new PersonAnswerDAO();
            this.numFemales = paDAO.countFemalesSurveyed(community_id, survey_year);

            //Calculate number of people
            this.numIndividuals = this.numMales + this.numFemales;

            //Load answers from community_answer table
            atDAO = new AnswerTallyDAO();
            List<AnswerTallyEntity> answerList = atDAO.tallyAnswers(community_id, survey_year);

            for (int i = 0; i < answerList.size(); i++) {

                AnswerTallyEntity oneAnswerTally = answerList.get(i);
                QuestionAnswerSet qaSet = new QuestionAnswerSet();

                QuestionDAO qDAO = new QuestionDAO();
                QuestionEntity question = qDAO.getQuestion(oneAnswerTally.getQuestion_id());

                if (question != null) {
                    qaSet.setQuestionid(question.getQuestion_id());
                    qaSet.setQuestiontext(question.getQuestiontext());

                    for(int j = 0; j < answerList.size(); j++){
                        if(qaSet.getQuestionid() == answerList.get(j).getQuestion_id()){
                            qaSet.getAnswerset().put(answerList.get(j).getOfferedanswer_id(), answerList.get(j).getAnswercount());
                            //answerList.remove(j);
                        }
                    }
                    
                    
//                    for (int j = 0; j < answerList.size(); j++) {
//                        OfferedAnswerDAO ansDAO = new OfferedAnswerDAO();
//                        OfferedAnswerEntity answer = ansDAO.getOfferedAnswer(answerList.get(j).getOfferedanswer_id());
//
//                        if (answer != null && qaSet.getQuestionid() == answerList.get(j).getQuestion_id()) {
//                            qaSet.getAnswerset().put(answer.getId(), answerList.get(j).getAnswercount());
//                        }
//                    }

                    surveyResults.put(qaSet.getQuestionid(), qaSet);
                }
            }

            
            //CALCULATE FAMILY SIZES AND PUT INTO SURVEY RESULTS (QUESTION ID 38)

            //Question Id 38 is Family Size in Survey Reference xls
            QuestionAnswerSet famSizeSet = new QuestionAnswerSet(38, "Family Size");

            atDAO = new AnswerTallyDAO();
            List<AnswerTallyEntity> famSizeList = atDAO.countFamilyMembers(community_id, survey_year);

            HashMap<Integer, Integer> famSizeMap = new HashMap();
            famSizeMap.put(160, 0); //2 and below
            famSizeMap.put(161, 0); //3
            famSizeMap.put(162, 0); //4
            famSizeMap.put(163, 0); //5
            famSizeMap.put(164, 0); //6
            famSizeMap.put(165, 0); //7
            famSizeMap.put(166, 0); //8+

            //question_id = family_id, answercount = number of people in family
            for (AnswerTallyEntity at : famSizeList) {
                switch (at.getAnswercount()) {
                    case 0:
                    case 1:
                    case 2: //If 2 and below
                        famSizeMap.put(160, famSizeMap.get(160) + 1);
                        break;
                    case 3:
                        famSizeMap.put(161, famSizeMap.get(161) + 1);
                        break;
                    case 4:
                        famSizeMap.put(162, famSizeMap.get(162) + 1);
                        break;
                    case 5:
                        famSizeMap.put(163, famSizeMap.get(163) + 1);
                        break;
                    case 6:
                        famSizeMap.put(164, famSizeMap.get(164) + 1);
                        break;
                    case 7:
                        famSizeMap.put(165, famSizeMap.get(165) + 1);
                    default: //If 8 and above
                        famSizeMap.put(166, famSizeMap.get(166) + 1);
                        break;
                }
            }
            
            famSizeSet.setAnswerset(famSizeMap);
            surveyResults.put(38, famSizeSet);
        }
    }

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public int getSurvey_year() {
        return survey_year;
    }

    public void setSurvey_year(int survey_year) {
        this.survey_year = survey_year;
    }

    public int getNumFamilies() {
        return numFamilies;
    }

    public void setNumFamilies(int numFamilies) {
        this.numFamilies = numFamilies;
    }

    public HashMap<Integer, QuestionAnswerSet> getSurveyResults() {
        return surveyResults;
    }

    public void setSurveyResults(HashMap<Integer, QuestionAnswerSet> surveyResults) {
        this.surveyResults = surveyResults;
    }

    public int getNumIndividuals() {
        return numIndividuals;
    }

    public void setNumIndividuals(int numIndividuals) {
        this.numIndividuals = numIndividuals;
    }

    public int getNumMales() {
        return numMales;
    }

    public void setNumMales(int numMales) {
        this.numMales = numMales;
    }

    public int getNumFemales() {
        return numFemales;
    }

    public void setNumFemales(int numFemales) {
        this.numFemales = numFemales;
    }
}
