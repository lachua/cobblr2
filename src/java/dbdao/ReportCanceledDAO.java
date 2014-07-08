/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportCanceledEntity;
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
public class ReportCanceledDAO extends QueryTemplate{

    // projects per status
    public List<ReportCanceledEntity> getReport(Date start, Date end){
        setQuery("SELECT \n" +
                "    pcd.date_cancelled, c.name as 'community_name', so.name as 'org_name', pcd.cancel_reason\n" +
                "FROM\n" +
                "    project_charter pc\n" +
                "        INNER JOIN\n" +
                "    project_charter_date pcd ON pc.id = pcd.project_id\n" +
                "		INNER JOIN\n" +
                "	community c ON pc.community_id = c.id\n" +
                "		INNER JOIN\n" +
                "	org_projects op ON pc.id = op.project_id\n" +
                "		INNER JOIN\n" +
                "	studentorg so ON so.id = op.org_id\n" +
                "WHERE\n" +
                "    pc.status = 6\n" +
                "        AND ? <= pcd.date_cancelled\n" +
                "        AND ? > pcd.date_cancelled");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+start);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(""+end);
        getParameters().add(onePair);

        List<ReportCanceledEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportCanceledEntity entity = new ReportCanceledEntity();

        try {
            entity.setDate_cancelled(rs.getDate("date_cancelled"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_name(rs.getString("community_name"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrg_name(rs.getString("org_name"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCancel_reason(rs.getString("cancel_reason"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
