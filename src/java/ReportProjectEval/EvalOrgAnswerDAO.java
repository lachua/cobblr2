/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportProjectEval;

import dbdao.*;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.AnswerEntity;
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
public class EvalOrgAnswerDAO extends QueryTemplate {

    public List<AnswerEntity> getOrgAnswers(int project_id) {

        String query = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    org_answer\n"
                + "WHERE\n"
                + "    project_id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<AnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        AnswerEntity answer = new AnswerEntity();

        try {
            answer.setSurvey_id(rs.getInt("survey_id"));
        } catch (SQLException ex) {
            Logger.getLogger(CommunityAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(CommunityAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(CommunityAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setId(rs.getInt("family_id"));
        } catch (SQLException ex) {
            Logger.getLogger(CommunityAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date date;
        try {
            date = rs.getDate("date_answered");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            answer.setDate_answered(cal);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setOtheranswer(rs.getString("otheranswer"));
        } catch (SQLException ex) {
            Logger.getLogger(CommunityAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return answer;
    }
}
