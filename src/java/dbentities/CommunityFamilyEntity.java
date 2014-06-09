/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

import java.util.Calendar;

/**
 *
 * @author user
 */
public class CommunityFamilyEntity {
    private int id;
    private String surname;
    private String address;
    private int years_residency;
    private String religion_father;
    private String religion_mother;
    private String origin_father;
    private String origin_mother;
    private String type_of_family;
    private int community;
    private Calendar date_created;

    public CommunityFamilyEntity() {
        this.id = 0;
        this.surname = "default";
        this.address = "default";
        this.years_residency = 0;
        this.religion_father = "default";
        this.religion_mother = "default";
        this.origin_father = "default";
        this.origin_mother = "default";
        this.type_of_family = "default";
        this.community = 0;
        this.date_created = Calendar.getInstance();
    }
    
    public CommunityFamilyEntity(int id, String surname, String address, int years_residency, String religion_father, String religion_mother, String origin_father, String origin_mother, String type_of_family, int community, Calendar date_created) {
        this.id = id;
        this.surname = surname;
        this.address = address;
        this.years_residency = years_residency;
        this.religion_father = religion_father;
        this.religion_mother = religion_mother;
        this.origin_father = origin_father;
        this.origin_mother = origin_mother;
        this.type_of_family = type_of_family;
        this.community = community;
        this.date_created = date_created;
    }

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
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
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
     * @return the years_residency
     */
    public int getYears_residency() {
        return years_residency;
    }

    /**
     * @param years_residency the years_residency to set
     */
    public void setYears_residency(int years_residency) {
        this.years_residency = years_residency;
    }

    /**
     * @return the religion_father
     */
    public String getReligion_father() {
        return religion_father;
    }

    /**
     * @param religion_father the religion_father to set
     */
    public void setReligion_father(String religion_father) {
        this.religion_father = religion_father;
    }

    /**
     * @return the religion_mother
     */
    public String getReligion_mother() {
        return religion_mother;
    }

    /**
     * @param religion_mother the religion_mother to set
     */
    public void setReligion_mother(String religion_mother) {
        this.religion_mother = religion_mother;
    }

    /**
     * @return the origin_father
     */
    public String getOrigin_father() {
        return origin_father;
    }

    /**
     * @param origin_father the origin_father to set
     */
    public void setOrigin_father(String origin_father) {
        this.origin_father = origin_father;
    }

    /**
     * @return the origin_mother
     */
    public String getOrigin_mother() {
        return origin_mother;
    }

    /**
     * @param origin_mother the origin_mother to set
     */
    public void setOrigin_mother(String origin_mother) {
        this.origin_mother = origin_mother;
    }

    /**
     * @return the type_of_family
     */
    public String getType_of_family() {
        return type_of_family;
    }

    /**
     * @param type_of_family the type_of_family to set
     */
    public void setType_of_family(String type_of_family) {
        this.type_of_family = type_of_family;
    }

    /**
     * @return the community
     */
    public int getCommunity() {
        return community;
    }

    /**
     * @param community the community to set
     */
    public void setCommunity(int community) {
        this.community = community;
    }

    /**
     * @return the date_created
     */
    public Calendar getDate_created() {
        return date_created;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(Calendar date_created) {
        this.date_created = date_created;
    }
    
    
}
