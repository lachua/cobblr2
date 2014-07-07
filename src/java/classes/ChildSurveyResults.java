/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dbdao.AnswerTallyDAO;
import dbdao.OfferedAnswerDAO;
import dbdao.PersonAnswerDAO;
import dbdao.QuestionDAO;
import dbentities.AnswerEntity;
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
public class ChildSurveyResults {

    private int survey_id;
    private int community_id;
    private int survey_year;
    private HashMap<Integer, QuestionAnswerSet> surveyResults; //where Integer is Question_id and QuestionAnswerSet is a set of answers

    public ChildSurveyResults(int community_id, int survey_year) {
        this.survey_id = 5; //Default survey id for personal information
        this.community_id = community_id;
        this.survey_year = survey_year;
        this.surveyResults = new HashMap<>();

        loadResults(community_id, survey_year);
    }

    private void loadResults(int community_id, int survey_year) {

        AnswerTallyDAO atDAO = new AnswerTallyDAO();

        //Load answers from personal_answer table
        atDAO = new AnswerTallyDAO();
        List<AnswerTallyEntity> answerList = atDAO.tallyChildAnswers(community_id, survey_year);

        for (int i = 0; i < answerList.size(); i++) {

            AnswerTallyEntity oneAnswerTally = answerList.get(i);

            QuestionAnswerSet qaSet = new QuestionAnswerSet();

            QuestionDAO qDAO = new QuestionDAO();
            QuestionEntity question = qDAO.getQuestion(oneAnswerTally.getQuestion_id());

            if (question != null) {
                qaSet.setQuestionid(question.getQuestion_id());
                qaSet.setQuestiontext(question.getQuestiontext());

                for (int j = 0; j < answerList.size(); j++) {
                    if (qaSet.getQuestionid() == answerList.get(j).getQuestion_id()) {
                        qaSet.getAnswerset().put(answerList.get(j).getOfferedanswer_id(), answerList.get(j).getAnswercount());
                    }
                }

                getSurveyResults().put(qaSet.getQuestionid(), qaSet);
            }
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

    public HashMap<Integer, QuestionAnswerSet> getSurveyResults() {
        return surveyResults;
    }

    public void setSurveyResults(HashMap<Integer, QuestionAnswerSet> surveyResults) {
        this.surveyResults = surveyResults;
    }
    
    public class Job{
        private String job;
        private int count;

        public Job(String job, int count) {
            this.job = job;
            this.count = count;
        }
        
        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
        
        
    }
}
