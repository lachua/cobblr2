/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author user
 */
public class ProjectTaskEntity {
    private int id;
    private int proj_id;
    private String title;
    private Date startdate;
    private Date enddate;
    private int completed;
    private int targetcount;
    private int currentcount;
    private String unit;
    private String resource_type;

    public ProjectTaskEntity() {
        this.id = 0;
        this.proj_id = 0;
        this.title = null;
        this.startdate = Calendar.getInstance().getTime();
        this.enddate = Calendar.getInstance().getTime();
        this.completed = 0;
        this.targetcount = 0;
        this.currentcount = 0;
        this.unit = null;
        this.resource_type = null;
    }

    public ProjectTaskEntity(int id, int proj_id, String title, String description, Date startdate, Date enddate, int completed, int targetcount, int currentcount, String unit, String resource_type) {
        this.id = id;
        this.proj_id = proj_id;
        this.title = title;
        this.startdate = startdate;
        this.enddate = enddate;
        this.completed = completed;
        this.targetcount = targetcount;
        this.currentcount = currentcount;
        this.unit = unit;
        this.resource_type = resource_type;
    }
    
    public ProjectTaskEntity setPreActs(ProjectTaskEntity projectTask, int project_id) {
        projectTask.setProj_id(project_id);
        projectTask.setTitle("Pre-Activity Requirements");
        projectTask.setCompleted(0);
        projectTask.setUnit("Documents");
        projectTask.setResource_type("pre-acts");
        
        return projectTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProj_id() {
        return proj_id;
    }

    public void setProj_id(int proj_id) {
        this.proj_id = proj_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getTargetcount() {
        return targetcount;
    }

    public void setTargetcount(int targetcount) {
        this.targetcount = targetcount;
    }

    public int getCurrentcount() {
        return currentcount;
    }

    public void setCurrentcount(int currentcount) {
        this.currentcount = currentcount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }
}