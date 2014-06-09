/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.NotificationEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class NotificationDAO extends QueryTemplate {

    //Get all users
    public List<NotificationEntity> getNotifsOrg(int org_id) {
        setQuery("select * from notification where org_id = ? and viewed = 1");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        List<NotificationEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //Get all users
    public boolean updateImplementation(NotificationEntity notif) {
        setQuery("UPDATE notification SET viewed=?, comments=?, date=? WHERE org_id=? and notificationtext=? and project_id=?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + notif.getViewed());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + notif.getComments());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + new java.sql.Date(notif.getDate().getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + notif.getOrg_id());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + notif.getNotificationtext());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + notif.getProject_id());
        getParameters().add(onePair);
        
        return executeUpdate();
    }

    //Get all users
    public boolean isExisting(String notificationtext, int proj_id, int org_id) {
        setQuery("select * from notification where org_id = ? and project_id = ? and notificationtext = ?");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + proj_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + notificationtext);
        getParameters().add(onePair);

        List<NotificationEntity> results = executeQuery();

        if (results.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Get all users
    public List<NotificationEntity> getNotifsCOSCA() {
        setQuery("select * from notification where viewed = 2");

        List<NotificationEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<NotificationEntity> getNewProjects(int org_id) {
        setQuery("select * from notification where notificationtext = 'Org_NewProject' and viewed = 1 and org_id = ?");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        List<NotificationEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //Get all users
    public boolean insertNotif(NotificationEntity entity) {
        setQuery("INSERT INTO notification (org_id, notificationtext, viewed, project_id, comments, date) VALUES (?, ?, ?, ?, ?, ?);");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + entity.getOrg_id());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + entity.getNotificationtext());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + entity.getViewed());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + entity.getProject_id());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + entity.getComments());
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + new java.sql.Date(entity.getDate().getTime()));
        getParameters().add(onePair);

        return executeUpdate();
    }

    //Set notification viewed
    public boolean notificataionViewed(int id_notification) {
        setQuery("UPDATE notification SET viewed=0 WHERE id_notification=?;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id_notification);
        getParameters().add(onePair);

        return executeUpdate();
    }

    //Finalize Full Charter
    public boolean finalizedFullCharter(int project_id, int org_id) {
        setQuery("INSERT INTO notification (org_id, notificationtext, viewed, project_id, date) VALUES (?, 'COSCA_FinalizedFullCharter', 2, ?, ?);");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String date = sdf.format(cal.getTime());

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date);
        getParameters().add(onePair);

        return executeUpdate();
    }

    //Approve Pending Project
    public boolean approvePendingProject(int project_id, int org_id) {
        setQuery("INSERT INTO notification (org_id, notificationtext, viewed, project_id, date) VALUES (?, 'ORG_PendingApprove', 1, ?, ?);");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String date = sdf.format(cal.getTime());

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date);
        getParameters().add(onePair);

        return executeUpdate();
    }

    //Disapprove Pending Project
    public boolean disapprovePendingProject(int project_id, int org_id, String comments) {
        setQuery("INSERT INTO notification (org_id, notificationtext, viewed, project_id, comments, date) VALUES (?, 'ORG_PendingDisapprove', 1, ?, ?, ?);");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + comments);
        getParameters().add(onePair);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String date = sdf.format(cal.getTime());

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + date);
        getParameters().add(onePair);

        return executeUpdate();
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        NotificationEntity entity = new NotificationEntity();
        try {
            entity.setId_notification(rs.getInt("id_notification"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrg_id(rs.getInt("org_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setNotificationtext(rs.getString("notificationtext"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setViewed(rs.getInt("viewed"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setProject_id(rs.getInt("project_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setComments(rs.getString("comments"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate(rs.getDate("date"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }

    public void updateImplementation(String cosca_Implementation, Integer project_id, Integer org_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
