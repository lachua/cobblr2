/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportProjectEval;

import dbdao.*;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class EvalCommunityDAO extends QueryTemplate {

    public String getCommunityName(int project_id) {

        String query = "SELECT \n"
                + "    c.name AS communityname\n"
                + "FROM\n"
                + "    project_charter pc\n"
                + "        INNER JOIN\n"
                + "    community c ON pc.community_id = c.id\n"
                + "WHERE\n"
                + "    pc.id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
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

        String title = "";

        try {
            title = rs.getString("communityname");
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return title;
    }
}
