/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportAnnualEntity;
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
public class ReportAnnualDAO extends QueryTemplate{
    
    public List<ReportAnnualEntity> getReportAnnualEntity(Date start, Date end){
        setQuery("SELECT \n" +
                "    oa.offeredanswer_id AS 'problem_id',\n" +
                "    oa.answertext AS 'problem',\n" +
                "    pc.id AS 'project_id',\n" +
                "    pc.title AS 'project_title',\n" +
                "    c.name AS 'community_name',\n" +
                "    COUNT(distinct pa.person_id) AS 'participant_count',\n" +
                "    pcd.date_target_implement AS 'date_target_implement'\n" +
                "FROM\n" +
                "    project_target pt\n" +
                "        INNER JOIN\n" +
                "    offeredanswer oa ON pt.offeredanswer_id = oa.offeredanswer_id\n" +
                "        INNER JOIN\n" +
                "    project_charter pc ON pt.project_id = pc.id\n" +
                "        INNER JOIN\n" +
                "	project_charter_date pcd on pc.id = pcd.project_id\n" +
                "		INNER JOIN\n" +
                "    community c ON pc.community_id = c.id\n" +
                "        INNER JOIN\n" +
                "    person_answer pa on pc.id = pa.otheranswer\n" +
                "WHERE\n" +
                "    ? <= pcd.date_target_implement\n" +
                "        AND ? > pcd.date_target_implement\n" +
                "GROUP BY pt.offeredanswer_id, pc.id\n" +
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

        List<ReportAnnualEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportAnnualEntity entity = new ReportAnnualEntity();

        try {
            entity.setProblem_id(rs.getInt("problem_id"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setProblem(rs.getString("problem"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setProject_id(rs.getInt("project_id"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setProject_title(rs.getString("project_title"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_name(rs.getString("community_name"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setParticipant_count(rs.getInt("participant_count"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_target_implement(rs.getDate("date_target_implement"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return entity;
    }
    
}
