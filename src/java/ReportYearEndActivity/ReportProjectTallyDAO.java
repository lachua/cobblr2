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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ReportProjectTallyDAO extends QueryTemplate {

    public int countCancelledProjects(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    pc.status as label, COUNT(DISTINCT pc.id) AS tally\n"
                + "FROM\n"
                + "    project_charter pc\n"
                + "WHERE\n"
                + "	pc.status = 6\n"
                + "        AND meetingdate >= ?\n"
                + "        AND meetingdate <= ?";

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

        List<ReportStringIntPair> results = executeQuery();

        if (results != null) {
            return results.get(0).getInteger();
        } else {
            return -1;
        }
    }

    public List<ReportStringIntPair> getActiveProjectsByCommunity(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    c.name AS label, COUNT(DISTINCT pc.id) AS tally\n"
                + "FROM\n"
                + "    project_charter pc\n"
                + "        INNER JOIN\n"
                + "    community c ON pc.community_id = c.id\n"
                + "WHERE\n"
                + "    ((pc.status = 1 OR pc.status = 5\n"
                + "        OR pc.status = 2\n"
                + "        OR pc.status = 3\n"
                + "        OR pc.status = 4)\n"
                + "        AND (meetingdate >= ?\n"
                + "        AND meetingdate <= ?))\n"
                + "GROUP BY c.name\n"
                + "ORDER BY tally DESC";

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

        List<ReportStringIntPair> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<ReportStringIntPair> getActiveProjectsByOrg(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    so.name AS label, COUNT(DISTINCT pc.id) AS tally\n"
                + "FROM\n"
                + "    project_charter pc\n"
                + "        INNER JOIN\n"
                + "    org_projects op ON pc.id = op.project_id\n"
                + "        INNER JOIN\n"
                + "    studentorg so ON op.org_id = so.id\n"
                + "WHERE\n"
                + "    ((pc.status = 1 OR pc.status = 5\n"
                + "        OR pc.status = 2\n"
                + "        OR pc.status = 3\n"
                + "        OR pc.status = 4)\n"
                + "        AND (meetingdate >= ?\n"
                + "        AND meetingdate <= ?))\n"
                + "GROUP BY so.name\n"
                + "ORDER BY tally DESC";

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

        List<ReportStringIntPair> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<ReportStringIntPair> getActiveProjectsPerType(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    type as label, count(id) as tally\n"
                + "FROM\n"
                + "    project_charter\n"
                + "WHERE\n"
                + "    ((status = 1 OR status = 5 OR status = 2\n"
                + "        OR status = 3\n"
                + "        OR status = 4)\n"
                + "        AND (meetingdate >= ?\n"
                + "        AND meetingdate <= ?))\n"
                + "GROUP BY type\n"
                + "ORDER BY tally DESC";

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

        List<ReportStringIntPair> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<ReportStringIntPair> getInactiveProjectsPerType(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    type as label, count(id) as tally\n"
                + "FROM\n"
                + "    project_charter\n"
                + "WHERE\n"
                + "    status = 0\n"
                + "        AND (date_created >= ?\n"
                + "        AND date_created <= ?)\n"
                + "GROUP BY type\n"
                + "ORDER BY tally DESC";

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

        List<ReportStringIntPair> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        ReportStringIntPair entity = new ReportStringIntPair();

        try {
            entity.setString(rs.getString("label"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setInteger(rs.getInt("tally"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
