/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.SurveyEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SurveyDAO extends QueryTemplate {

//    private int id;
//    private String title;
//    private String description;
//    private Calendar  date_created;
//    private int is_default; //0 if false, 1 if true
    public boolean createSurvey(Integer id, String title, String description, Calendar date_created, Integer is_default) {
        setQuery("insert into survey (id, title, description, date_created, is_default) values (?,?,?,?,?)");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(title);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(description);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(date_created.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + is_default);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public SurveyEntity getSurvey(Integer id) {
        setQuery("select * from survey where id = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + id);
        getParameters().add(onePair);

        List<SurveyEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        SurveyEntity survey = new SurveyEntity();

        try {
            survey.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            survey.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            survey.setTitle(rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Date datecreated = rs.getDate("date_created");
            Calendar cal = Calendar.getInstance();
            cal.setTime(datecreated);
            survey.setDate_created(cal);
        } catch (SQLException ex) {
            Logger.getLogger(SurveyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            survey.setIs_default(rs.getInt("is_default"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return survey;
    }
}
