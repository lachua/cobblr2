/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportYearEnd4Entity;
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
public class ReportYearEnd4DAO extends QueryTemplate{
    
    // projects per status
    public List<ReportYearEnd4Entity> getReport(Date start, Date end){
        setQuery("SELECT \n" +
                "    so.name, pc.title\n" +
                "FROM\n" +
                "    project_charter pc\n" +
                "        INNER JOIN\n" +
                "    project_charter_date pcd ON pc.id = pcd.project_id\n" +
                "        INNER JOIN\n" +
                "    org_projects op ON pc.id = op.project_id\n" +
                "        INNER JOIN\n" +
                "    studentorg so ON op.org_id = so.id\n" +
                "WHERE\n" +
                "    (? <= YEAR(pcd.date_target_implement)\n" +
                "        && ? > YEAR(pcd.date_target_implement))\n" +
                "GROUP BY so.id , pc.id\n" +
                "ORDER BY COUNT(*);");
        
         KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+end);
        getParameters().add(onePair);

        List<ReportYearEnd4Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportYearEnd4Entity entity = new ReportYearEnd4Entity();

        try {
            entity.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
    
}
