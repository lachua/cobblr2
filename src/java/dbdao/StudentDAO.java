/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ProjectCharterEntity;
import dbentities.StudentEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class StudentDAO extends QueryTemplate {

    //Get default project charter of type
    public boolean isExisting(int idno, int org_id) {
        setQuery("SELECT * FROM healthdb.students where idno = ? and org_id = ?");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + idno);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        List<ProjectCharterEntity> results = executeQuery();

        if (results.size() > 0 ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        StudentEntity entity = new StudentEntity();
        try {
            entity.setIdno(rs.getInt("idno"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrg_id(rs.getInt("org_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setFirstname(rs.getString("firstname"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setLastname(rs.getString("lastname"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrg_position(rs.getString("org_position"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setEmail(rs.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setHomeno(rs.getString("homeno"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setMobileno(rs.getString("mobileno"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return entity;
    }
}
