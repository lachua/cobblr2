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
public class UnavailableProjectEntity{
    private Integer project_id;
    private Integer community_id;
    private String title;
    private String description;
    private String preparedby;
    private String objectives;
    private String scope;
    private String requirements;
    private Integer status;
    private String type;
    private Date meetingdate;
    private Integer org_id;
    private String org_name;
    private String org_description;
    private Integer student_idno;
    private String student_firstname;
    private String student_lastname;
    private String student_position;
    private String student_email;
    private String student_homeno;
    private String student_mobileno;
    private String community_name;
    private String community_address;
    private String community_phone;
    private String community_mobile;
    private String community_email;

    public UnavailableProjectEntity() {
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
     * @return the community_id
     */
    public Integer getCommunity_id() {
        return community_id;
    }

    /**
     * @param community_id the community_id to set
     */
    public void setCommunity_id(Integer community_id) {
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

    /**
     * @return the org_name
     */
    public String getOrg_name() {
        return org_name;
    }

    /**
     * @param org_name the org_name to set
     */
    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    /**
     * @return the org_description
     */
    public String getOrg_description() {
        return org_description;
    }

    /**
     * @param org_description the org_description to set
     */
    public void setOrg_description(String org_description) {
        this.org_description = org_description;
    }

    /**
     * @return the student_idno
     */
    public Integer getStudent_idno() {
        return student_idno;
    }

    /**
     * @param student_idno the student_idno to set
     */
    public void setStudent_idno(Integer student_idno) {
        this.student_idno = student_idno;
    }

    /**
     * @return the student_firstname
     */
    public String getStudent_firstname() {
        return student_firstname;
    }

    /**
     * @param student_firstname the student_firstname to set
     */
    public void setStudent_firstname(String student_firstname) {
        this.student_firstname = student_firstname;
    }

    /**
     * @return the student_lastname
     */
    public String getStudent_lastname() {
        return student_lastname;
    }

    /**
     * @param student_lastname the student_lastname to set
     */
    public void setStudent_lastname(String student_lastname) {
        this.student_lastname = student_lastname;
    }

    /**
     * @return the student_position
     */
    public String getStudent_position() {
        return student_position;
    }

    /**
     * @param student_position the student_position to set
     */
    public void setStudent_position(String student_position) {
        this.student_position = student_position;
    }

    /**
     * @return the student_email
     */
    public String getStudent_email() {
        return student_email;
    }

    /**
     * @param student_email the student_email to set
     */
    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    /**
     * @return the student_homeno
     */
    public String getStudent_homeno() {
        return student_homeno;
    }

    /**
     * @param student_homeno the student_homeno to set
     */
    public void setStudent_homeno(String student_homeno) {
        this.student_homeno = student_homeno;
    }

    /**
     * @return the student_mobileno
     */
    public String getStudent_mobileno() {
        return student_mobileno;
    }

    /**
     * @param student_mobileno the student_mobileno to set
     */
    public void setStudent_mobileno(String student_mobileno) {
        this.student_mobileno = student_mobileno;
    }

    /**
     * @return the community_name
     */
    public String getCommunity_name() {
        return community_name;
    }

    /**
     * @param community_name the community_name to set
     */
    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    /**
     * @return the community_address
     */
    public String getCommunity_address() {
        return community_address;
    }

    /**
     * @param community_address the community_address to set
     */
    public void setCommunity_address(String community_address) {
        this.community_address = community_address;
    }

    /**
     * @return the community_phone
     */
    public String getCommunity_phone() {
        return community_phone;
    }

    /**
     * @param community_phone the community_phone to set
     */
    public void setCommunity_phone(String community_phone) {
        this.community_phone = community_phone;
    }

    /**
     * @return the community_mobile
     */
    public String getCommunity_mobile() {
        return community_mobile;
    }

    /**
     * @param community_mobile the community_mobile to set
     */
    public void setCommunity_mobile(String community_mobile) {
        this.community_mobile = community_mobile;
    }

    /**
     * @return the community_email
     */
    public String getCommunity_email() {
        return community_email;
    }

    /**
     * @param community_email the community_email to set
     */
    public void setCommunity_email(String community_email) {
        this.community_email = community_email;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
}
