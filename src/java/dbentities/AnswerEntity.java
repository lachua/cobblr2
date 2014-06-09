/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

import java.util.Calendar;

/**
 *
 * @author user
 */
public class AnswerEntity {

    private int survey_id;
    private int question_id;
    private int offeredanswer_id;
    private int id;
    private Calendar date_answered;
    private String otheranswer;

    public AnswerEntity() {
        this.survey_id = 1;
        this.question_id = -1;
        this.offeredanswer_id = 82; //82 is 'other', by default offered answer is set to other
        this.id = -1;
        this.date_answered = Calendar.getInstance();
        this.otheranswer = "";
    }    
    
    public AnswerEntity(int survey_id, int question_id, int offeredanswer_id, int family_id, Calendar date_answered, String otheranswer) {
        this();
        this.survey_id = survey_id;
        this.question_id = question_id;
        this.offeredanswer_id = offeredanswer_id;
        this.id = family_id;
        this.date_answered = date_answered;
        this.otheranswer = otheranswer;
    }
    
    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getOfferedanswer_id() {
        return offeredanswer_id;
    }

    public void setOfferedanswer_id(int offeredanswer_id) {
        this.offeredanswer_id = offeredanswer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDate_answered() {
        return date_answered;
    }

    public void setDate_answered(Calendar date_answered) {
        this.date_answered = date_answered;
    }

    public String getOtheranswer() {
        return otheranswer;
    }

    public void setOtheranswer(String otheranswer) {
        this.otheranswer = otheranswer;
    }
}
