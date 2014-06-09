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
public class StudentEntity {
    private Integer idno;
    private Integer org_id;
    private String firstname;
    private String lastname;
    private String org_position;
    private String email;
    private String homeno;
    private String mobileno;

    /**
     * @return the idno
     */
    public Integer getIdno() {
        return idno;
    }

    /**
     * @param idno the idno to set
     */
    public void setIdno(Integer idno) {
        this.idno = idno;
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
     * @return the homeno
     */
    public String getHomeno() {
        return homeno;
    }

    /**
     * @param homeno the homeno to set
     */
    public void setHomeno(String homeno) {
        this.homeno = homeno;
    }

    /**
     * @return the mobileno
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno the mobileno to set
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
