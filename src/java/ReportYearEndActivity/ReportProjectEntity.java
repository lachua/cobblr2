/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportYearEndActivity;

import java.util.Calendar;

/**
 *
 * @author user
 */
public class ReportProjectEntity {

    private int project_id;
    private Calendar date_created;
    private Calendar meetingdate;
    private String projectTitle;
    private int owner_id;
    private String ownerName; //org or community name

    public ReportProjectEntity() {
        this.project_id = -1;
        this.date_created = Calendar.getInstance();
        this.meetingdate = Calendar.getInstance();
        this.projectTitle = "title";
        this.owner_id = -1;
        this.ownerName = "community or org name";
    }
    
    public Calendar getDate_created() {
        return date_created;
    }

    public void setDate_created(Calendar date_created) {
        this.date_created = date_created;
    }

    public Calendar getMeetingdate() {
        return meetingdate;
    }

    public void setMeetingdate(Calendar meetingdate) {
        this.meetingdate = meetingdate;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getOwnerName() {
        return ownerName;
    }

    
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    
    
}
