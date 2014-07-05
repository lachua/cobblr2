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
public class AvailableProjectEntity{
    private Integer project_id;
    private String title;
    private String description;
    private String preparedby;
    private String objectives;
    private String scope;
    private String requirements;
    private String type;
    private Integer community_id;
    private String community_name;
    private String community_address;

    public AvailableProjectEntity() {
    }
    
    /**
     * @return the project_id
     */
    public Integer getProject_id() {
        return project_id;
    }

    /**
     * @param project_id the project_id to set
     */
    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
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
     * @return the community_address
     */
    public String getCommunity_address() {
        return community_address;
    }

    /**
     * @param community_address the community_address to set
     */
    public void setCommunity_address(String community_address) {
        this.community_address = community_address;
    }
    
    

}
