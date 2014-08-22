/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportInfectionEntity;
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
public class ReportInfectionDAO  extends QueryTemplate{
    public List<ReportInfectionEntity> getReportInfection(int question_id, int answer_id, String start){
        setQuery("SELECT \n" +
                "    affected.cid AS community_id, c.name, acount AS 'magnitude', tcount AS 'total_respondents', (acount / tcount) * 100 AS 'percent'\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        cf.community_id AS 'cid',\n" +
                "            COUNT(DISTINCT pa.person_id) AS 'acount'\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    LEFT JOIN community_members cm ON pa.person_id = cm.person_id\n" +
                "    LEFT JOIN community_family cf ON cm.family_id = cf.id\n" +
                "    WHERE\n" +
                "        question_id = ?\n" +
                "            AND offeredanswer_id = ?\n" +
                "            AND Year(date_answered) = ?\n" +
                "    GROUP BY cf.community_id) affected\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        cf.community_id AS 'cid',\n" +
                "            COUNT(DISTINCT pa.person_id) AS 'tcount'\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    LEFT JOIN community_members cm ON pa.person_id = cm.person_id\n" +
                "    LEFT JOIN community_family cf ON cm.family_id = cf.id\n" +
                "    WHERE\n" +
                "        Year(date_answered) = ?\n" +
                "    GROUP BY cf.community_id) totalpop ON affected.cid = totalpop.cid\n" +
                "	LEFT JOIN community c ON affected.cid = c.id\n" +
                "WHERE (acount / tcount) >= 0.20\n" +
                "ORDER BY percent DESC;");
        
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
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(""+start);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        List<ReportInfectionEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportInfectionEntity entity = new ReportInfectionEntity();

        try {
            entity.setCommunity_id(rs.getInt("community_id"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setMagnitude(rs.getInt("magnitude"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTotal_respondents(rs.getInt("total_respondents"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPercent(rs.getDouble("percent"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
}
