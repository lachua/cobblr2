/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.FilterEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class FilterDAO extends QueryTemplate{
    //Get Community
    public List<FilterEntity> getFilterData(Integer question_id, Integer offeredanswer_id, Integer year) {
        setQuery("SELECT \n" +
                "    totalpop.comm_id AS 'community_id',\n" +
                "    totalpop.tpop AS 'total_community_members',\n" +
                "    IFNULL(affected.count, 0) AS 'total_affected',\n" +
                "    ((IFNULL(affected.count, 0) / totalpop.tpop) * 100) AS 'percent_affected'\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        cf.community_id AS 'comm_id',\n" +
                "            IFNULL(COUNT(DISTINCT cm.person_id), 0) AS 'tpop'\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    LEFT JOIN community_members cm ON pa.person_id = cm.person_id\n" +
                "    LEFT JOIN community_family cf ON cm.family_id = cf.id\n" +
                "    WHERE\n" +
                "        YEAR(date_answered) = ? \n" +
                "    GROUP BY community_id) totalpop\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        cf.community_id AS 'comm_id',\n" +
                "            COUNT(pa.offeredanswer_id) AS 'count'\n" +
                "    FROM\n" +
                "        person_answer pa\n" +
                "    LEFT JOIN community_members cm ON pa.person_id = cm.person_id\n" +
                "    LEFT JOIN community_family cf ON cm.family_id = cf.id\n" +
                "    WHERE\n" +
                "        question_id = ? \n" +
                "            AND offeredanswer_id = ? \n" +
                "            AND YEAR(date_answered) = ? \n" +
                "    GROUP BY community_id) affected ON totalpop.comm_id = affected.comm_id " +
                " WHERE totalpop.comm_id IS NOT NULL;");

        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + question_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + offeredanswer_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year);
        getParameters().add(onePair);
        
        List<FilterEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        FilterEntity entity = new FilterEntity();
        try {
            entity.setCommunity_id(rs.getInt("community_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTotal_community_members(rs.getInt("total_community_members"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTotal_affected(rs.getInt("total_affected"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPercent_affected(rs.getDouble("percent_affected"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
}
