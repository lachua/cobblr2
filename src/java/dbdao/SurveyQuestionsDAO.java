/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.AnswerTallyEntity;
import dbentities.SurveyQuestionsEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SurveyQuestionsDAO extends QueryTemplate {

//    private int survey_id;
//    private int question_id;
//    private int question_index;
    
    public List<SurveyQuestionsEntity> getSurveyQuestions(int survey_id) {

        setQuery("SELECT * FROM survey_question WHERE survey_id = ? ORDER BY question_index ASC");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
        getParameters().add(onePair);

        List<SurveyQuestionsEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        SurveyQuestionsEntity sq = new SurveyQuestionsEntity();
        try {
            sq.setSurvey_id(rs.getInt("survey_id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sq.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sq.setQuestion_index(rs.getInt("question_index"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return sq;
    }
}
