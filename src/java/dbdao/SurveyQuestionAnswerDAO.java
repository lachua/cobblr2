/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.SurveyQuestionAnswerEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SurveyQuestionAnswerDAO extends QueryTemplate {

//    private int survey_id;
//    private int question_id;
//    private int offeredanswer_id;
    
    public static final int SURVEY = 1;
    public static final int PERSONAL = 2;
    public static final int ORGANIZATION = 3;
    public static final int BENEFICIARY = 4;
    
    
    public List<SurveyQuestionAnswerEntity> getQuestionAnswers(int question_id) {
        setQuery("select * from survey_question_answer where question_id = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + question_id);
        getParameters().add(onePair);

        List<SurveyQuestionAnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<SurveyQuestionAnswerEntity> getAllQuestionAnswers() {
        setQuery("select * from survey_question_answer");

        List<SurveyQuestionAnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public boolean insertAnswer(int survey_id, int question_id, int offeredanswer_id) {
        boolean result;
        setQuery("INSERT INTO survey_question_answer (survey_id, question_id, offeredanswer_id) VALUES (?, ?, ?);");
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

        result = executeUpdate();
        return result;

    }
    
    public boolean insertBeneficiaryAnswer(String query) {
        boolean result;
        setQuery(query);
        
        result = executeUpdate();
        return result;

    }

    @Override
    protected Object storeResults(ResultSet rs) {
        SurveyQuestionAnswerEntity questionanswer = new SurveyQuestionAnswerEntity();
        try {
            questionanswer.setSurvey_id(rs.getInt("survey_id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            questionanswer.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            questionanswer.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return questionanswer;
    }
}
