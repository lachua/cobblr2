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
public class CommunityMembersEntity {
    private Integer person_id;
    private Integer family_id;
    private String givenname;
    private Integer age;
    private String gender;
    private String position;

    /**
     * @return the person_id
     */
    public Integer getPerson_id() {
        return person_id;
    }

    /**
     * @param person_id the person_id to set
     */
    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    /**
     * @return the family_id
     */
    public Integer getFamily_id() {
        return family_id;
    }

    /**
     * @param family_id the family_id to set
     */
    public void setFamily_id(Integer family_id) {
        this.family_id = family_id;
    }

    /**
     * @return the givenname
     */
    public String getGivenname() {
        return givenname;
    }

    /**
     * @param givenname the givenname to set
     */
    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

}
