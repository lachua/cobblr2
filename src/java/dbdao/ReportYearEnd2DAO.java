/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportYearEnd2Entity;
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
public class ReportYearEnd2DAO extends QueryTemplate{
    
    // projects per status
    public List<ReportYearEnd2Entity> getReport(Date start, Date end){
        setQuery("SELECT \n" +
                "    oa.answertext,\n" +
                "    SUM(CASE\n" +
                "        WHEN pc.status = 3 THEN 1\n" +
                "        ELSE 0\n" +
                "    END) AS 'count_implemented',\n" +
                "    SUM(CASE\n" +
                "        WHEN pc.status = 0 THEN 1\n" +
                "        ELSE 0\n" +
                "    END) AS 'count_available'\n" +
                "FROM\n" +
                "    project_charter pc\n" +
                "        INNER JOIN\n" +
                "    project_target pt ON pc.id = pt.project_id\n" +
                "        INNER JOIN\n" +
                "    project_charter_date pcd ON pc.id = pcd.project_id\n" +
                "        INNER JOIN\n" +
                "    offeredanswer oa ON pt.offeredanswer_id = oa.offeredanswer_id\n" +
                "WHERE\n" +
                "    (YEAR(pc.date_created) >= ? && YEAR(pc.date_created) < ?)\n" +
                "	OR (YEAR(pcd.date_target_implement) >= ? && YEAR(pcd.date_target_implement) < ?)\n" +
                "GROUP BY oa.offeredanswer_id\n" +
                "ORDER BY\n" +
                "	CASE WHEN oa.offeredanswer_id = 82 \n" +
                "            THEN 1 -- last\n" +
                "            ELSE 0 -- first\n" +
                "        END ASC\n" +
                "     , oa.offeredanswer_id ASC;");
    
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

        List<ReportYearEnd2Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportYearEnd2Entity entity = new ReportYearEnd2Entity();

        try {
            entity.setAnswertext(rs.getString("answertext"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCount_implemented(rs.getInt("count_implemented"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCount_available(rs.getInt("count_available"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
