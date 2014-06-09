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
public class EvalProjectOrgDetailsDAO extends QueryTemplate {

    public EvalProjectOrgDetailsEntity getProjectOrgDetails(int project_id) {

        //IM NOT SURE WHAT STATUS IS SUPPOSED TO BE IMPLEMENTED BETTER CHANGE IT LATER
        String query = "SELECT \n"
                + "    op.project_id,\n"
                + "    op.org_id,\n"
                + "    op.student_idno,\n"
                + "    CONCAT(s.firstname, ' ', s.lastname) AS studentname,\n"
                + "    so.name AS orgname\n"
                + "FROM\n"
                + "    org_projects op\n"
                + "        INNER JOIN\n"
                + "    studentorg so ON op.org_id = so.id\n"
                + "        INNER JOIN\n"
                + "    students s ON op.student_idno = s.idno\n"
                + "WHERE\n"
                + "    op.project_id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<EvalProjectOrgDetailsEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        EvalProjectOrgDetailsEntity entity = new EvalProjectOrgDetailsEntity();

        try {
            entity.setProject_id(rs.getInt("project_id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setOrg_id(rs.getInt("org_id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setStudent_idno(rs.getInt("student_idno"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setStudentname(rs.getString("studentname"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setOrgname(rs.getString("orgname"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
