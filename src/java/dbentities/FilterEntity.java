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
public class FilterEntity {
    private int community_id;
    private int total_community_members;
    private int total_affected;
    private double percent_affected;

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
     * @return the total_community_members
     */
    public int getTotal_community_members() {
        return total_community_members;
    }

    /**
     * @param total_community_members the total_community_members to set
     */
    public void setTotal_community_members(int total_community_members) {
        this.total_community_members = total_community_members;
    }

    /**
     * @return the total_affected
     */
    public int getTotal_affected() {
        return total_affected;
    }

    /**
     * @param total_affected the total_affected to set
     */
    public void setTotal_affected(int total_affected) {
        this.total_affected = total_affected;
    }

    /**
     * @return the percent_affected
     */
    public double getPercent_affected() {
        return percent_affected;
    }

    /**
     * @param percent_affected the percent_affected to set
     */
    public void setPercent_affected(double percent_affected) {
        this.percent_affected = percent_affected;
    }
}
