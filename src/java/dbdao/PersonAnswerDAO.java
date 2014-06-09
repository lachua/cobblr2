/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import static dbdao.templates.QueryTemplate.df;
import dbentities.AnswerEntity;
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
public class PersonAnswerDAO extends QueryTemplate {

//    private int survey_id;
//    private int question_id;
//    private int offeredanswer_id;
//    private int id;
//    private Calendar date_answered;
//    private String otheranswer;
    public boolean insertAnswer( int person_id, String query, int project_id) {
        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + person_id);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        return executeUpdate();
    }
    
    public boolean insertAnswer(AnswerEntity answer) {
        return insertAnswer(answer.getSurvey_id(), answer.getQuestion_id(), answer.getOfferedanswer_id(), answer.getId(), answer.getDate_answered(), answer.getOtheranswer());
    }

    public boolean insertAnswer(int survey_id, int question_id, int offeredanswer_id, int person_id, Calendar date_answered, String otheranswer) {
        setQuery("insert into person_answer (survey_id, question_id, offeredanswer_id, person_id, date_answered, otheranswer) values (?,?,?,?,?,?)");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
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
        onePair.setValue("" + person_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(date_answered.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(otheranswer);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public boolean deleteAnswer(AnswerEntity answer) {
        return deleteAnswer(answer.getSurvey_id(), answer.getQuestion_id(), answer.getOfferedanswer_id(), answer.getId(), answer.getDate_answered(), answer.getOtheranswer());
    }

    public boolean deleteAnswer(int survey_id, int question_id, int offeredanswer_id, int person_id, Calendar date_answered, String otheranswer) {
        setQuery("delete from person_answer where survey_id = ? and question_id = ? and offeredanswer_id = ? and person_id = ? and date_answered = ? and otheranswer = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
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
        onePair.setValue("" + person_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(date_answered.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(otheranswer);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public AnswerEntity getAnswer(int survey_id, int question_id, int offeredanswer_id, int person_id, Calendar date_answered, String otheranswer) {
        setQuery("select * from person_answer where survey_id = ? and question_id = ? and offeredanswer_id = ? and person_id = ? and date_answered = ? and otheranswer = ?");
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
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
        onePair.setValue("" + person_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue(df.format(date_answered.getTime()));
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(otheranswer);
        getParameters().add(onePair);

        List<AnswerEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0);
        } else {
            return null;
        }
    }

    public List<AnswerEntity> getAllAnswers() {
        setQuery("select * from person_answer");

        List<AnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //COUNT PEOPLES AGES BY COMMUNITY, GENDER, AND YEAR
    //returns age column as question_id and count as offeredanswer_id
    public List<AnswerEntity> countAgeMales(int community_id, int year) {
        return countAgeByGender(community_id, year, "M");
    }

    //returns age column as question_id and count as offeredanswer_id
    public List<AnswerEntity> countAgeFemales(int community_id, int year) {
        return countAgeByGender(community_id, year, "F");
    }

    //returns age column as question_id and count as offeredanswer_id
    public List<AnswerEntity> countAgeByGender(int community_id, int year, String gender) {
        String query = "SELECT \n"
                + "cm.age as question_id, COUNT(cm.age) as offeredanswer_id\n"
                + "FROM\n"
                + "    community_members cm\n"
                + "        INNER JOIN\n"
                + "    community_family cf ON cm.family_id = cf.id\n"
                + "WHERE\n"
                + "    cf.community_id = ? AND cm.gender = ?\n"
                + "        AND YEAR(date_created) = ?\n"
                + "GROUP BY age";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(gender);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year);
        getParameters().add(onePair);

        List<AnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    //COUNT PEOPLE SURVEYED BY COMMUNITY, GENDER, AND YEAR
    public int countPeoplesurveyed(int community_id, int year) {
        int males;
        int females;

        males = countMalesSurveyed(community_id, year);
        females = countFemalesSurveyed(community_id, year);

        return males + females;
    }

    public int countMalesSurveyed(int community_id, int year) {
        return countGenderSurveyed(community_id, year, "M");
    }

    public int countFemalesSurveyed(int community_id, int year) {
        return countGenderSurveyed(community_id, year, "F");
    }

    public int countGenderSurveyed(int community_id, int year, String gender) {
        String query = "SELECT \n"
                + "    COUNT(DISTINCT pa.person_id) AS question_id\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        *\n"
                + "    FROM\n"
                + "        community_members cm\n"
                + "    INNER JOIN community_family cf ON cm.family_id = cf.id\n"
                + "    WHERE\n"
                + "        cf.community_id = ?\n"
                + "            AND YEAR(date_created) = ?) peeps\n"
                + "        INNER JOIN\n"
                + "    person_answer pa ON peeps.person_id = pa.person_id\n"
                + "WHERE\n"
                + "    peeps.gender = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(gender);
        getParameters().add(onePair);

        List<AnswerEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0).getQuestion_id();
        } else {
            return 0;
        }
    }

    //COUNT OCCUPATIONS
    public List<AnswerEntity> getCountOccupations(int community_id, int year) {
        String query = "SELECT \n"
                + "    pa.otheranswer AS otheranswer, COUNT(pa.otheranswer) AS offeredanswer_id\n"
                + "FROM\n"
                + "    person_answer pa\n"
                + "        INNER JOIN\n"
                + "    community_members cm ON pa.person_id = cm.person_id\n"
                + "        INNER JOIN\n"
                + "    community_family cf ON cm.family_id = cf.id\n"
                + "WHERE\n"
                + "    cf.community_id = ?\n"
                + "        AND YEAR(pa.date_answered) = ?\n"
                + "        AND pa.question_id = 40\n"
                + "GROUP BY pa.otheranswer";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + year);
        getParameters().add(onePair);

        List<AnswerEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        AnswerEntity answer = new AnswerEntity();

        try {
            answer.setSurvey_id(rs.getInt("survey_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setId(rs.getInt("person_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date date;
        try {
            date = rs.getDate("date_answered");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            answer.setDate_answered(cal);
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            answer.setOtheranswer(rs.getString("otheranswer"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return answer;
    }
}
