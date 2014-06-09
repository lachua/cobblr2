/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

/**
 *
 * @author user
 */
public class SurveyQuestionAnswerEntity {

    private int survey_id;
    private int question_id;
    private int offeredanswer_id;

    public SurveyQuestionAnswerEntity() {
        this.survey_id = 0;
        this.question_id = 0;
        this.offeredanswer_id = 0;
    }

    public SurveyQuestionAnswerEntity(int survey_id, int question_id, int offeredanswer_id) {
        this.survey_id = survey_id;
        this.question_id = question_id;
        this.offeredanswer_id = offeredanswer_id;
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
}
