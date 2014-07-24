/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportChild6Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ReportChild6DAO extends QueryTemplate{

    // projects per status
    public List<ReportChild6Entity> getReport(int community_id, Date start, Date end){
        setQuery("SELECT \n" +
                "    oa.answertext as 'newborn',\n" +
                "    count(ans.offeredanswer_id) as 'count'\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        q.question_id, questiontext, oa.offeredanswer_id, answertext\n" +
                "    FROM\n" +
                "        survey_question_answer sqa\n" +
                "    INNER JOIN question q ON sqa.question_id = q.question_id\n" +
                "    INNER JOIN offeredanswer oa ON sqa.offeredanswer_id = oa.offeredanswer_id\n" +
                "    WHERE\n" +
                "        sqa.survey_id = 5\n" +
                "            AND sqa.question_id = 75) oa\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        pa.offeredanswer_id\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    INNER JOIN community_members cm ON pa.person_id = cm.person_id\n" +
                "    INNER JOIN community_family cf ON cm.family_id = cf.id\n" +
                "    WHERE\n" +
                "        pa.survey_id = 5 AND cf.community_id = ?\n" +
                "            AND pa.question_id = 75\n" +
                "            AND (? <= YEAR(pa.date_answered)\n" +
                "            AND ? > YEAR(pa.date_answered))) ans ON oa.offeredanswer_id = ans.offeredanswer_id\n" +
                "GROUP BY oa.offeredanswer_id\n" +
                "ORDER BY oa.offeredanswer_id asc;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+end);
        getParameters().add(onePair);

        List<ReportChild6Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportChild6Entity entity = new ReportChild6Entity();

        try {
            entity.setNewborn(rs.getString("newborn"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCount(rs.getInt("count"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
