/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import static dbdao.templates.QueryTemplate.df;
import dbentities.AnswerEntity;
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
public class CommunityAnswerDAO extends QueryTemplate {

//    private int survey_id;
//    private int question_id;
//    private int offeredanswer_id;
//    private int family_id;
//    private Calendar date_answered;
//    private String otheranswer;
    
//    SELECT * FROM community_answer INNER JOIN (SELECT community_family.id as id FROM community inner join community_family on community.id = community_family.community_id where community.id = 1) comm ON community_answer.family_id = comm.id WHERE year(date_answered) = 2014;
    
    public boolean insertAnswer(AnswerEntity ca) {
        return insertAnswer(ca.getSurvey_id(), ca.getQuestion_id(), ca.getOfferedanswer_id(), ca.getId(), ca.getDate_answered(), ca.getOtheranswer());
    }

    public boolean insertAnswer(int survey_id, int question_id, int offeredanswer_id, int family_id, Calendar date_answered, String otheranswer) {
        setQuery("insert into community_answer (survey_id, question_id, offeredanswer_id, family_id, date_answered, otheranswer) values (?,?,?,?,?,?)");
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
        onePair.setValue("" + family_id);
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

    public boolean deleteAnswer(AnswerEntity ca) {
        return deleteAnswer(ca.getSurvey_id(), ca.getQuestion_id(), ca.getOfferedanswer_id(), ca.getId(), ca.getDate_answered(), ca.getOtheranswer());
    }

    public boolean deleteAnswer(int survey_id, int question_id, int offeredanswer_id, int family_id, Calendar date_answered, String otheranswer) {
        setQuery("delete from community_answer where survey_id = ? and question_id = ? and offeredanswer_id = ? and family_id = ? and date_answered = ? and otheranswer = ?");
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
        onePair.setValue("" + family_id);
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

    public AnswerEntity getAnswer(int survey_id, int question_id, int offeredanswer_id, int family_id, Calendar date_answered, String otheranswer) {
        setQuery("select * from community_answer where survey_id = ? and question_id = ? and offeredanswer_id = ? and family_id = ? and date_answered = ? and otheranswer = ?");
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
        onePair.setValue("" + family_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(date_answered.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(otheranswer);
        getParameters().add(onePair);

        List<AnswerEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    public List<AnswerEntity> getCommunityAnswersForYear(int community_id, int year) {

        setQuery("SELECT * FROM community_answer INNER JOIN"
                + " (SELECT community_family.id as id"
                + " FROM community INNER JOIN community_family"
                + " ON community.id = community_family.community_id"
                + " WHERE community.id = ?) comm"
                + " ON community_answer.family_id = comm.id WHERE year(date_answered) = ?");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);        
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year);
        getParameters().add(onePair);

        List<AnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    public List<AnswerEntity> getAllAnswers() {
        setQuery("select * from community_answer");

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
