/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.QueryTemplate;
import dbdao.templates.KeyValuePair;
import dbentities.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UserEntityDAO extends QueryTemplate {

    //Get all user data
    public UserEntity getUserDetails() {
        setQuery("SELECT id, username, password, name, description  \n"
                + "FROM users inner join studentorg on users.org_id = studentorg.id;");

        List<UserEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else if (results != null && results.isEmpty()) {
            return null;
        } else {
            return null;
        }
    }

    //Get User from username and password
    public UserEntity getUserDetails(String username, String password) {
        setQuery("SELECT id, username, password, name, description  \n"
                + "FROM users inner join studentorg on users.org_id = studentorg.id\n"
                + "WHERE username = ? and password = ?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(""+username);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(""+password);
        getParameters().add(onePair);

        List<UserEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else if (results != null && results.isEmpty()) {
            return null;
        } else {
            return null;
        }
    }
    
    //Get User from username
    public UserEntity getUserDetails(String username) {
        setQuery("SELECT id, username, password, name, description  \n"
                + "FROM users inner join studentorg on users.org_id = studentorg.id\n"
                + "WHERE username = ?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(""+username);
        getParameters().add(onePair);

        List<UserEntity> results = executeQuery();

        if (results != null && !results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    public List<UserEntity> getCOSCAAccounts() {
        setQuery("SELECT id, username, password, name, description  \n"
                + "FROM users inner join studentorg on users.org_id = studentorg.id\n"
                + "WHERE users.org_id = 1;");

        List<UserEntity> results = executeQuery();

        if (results != null && !results.isEmpty()) {
            return results;
        } else {
            return null;
        }
    }
    
    public List<UserEntity> getSOrgAccounts() {
        setQuery("SELECT id, username, password, name, description  \n"
                + "FROM users inner join studentorg on users.org_id = studentorg.id\n"
                + "WHERE users.org_id > 1;");

        List<UserEntity> results = executeQuery();

        if (results != null && !results.isEmpty()) {
            return results;
        } else {
            return null;
        }
    }
    
    public boolean insertUser(int orgId, String user, String pass) {
        setQuery("INSERT INTO users VALUE (?, ?, ?)");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + user);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + pass);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + orgId);
        getParameters().add(onePair);

        return executeUpdate();
    }
    
    public boolean editPass(String user, String pass) {
        setQuery("UPDATE users\n" +
                "SET password = ?\n" +
                "WHERE username=?;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + pass);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + user);
        getParameters().add(onePair);

        return executeUpdate();
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        UserEntity entity = new UserEntity();
        try {
            entity.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setUsername(rs.getString("username"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPassword(rs.getString("password"));
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
