/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao.templates;

import db.DBConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joanna Charmaine
 */
public abstract class DAOTemplate {

    private DBConnectionFactory myFactory;
    private Connection conn;

    public boolean executeUpdate() {
        try {
            setMyFactory(DBConnectionFactory.getInstance());
            setConn(getMyFactory().getConnection());
            conn.setAutoCommit(false);
            int numRowsAffected = performUpdate();
            conn.commit();
            getConn().close();
            return numRowsAffected >= 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex);

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

        } finally {
            if (getConn() != null) {
                try {
                    conn.setAutoCommit(true);
                    getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public abstract int performUpdate();

    public List executeQuery() {
        try {
            setMyFactory(DBConnectionFactory.getInstance());
            setConn(getMyFactory().getConnection());
            List result = performQuery();
            getConn().close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (getConn() != null) {
                try {
                    getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public abstract List performQuery();

    /**
     * @return the myFactory
     */
    public DBConnectionFactory getMyFactory() {
        return myFactory;
    }

    /**
     * @param myFactory the myFactory to set
     */
    public void setMyFactory(DBConnectionFactory myFactory) {
        this.myFactory = myFactory;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }
}