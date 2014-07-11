/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import Utilities.Year;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ProjectCharterEntity;
import dbentities.StudentEntity;
import dbentities.UnavailableProjectEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ProjectCharterDAO extends QueryTemplate {

    public static final int AVAILABLE = 0;
    public static final int PENDING = 1;
    public static final int ON_GOING = 2;
    public static final int IMPLMENTED = 3;
    public static final int ACCOMPLISHED = 4;
    public static final int COMFIRMED = 5;
    public static final int CANCELED = 6;

    //Get default project charter of type
    public ProjectCharterEntity getDefaultCharterTemplate(String typeOfProject) {
        setQuery("select * from project_charter where type = ? and istemplate = 1");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + typeOfProject);
        getParameters().add(onePair);

        List<ProjectCharterEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }

    //Get default project charter of type
    public Integer getLastId() {
        setQuery("select * from project_charter");

        List<ProjectCharterEntity> results = executeQuery();

        if (results != null) {
            return results.get(results.size()-1).getId();
        } else {
            return null;
        }
    }
    
    //Get charter for project
    public ProjectCharterEntity getProjectCharter(int project_id) {
        setQuery("select * from project_charter where id = ?");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<ProjectCharterEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    public boolean setOngoingDate(int id){
        setQuery("UPDATE project_charter SET date_ongoing =? WHERE id=?;");

        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + Year.getCurrentDate());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    //Get charter for project
    public boolean updateFullCharter(UnavailableProjectEntity fullCharter) {
        setQuery("UPDATE project_charter SET title=?, description=?, preparedby=?, objectives=?, scope=?, requirements=?, status='2' WHERE id=?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + fullCharter.getTitle());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + fullCharter.getDescription());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + fullCharter.getPreparedby());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + fullCharter.getObjectives());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + fullCharter.getScope());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + fullCharter.getRequirements());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + fullCharter.getProject_id());
        getParameters().add(onePair);
        
        ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
        project_date.setDateTargetImplement(fullCharter.getProject_id(), fullCharter.getMeetingdate());

        return executeUpdate();
    }

    //Disapprove Pending Project
    public boolean disapprovePendingProject(int project_id, int org_id) {
        setQuery("UPDATE project_charter SET status = 0, meetingdate = NULL WHERE id = ?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        executeUpdate();

        setQuery("DELETE FROM project_members WHERE project_id = ?;");

        getParameters().clear();
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        executeUpdate();

        setQuery("DELETE FROM org_projects WHERE org_id= ? and project_id= ?;");

        getParameters().clear();
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        return executeUpdate();
    }

    //Approve Pending Project
    public boolean reserveAvailableProject(int project_id, StudentEntity student, boolean isExisting) {
        boolean result = false;
        if (!isExisting) {
            setQuery("INSERT INTO students (idno, org_id, firstname, lastname, org_position, email, mobileno) VALUES (?, ?, ?, ?, ?, ?, ?);");

            KeyValuePair onePair;

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + student.getIdno());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + student.getOrg_id());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getFirstname());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getLastname());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getOrg_position());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getEmail());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getMobileno());
            getParameters().add(onePair);

            result = executeUpdate();
        } else {
            setQuery("UPDATE students SET firstname = ?, lastname = ?, org_position = ?, email = ?, mobileno = ? WHERE idno= ? and org_id = ?;");

            KeyValuePair onePair;

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getFirstname());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getLastname());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getOrg_position());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getEmail());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.STRING);
            onePair.setValue("" + student.getMobileno());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + student.getIdno());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + student.getOrg_id());
            getParameters().add(onePair);

            result = executeUpdate();
        }

        if (result) {
            setQuery("INSERT INTO org_projects (project_id, org_id, student_idno) VALUES (?,?,?);");

            KeyValuePair onePair;

            getParameters().clear();
            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + project_id);
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + student.getOrg_id());
            getParameters().add(onePair);

            onePair = new KeyValuePair();
            onePair.setKey(KeyValuePair.INT);
            onePair.setValue("" + student.getIdno());
            getParameters().add(onePair);

            result = executeUpdate();

            if (result) {
                setQuery("INSERT INTO project_members (project_id, stud_idno, role) VALUES (?,?,'Project Head');");

                getParameters().clear();
                onePair = new KeyValuePair();
                onePair.setKey(KeyValuePair.INT);
                onePair.setValue("" + project_id);
                getParameters().add(onePair);

                onePair = new KeyValuePair();
                onePair.setKey(KeyValuePair.INT);
                onePair.setValue("" + student.getIdno());
                getParameters().add(onePair);

                result = executeUpdate();

                if (result) {
                    setQuery("UPDATE project_charter SET status = 1, meetingdate = ? WHERE id = ?;");

                    getParameters().clear();
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, 2);
                    String date = sdf.format(cal.getTime());
                    
                    onePair = new KeyValuePair();
                    onePair.setKey(KeyValuePair.DATE);
                    onePair.setValue("" + date);
                    getParameters().add(onePair);
                    
                    onePair = new KeyValuePair();
                    onePair.setKey(KeyValuePair.INT);
                    onePair.setValue("" + project_id);
                    getParameters().add(onePair);

                    return executeUpdate();
                }
            }
        }
        return false;
    }

    //Approve Pending Project
    public boolean approvePendingProject(int project_id, Date date) {
        setQuery("UPDATE project_charter SET status = 5 WHERE id = ?;");

        KeyValuePair onePair;
        
        ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
        project_date.setDateConfirmed(project_id, date);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    //Edit Status of Project
    public boolean updateProjectStatus(int project_id, int status) {
        setQuery("UPDATE project_charter SET status = ? WHERE id = ?;");

        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + status);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        return executeUpdate();
    }
    
    //Edit Status of Project
    public boolean updateProjectStatusDate(int project_id, int status, Date date) {
        setQuery("UPDATE project_charter SET status = ?, meetingdate = ? WHERE id = ?;");

        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + status);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + df.format(date));
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        return executeUpdate();
    }

    //Create New Project
    public boolean createNewProject(ProjectCharterEntity initialCharter) {
        setQuery("INSERT INTO project_charter (community_id, title, description, preparedby, objectives, \n"
                + "scope, requirements, istemplate, status, type, date_created) \n"
                + "VALUES (?,?,?,?,?,?,?,0,0,?,?);");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + initialCharter.getCommunity_id());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + initialCharter.getTitle());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + initialCharter.getDescription());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + initialCharter.getPreparedby());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + initialCharter.getObjectives());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + initialCharter.getScope());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + initialCharter.getRequirements());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + initialCharter.getType());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + new java.sql.Date(Year.getCurrentDateinCalendar().getTime().getTime()));
        getParameters().add(onePair);


        return executeUpdate();
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        ProjectCharterEntity entity = new ProjectCharterEntity();
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
            entity.setStatus(rs.getString("status"));
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

        return entity;
    }
}
