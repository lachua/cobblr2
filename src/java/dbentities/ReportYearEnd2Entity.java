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
public class ReportYearEnd2Entity {
    private String answertext;
    private int count_implemented;
    private int count_available;

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
     * @return the count_implemented
     */
    public int getCount_implemented() {
        return count_implemented;
    }

    /**
     * @param count_implemented the count_implemented to set
     */
    public void setCount_implemented(int count_implemented) {
        this.count_implemented = count_implemented;
    }

    /**
     * @return the count_available
     */
    public int getCount_available() {
        return count_available;
    }

    /**
     * @param count_available the count_available to set
     */
    public void setCount_available(int count_available) {
        this.count_available = count_available;
    }
}
