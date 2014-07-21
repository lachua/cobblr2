/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportHealth1Entity;
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
public class ReportHealth1DAO extends QueryTemplate{

    // projects per status
    public List<ReportHealth1Entity> getReport(int community_id, Date start){
        setQuery("SELECT \n" +
                "    YEAR(pa.date_answered) AS 'year',\n" +
                "    COUNT(DISTINCT pa.person_id) AS 'num_respondents'\n" +
                "FROM\n" +
                "    person_answer pa\n" +
                "        INNER JOIN\n" +
                "    community_members cm ON pa.person_id = cm.person_id\n" +
                "        INNER JOIN\n" +
                "    community_family cf ON cm.family_id = cf.id\n" +
                "WHERE\n" +
                "    cf.community_id = ?\n" +
                "        AND (YEAR(pa.date_answered) = ?\n" +
                "GROUP BY YEAR(pa.date_answered)\n" +
                "ORDER BY YEAR(pa.date_answered) ASC;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        List<ReportHealth1Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportHealth1Entity entity = new ReportHealth1Entity();

        try {
            entity.setYear(rs.getInt("year"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setNum_respondents(rs.getInt("num_respondents"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
