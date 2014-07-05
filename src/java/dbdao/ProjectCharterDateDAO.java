/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import Utilities.Year;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ProjectCharterDateEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ProjectCharterDateDAO extends QueryTemplate {
    
    public List<ProjectCharterDateEntity> getProjectDate() {
        setQuery("SELECT * FROM project_charter_date");

        List<ProjectCharterDateEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    public ProjectCharterDateEntity getProjectDate(int project_id) {
        setQuery("SELECT * FROM project_charter_date WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        
        List<ProjectCharterDateEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    public boolean setDateConfirmed(int project_id, Date date_confirmed){
        setQuery("UPDATE project_charter_date  SET date_confirmed = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date_confirmed);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateOngoing(int project_id, Date date_ongoing){
        setQuery("UPDATE project_charter_date  SET date_ongoing = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date_ongoing);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateOngoing(int project_id){
        setQuery("UPDATE project_charter_date  SET date_ongoing = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + Year.getCurrentDateinDate());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateTargetImplement(int project_id, Date date_target_implement){
        setQuery("UPDATE project_charter_date  SET date_target_implement = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date_target_implement);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateImplemented(int project_id, Date date_implemented){
        setQuery("UPDATE project_charter_date  SET date_implemented = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date_implemented);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
     public boolean setDateImplemented(int project_id){
        setQuery("UPDATE project_charter_date  SET date_implemented = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + Year.getCurrentDateinDate());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateClosed(int project_id, Date date_closed){
        setQuery("UPDATE project_charter_date  SET date_closed = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date_closed);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateClosed(int project_id){
        setQuery("UPDATE project_charter_date  SET date_closed = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + Year.getCurrentDateinDate());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateCancelled(int project_id, Date date_cancelled){
        setQuery("UPDATE project_charter_date  SET date_cancelled = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date_cancelled);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    public boolean setDateCancelled(int project_id){
        setQuery("UPDATE project_charter_date  SET date_cancelled = ? WHERE project_id = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + Year.getCurrentDateinDate());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ProjectCharterDateEntity entity = new ProjectCharterDateEntity();
        try {
            entity.setProject_id(rs.getInt("project_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_confirmed(rs.getDate("date_confirmed"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_ongoing(rs.getDate("date_ongoing"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_target_implement(rs.getDate("date_target_implement"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_implemented(rs.getDate("date_implemented"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_closed(rs.getDate("date_closed"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_cancelled(rs.getDate("date_cancelled"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
