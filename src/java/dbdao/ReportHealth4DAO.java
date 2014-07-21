/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportHealth4Entity;
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
public class ReportHealth4DAO  extends QueryTemplate{

    // projects per status
    public List<ReportHealth4Entity> getReport(int community_id, Date start, Date end){
        setQuery("SELECT \n" +
                "    pcd.date_implemented,\n" +
                "    pc.title,\n" +
                "    oa.answertext,\n" +
                "    COUNT(DISTINCT pm.stud_idno) AS 'num_participants'\n" +
                "FROM\n" +
                "    project_charter pc\n" +
                "        INNER JOIN\n" +
                "    project_charter_date pcd ON pc.id = pcd.project_id\n" +
                "        INNER JOIN\n" +
                "    community c ON pc.community_id = c.id\n" +
                "        INNER JOIN\n" +
                "    project_target pt ON pt.project_id = pc.id\n" +
                "        INNER JOIN\n" +
                "    offeredanswer oa ON pt.offeredanswer_id = oa.offeredanswer_id\n" +
                "        INNER JOIN\n" +
                "    project_members pm ON pc.id = pm.project_id\n" +
                "WHERE\n" +
                "    c.id = ?\n" +
                "        AND (? <= pcd.date_implemented\n" +
                "        && ? > pcd.date_implemented)\n" +
                "GROUP BY c.id , pc.id\n" +
                "ORDER BY pcd.date_implemented ASC;");
        
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

        List<ReportHealth4Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportHealth4Entity entity = new ReportHealth4Entity();

        try {
            entity.setDate_implemented(rs.getDate("date_implemented"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAnswertext(rs.getString("answertext"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setNum_participants(rs.getInt("num_participants"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
