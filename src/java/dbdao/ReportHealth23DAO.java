/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportHealth23Entity;
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
public class ReportHealth23DAO  extends QueryTemplate{

    // projects per status
    public List<ReportHealth23Entity> getReport2(int community_id, Date start){
        setQuery("SELECT \n" +
                "    oa.answertext AS 'illness',\n" +
                "    COUNT(DISTINCT pa.person_id) AS 'incidence'\n" +
                "FROM\n" +
                "    person_answer pa\n" +
                "        INNER JOIN\n" +
                "    community_members cm ON pa.person_id = cm.person_id\n" +
                "        INNER JOIN\n" +
                "    community_family cf ON cm.family_id = cf.id\n" +
                "        INNER JOIN\n" +
                "    offeredanswer oa ON oa.offeredanswer_id = pa.offeredanswer_id\n" +
                "WHERE\n" +
                "    cf.community_id = ?\n" +
                "        AND YEAR(pa.date_answered) = ?\n" +
                "        AND pa.question_id = 35\n" +
                "GROUP BY pa.question_id , pa.offeredanswer_id\n" +
                "ORDER BY incidence DESC\n" +
                "LIMIT 10;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        List<ReportHealth23Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    // projects per status
    public List<ReportHealth23Entity> getReport3(int community_id, Date start){
        setQuery("SELECT \n" +
                "    oa.answertext AS 'illness',\n" +
                "    COUNT(DISTINCT ca.family_id) AS 'incidence'\n" +
                "FROM\n" +
                "    community_answer ca\n" +
                "        INNER JOIN\n" +
                "    community_family cf ON ca.family_id = cf.id\n" +
                "        INNER JOIN\n" +
                "    offeredanswer oa ON oa.offeredanswer_id = ca.offeredanswer_id\n" +
                "WHERE\n" +
                "    cf.community_id = ?\n" +
                "        AND YEAR(ca.date_answered) = ?\n" +
                "        AND ca.question_id = 8\n" +
                "GROUP BY ca.question_id , ca.offeredanswer_id\n" +
                "ORDER BY incidence DESC\n" +
                "LIMIT 3;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        List<ReportHealth23Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportHealth23Entity entity = new ReportHealth23Entity();

        try {
            entity.setIllness(rs.getString("illness"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setIncidence(rs.getInt("incidence"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
    
}
