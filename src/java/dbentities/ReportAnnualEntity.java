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
public class ReportAnnualEntity {
    private int problem_id;
    private String problem;
    private int project_id;
    private String project_title;
    private String community_name;
    private int participant_count;
    private Date date_target_implement;

    /**
     * @return the problem_id
     */
    public int getProblem_id() {
        return problem_id;
    }

    /**
     * @param problem_id the problem_id to set
     */
    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    /**
     * @return the problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * @return the project_id
     */
    public int getProject_id() {
        return project_id;
    }

    /**
     * @param project_id the project_id to set
     */
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    /**
     * @return the project_title
     */
    public String getProject_title() {
        return project_title;
    }

    /**
     * @param project_title the project_title to set
     */
    public void setProject_title(String project_title) {
        this.project_title = project_title;
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
     * @return the participant_count
     */
    public int getParticipant_count() {
        return participant_count;
    }

    /**
     * @param participant_count the participant_count to set
     */
    public void setParticipant_count(int participant_count) {
        this.participant_count = participant_count;
    }

    /**
     * @return the date_target_implement
     */
    public Date getDate_target_implement() {
        return date_target_implement;
    }

    /**
     * @param date_target_implement the date_target_implement to set
     */
    public void setDate_target_implement(Date date_target_implement) {
        this.date_target_implement = date_target_implement;
    }
}
