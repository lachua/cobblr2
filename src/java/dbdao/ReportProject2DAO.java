/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportProject2Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ReportProject2DAO extends QueryTemplate{

    // projects per status
    public List<ReportProject2Entity> getReport(int project_id){
        setQuery("SELECT \n" +
                "    answers.question_id, choices.questiontext, answers.avg_answer_id, choices.answertext\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        pa.question_id,\n" +
                "            FLOOR(AVG(pa.offeredanswer_id)) AS 'avg_answer_id'\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    WHERE\n" +
                "        pa.survey_id = 4 AND pa.otheranswer = ?\n" +
                "    GROUP BY pa.question_id) answers\n" +
                "        INNER JOIN\n" +
                "    (SELECT \n" +
                "        sqa.question_id,\n" +
                "            q.questiontext,\n" +
                "            sqa.offeredanswer_id,\n" +
                "            oa.answertext\n" +
                "    FROM\n" +
                "        survey_question_answer sqa\n" +
                "    INNER JOIN question q ON sqa.question_id = q.question_id\n" +
                "    INNER JOIN offeredanswer oa ON sqa.offeredanswer_id = oa.offeredanswer_id\n" +
                "    WHERE\n" +
                "        sqa.survey_id = 4) choices ON answers.question_id = choices.question_id\n" +
                "        AND answers.avg_answer_id = choices.offeredanswer_id\n" +
                "ORDER BY answers.question_id;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+project_id);
        getParameters().add(onePair);

        List<ReportProject2Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportProject2Entity entity = new ReportProject2Entity();

        try {
            entity.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setQuestiontext(rs.getString("questiontext"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAvg_answer_id(rs.getInt("avg_answer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAnswertext(rs.getString("answertext"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
