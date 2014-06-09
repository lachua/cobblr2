/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.OfferedAnswerEntity;
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
public class OfferedAnswerDAO extends QueryTemplate {

//    private int offeredanswer_id;
//    private String answertext;
//    private String answer_category;  
    public boolean insertOfferedAnswer(OfferedAnswerEntity oa) {
        return insertOfferedAnswer(oa.getId(), oa.getAnswertext(), oa.getAnswer_category());
    }

    public boolean insertOfferedAnswer(int offeredanswer_id, String answertext, String answer_category) {
        setQuery("insert into offeredanswer (offeredanswer_id, answertext, answer_category) values (?,?,?)");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + offeredanswer_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(answertext);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(answer_category);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public OfferedAnswerEntity getOfferedAnswer(int offeredanswer_id) {
        setQuery("select * from offeredanswer where offeredanswer_id = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + offeredanswer_id);
        getParameters().add(onePair);

        List<OfferedAnswerEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else {
            return null;
        }
    }

    public List<OfferedAnswerEntity> getAllOfferedAnswers() {
        setQuery("select * from offeredanswer");

        List<OfferedAnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        OfferedAnswerEntity oa = new OfferedAnswerEntity();
        
        try {
            oa.setId(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(OfferedAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            oa.setAnswertext(rs.getString("answertext"));
        } catch (SQLException ex) {
            Logger.getLogger(OfferedAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            oa.setAnswer_category(rs.getString("answer_category"));
        } catch (SQLException ex) {
            Logger.getLogger(OfferedAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return oa;
    }
}
