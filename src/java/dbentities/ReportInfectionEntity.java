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
public class ReportInfectionEntity {
    private int community_id;
    private String name;
    private int magnitude;
    private int total_respondents;
    private double percent;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the magnitude
     */
    public int getMagnitude() {
        return magnitude;
    }

    /**
     * @param magnitude the magnitude to set
     */
    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * @return the total_respondents
     */
    public int getTotal_respondents() {
        return total_respondents;
    }

    /**
     * @param total_respondents the total_respondents to set
     */
    public void setTotal_respondents(int total_respondents) {
        this.total_respondents = total_respondents;
    }

    /**
     * @return the percent
     */
    public double getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(double percent) {
        this.percent = percent;
    }
}
