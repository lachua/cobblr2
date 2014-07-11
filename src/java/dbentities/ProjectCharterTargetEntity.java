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
public class ProjectCharterTargetEntity {
    private int id;
    private int community_id;
    private String title;
    private String description;
    private String preparedby;
    private String objectives;
    private String scope;
    private String requirements;
    private int istemplate;
    private int status;
    private String type;
    private Date date_created;
    private Date meetingdate;
    private Date date_confirmed;
    private Date date_ongoing;
    private Date date_target_implement;
    private Date date_implemented;
    private Date date_closed;
    private Date date_cancelled;
    private int target_participant_num;
    private String cancel_reason;
    private int offeredanswer_id;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the community_id
     */
    public int getCommunity_id() {
        return community_id;
    }

    /**
     * @param community_id the community_id to set
     */
    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the preparedby
     */
    public String getPreparedby() {
        return preparedby;
    }

    /**
     * @param preparedby the preparedby to set
     */
    public void setPreparedby(String preparedby) {
        this.preparedby = preparedby;
    }

    /**
     * @return the objectives
     */
    public String getObjectives() {
        return objectives;
    }

    /**
     * @param objectives the objectives to set
     */
    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    /**
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return the requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * @param requirements the requirements to set
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * @return the istemplate
     */
    public int getIstemplate() {
        return istemplate;
    }

    /**
     * @param istemplate the istemplate to set
     */
    public void setIstemplate(int istemplate) {
        this.istemplate = istemplate;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the date_created
     */
    public Date getDate_created() {
        return date_created;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    /**
     * @return the meetingdate
     */
    public Date getMeetingdate() {
        return meetingdate;
    }

    /**
     * @param meetingdate the meetingdate to set
     */
    public void setMeetingdate(Date meetingdate) {
        this.meetingdate = meetingdate;
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
}
