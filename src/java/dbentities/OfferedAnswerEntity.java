/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

/**
 *
 * @author user
 */
public class OfferedAnswerEntity {

    private int offeredanswer_id;
    private String answertext;
    private String answer_category;

    public OfferedAnswerEntity() {
        this.offeredanswer_id = 0;
        this.answertext = "no answer";
        this.answer_category = "no category";
    }
    
    public OfferedAnswerEntity(int id, String answertext, String answer_category) {
        this.offeredanswer_id = id;
        this.answertext = answertext;
        this.answer_category = answer_category;
    }

    public int getId() {
        return offeredanswer_id;
    }

    public void setId(int id) {
        this.offeredanswer_id = id;
    }

    public String getAnswertext() {
        return answertext;
    }

    public void setAnswertext(String answertext) {
        this.answertext = answertext;
    }

    public String getAnswer_category() {
        return answer_category;
    }

    public void setAnswer_category(String answer_category) {
        this.answer_category = answer_category;
    }
}
