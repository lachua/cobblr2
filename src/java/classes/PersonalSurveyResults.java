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
public class PersonalSurveyResults {

    private int survey_id;
    private int community_id;
    private int survey_year;
    private HashMap<Integer, Integer> MaleAges;
    private HashMap<Integer, Integer> FemaleAges;
    private ArrayList<Job> jobcount;
    private HashMap<Integer, QuestionAnswerSet> surveyResults; //where Integer is Question_id and QuestionAnswerSet is a set of answers

    public PersonalSurveyResults(int community_id, int survey_year) {
        this.survey_id = 2; //Default survey id for personal information
        this.community_id = community_id;
        this.survey_year = survey_year;
        this.surveyResults = new HashMap<>();
        this.MaleAges = new HashMap<>();
        this.FemaleAges = new HashMap<>();
        this.jobcount = new ArrayList<>();

        loadResults(community_id, survey_year);
        loadAges(MaleAges, community_id, survey_year, "M");
        loadAges(FemaleAges, community_id, survey_year, "F");
        loadJobs(jobcount, community_id, survey_year);
    }

    private void loadResults(int community_id, int survey_year) {

        AnswerTallyDAO atDAO = new AnswerTallyDAO();

        //Load answers from personal_answer table
        atDAO = new AnswerTallyDAO();
        List<AnswerTallyEntity> answerList = atDAO.tallyPersonAnswers(community_id, survey_year);

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

    private void loadAges(HashMap<Integer, Integer> map, int community_id, int survey_year, String gender) {
        //CALCULATE MALE AGES AND PUT INTO SURVEY RESULTS (QUESTION ID 39)
        AnswerTallyDAO atDAO = new AnswerTallyDAO();
        List<AnswerTallyEntity> ageList = atDAO.tallyAgesByGender(community_id, survey_year, gender);

        map.put(151, 0); //1-3
        map.put(152, 0); //4-5
        map.put(153, 0); //6-10
        map.put(154, 0); //11-14
        map.put(155, 0); //15-17
        map.put(156, 0); //18-20
        map.put(157, 0); //21-40
        map.put(158, 0); //41-60
        map.put(159, 0); //61+

        //question_id = family_id, answercount = number of people in family
        for (AnswerTallyEntity at : ageList) {
            int age = at.getQuestion_id();

            if (age >= 0 && age <= 3) {
                map.put(151, map.get(151) + 1);
            } else if (age >= 4 && age <= 5) {
                map.put(152, map.get(152) + 1);
            } else if (age >= 6 && age <= 10) {
                map.put(153, map.get(153) + 1);
            } else if (age >= 11 && age <= 14) {
                map.put(154, map.get(154) + 1);
            } else if (age >= 15 && age <= 17) {
                map.put(155, map.get(155) + 1);
            } else if (age >= 18 && age <= 20) {
                map.put(156, map.get(156) + 1);
            } else if (age >= 21 && age <= 40) {
                map.put(157, map.get(157) + 1);
            } else if (age >= 41 && age <= 60) {
                map.put(158, map.get(158) + 1);
            } else if (age > 61) {
                map.put(159, map.get(159) + 1);
            }
        }
    }
    
    private void loadJobs(ArrayList<Job> jobcount, int community_id, int survey_year) {
        PersonAnswerDAO pDAO = new PersonAnswerDAO();
        List<AnswerEntity> answers = pDAO.getCountOccupations(community_id, survey_year);
        
        for(AnswerEntity a : answers){
            Job j = new Job(a.getOtheranswer(), a.getOfferedanswer_id());
            jobcount.add(j);
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

    /**
     * @return the MaleAges
     */
    public HashMap<Integer, Integer> getMaleAges() {
        return MaleAges;
    }

    /**
     * @param MaleAges the MaleAges to set
     */
    public void setMaleAges(HashMap<Integer, Integer> MaleAges) {
        this.MaleAges = MaleAges;
    }

    /**
     * @return the FemaleAges
     */
    public HashMap<Integer, Integer> getFemaleAges() {
        return FemaleAges;
    }

    /**
     * @param FemaleAges the FemaleAges to set
     */
    public void setFemaleAges(HashMap<Integer, Integer> FemaleAges) {
        this.FemaleAges = FemaleAges;
    }

    public ArrayList<Job> getJobcount() {
        return jobcount;
    }

    public void setJobcount(ArrayList<Job> jobcount) {
        this.jobcount = jobcount;
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
