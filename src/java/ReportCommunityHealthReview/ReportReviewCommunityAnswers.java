/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportCommunityHealthReview;

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
public class ReportReviewCommunityAnswers extends QueryTemplate {

    public List<AnswerTallyEntity> tallyCommunityAnswers(int survey_id, int community_id, int surveyyear, int question_id, int limit) {

        String query = "SELECT \n"
                + "    sqa.question_id as question_id,\n"
                + "    sqa.offeredanswer_id as offeredanswer_id,\n"
                + "    IF(ans.count > 0, ans.count, 0) AS answercount\n"
                + "FROM\n"
                + "    survey_question_answer sqa\n"
                + "        LEFT JOIN\n"
                + "    (SELECT \n"
                + "        ca.question_id,\n"
                + "            ca.offeredanswer_id,\n"
                + "            COUNT(ca.offeredanswer_id) AS count\n"
                + "    FROM\n"
                + "        community_answer ca\n"
                + "    INNER JOIN community_family cf ON ca.family_id = cf.id\n"
                + "    WHERE\n"
                + "        ca.survey_id = ?\n"
                + "            AND YEAR(ca.date_answered) = ?\n"
                + "            AND cf.community_id = ?\n"
                + "    GROUP BY ca.question_id , ca.offeredanswer_id) ans ON sqa.question_id = ans.question_id\n"
                + "        AND sqa.offeredanswer_id = ans.offeredanswer_id\n"
                + "WHERE\n"
                + "    sqa.question_id = ?\n"
                + "GROUP BY sqa.question_id , sqa.offeredanswer_id\n"
                + "ORDER BY answercount DESC\n"
                + "LIMIT ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + question_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + limit);
        getParameters().add(onePair);        
        
        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public List<AnswerTallyEntity> tallyPersonAnswers(int survey_id, int community_id, int surveyyear, int question_id, int limit) {

        String query = "SELECT \n"
                + "    sqa.question_id as question_id,\n"
                + "    sqa.offeredanswer_id as offeredanswer_id,\n"
                + "    IF(ans.count > 0, ans.count, 0) AS answercount\n"
                + "FROM\n"
                + "    survey_question_answer sqa\n"
                + "        LEFT JOIN\n"
                + "    (SELECT \n"
                + "        pa.question_id,\n"
                + "            pa.offeredanswer_id,\n"
                + "            COUNT(pa.offeredanswer_id) AS count\n"
                + "    FROM\n"
                + "        person_answer pa\n"
                + "    INNER JOIN community_members cm ON pa.person_id = cm.person_id\n"
                + "    INNER JOIN community_family cf ON cm.family_id = cf.id\n"
                + "    WHERE\n"
                + "        pa.survey_id = ?\n"
                + "            AND YEAR(pa.date_answered) = ?\n"
                + "            AND cf.community_id = ?\n"
                + "    GROUP BY pa.question_id , pa.offeredanswer_id) ans ON sqa.question_id = ans.question_id\n"
                + "        AND sqa.offeredanswer_id = ans.offeredanswer_id\n"
                + "WHERE\n"
                + "    sqa.question_id = ?\n"
                + "GROUP BY sqa.question_id , sqa.offeredanswer_id\n"
                + "ORDER BY answercount DESC\n"
                + "LIMIT ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + question_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + limit);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    public int countFamiliesSurveyed(int survey_id, int community_id, int surveyyear) {

        String query = "SELECT \n"
                + "    COUNT(DISTINCT ca.family_id) AS answercount\n"
                + "FROM\n"
                + "    community_answer ca\n"
                + "        INNER JOIN\n"
                + "    community_family cf ON ca.family_id = cf.id\n"
                + "WHERE\n"
                + "    ca.survey_id = ?\n"
                + "        AND YEAR(ca.date_answered) = ?\n"
                + "        AND cf.community_id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getAnswercount();
        } else {
            return 0;
        }
    }

    public int countPersonsSurveyed(int survey_id, int community_id, int surveyyear) {

        String query = "SELECT \n"
                + "    COUNT(DISTINCT pa.person_id) AS answercount\n"
                + "FROM\n"
                + "    person_answer pa\n"
                + "        INNER JOIN\n"
                + "    community_members cm ON pa.person_id = cm.person_id\n"
                + "        INNER JOIN\n"
                + "    community_family cf ON cm.family_id = cf.id\n"
                + "WHERE\n"
                + "    pa.survey_id = ?\n"
                + "        AND YEAR(pa.date_answered) = ?\n"
                + "        AND cf.community_id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + survey_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + surveyyear);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + community_id);
        getParameters().add(onePair);

        List<AnswerTallyEntity> results = executeQuery();

        if (results != null) {
            return results.get(0).getAnswercount();
        } else {
            return 0;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {

        AnswerTallyEntity at = new AnswerTallyEntity();
        try {
            at.setQuestion_id(rs.getInt("question_id"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewCommunityAnswers.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            at.setOfferedanswer_id(rs.getInt("offeredanswer_id"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewCommunityAnswers.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            at.setAnswercount(rs.getInt("answercount"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportReviewCommunityAnswers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return at;
    }
}
