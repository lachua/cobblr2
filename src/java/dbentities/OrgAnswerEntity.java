/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbentities;

import java.util.Calendar;

/**
 *
 * @author Renliw
 */
public class OrgAnswerEntity {
    private int survey_id;
    private int question_id;
    private int offeredanswer_id;
    private int org_id;
    private int project_id;
    private Calendar date_answered;
    private String otheranswer;

    /**
     * @return the survey_id
     */
    public int getSurvey_id() {
        return survey_id;
    }

    /**
     * @param survey_id the survey_id to set
     */
    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    /**
     * @return the question_id
     */
    public int getQuestion_id() {
        return question_id;
    }

    /**
     * @param question_id the question_id to set
     */
    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    /**
     * @return the offeredanswer_id
     */
    public int getOfferedanswer_id() {
        return offeredanswer_id;
    }

    /**
     * @param offeredanswer_id the offeredanswer_id to set
     */
    public void setOfferedanswer_id(int offeredanswer_id) {
        this.offeredanswer_id = offeredanswer_id;
    }

    /**
     * @return the org_id
     */
    public int getOrg_id() {
        return org_id;
    }

    /**
     * @param org_id the org_id to set
     */
    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    /**
     * @return the project_id
     */
    public int getProject_id() {
        return project_id;
    }

    /**
     * @param project_id the project_id to set
     */
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    /**
     * @return the date_answered
     */
    public Calendar getDate_answered() {
        return date_answered;
    }

    /**
     * @param date_answered the date_answered to set
     */
    public void setDate_answered(Calendar date_answered) {
        this.date_answered = date_answered;
    }

    /**
     * @return the otheranswer
     */
    public String getOtheranswer() {
        return otheranswer;
    }

    /**
     * @param otheranswer the otheranswer to set
     */
    public void setOtheranswer(String otheranswer) {
        this.otheranswer = otheranswer;
    }
}
