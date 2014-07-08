/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportYearEnd3Entity;
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
public class ReportYearEnd3DAO extends QueryTemplate{
    
    // projects per status
    public List<ReportYearEnd3Entity> getReport(Date start, Date end){
        setQuery("SELECT \n" +
                "    c.name,\n" +
                "    pc.title,\n" +
                "    pcd.target_participant_num,\n" +
                "    COUNT(DISTINCT pm.stud_idno) AS actual_participant\n" +
                "FROM\n" +
                "    project_charter pc\n" +
                "        INNER JOIN\n" +
                "    project_charter_date pcd ON pc.id = pcd.project_id\n" +
                "        INNER JOIN\n" +
                "    community c ON pc.community_id = c.id\n" +
                "        INNER JOIN\n" +
                "    project_members pm ON pc.id = pm.project_id\n" +
                "WHERE\n" +
                "    (? <= YEAR(pcd.date_target_implement)\n" +
                "        && ? > YEAR(pcd.date_target_implement))\n" +
                "GROUP BY c.id , pc.id\n" +
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

        List<ReportYearEnd3Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportYearEnd3Entity entity = new ReportYearEnd3Entity();

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
        try {
            entity.setTarget_participant_num(rs.getInt("target_participant_num"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setActual_participant(rs.getInt("actual_participant"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
        return entity;
    }
}
