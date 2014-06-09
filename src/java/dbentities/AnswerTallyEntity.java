/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

/**
 *
 * @author user
 */
public class AnswerTallyEntity {
    private int question_id;
    private int offeredanswer_id;
    private int answercount;

    public AnswerTallyEntity(){
        this.question_id = 0;
        this.offeredanswer_id = 0;
        this.answercount = 0;
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

    public int getAnswercount() {
        return answercount;
    }

    public void setAnswercount(int answercount) {
        this.answercount = answercount;
    }
    
    
}
