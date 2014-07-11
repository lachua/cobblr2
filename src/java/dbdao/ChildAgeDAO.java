/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class ChildAgeDAO extends QueryTemplate{
    
    public Integer getGenderCount(int community_id, int year, String gender){
        setQuery("SELECT gender, count(gender) as count\n" +
                "FROM\n" +
                "	(SELECT community_id, family_id, pa.person_id, age, gender, answertext, date_answered\n" +
                "	FROM person_answer pa\n" +
                "	JOIN community_members cm\n" +
                "		ON pa.person_id = cm.person_id\n" +
                "	JOIN community_family cf\n" +
                "		ON cm.family_id = cf.id\n" +
                "	JOIN offeredanswer oa\n" +
                "		ON pa.offeredanswer_id = oa.offeredanswer_id\n" +
                "	WHERE survey_id = 5 \n" +
                "		AND YEAR(date_answered) = ?\n" +
                "		AND cf.community_id = ?\n" +
                "		AND gender = ?\n" +
                "	GROUP BY pa.person_id) A\n" +
                "GROUP BY gender\n" +
                "ORDER BY gender DESC");
        
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+year);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue(""+community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(""+gender);
        getParameters().add(onePair);

        List<Integer> results = executeQuery();

        if (results != null && !results.isEmpty()) {
            return results.get(0);
        } else {
            return 0;
        }
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        Integer entity = 0;

        try {
            entity = rs.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
    
}
