/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportChild1Entity;
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
public class ReportChild1DAO  extends QueryTemplate{

    // projects per status
    public List<ReportChild1Entity> getReport(int community_id, Date start, Date end){
        setQuery("SELECT \n" +
                "    count(*) as total\n" +
                "FROM\n" +
                "    person_answer pa\n" +
                "        INNER JOIN\n" +
                "    community_members cm ON pa.person_id = cm.person_id\n" +
                "        INNER JOIN\n" +
                "    community_family cf ON cm.family_id = cf.id\n" +
                "WHERE\n" +
                "    pa.survey_id = 5 AND cf.community_id = ?\n" +
                "        AND pa.question_id = 71\n" +
                "        AND (? <= pa.date_answered\n" +
                "        AND ? >= pa.date_answered);");

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

        List<ReportChild1Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportChild1Entity entity = new ReportChild1Entity();

        try {
            entity.setTotal(rs.getInt("total"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
