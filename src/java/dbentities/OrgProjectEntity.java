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
public class OrgProjectEntity {
    private Integer project_id;
    private Integer org_id;
    private Integer student_idno;
    private String firstname;
    private String lastname;
    private String org_position;
    private String email;
    private Integer mobileno;
    private String orgName;

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
     * @return the org_position
     */
    public String getOrg_position() {
        return org_position;
    }

    /**
     * @param org_position the org_position to set
     */
    public void setOrg_position(String org_position) {
        this.org_position = org_position;
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
     * @return the mobileno
     */
    public Integer getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno the mobileno to set
     */
    public void setMobileno(Integer mobileno) {
        this.mobileno = mobileno;
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
