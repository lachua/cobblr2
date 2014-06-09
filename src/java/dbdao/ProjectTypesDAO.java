/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.QueryTemplate;
import dbentities.ProjectTypesEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ProjectTypesDAO extends QueryTemplate{
    //Get User from username
    public List<ProjectTypesEntity> getAllTypes() {
        setQuery("SELECT * FROM ref_projtypes;");

        List<ProjectTypesEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        ProjectTypesEntity entity = new ProjectTypesEntity();
        try {
            entity.setType(rs.getString("type"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
