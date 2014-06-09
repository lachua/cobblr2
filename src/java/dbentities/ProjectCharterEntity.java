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
public class ProjectCharterEntity {
    private Integer id;
    private Integer community_id;
    private String title;
    private String description;
    private String preparedby;
    private String objectives;
    private String scope;
    private String requirements;
    private Integer istemplate;
    private String status;
    private String type;

    public ProjectCharterEntity() {
    }

    public ProjectCharterEntity(Integer community_id, String title, String description, String preparedby, String objectives, String scope, String requirements, String type) {
        this.community_id = community_id;
        this.title = title;
        this.description = description;
        this.preparedby = preparedby;
        this.objectives = objectives;
        this.scope = scope;
        this.requirements = requirements;
        this.type = type;
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the community_id
     */
    public Integer getCommunity_id() {
        return community_id;
    }

    /**
     * @param community_id the community_id to set
     */
    public void setCommunity_id(Integer community_id) {
        this.community_id = community_id;
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
     * @return the preparedby
     */
    public String getPreparedby() {
        return preparedby;
    }

    /**
     * @param preparedby the preparedby to set
     */
    public void setPreparedby(String preparedby) {
        this.preparedby = preparedby;
    }

    /**
     * @return the objectives
     */
    public String getObjectives() {
        return objectives;
    }

    /**
     * @param objectives the objectives to set
     */
    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    /**
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return the requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * @param requirements the requirements to set
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * @return the istemplate
     */
    public Integer getIstemplate() {
        return istemplate;
    }

    /**
     * @param istemplate the istemplate to set
     */
    public void setIstemplate(Integer istemplate) {
        this.istemplate = istemplate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    
}
