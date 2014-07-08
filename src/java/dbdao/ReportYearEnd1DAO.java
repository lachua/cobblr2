/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportYearEnd1Entity;
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
public class ReportYearEnd1DAO extends QueryTemplate{

    // projects per status
    public List<ReportYearEnd1Entity> getReport(Date start, Date end){
        setQuery("SELECT \n" +
                "    CASE status\n" +
                "        WHEN 0 THEN 'available'\n" +
                "        WHEN 1 THEN 'pending'\n" +
                "        WHEN 2 THEN 'ongoing'\n" +
                "        WHEN 3 THEN 'implemented'\n" +
                "        WHEN 4 THEN 'closed'\n" +
                "        WHEN 5 THEN 'confirmed'\n" +
                "        WHEN 6 THEN 'cancelled'\n" +
                "    END AS 'status' ,\n" +
                "    COUNT(DISTINCT pc.id) AS 'count'\n" +
                "FROM\n" +
                "    project_charter pc JOIN project_charter_date pcd\n" +
                "WHERE\n" +
                "	status IS NOT NULL AND (\n" +
                "    (YEAR(pc.date_created) >= ? && YEAR(pc.date_created) < ?)\n" +
                "	OR (YEAR(pcd.date_target_implement) >= ? && YEAR(pcd.date_target_implement) < ?))\n" +
                "GROUP BY pc.status;");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+end);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+end);
        getParameters().add(onePair);

        List<ReportYearEnd1Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportYearEnd1Entity entity = new ReportYearEnd1Entity();

        try {
            entity.setStatus(rs.getString("status"));
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
