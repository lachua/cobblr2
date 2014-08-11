/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import static dbdao.templates.QueryTemplate.df;
import dbentities.ProjectTaskEntity;
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
public class ProjectTaskDAO extends QueryTemplate {
    //    private int id;
//    private int proj_id;
//    private String title;
//    private Calendar startdate;
//    private Calendar enddate;
//    private int completed;
//    private int targetcount;
//    private int currentcount;
//    private String unit;
//    private String resource_type;

    public static final String MEDICINE = "medicine";
    public static final String EQUIPMENT = "equipment";
    public static final String MEDICAL_PROFESSIONAL = "medical profesional";
    public static final String PRE_ACTS = "pre-acts";
    public static final String SPEAKER = "speaker";

    public boolean setCompleted(int project_id, String resource_type, boolean isCompleted) {
        int completed;
        if (isCompleted) {
            completed = 1;
        } else {
            completed = 0;
        }

        setQuery("UPDATE project_tasks SET completed=? WHERE proj_id = ? AND resource_type = ?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + completed);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + resource_type);
        getParameters().add(onePair);

        return executeUpdate();

    }

    public boolean insertTask(ProjectTaskEntity entity) {
        return insertTask(entity.getProj_id(), entity.getTitle(), entity.getStartdate(), entity.getEnddate(), entity.getCompleted(), entity.getTargetcount(), entity.getCurrentcount(), entity.getUnit(), entity.getResource_type());
    }

    public boolean insertTask(int proj_id, String title, Date startdate, Date enddate, int completed, int targetcount, int currentcount, String unit, String resource_type) {
        setQuery("insert into project_tasks (proj_id, title, startdate, enddate, completed, targetcount, currentcount, unit, resource_type) values (?,?,?,?,?,?,?,?,?)");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + proj_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(title);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(startdate.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(enddate.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + completed);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + targetcount);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + currentcount);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(unit);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(resource_type);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public boolean updateTask(ProjectTaskEntity entity) {
        return updateTask(entity.getId(), entity.getTitle(), entity.getStartdate(), entity.getEnddate(), entity.getCompleted(), entity.getTargetcount(), entity.getCurrentcount(), entity.getUnit(), entity.getResource_type());
    }

    public boolean updateTask(int id, String title, Date startdate, Date enddate, int completed, int targetcount, int currentcount, String unit, String resource_type) {
        setQuery("update project_tasks set title = ?, startdate = ?, enddate = ?, completed = ?, targetcount = ?, currentcount = ?, unit = ?, resource_type = ? where id = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(title);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(startdate.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(enddate.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + completed);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + targetcount);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + currentcount);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(unit);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(resource_type);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public boolean deletePledgeNTask(int id) {
        setQuery("delete from contact_pledge where task_id=?");

        KeyValuePair onePair;
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);

        Boolean addDB = executeUpdate();

        if (addDB) {
            setQuery("delete from project_tasks where id = ?");

            getParameters().clear();
            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + id);
            getParameters().add(onePair);
            addDB = executeUpdate();
        }
        return addDB;
    }

    public boolean deleteTask(int id) {
        setQuery("delete from project_tasks where id = ?");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);
        Boolean addDB = executeUpdate();
        return addDB;
    }

    public ProjectTaskEntity getTask(int id) {
        setQuery("select * from project_tasks where id = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);

        List<ProjectTaskEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else {
            return null;
        }
    }

    public List<ProjectTaskEntity> getAllTasksForProject(int proj_id) {
        setQuery("select * from project_tasks where proj_id = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + proj_id);
        getParameters().add(onePair);

        List<ProjectTaskEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<ProjectTaskEntity> getAllTasksOfTypeForProject(int proj_id, String resource_type) {
        setQuery("select * from project_tasks where proj_id = ? and resource_type = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + proj_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(resource_type);
        getParameters().add(onePair);

        List<ProjectTaskEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    public ProjectTaskEntity getPreactsTaskForProject(int proj_id) {
        setQuery("select * from project_tasks where proj_id = ? and resource_type = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + proj_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("pre-acts");
        getParameters().add(onePair);

        List<ProjectTaskEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        ProjectTaskEntity entity = new ProjectTaskEntity();

        try {
            entity.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setProj_id(rs.getInt("proj_id"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStartdate(rs.getDate("startdate"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setEnddate(rs.getDate("enddate"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCompleted(rs.getInt("completed"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTargetcount(rs.getInt("targetcount"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCurrentcount(rs.getInt("currentcount"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setUnit(rs.getString("unit"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setResource_type(rs.getString("resource_type"));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTaskDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
