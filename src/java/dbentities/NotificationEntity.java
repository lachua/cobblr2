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
public class NotificationEntity {
    private Integer id_notification;
    private Integer org_id;
    private String notificationtext;
    private Integer viewed;
    private Integer project_id;
    private String comments;
    private Date date;

    /**
     * @return the id_notification
     */
    public Integer getId_notification() {
        return id_notification;
    }

    /**
     * @param id_notification the id_notification to set
     */
    public void setId_notification(Integer id_notification) {
        this.id_notification = id_notification;
    }



    /**
     * @return the notificationtext
     */
    public String getNotificationtext() {
        return notificationtext;
    }

    /**
     * @param notificationtext the notificationtext to set
     */
    public void setNotificationtext(String notificationtext) {
        this.notificationtext = notificationtext;
    }

    /**
     * @return the viewed
     */
    public Integer getViewed() {
        return viewed;
    }

    /**
     * @param viewed the viewed to set
     */
    public void setViewed(Integer viewed) {
        this.viewed = viewed;
    }

    /**
     * @return the project_id
     */
    public Integer getProject_id() {
        return project_id;
    }

    /**
     * @param project_id the project_id to set
     */
    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the org_id
     */
    public Integer getOrg_id() {
        return org_id;
    }

    /**
     * @param org_id the org_id to set
     */
    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }
    
    
}
