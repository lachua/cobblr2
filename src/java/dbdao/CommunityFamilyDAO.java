/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import Utilities.Converter;
import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.CommunityFamilyEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class CommunityFamilyDAO extends QueryTemplate{
    //Get User from username
    public int getLastId() {
        setQuery("SELECT * FROM community_family;");

        List<CommunityFamilyEntity> results = executeQuery();

        if (results != null) {
            return results.get(results.size()-1).getId();
        } else {
            return 0;
        }
    }
    
    //Insert New Family
    public boolean insertFamily(CommunityFamilyEntity family) {
        setQuery("INSERT INTO community_family (id, surname, address, years_residency, origin_father, origin_mother, type_of_family, community_id, date_created) VALUES (?,?,?,?,?,?,?,?,?);");
        
        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + family.getId());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + family.getSurname());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + family.getAddress());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + family.getYears_residency());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + family.getOrigin_father());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + family.getOrigin_mother());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.STRING);
        onePair.setValue("" + family.getType_of_family());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + family.getCommunity());
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.DATE);
        onePair.setValue("" + Converter.toDate(family.getDate_created()));
        getParameters().add(onePair);
        
        return executeUpdate();
    }
    
    @Override
    protected Object storeResults(ResultSet rs) {
        CommunityFamilyEntity entity = new CommunityFamilyEntity();
        try {
            entity.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setSurname(rs.getString("surname"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAddress(rs.getString("address"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setYears_residency(rs.getInt("years_residency"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrigin_father(rs.getString("origin_father"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrigin_mother(rs.getString("origin_mother"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setType_of_family(rs.getString("type_of_family"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity(rs.getInt("community_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDate_created(Converter.toCalendar(rs.getDate("date_created")));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
