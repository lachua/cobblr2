/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportProjectEval;

import dbdao.*;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.AnswerTallyEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class EvalBenefAnswerDAO extends QueryTemplate {

//    private int question_id;
//    private int offeredanswer_id;
//    private int answercount;
    
    public int countParticipants (int project_id) {

        String query = "SELECT \n"
                + "    COUNT(DISTINCT person_id) as answercount\n"
                + "FROM\n"
                + "    person_answer\n"
                + "WHERE\n"
                + "    survey_id = 4 AND otheranswer = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getAnswercount();
        } else {
            return 0;
        }
    }

    public List<AnswerTallyEntity> tallyBenefEvalAnswers(int project_id) {

        String query = "SELECT \n"
                + "    sqa.question_id,\n"
                + "    sqa.offeredanswer_id,\n"
                + "    IF(ans.answercount > 0,\n"
                + "        ans.answercount,\n"
                + "        0) AS answercount\n"
                + "FROM\n"
                + "    survey_question_answer sqa\n"
                + "        LEFT JOIN\n"
                + "    (SELECT \n"
                + "        pa.question_id,\n"
                + "            pa.offeredanswer_id,\n"
                + "            COUNT(pa.offeredanswer_id) AS answercount\n"
                + "    FROM\n"
                + "        person_answer pa\n"
                + "    WHERE\n"
                + "        pa.survey_id = 4 AND pa.otheranswer = ?\n"
                + "    GROUP BY pa.question_id , pa.offeredanswer_id) ans ON sqa.question_id = ans.question_id\n"
                + "        AND sqa.offeredanswer_id = ans.offeredanswer_id\n"
                + "WHERE\n"
                + "    sqa.survey_id = 4\n"
                + "GROUP BY sqa.question_id , sqa.offeredanswer_id";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        AnswerTallyEntity at = new AnswerTallyEntity();
        try {
            at.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            at.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            at.setAnswercount(rs.getInt("answercount"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return at;
    }
}
