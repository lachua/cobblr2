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
public class ProjectTargetEntity {
    private int project_id;
    private int offeredanswer_id;
    private String answertext;

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
