/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ProjectTargetEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ProjectTargetDAO extends QueryTemplate{
    
    //Get all data
    public List<ProjectTargetEntity> getAllProjectTarget() {
        setQuery("SELECT project_id, a.offeredanswer_id, answertext \n" +
                    "FROM project_target a \n" +
                    "Join offeredanswer b \n" +
                    "ON a.offeredanswer_id = b.offeredanswer_id");

        List<ProjectTargetEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    //Get all data
    public ProjectTargetEntity getAllProjectTarget(int project_id) {
        setQuery("SELECT project_id, a.offeredanswer_id, answertext \n" +
                    "FROM project_target a \n" +
                    "Join offeredanswer b \n" +
                    "ON a.offeredanswer_id = b.offeredanswer_id\n" +
                    "where project_id = ?");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+project_id);
        getParameters().add(onePair);
        
        List<ProjectTargetEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    //Get all data
    public boolean insertProjectTarget(int project_id, int offeredanswer_id) {
        setQuery("INSERT INTO project_target VALUES (?,?)");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+project_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+offeredanswer_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        ProjectTargetEntity entity = new ProjectTargetEntity();
        
        try {
            entity.setProject_id(rs.getInt("project_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAnswertext(rs.getString("answertext"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
    
}
