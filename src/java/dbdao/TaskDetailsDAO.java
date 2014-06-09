/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ProjectTaskEntity;
import dbentities.ResourceDirectoryEntity;
import dbentities.TaskDetailsEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class TaskDetailsDAO extends QueryTemplate {

    //Get pending project and all other detail
    public List<TaskDetailsEntity> getAllTask(int project_id, String resource_type) {
        setQuery("select a.id, proj_id, contact_id, title, startdate, enddate, completed, targetcount, currentcount, unit, a.resource_type, a.description as org_description, firstname, lastname, mi, organizationname, address, b.description as supply_description, ispublic, mobile, email, phone "
                + "from "
                + "	(SELECT pt.id, proj_id, contact_id, title, startdate, enddate, completed, targetcount, currentcount, unit, pt.resource_type, description  "
                + "	FROM project_tasks pt  "
                + "	left join contact_pledge cp on pt.id = cp.task_id "
                + "	where pt.proj_id = ? and pt.resource_type = ? ) a "
                + "left join resource_directory b "
                + "on a.contact_id = b.id"
                + " group by title");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource_type);
        getParameters().add(onePair);

        List<TaskDetailsEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //Get pending project and all other detail
    public List<TaskDetailsEntity> getTask(int task_id) {
        setQuery("select b.id, a.id, proj_id, contact_id, title, startdate, enddate, completed, targetcount, currentcount, unit, a.resource_type, a.description as org_description, firstname, lastname, mi, organizationname, address, b.description as supply_description, ispublic, mobile, email, phone \n"
                + "                from \n"
                + "                	(SELECT pt.id, proj_id, contact_id, title, startdate, enddate, completed, targetcount, currentcount, unit, pt.resource_type, description  \n"
                + "                	FROM project_tasks pt  \n"
                + "                	left join contact_pledge cp on pt.id = cp.task_id \n"
                + "                	where pt.id = ? ) a \n"
                + "                right join resource_directory b \n"
                + "                on a.contact_id = b.id\n"
                + "where a.id is not null");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + task_id);
        getParameters().add(onePair);

        List<TaskDetailsEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //Get pending project and all other detail
    public List<TaskDetailsEntity> getAllDoctorsSummary(int project_id, String resource_type) {
        setQuery("select a.id, proj_id, contact_id, title, startdate, enddate, completed, targetcount, currentcount, unit, a.resource_type, a.description as org_description, firstname, lastname, mi, organizationname, address, b.description as supply_description, ispublic, mobile, email, phone "
                + "from "
                + "	(SELECT pt.id, proj_id, contact_id, title, startdate, enddate, completed, targetcount, currentcount, unit, pt.resource_type, description  "
                + "	FROM project_tasks pt  "
                + "	left join contact_pledge cp on pt.id = cp.task_id "
                + "	where pt.proj_id = ? and pt.resource_type = ? ) a "
                + "left join resource_directory b "
                + "on a.contact_id = b.id "
                + "group by title;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource_type);
        getParameters().add(onePair);

        List<TaskDetailsEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //Get pending project and all other detail
    public boolean addProfessional(int task_id, String title, ResourceDirectoryEntity resource) {

        setQuery("INSERT INTO resource_directory (firstname, lastname, mi, "
                + "organizationname, address, description, ispublic, mobile, email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

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

        Boolean addDB = executeUpdate();

        if (addDB) {
            ResourceDirectoryDAO resourceDAO = new ResourceDirectoryDAO();
            int size = resourceDAO.getAllResourceDirectory().size();
            int resourceID = resourceDAO.getAllResourceDirectory().get(size - 1).getId();

            setQuery("INSERT INTO contact_pledge "
                    + "(task_id, contact_id, resource_type, description) "
                    + "VALUES (?, ?, ?, ?);");

            getParameters().clear();
            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + task_id);
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + resourceID);
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + ProjectTaskDAO.MEDICAL_PROFESSIONAL);
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + title);
            getParameters().add(onePair);

            addDB = executeUpdate();

            if (addDB) {
                ProjectTaskDAO taskDAO = new ProjectTaskDAO();
                ProjectTaskEntity task = taskDAO.getTask(task_id);
                task.setCurrentcount(task.getCurrentcount() + 1);
                taskDAO = new ProjectTaskDAO();
                addDB = taskDAO.updateTask(task);
            }
        }

        return addDB;
    }

    //Get pending project and all other detail
    public boolean deleteProfessional(int task_id, int contact_id) {

        setQuery("DELETE FROM contact_pledge WHERE task_id= ? and contact_id=?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + task_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + contact_id);
        getParameters().add(onePair);

        Boolean addDB = executeUpdate();
        
        if (addDB) {
            ProjectTaskDAO taskDAO = new ProjectTaskDAO();
            ProjectTaskEntity task = taskDAO.getTask(task_id);
            task.setCurrentcount(task.getCurrentcount() - 1);
            taskDAO = new ProjectTaskDAO();
            addDB = taskDAO.updateTask(task);
        }
        
        return addDB;
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        TaskDetailsEntity entity = new TaskDetailsEntity();
        try {
            entity.setTask_id(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setProj_id(rs.getInt("proj_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setContact_id(rs.getInt("contact_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStartdate(rs.getDate("startdate"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setEnddate(rs.getDate("enddate"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCompleted(rs.getInt("completed"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTargetcount(rs.getInt("targetcount"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCurrentcount(rs.getInt("currentcount"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setUnit(rs.getString("unit"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setResource_type(rs.getString("resource_type"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrg_description(rs.getString("org_description"));
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
            entity.setSupply_description(rs.getString("supply_description"));
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
