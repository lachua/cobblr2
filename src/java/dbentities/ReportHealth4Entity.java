/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbentities;

import java.util.Date;

/**
 *
 * @author Renliw
 */
public class ReportHealth4Entity {
    private Date date_implemented;
    private String title;
    private String answertext;
    private int num_participants;

    /**
     * @return the date_implemented
     */
    public Date getDate_implemented() {
        return date_implemented;
    }

    /**
     * @param date_implemented the date_implemented to set
     */
    public void setDate_implemented(Date date_implemented) {
        this.date_implemented = date_implemented;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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

    /**
     * @return the num_participants
     */
    public int getNum_participants() {
        return num_participants;
    }

    /**
     * @param num_participants the num_participants to set
     */
    public void setNum_participants(int num_participants) {
        this.num_participants = num_participants;
    }
}
