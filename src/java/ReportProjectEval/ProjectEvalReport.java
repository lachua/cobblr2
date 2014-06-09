/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportProjectEval;

import classes.QuestionAnswerSet;
import dbdao.QuestionDAO;
import dbentities.AnswerEntity;
import dbentities.AnswerTallyEntity;
import dbentities.QuestionEntity;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author user
 */
public class ProjectEvalReport {
    
    //for studentEval
    private Calendar dateEvaluated;
    private String studentOrg;
    private String studentName;
    private Calendar datePrinted;
    private String projectTitle;
    private HashMap<Integer, Integer> studentEvalAnswers; //Integer 1 = Question, Integer 2 = Answer
    
    //for Beneficiaries
    private String communityName;
    private int numSurveyed;
    private HashMap<Integer, QuestionAnswerSet> beneficiaryEvalTally; // Integer

    public ProjectEvalReport(int project_id) {
        this.dateEvaluated = Calendar.getInstance();
        this.studentOrg = "";
        this.studentName = "";
        this.datePrinted = Calendar.getInstance();
        this.projectTitle = "";
        this.studentEvalAnswers = new HashMap<>();
        this.communityName = "";
        this.numSurveyed = 0;
        this.beneficiaryEvalTally = new HashMap<>();
        
        loadResults(project_id);
    }
        
    private void loadResults(int project_id){
        
        //Student Org Stuff
        EvalProjectDAO epDAO = new EvalProjectDAO();
        this.setProjectTitle(epDAO.getProjectTitle(project_id));

        EvalProjectOrgDetailsDAO odDAO = new EvalProjectOrgDetailsDAO();
        EvalProjectOrgDetailsEntity orgDetails = odDAO.getProjectOrgDetails(project_id);
        
        this.setStudentOrg(orgDetails.getOrgname());
        this.setStudentName(orgDetails.getStudentname());
                
        EvalOrgAnswerDAO eoaDAO = new EvalOrgAnswerDAO();
        List<AnswerEntity> orgAnswerList = eoaDAO.getOrgAnswers(project_id);
        
        for(AnswerEntity a : orgAnswerList){
            this.getStudentEvalAnswers().put(a.getQuestion_id(), a.getOfferedanswer_id());
        }
        
        this.setDateEvaluated(orgAnswerList.get(0).getDate_answered());
        
        
        
        //Beneficiary Stuff
        //Community Name
        this.setCommunityName(new EvalCommunityDAO().getCommunityName(project_id));
        
        //Answer Tally and Number of Individuals Surveyed
        EvalBenefAnswerDAO ebaDAO = new EvalBenefAnswerDAO();
        List<AnswerTallyEntity> benefAnswerList = ebaDAO.tallyBenefEvalAnswers(project_id);
        
        for (int i = 0; i < benefAnswerList.size(); i++) {

            AnswerTallyEntity oneAnswerTally = benefAnswerList.get(i);

            QuestionAnswerSet qaSet = new QuestionAnswerSet();

            QuestionDAO qDAO = new QuestionDAO();
            QuestionEntity question = qDAO.getQuestion(oneAnswerTally.getQuestion_id());

            if (question != null) {
                qaSet.setQuestionid(question.getQuestion_id());
                qaSet.setQuestiontext(question.getQuestiontext());

                for (int j = 0; j < benefAnswerList.size(); j++) {
                    if (qaSet.getQuestionid() == benefAnswerList.get(j).getQuestion_id()) {
                        qaSet.getAnswerset().put(benefAnswerList.get(j).getOfferedanswer_id(), benefAnswerList.get(j).getAnswercount());
                    }
                }

                this.getBeneficiaryEvalTally().put(qaSet.getQuestionid(), qaSet);
            }
            
            ebaDAO = new EvalBenefAnswerDAO();
            setNumSurveyed(ebaDAO.countParticipants(project_id));
        }
    }

    /**
     * @return the dateEvaluated
     */
    public Calendar getDateEvaluated() {
        return dateEvaluated;
    }

    /**
     * @param dateEvaluated the dateEvaluated to set
     */
    public void setDateEvaluated(Calendar dateEvaluated) {
        this.dateEvaluated = dateEvaluated;
    }

    /**
     * @return the studentOrg
     */
    public String getStudentOrg() {
        return studentOrg;
    }

    /**
     * @param studentOrg the studentOrg to set
     */
    public void setStudentOrg(String studentOrg) {
        this.studentOrg = studentOrg;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the datePrinted
     */
    public Calendar getDatePrinted() {
        return datePrinted;
    }

    /**
     * @param datePrinted the datePrinted to set
     */
    public void setDatePrinted(Calendar datePrinted) {
        this.datePrinted = datePrinted;
    }

    /**
     * @return the projectTitle
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * @param projectTitle the projectTitle to set
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     * @return the studentEvalAnswers
     */
    public HashMap<Integer, Integer> getStudentEvalAnswers() {
        return studentEvalAnswers;
    }

    /**
     * @param studentEvalAnswers the studentEvalAnswers to set
     */
    public void setStudentEvalAnswers(HashMap<Integer, Integer> studentEvalAnswers) {
        this.studentEvalAnswers = studentEvalAnswers;
    }

    /**
     * @return the communityName
     */
    public String getCommunityName() {
        return communityName;
    }

    /**
     * @param communityName the communityName to set
     */
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    /**
     * @return the numSurveyed
     */
    public int getNumSurveyed() {
        return numSurveyed;
    }

    /**
     * @param numSurveyed the numSurveyed to set
     */
    public void setNumSurveyed(int numSurveyed) {
        this.numSurveyed = numSurveyed;
    }

    /**
     * @return the beneficiaryEvalTally
     */
    public HashMap<Integer, QuestionAnswerSet> getBeneficiaryEvalTally() {
        return beneficiaryEvalTally;
    }

    /**
     * @param beneficiaryEvalTally the beneficiaryEvalTally to set
     */
    public void setBeneficiaryEvalTally(HashMap<Integer, QuestionAnswerSet> beneficiaryEvalTally) {
        this.beneficiaryEvalTally = beneficiaryEvalTally;
    }
}
