/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ResourceDirectoryEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ResourceDirectoryDAO extends QueryTemplate {

    public List<ResourceDirectoryEntity> getAllResourceDirectory() {
        setQuery("select * from resource_directory");

        List<ResourceDirectoryEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<ResourceDirectoryEntity> getAllMedicalResourceDirectory() {
        setQuery("select * from resource_directory where isPublic = 1");

        List<ResourceDirectoryEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<ResourceDirectoryEntity> getAllMaterialResourceDirectory() {
        setQuery("select * from resource_directory where isPublic = 2");

        List<ResourceDirectoryEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public boolean insertDirectory(ResourceDirectoryEntity resource) {
        setQuery("INSERT INTO resource_directory (firstname, lastname, mi, organizationname, address, description, ispublic, mobile, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getFirstname());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getLastname());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getMi());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getOrganizationname());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getAddress());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getDescription());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + resource.getIspublic());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getMobile());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource.getEmail());
        getParameters().add(onePair);

        return executeUpdate();
    }
    
    public boolean deleteDirectory(int resource_id) {
        setQuery("DELETE FROM resource_directory WHERE id = ?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + resource_id);
        getParameters().add(onePair);

        
        return executeUpdate();
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        ResourceDirectoryEntity entity = new ResourceDirectoryEntity();
        try {
            entity.setId(rs.getInt("id"));
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
            entity.setMi(rs.getString("mi"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrganizationname(rs.getString("organizationname"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAddress(rs.getString("address"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setIspublic(rs.getInt("ispublic"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setMobile(rs.getString("mobile"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setEmail(rs.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPhone(rs.getString("phone"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
