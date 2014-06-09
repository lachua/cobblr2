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
public class SurveyEntity {
    private int id;
    private String title;
    private String description;
    private Calendar  date_created;
    private int is_default; //0 if false, 1 if true
    
    public SurveyEntity(){
        id = -1;
        description = "No Description Available";
        date_created = Calendar.getInstance();
        is_default = 0;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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

    /**
     * @return the is_default
     */
    public int getIs_default() {
        return is_default;
    }

    /**
     * @param is_default the is_default to set
     */
    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }
    
}
