/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportProject1Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ReportProject1DAO extends QueryTemplate{

    // projects per status
    public List<ReportProject1Entity> getReport(int project_id){
        setQuery("SELECT \n" +
                "    pc.title,\n" +
                "    oa.answertext AS 'target',\n" +
                "    c.name AS 'partner_community',\n" +
                "    c.address AS 'location',\n" +
                "    so.name AS 'sponsor',\n" +
                "    pcd.date_target_implement AS 'date_target_implement',\n" +
                "    pcd.date_implemented AS 'date_implemented',\n" +
                "    pc.description,\n" +
                "    pc.objectives\n" +
                "FROM\n" +
                "    project_charter pc\n" +
                "        INNER JOIN\n" +
                "    project_target pt ON pc.id = pt.project_id\n" +
                "        INNER JOIN\n" +
                "    project_charter_date pcd ON pc.id = pcd.project_id\n" +
                "        INNER JOIN\n" +
                "    offeredanswer oa ON pt.offeredanswer_id = oa.offeredanswer_id\n" +
                "        INNER JOIN\n" +
                "    community c ON pc.community_id = c.id\n" +
                "        INNER JOIN\n" +
                "    org_projects op ON pc.id = op.project_id\n" +
                "        INNER JOIN\n" +
                "    studentorg so ON op.org_id = so.id\n" +
                "WHERE\n" +
                "    pc.id = ?\n" +
                "ORDER BY\n" +
                "	CASE WHEN oa.offeredanswer_id = 82 \n" +
                "            THEN 1 -- last\n" +
                "            ELSE 0 -- first\n" +
                "        END ASC\n" +
                "     , oa.offeredanswer_id ASC;");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+project_id);
        getParameters().add(onePair);

        List<ReportProject1Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportProject1Entity entity = new ReportProject1Entity();

        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTarget(rs.getString("target"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPartner_community(rs.getString("partner_community"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setLocation(rs.getString("location"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setSponsor(rs.getString("sponsor"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_target_implement(rs.getDate("date_target_implement"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_implemented(rs.getDate("date_implemented"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setObjectives(rs.getString("objectives"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
