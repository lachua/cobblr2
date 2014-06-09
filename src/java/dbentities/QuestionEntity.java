/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

/**
 *
 * @author user
 */
public class QuestionEntity {
    private int question_id;
    private String questiontext;
    private String question_tag;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public String getQuestion_tag() {
        return question_tag;
    }

    public void setQuestion_tag(String question_tag) {
        this.question_tag = question_tag;
    }
}
