/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.QuestionEntity;
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
public class QuestionDAO extends QueryTemplate {

//    private int question_id;
//    private String questiontext;
//    private String question_tag;
    
    public boolean insertQuestion(Integer question_id, String questiontext, String question_tag) {
        setQuery("insert into question (question_id, questiontext, question_tag) values (?,?,?)");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + question_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(questiontext);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(question_tag);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public QuestionEntity getQuestion(Integer question_id) {
        setQuery("select * from question where question_id = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + question_id);
        getParameters().add(onePair);

        List<QuestionEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        QuestionEntity question = new QuestionEntity();

        try {
            question.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            question.setQuestiontext(rs.getString("questiontext"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            question.setQuestion_tag(rs.getString("question_tag"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return question;
    }
}
