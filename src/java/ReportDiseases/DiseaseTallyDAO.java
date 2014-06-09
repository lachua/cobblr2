/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportDiseases;

import dbdao.*;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import static dbdao.templates.QueryTemplate.df;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DiseaseTallyDAO extends QueryTemplate {

    public List<DiseaseTallyEntity> getTopDiseases(Calendar periodStart, Calendar periodEnd) {

        String query = "SELECT \n"
                + "    oa.answertext, COUNT(pa.offeredanswer_id) AS count\n"
                + "FROM\n"
                + "    person_answer pa\n"
                + "        INNER JOIN\n"
                + "    offeredanswer oa ON pa.offeredanswer_id = oa.offeredanswer_id\n"
                + "WHERE\n"
                + "    question_id = 35\n"
                + "        AND date_answered >= ?\n"
                + "        AND date_answered <= ?\n"
                + "GROUP BY pa.offeredanswer_id\n"
                + "ORDER BY count DESC\n"
                + "LIMIT 10";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodStart.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(periodEnd.getTime()));
        getParameters().add(onePair);

        List<DiseaseTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        DiseaseTallyEntity entity = new DiseaseTallyEntity();

        try {
            entity.setIllness(rs.getString("answertext"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setCount(rs.getInt("count"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
