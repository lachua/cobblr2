/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbentities;

/**
 *
 * @author Renliw
 */
public class ReportProject2Entity {
    private int question_id;
    private String questiontext;
    private int avg_answer_id;
    private String answertext;

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
     * @return the questiontext
     */
    public String getQuestiontext() {
        return questiontext;
    }

    /**
     * @param questiontext the questiontext to set
     */
    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    /**
     * @return the avg_answer_id
     */
    public int getAvg_answer_id() {
        return avg_answer_id;
    }

    /**
     * @param avg_answer_id the avg_answer_id to set
     */
    public void setAvg_answer_id(int avg_answer_id) {
        this.avg_answer_id = avg_answer_id;
    }

    /**
     * @return the answertext
     */
    public String getAnswertext() {
        return answertext;
    }

    /**
     * @param answertext the answertext to set
     */
    public void setAnswertext(String answertext) {
        this.answertext = answertext;
    }
}
