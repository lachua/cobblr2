/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.CommunityMembersEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class CommunityMembersDAO extends QueryTemplate {

    public List<CommunityMembersEntity> getAllMembers() {
        setQuery("select * from community_members");

        List<CommunityMembersEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    public int getNewMemberId() {
        setQuery("select * from community_members");

        List<CommunityMembersEntity> results = executeQuery();

        if (results != null) {
            return results.get(results.size()-1).getPerson_id();
        } else {
            return 0;
        }
    }

    public boolean insertMember(String query) {
        setQuery(query);

        boolean result = executeUpdate();
        return result;
    }
    
    public boolean insertMember(CommunityMembersEntity members) {
        setQuery("INSERT INTO community_members (family_id, givenname, age, gender, position) VALUES (?, ?, ?, ?, ?)");
        
        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + members.getFamily_id());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + members.getGivenname());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + members.getAge());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + members.getGender());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + members.getPosition());
        getParameters().add(onePair);
        
        
        boolean result = executeUpdate();
        return result;
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        CommunityMembersEntity entity = new CommunityMembersEntity();
        try {
            entity.setPerson_id(rs.getInt("person_id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setFamily_id(rs.getInt("family_id"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setGivenname(rs.getString("givenname"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAge(rs.getInt("age"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setGender(rs.getString("position"));
        } catch (SQLException ex) {
            Logger.getLogger(SurveyQuestionAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
}
