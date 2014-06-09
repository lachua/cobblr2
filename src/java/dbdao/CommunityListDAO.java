/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbdao;

import dbdao.templates.QueryTemplate;
import dbentities.CommunityListEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class CommunityListDAO extends QueryTemplate{
    //Get User from username
    public List<CommunityListEntity> getAllCommunity() {
        setQuery("SELECT * FROM community;");

        List<CommunityListEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        CommunityListEntity entity = new CommunityListEntity();
        try {
            entity.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setAddress(rs.getString("address"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPhone(rs.getString("phone"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setMobile(rs.getString("mobile"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setEmail(rs.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
