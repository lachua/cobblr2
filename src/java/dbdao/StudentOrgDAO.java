/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.StudentOrgEntity;
import dbentities.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class StudentOrgDAO extends QueryTemplate{
    //Get User from username
    public List<StudentOrgEntity> getUserDetails() {
        setQuery("select * from studentorg AND isactive = 1;");

        List<StudentOrgEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    //Get User from username
    public StudentOrgEntity getUserDetails(int id) {
        setQuery("select * from studentorg WHERE id = ? AND isactive = 1;;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);
        
        List<StudentOrgEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    //Get User from username
    public List<StudentOrgEntity> getOrgName(String org) {
        setQuery("select * from studentorg where name = ? AND isactive = 1;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + org);
        getParameters().add(onePair);
        
        List<StudentOrgEntity> results = executeQuery();

        if (results != null && !results.isEmpty()) {
            return results;
        } else {
            return null;
        }
    }
    
    public int getLastId() {
        setQuery("select * from studentorg order by id desc");

        List<StudentOrgEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getId();
        } else {
            return -1;
        }
    }
    
    public List<StudentOrgEntity> getOrgsUnder(String org) {
        setQuery("SELECT * FROM studentorg WHERE description = ? AND isactive = 1;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + org);
        getParameters().add(onePair);

        List<StudentOrgEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    public boolean insertOrg(int newId, String orgName, String orgType) {
        setQuery("INSERT INTO studentorg VALUE (?, ?, ?, 1)");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + newId);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + orgName);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + orgType);
        getParameters().add(onePair);

        return executeUpdate();
    }
    
    public boolean updateOrg(int newId, String orgName) {
        setQuery("UPDATE studentorg SET name = ? WHERE id = ? AND isactive = 1");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + orgName);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + newId);
        getParameters().add(onePair);

        return executeUpdate();
    }
    
    public boolean inactivateOrg(int newId) {
        
        UserEntityDAO dao = new UserEntityDAO();
        boolean addDB = dao.deleteOrg(newId);
        
        if(addDB){
            setQuery("UPDATE studentorg SET isactive = 0 WHERE id = ? AND isactive = 1");

            KeyValuePair onePair;

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + newId);
            getParameters().add(onePair);

            return executeUpdate();
        }
        
        return addDB;
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        StudentOrgEntity entity = new StudentOrgEntity();
        try {
            entity.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
