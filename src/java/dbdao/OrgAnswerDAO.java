/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import static dbdao.templates.QueryTemplate.df;
import dbentities.AnswerEntity;
import dbentities.OrgAnswerEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class OrgAnswerDAO extends QueryTemplate {

    public boolean insertAnswer(OrgAnswerEntity answer) {
        return insertAnswer(answer.getSurvey_id(), answer.getQuestion_id(), answer.getOfferedanswer_id(), answer.getOrg_id(), answer.getProject_id(), answer.getDate_answered(), answer.getOtheranswer());
    }

    public boolean insertAnswer(int survey_id, int question_id, int offeredanswer_id, int org_id, int project_id, Calendar date_answered, String otheranswer) {
        setQuery("insert into org_answer (survey_id, question_id, offeredanswer_id, org_id, project_id, date_answered, otheranswer) values (?,?,?,?,?,?,?)");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + question_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + offeredanswer_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(date_answered.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(otheranswer);
        getParameters().add(onePair);

        return executeUpdate();
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        OrgAnswerEntity answer = new OrgAnswerEntity();

        try {
            answer.setSurvey_id(rs.getInt("survey_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setOrg_id(rs.getInt("org_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            answer.setProject_id(rs.getInt("project_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date date;
        try {
            date = rs.getDate("date_answered");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            answer.setDate_answered(cal);
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setOtheranswer(rs.getString("otheranswer"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return answer;
    }
}
