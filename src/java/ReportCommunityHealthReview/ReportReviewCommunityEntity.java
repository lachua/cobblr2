/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportCommunityHealthReview;

import dbentities.AnswerEntity;
import dbentities.AnswerTallyEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ReportReviewCommunityEntity {

    private int year;
    private int community_id;
    private String community_name;
    private int numFamilies;
    private int numSurveyed;
    private List<AnswerTallyEntity> topTenDiseasesList;
    private List<AnswerTallyEntity> topThreeNeeds;

    public ReportReviewCommunityEntity() {
        this.year = 0;
        this.community_id = 0;
        this.community_name = "name";
        this.numFamilies = 0;
        this.numSurveyed = 0;
        this.topTenDiseasesList = new ArrayList();
        this.topThreeNeeds = new ArrayList();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public int getNumFamilies() {
        return numFamilies;
    }

    public void setNumFamilies(int numFamilies) {
        this.numFamilies = numFamilies;
    }

    public List<AnswerTallyEntity> getTopTenDiseasesList() {
        return topTenDiseasesList;
    }

    public void setTopTenDiseasesList(List<AnswerTallyEntity> topTenDiseasesList) {
        this.topTenDiseasesList = topTenDiseasesList;
    }

    public List<AnswerTallyEntity> getTopThreeNeeds() {
        return topThreeNeeds;
    }

    public void setTopThreeNeeds(List<AnswerTallyEntity> topThreeNeeds) {
        this.topThreeNeeds = topThreeNeeds;
    }

    public int getNumSurveyed() {
        return numSurveyed;
    }

    public void setNumSurveyed(int numSurveyed) {
        this.numSurveyed = numSurveyed;
    }
}
