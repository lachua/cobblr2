/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ProjectCharterTargetEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ProjectCharterTargetDAO extends QueryTemplate {
    //Get default project charter of type
    public List<ProjectCharterTargetEntity> getCharters(int community_id, String typeOfProject) {
        setQuery("SELECT * \n" +
                "FROM (\n" +
                "	SELECT *\n" +
                "		FROM project_charter pc\n" +
                "		JOIN project_charter_date pcd\n" +
                "			ON pc.id = pcd.project_id\n" +
                "		WHERE type = ?\n" +
                "			AND community_id = ?\n" +
                "			AND status != 6\n" +
                "		ORDER BY date_created desc\n" +
                "		Limit 3) pc\n" +
                "RIGHT JOIN project_target pt\n" +
                "	ON pc.id = pt.project_id\n" +
                "WHERE pc.id IS NOT NULL");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + typeOfProject);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        List<ProjectCharterTargetEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ProjectCharterTargetEntity entity = new ProjectCharterTargetEntity();
        try {
            entity.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_id(rs.getInt("community_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPreparedby(rs.getString("preparedby"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setObjectives(rs.getString("objectives"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setObjectives(rs.getString("objectives"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setScope(rs.getString("scope"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setRequirements(rs.getString("requirements"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setIstemplate(rs.getInt("istemplate"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStatus(rs.getInt("status"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setType(rs.getString("type"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_created(rs.getDate("date_created"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setMeetingdate(rs.getDate("meetingdate"));
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
        try {
            entity.setTarget_participant_num(rs.getInt("target_participant_num"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCancel_reason(rs.getString("cancel_reason"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
