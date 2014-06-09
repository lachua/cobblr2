/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

/**
 *
 * @author user
 */
public class SurveyQuestionsEntity {
    private int survey_id;
    private int question_id;
    private int question_index;

    public SurveyQuestionsEntity() {
        this.survey_id = 0;
        this.question_id = 0;
        this.question_index = 0;
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

    public int getQuestion_index() {
        return question_index;
    }

    public void setQuestion_index(int question_index) {
        this.question_index = question_index;
    }
    
    
}
