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
public class EvalProjectDAO extends QueryTemplate {

    public String getProjectTitle(int project_id) {

        //IM NOT SURE WHAT STATUS IS SUPPOSED TO BE IMPLEMENTED BETTER CHANGE IT LATER
        String query = "SELECT \n"
                + "    id, title\n"
                + "FROM\n"
                + "    project_charter\n"
                + "WHERE\n"
                + "    id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<EvalProjectEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getTitle();
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        EvalProjectEntity entity = new EvalProjectEntity();

        try {
            entity.setProject_id(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
