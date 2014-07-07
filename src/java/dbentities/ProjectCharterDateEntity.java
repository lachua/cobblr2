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
public class ProjectCharterDateEntity {
    private int project_id;
    private Date date_confirmed;
    private Date date_ongoing;
    private Date date_target_implement;
    private Date date_implemented;
    private Date date_closed;
    private Date date_cancelled;
    private int target_participant_num;
    private String cancel_reason;
    

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
     * @return the date_confirmed
     */
    public Date getDate_confirmed() {
        return date_confirmed;
    }

    /**
     * @param date_confirmed the date_confirmed to set
     */
    public void setDate_confirmed(Date date_confirmed) {
        this.date_confirmed = date_confirmed;
    }

    /**
     * @return the date_ongoing
     */
    public Date getDate_ongoing() {
        return date_ongoing;
    }

    /**
     * @param date_ongoing the date_ongoing to set
     */
    public void setDate_ongoing(Date date_ongoing) {
        this.date_ongoing = date_ongoing;
    }

    /**
     * @return the date_target_implement
     */
    public Date getDate_target_implement() {
        return date_target_implement;
    }

    /**
     * @param date_target_implement the date_target_implement to set
     */
    public void setDate_target_implement(Date date_target_implement) {
        this.date_target_implement = date_target_implement;
    }

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
     * @return the date_closed
     */
    public Date getDate_closed() {
        return date_closed;
    }

    /**
     * @param date_closed the date_closed to set
     */
    public void setDate_closed(Date date_closed) {
        this.date_closed = date_closed;
    }

    /**
     * @return the date_cancelled
     */
    public Date getDate_cancelled() {
        return date_cancelled;
    }

    /**
     * @param date_cancelled the date_cancelled to set
     */
    public void setDate_cancelled(Date date_cancelled) {
        this.date_cancelled = date_cancelled;
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
     * @return the cancel_reason
     */
    public String getCancel_reason() {
        return cancel_reason;
    }

    /**
     * @param cancel_reason the cancel_reason to set
     */
    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }
}
