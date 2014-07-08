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
public class ReportYearEnd3Entity {
    private String name;
    private String title;
    private int target_participant_num;
    private int actual_participant;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the target_participant_num
     */
    public int getTarget_participant_num() {
        return target_participant_num;
    }

    /**
     * @param target_participant_num the target_participant_num to set
     */
    public void setTarget_participant_num(int target_participant_num) {
        this.target_participant_num = target_participant_num;
    }

    /**
     * @return the actual_participant
     */
    public int getActual_participant() {
        return actual_participant;
    }

    /**
     * @param actual_participant the actual_participant to set
     */
    public void setActual_participant(int actual_participant) {
        this.actual_participant = actual_participant;
    }
}
