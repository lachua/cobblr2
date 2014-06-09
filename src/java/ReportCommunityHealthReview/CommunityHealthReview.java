/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportCommunityHealthReview;

import dbentities.AnswerTallyEntity;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author user
 */
public class CommunityHealthReview {

    private int community_id;
    private int currentYear;
    private ReportReviewCommunityEntity communityCurrent;
    private ReportReviewCommunityEntity communityPast;
    private List<ReportReviewProjectEntity> projectsImplemented;
    private HashMap<Integer, Double> illnessPercentChange; //Integer is offeredanswer_id (illness), double is %

    public CommunityHealthReview(int community_id, int currentYear) {
        this.community_id = community_id;
        this.currentYear = currentYear;
        this.illnessPercentChange = new HashMap();

        ReportReviewCommunityAnswers chrDAO = new ReportReviewCommunityAnswers();
        ReportReviewCommunityInfoDAO commDAO = new ReportReviewCommunityInfoDAO();

        String communityName = commDAO.getCommunityName(community_id);

        //Initialize values for community for current year
        this.communityCurrent = new ReportReviewCommunityEntity();

        communityCurrent.setCommunity_id(community_id);
        communityCurrent.setCommunity_name(communityName);
        communityCurrent.setNumFamilies(chrDAO.countFamiliesSurveyed(1, community_id, currentYear));
        chrDAO = new ReportReviewCommunityAnswers();
        communityCurrent.setNumSurveyed(chrDAO.countPersonsSurveyed(2, community_id, currentYear));

        //top illnesses for current year (Survey 2, Question id 35)
        chrDAO = new ReportReviewCommunityAnswers();
        communityCurrent.setTopTenDiseasesList(chrDAO.tallyPersonAnswers(2, community_id, currentYear, 35, 1000));

        //top needs for current year (Survey 1, Question id 8)
        chrDAO = new ReportReviewCommunityAnswers();
        communityCurrent.setTopThreeNeeds(chrDAO.tallyCommunityAnswers(1, community_id, currentYear, 8, 3));



        //Initialize values for community for past year
        this.communityPast = new ReportReviewCommunityEntity();
        chrDAO = new ReportReviewCommunityAnswers();
        
        communityPast.setCommunity_id(community_id);
        communityPast.setCommunity_name(communityName);
        communityPast.setNumFamilies(chrDAO.countFamiliesSurveyed(1, community_id, currentYear - 1));
        chrDAO = new ReportReviewCommunityAnswers();
        communityPast.setNumSurveyed(chrDAO.countPersonsSurveyed(2, community_id, currentYear - 1));
        
        //top illnesses for past year (Survey 2, Question id 35)
        chrDAO = new ReportReviewCommunityAnswers();
        communityPast.setTopTenDiseasesList(chrDAO.tallyPersonAnswers(2, community_id, currentYear - 1, 35, 1000));

        //top needs for past year (Survey 1, Question id 8)
        chrDAO = new ReportReviewCommunityAnswers();
        communityPast.setTopThreeNeeds(chrDAO.tallyCommunityAnswers(1, community_id, currentYear - 1, 8, 3));

        //Projects implemented for BOTH years
        ReportReviewProjectDAO rrpDAO = new ReportReviewProjectDAO();
        this.projectsImplemented = rrpDAO.getProjectsImplemented(community_id, currentYear);

        calculatePercentChangeIllness();
    }

    private void calculatePercentChangeIllness() {

        if (this.communityCurrent.getTopTenDiseasesList() != null && this.communityPast.getTopTenDiseasesList() != null) {

            List<AnswerTallyEntity> tempCurrIllnessList = this.communityCurrent.getTopTenDiseasesList();

            loop1:
            for (AnswerTallyEntity atPast : communityPast.getTopTenDiseasesList()) {

                loop2:
                for (AnswerTallyEntity atCurr : tempCurrIllnessList) {
                    if (atPast.getOfferedanswer_id() == atCurr.getOfferedanswer_id()) {

                        int change = atPast.getAnswercount() - atCurr.getAnswercount();
                        Double percentchange = ((double) change / (double) atPast.getAnswercount()) * 100;

                        this.illnessPercentChange.put(atCurr.getOfferedanswer_id(), percentchange);
                        break loop2;
                    }
                }

            }
        }

    }

    public List<ReportReviewProjectEntity> getProjectsImplemented() {
        return projectsImplemented;
    }

    public void setProjectsImplemented(List<ReportReviewProjectEntity> projectsImplemented) {
        this.projectsImplemented = projectsImplemented;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public ReportReviewCommunityEntity getCommunityCurrent() {
        return communityCurrent;
    }

    public void setCommunityCurrent(ReportReviewCommunityEntity communityCurrent) {
        this.communityCurrent = communityCurrent;
    }

    public ReportReviewCommunityEntity getCommunityPast() {
        return communityPast;
    }

    public void setCommunityPast(ReportReviewCommunityEntity communityPast) {
        this.communityPast = communityPast;
    }

    public HashMap<Integer, Double> getIllnessPercentChange() {
        return illnessPercentChange;
    }

    public void setIllnessPercentChange(HashMap<Integer, Double> illnessPercentChange) {
        this.illnessPercentChange = illnessPercentChange;
    }
}
