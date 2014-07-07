/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

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
public class AnswerTallyDAO extends QueryTemplate {

//    private int question_id;
//    private int offeredanswer_id;
//    private int answercount;
    private static int survey_id = 1;

    public List<AnswerTallyEntity> tallyAnswers(int community_id, int surveyyear) {

        String query = "SELECT \n"
                + "    qas.survey_id,\n"
                + "    qas.question_id,\n"
                + "    qas.offeredanswer_id,\n"
                + "    COUNT(commans.offeredanswer_id) AS answercount\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        sq.survey_id, sq.question_id, sqa.offeredanswer_id\n"
                + "    FROM\n"
                + "        survey_question sq\n"
                + "    LEFT JOIN survey_question_answer sqa ON sq.survey_id = sqa.survey_id\n"
                + "        AND sq.question_id = sqa.question_id\n"
                + "    WHERE\n"
                + "        sq.survey_id = 1) qas\n"
                + "        LEFT JOIN\n"
                + "    (SELECT \n"
                + "        *\n"
                + "    FROM\n"
                + "        community_answer\n"
                + "    INNER JOIN (SELECT \n"
                + "        community_family.id AS id\n"
                + "    FROM\n"
                + "        community\n"
                + "    INNER JOIN community_family ON community.id = community_family.community_id\n"
                + "    WHERE\n"
                + "        community.id = ?) comm ON community_answer.family_id = comm.id\n"
                + "    WHERE\n"
                + "        YEAR(date_answered) = ?) commans ON qas.question_id = commans.question_id\n"
                + "        AND qas.offeredanswer_id = commans.offeredanswer_id\n"
                + "GROUP BY qas.question_id , qas.offeredanswer_id\n"
                + "ORDER BY question_id , offeredanswer_id";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<AnswerTallyEntity> tallyPersonAnswers(int community_id, int surveyyear) {

        String query = "SELECT \n"
                + "    qas.survey_id,\n"
                + "    qas.question_id,\n"
                + "    qas.offeredanswer_id,\n"
                + "    COUNT(commans.offeredanswer_id) AS answercount\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        sq.survey_id, sq.question_id, sqa.offeredanswer_id\n"
                + "    FROM\n"
                + "        survey_question sq\n"
                + "    LEFT JOIN survey_question_answer sqa ON sq.survey_id = sqa.survey_id\n"
                + "        AND sq.question_id = sqa.question_id\n"
                + "    WHERE\n"
                + "        sq.survey_id = 2) qas\n"
                + "        LEFT JOIN\n"
                + "    (SELECT \n"
                + "        pa.survey_id,\n"
                + "            pa.person_id,\n"
                + "            pa.question_id,\n"
                + "            pa.offeredanswer_id\n"
                + "    FROM\n"
                + "        community_family cf\n"
                + "    INNER JOIN community_members cm ON cf.id = cm.family_id\n"
                + "    INNER JOIN person_answer pa ON pa.person_id = cm.person_id\n"
                + "    WHERE\n"
                + "        community_id = ?\n"
                + "            AND YEAR(pa.date_answered) = ?) commans ON qas.question_id = commans.question_id\n"
                + "        AND qas.offeredanswer_id = commans.offeredanswer_id\n"
                + "GROUP BY qas.question_id , qas.offeredanswer_id\n"
                + "ORDER BY question_id , offeredanswer_id";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    public List<AnswerTallyEntity> tallyChildAnswers(int community_id, int surveyyear) {

        String query = "SELECT \n"
                + "    qas.survey_id,\n"
                + "    qas.question_id,\n"
                + "    qas.offeredanswer_id,\n"
                + "    COUNT(commans.offeredanswer_id) AS answercount\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        sq.survey_id, sq.question_id, sqa.offeredanswer_id\n"
                + "    FROM\n"
                + "        survey_question sq\n"
                + "    LEFT JOIN survey_question_answer sqa ON sq.survey_id = sqa.survey_id\n"
                + "        AND sq.question_id = sqa.question_id\n"
                + "    WHERE\n"
                + "        sq.survey_id = 5) qas\n"
                + "        LEFT JOIN\n"
                + "    (SELECT \n"
                + "        pa.survey_id,\n"
                + "            pa.person_id,\n"
                + "            pa.question_id,\n"
                + "            pa.offeredanswer_id\n"
                + "    FROM\n"
                + "        community_family cf\n"
                + "    INNER JOIN community_members cm ON cf.id = cm.family_id\n"
                + "    INNER JOIN person_answer pa ON pa.person_id = cm.person_id\n"
                + "    WHERE\n"
                + "        community_id = ?\n"
                + "            AND YEAR(pa.date_answered) = ?) commans ON qas.question_id = commans.question_id\n"
                + "        AND qas.offeredanswer_id = commans.offeredanswer_id\n"
                + "GROUP BY qas.question_id , qas.offeredanswer_id\n"
                + "ORDER BY question_id , offeredanswer_id";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<AnswerTallyEntity> tallyAgesByGender(int community_id, int surveyyear, String gender) {

        String query = "SELECT \n"
                + "    cm.age AS question_id, COUNT(cm.age) AS answercount\n"
                + "FROM\n"
                + "    community_members cm\n"
                + "        INNER JOIN\n"
                + "    (SELECT DISTINCT\n"
                + "        person_id\n"
                + "    FROM\n"
                + "        person_answer\n"
                + "    WHERE\n"
                + "        survey_id = 2\n"
                + "            AND YEAR(date_answered) = ?) pa ON cm.person_id = pa.person_id\n"
                + "        INNER JOIN\n"
                + "    community_family cf ON cm.family_id = cf.id\n"
                + "WHERE\n"
                + "    cf.community_id = ? AND cm.gender = ?\n"
                + "GROUP BY age";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue(gender);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public Integer countFamilies(int community_id, int surveyyear) {

        String query = "SELECT  "
                + "    COUNT(DISTINCT comm.family_id) AS answercount "
                + "FROM "
                + "    community_answer ca "
                + "        INNER JOIN "
                + "    (SELECT  "
                + "        community_family.id AS family_id "
                + "    FROM "
                + "        community "
                + "    INNER JOIN community_family ON community.id = community_family.community_id "
                + "    WHERE "
                + "        community.id = ?) comm ON ca.family_id = comm.family_id "
                + "WHERE "
                + "    YEAR(date_answered) = ? AND survey_id = " + survey_id;

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null && results.size() == 1) {
            return results.get(0).getAnswercount();
        } else {
            return null;
        }
    }

    //returns family_id as question_id and number of people in that family as answercount
    public List<AnswerTallyEntity> countFamilyMembers(int community_id, int surveyyear) {

        String query = "SELECT \n"
                + "    cm.family_id AS question_id, COUNT(person_id) AS answercount\n"
                + "FROM\n"
                + "    community_members cm\n"
                + "        INNER JOIN\n"
                + "    (SELECT \n"
                + "        cf.id AS family_id\n"
                + "    FROM\n"
                + "        community_family cf\n"
                + "    INNER JOIN community_answer ca ON cf.id = ca.family_id\n"
                + "    WHERE\n"
                + "        cf.community_id = ?\n"
                + "            AND YEAR(ca.date_answered) = ?\n"
                + "            AND survey_id = ?\n"
                + "    GROUP BY cf.id) fam ON cm.family_id = fam.family_id\n"
                + "GROUP BY cm.family_id";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        //survey id 1
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + 1);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        AnswerTallyEntity at = new AnswerTallyEntity();
        try {
            at.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            at.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            at.setAnswercount(rs.getInt("answercount"));
        } catch (SQLException ex) {
            Logger.getLogger(AnswerTallyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return at;
    }
}
