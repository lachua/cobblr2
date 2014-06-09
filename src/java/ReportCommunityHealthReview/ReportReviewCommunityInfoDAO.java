/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportCommunityHealthReview;

import dbdao.*;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.AnswerTallyEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ReportReviewCommunityInfoDAO extends QueryTemplate {

    public String getCommunityName(int community_id) {

        String query = "SELECT \n"
                + "    name\n"
                + "FROM\n"
                + "    community\n"
                + "WHERE\n"
                + "    id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        List<String> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        String communityName = "";
        
        try {
            communityName = rs.getString("name");
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewCommunityInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return communityName;
    }
}
