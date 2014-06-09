/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportCommunityHealthReview;

import java.util.Calendar;

/**
 *
 * @author user
 */
public class ReportReviewProjectEntity {
    private int project_id;
    private Calendar date_implemented;
    private String project_title;
    private String project_type;
    private int numParticipants;

    public ReportReviewProjectEntity() {
        this.project_id = 0;
        this.date_implemented = Calendar.getInstance();
        this.project_title = "title";
        this.project_type = "type";
        this.numParticipants = 0;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public Calendar getDate_implemented() {
        return date_implemented;
    }

    public void setDate_implemented(Calendar date_implemented) {
        this.date_implemented = date_implemented;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }
    
    
}
