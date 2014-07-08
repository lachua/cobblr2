/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportMagnitudeEntity;
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
public class ReportMagnitudeDAO extends QueryTemplate{
    public List<ReportMagnitudeEntity> getReportMagnitudeEntity(int question_id, int answer_id,Date start, Date end){
        setQuery("SELECT \n" +
                "    curryear.offeredanswer_id,\n" +
                "    curryear.community_name,\n" +
                "    ROUND(((curryear.count - prevyear.count) / prevyear.count) * 100,\n" +
                "            2) AS 'percent_change'\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        pa.offeredanswer_id,\n" +
                "            c.name AS 'community_name',\n" +
                "            COUNT(DISTINCT cm.person_id) AS 'count'\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    INNER JOIN community_members cm ON pa.person_id = cm.person_id\n" +
                "    INNER JOIN community_family cf ON cm.family_id = cf.id\n" +
                "    INNER JOIN community c ON cf.community_id = c.id\n" +
                "    WHERE\n" +
                "        pa.question_id = ?\n" +
                "            AND pa.offeredanswer_id = ?\n" +
                "            AND Year(pa.date_answered) >= ?\n" +
                "    GROUP BY c.name) prevyear\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        pa.offeredanswer_id,\n" +
                "            c.name AS 'community_name',\n" +
                "            COUNT(DISTINCT cm.person_id) AS 'count'\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    INNER JOIN community_members cm ON pa.person_id = cm.person_id\n" +
                "    INNER JOIN community_family cf ON cm.family_id = cf.id\n" +
                "    INNER JOIN community c ON cf.community_id = c.id\n" +
                "    WHERE\n" +
                "        pa.question_id = ?\n" +
                "            AND pa.offeredanswer_id = ?\n" +
                "            AND Year(pa.date_answered) < ?\n" +
                "    GROUP BY c.name) curryear ON prevyear.community_name = curryear.community_name\n" +
                "ORDER BY ROUND(((curryear.count - prevyear.count) / prevyear.count) * 100,\n" +
                "            2) DESC;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+question_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+answer_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+question_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+answer_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+end);
        getParameters().add(onePair);

        List<ReportMagnitudeEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportMagnitudeEntity entity = new ReportMagnitudeEntity();

        try {
            entity.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_name(rs.getString("community_name"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPercent_change(rs.getDouble("percent_change"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
}
