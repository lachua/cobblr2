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
public class TaskDetailsEntity {
    private Integer task_id;
    private Integer proj_id;
    private Integer contact_id;
    private String title;
    private Date startdate;
    private Date enddate;
    private Integer completed;
    private Integer targetcount;
    private Integer currentcount;
    private String unit;
    private String resource_type;
    private String org_description;
    private String firstname;
    private String lastname;
    private String mi;
    private String organizationname;
    private String address;
    private String supply_description;
    private Integer ispublic;
    private String mobile;
    private String email;
    private String phone;

    /**
     * @return the task_id
     */
    public Integer getTask_id() {
        return task_id;
    }

    /**
     * @param task_id the task_id to set
     */
    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    /**
     * @return the proj_id
     */
    public Integer getProj_id() {
        return proj_id;
    }

    /**
     * @param proj_id the proj_id to set
     */
    public void setProj_id(Integer proj_id) {
        this.proj_id = proj_id;
    }

    /**
     * @return the contact_id
     */
    public Integer getContact_id() {
        return contact_id;
    }

    /**
     * @param contact_id the contact_id to set
     */
    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
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
     * @return the startdate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * @param startdate the startdate to set
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * @return the enddate
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * @param enddate the enddate to set
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * @return the completed
     */
    public Integer getCompleted() {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    /**
     * @return the targetcount
     */
    public Integer getTargetcount() {
        return targetcount;
    }

    /**
     * @param targetcount the targetcount to set
     */
    public void setTargetcount(Integer targetcount) {
        this.targetcount = targetcount;
    }

    /**
     * @return the currentcount
     */
    public Integer getCurrentcount() {
        return currentcount;
    }

    /**
     * @param currentcount the currentcount to set
     */
    public void setCurrentcount(Integer currentcount) {
        this.currentcount = currentcount;
    }

    /**
     * @return the resource_type
     */
    public String getResource_type() {
        return resource_type;
    }

    /**
     * @param resource_type the resource_type to set
     */
    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the mi
     */
    public String getMi() {
        return mi;
    }

    /**
     * @param mi the mi to set
     */
    public void setMi(String mi) {
        this.mi = mi;
    }

    /**
     * @return the organizationname
     */
    public String getOrganizationname() {
        return organizationname;
    }

    /**
     * @param organizationname the organizationname to set
     */
    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the supply_description
     */
    public String getSupply_description() {
        return supply_description;
    }

    /**
     * @param supply_description the supply_description to set
     */
    public void setSupply_description(String supply_description) {
        this.supply_description = supply_description;
    }

    /**
     * @return the ispublic
     */
    public Integer getIspublic() {
        return ispublic;
    }

    /**
     * @param ispublic the ispublic to set
     */
    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
