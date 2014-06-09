/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportCommunityHealthReview;

import dbdao.*;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
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
public class ReportReviewProjectDAO extends QueryTemplate {

    public List<ReportReviewProjectEntity> getProjectsImplemented(int community_id, int year) {

        //Status 3 or 4 are implemented and closed, respectively
        //Survey 4 is beneficiary survey
        String query = "SELECT \n"
                + "    pc.id,\n"
                + "    pc.title,\n"
                + "    pc.type,\n"
                + "    pc.meetingdate,\n"
                + "    COUNT(DISTINCT pa.person_id) AS numparticipants\n"
                + "FROM\n"
                + "    project_charter pc\n"
                + "        LEFT JOIN\n"
                + "    person_answer pa ON pc.id = pa.otheranswer\n"
                + "WHERE\n"
                + "    (pc.status = 3 OR pc.status = 4)\n"
                + "        AND pc.community_id = ?\n"
                + "        AND YEAR(meetingdate) >= ?\n"
                + "        AND YEAR(meetingdate) <= ?\n"
                + "        Group by pc.id\n"
                + "ORDER BY meetingdate DESC";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);
        
        int year2 = year - 1;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year2);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year);
        getParameters().add(onePair);

        List<ReportReviewProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

//    private int project_id;
//    private Calendar date_implemented;
//    private String project_title;
//    private String project_type;
//    private int numParticipants;
//        
        ReportReviewProjectEntity entity = new ReportReviewProjectEntity();

        try {
            entity.setProject_id(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Date date;
            date = rs.getDate("meetingdate");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            entity.setDate_implemented(cal);
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setProject_title(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setProject_type(rs.getString("type"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setNumParticipants(rs.getInt("numparticipants"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
