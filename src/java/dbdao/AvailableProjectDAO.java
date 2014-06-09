/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.AvailableProjectEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class AvailableProjectDAO extends QueryTemplate {

    //Get available project and community detail
    public List<AvailableProjectEntity> getAllAvailableProjects() {
        setQuery("SELECT project_charter.id, title, description, preparedby, \n"
                + "objectives, scope, requirements, type, community_id, name, address \n"
                + "FROM project_charter JOIN community \n"
                + "ON project_charter.community_id = community.id \n"
                + "WHERE status = 0 ;");

        List<AvailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //Get available project and community detail
    public List<AvailableProjectEntity> getAllAvailableProjectsCommunity() {
        setQuery("SELECT project_charter.id, title, description, preparedby, \n"
                + "objectives, scope, requirements, type, community_id, name, address \n"
                + "FROM project_charter JOIN community \n"
                + "ON project_charter.community_id = community.id \n"
                + "WHERE status = 0\n"
                + "group by name");

        List<AvailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //Get available project and community detail for project_d
    public AvailableProjectEntity getAvailableProject(int project_id) {
        setQuery("SELECT project_charter.id, title, description, preparedby, \n"
                + "objectives, scope, requirements, type, community_id, name, address \n"
                + "FROM project_charter JOIN community \n"
                + "ON project_charter.community_id = community.id \n"
                + "WHERE status = 0 AND project_charter.id = ? ;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<AvailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        AvailableProjectEntity entity = new AvailableProjectEntity();
        try {
            entity.setProject_id(rs.getInt("id"));
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
            entity.setType(rs.getString("type"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_id(rs.getInt("community_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_name(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_address(rs.getString("address"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
