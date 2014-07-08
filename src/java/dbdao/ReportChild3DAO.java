/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.ReportChild3Entity;
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
public class ReportChild3DAO extends QueryTemplate{

    // projects per status
    public List<ReportChild3Entity> getReport(int community_id, Date start, Date end){
        setQuery("SELECT \n" +
                "    SUM(IF(cm.age = 0, 1, 0)) AS 'under1',\n" +
                "    SUM(IF(cm.age = 1, 1, 0)) AS 'age1',\n" +
                "    SUM(IF(cm.age = 2, 1, 0)) AS 'age2',\n" +
                "    SUM(IF(cm.age = 3, 1, 0)) AS 'age3',\n" +
                "    SUM(IF(cm.age = 4, 1, 0)) AS 'age4',\n" +
                "    SUM(IF(cm.age = 5, 1, 0)) AS 'age5',\n" +
                "    COUNT(*) AS 'Total'\n" +
                "FROM\n" +
                "    person_answer pa\n" +
                "        INNER JOIN\n" +
                "    community_members cm ON pa.person_id = cm.person_id\n" +
                "        INNER JOIN\n" +
                "    community_family cf ON cm.family_id = cf.id\n" +
                "WHERE\n" +
                "    (cm.age >= 0 AND cm.age <= 5)\n" +
                "        AND cf.community_id = ?\n" +
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

        List<ReportChild3Entity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        ReportChild3Entity entity = new ReportChild3Entity();

        try {
            entity.setUnder1(rs.getInt("under1"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAge1(rs.getInt("age1"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAge2(rs.getInt("age2"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAge3(rs.getInt("age3"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAge4(rs.getInt("age4"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAge5(rs.getInt("age5"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTotal(rs.getInt("total"));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
