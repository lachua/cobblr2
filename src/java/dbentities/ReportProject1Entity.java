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
public class ReportProject1Entity {
    private String title;
    private String type;
    private String target;
    private String partner_community;
    private String location;
    private String sponsor;
    private Date date_target_implement;
    private Date date_implemented;
    private String description;
    private String objectives;

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
     * @return the target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * @return the partner_community
     */
    public String getPartner_community() {
        return partner_community;
    }

    /**
     * @param partner_community the partner_community to set
     */
    public void setPartner_community(String partner_community) {
        this.partner_community = partner_community;
    }

    /**
     * @return the sponsor
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * @param sponsor the sponsor to set
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
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
    
}
