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
public class ReportMagnitudeEntity {
    private int offeredanswer_id;
    private String community_name;
    private double percent_change;

    /**
     * @return the offeredanswer_id
     */
    public int getOfferedanswer_id() {
        return offeredanswer_id;
    }

    /**
     * @param offeredanswer_id the offeredanswer_id to set
     */
    public void setOfferedanswer_id(int offeredanswer_id) {
        this.offeredanswer_id = offeredanswer_id;
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
     * @return the percent_change
     */
    public double getPercent_change() {
        return percent_change;
    }

    /**
     * @param percent_change the percent_change to set
     */
    public void setPercent_change(double percent_change) {
        this.percent_change = percent_change;
    }
    
    
}
