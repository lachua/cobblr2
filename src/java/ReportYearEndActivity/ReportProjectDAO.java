/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportYearEndActivity;

import dbdao.*;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import static dbdao.templates.QueryTemplate.df;
import dbentities.AnswerTallyEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ReportProjectDAO extends QueryTemplate {

    public List<ReportProjectEntity> getDeadProjectsList() {

        String query = "SELECT \n"
                + "    pc.id,\n"
                + "    pc.date_created,\n"
                + "    pc.meetingdate,\n"
                + "    pc.title,\n"
                + "    c.id AS owner_id,\n"
                + "    c.name AS owner_name\n"
                + "FROM\n"
                + "    project_charter pc\n"
                + "        INNER JOIN\n"
                + "    community c ON pc.community_id = c.id\n"
                + "WHERE\n"
                + "    pc.status = 0\n"
                + "        AND (YEAR(CURDATE()) - YEAR(pc.date_created) >= 1)";

        setQuery(query);

        List<ReportProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<ReportProjectEntity> getProjectsWithStatus(int status, Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    pc.id,\n"
                + "    pc.date_created,\n"
                + "    pc.meetingdate,\n"
                + "    pc.title,\n"
                + "    so.id as owner_id,\n"
                + "    so.name as owner_name\n"
                + "FROM\n"
                + "    project_charter pc\n"
                + "        INNER JOIN\n"
                + "    org_projects op ON pc.id = op.project_id\n"
                + "        INNER JOIN\n"
                + "    studentorg so ON op.org_id = so.id\n"
                + "WHERE\n"
                + "    pc.status = ?\n"
                + "        AND meetingdate >= ?\n"
                + "        AND meetingdate <= ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + status);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodStart.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodEnd.getTime()));
        getParameters().add(onePair);

        List<ReportProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public int countProjectsTotal(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    COUNT(DISTINCT id) AS count\n"
                + "FROM\n"
                + "    project_charter\n"
                + "WHERE\n"
                + "    (date_created >= ?\n"
                + "        AND date_created <= ?)\n"
                + "        OR (meetingdate >= ?\n"
                + "        AND meetingdate <= ?)";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodStart.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodEnd.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodStart.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodEnd.getTime()));
        getParameters().add(onePair);

        List<ReportProjectEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getProject_id();
        } else {
            return -1;
        }
    }

    public int countProjectsCreated(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    count(id) as id\n"
                + "FROM\n"
                + "    project_charter\n"
                + "WHERE\n"
                + "    status = 0\n"
                + "        AND date_created >= ?\n"
                + "        AND date_created <= ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodStart.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodEnd.getTime()));
        getParameters().add(onePair);

        List<ReportProjectEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getProject_id();
        } else {
            return -1;
        }
    }

    public int countProjectsWithStatus(int status, Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "	count(id) as id\n"
                + "FROM\n"
                + "    project_charter\n"
                + "WHERE\n"
                + "    status = ?\n"
                + "        AND meetingdate >= ?\n"
                + "        AND meetingdate <= ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + status);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodStart.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodEnd.getTime()));
        getParameters().add(onePair);

        List<ReportProjectEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getProject_id();
        } else {
            return -1;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

//      private int project_id;
//      private Calendar date_created;
//      private Calendar meetingdate;
//      private String projectTitle;
//      private int owner_id;
//      private String ownerName; //org or community name


        ReportProjectEntity entity = new ReportProjectEntity();

        try {
            entity.setProject_id(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Date date;
            date = rs.getDate("date_created");
            Calendar cal = Calendar.getInstance();

            if (date != null) {
                cal.setTime(date);
                entity.setDate_created(cal);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Date date;
            date = rs.getDate("date_created");
            Calendar cal = Calendar.getInstance();

            if (date != null) {
                cal.setTime(date);
                entity.setMeetingdate(cal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setProjectTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setOwner_id(rs.getInt("owner_id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setOwnerName(rs.getString("owner_name"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
