/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao.templates;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joanna Charmaine
 */
public abstract class QueryTemplate extends DAOTemplate {

    private InputStream inputStream;
    private String query;
    private ArrayList<KeyValuePair> parameters = new ArrayList<>();
    ArrayList resultset;
    public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public int performUpdate() {
        try {
            PreparedStatement pstmt = getConn().prepareStatement(getQuery());
            KeyValuePair onePair;
            for (int i = 0; i < getParameters().size(); i++) {
                onePair = getParameters().get(i);
                switch (onePair.getKey()) {
                    case KeyValuePair.STRING:
                        pstmt.setString(i + 1, onePair.getValue().toString());
                        break;
                    case KeyValuePair.INT:
                        pstmt.setInt(i + 1, Integer.parseInt(String.valueOf(onePair.getValue())));
                        break;
                    case KeyValuePair.DOUBLE:
                        pstmt.setDouble(i + 1, Double.parseDouble(String.valueOf(onePair.getValue())));
                    case KeyValuePair.DATE:
                        try {
                            Date date = df.parse(String.valueOf(onePair.getValue()));
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                            pstmt.setDate(i + 1, sqlDate);
                        } catch (ParseException ex) {
                            Logger.getLogger(QueryTemplate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case KeyValuePair.FILE:
                        inputStream = (InputStream)onePair.getValue();
                        pstmt.setBinaryStream(i + 1, inputStream);
                        break;
                }
            }
            int numRowsAffected = pstmt.executeUpdate();
            return numRowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(QueryTemplate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(QueryTemplate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    protected abstract Object storeResults(ResultSet rs);

    @Override
    public ArrayList performQuery() {
        try {
            PreparedStatement pstmt = getConn().prepareStatement(getQuery());
            KeyValuePair onePair;

            for (int i = 0; i < getParameters().size(); i++) {
                onePair = getParameters().get(i);
                switch (onePair.getKey()) {
                    case KeyValuePair.STRING:
                        pstmt.setString(i + 1, onePair.getValue().toString());
                        break;
                    case KeyValuePair.INT:
                        pstmt.setInt(i + 1, Integer.parseInt(String.valueOf(onePair.getValue())));
                        break;
                    case KeyValuePair.DOUBLE:
                        pstmt.setDouble(i + 1, Double.parseDouble(String.valueOf(onePair.getValue())));
                        break;
                    case KeyValuePair.DATE:
                        try {
                            Date date = df.parse(String.valueOf(onePair.getValue()));
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                            pstmt.setDate(i + 1, sqlDate);
                        } catch (ParseException ex) {
                            Logger.getLogger(QueryTemplate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                }
            }

            ResultSet rs = pstmt.executeQuery();
            resultset = new ArrayList();
            while (rs.next()) {
                resultset.add(storeResults(rs));
            }
            rs.close();
            return resultset;
        } catch (SQLException ex) {
            Logger.getLogger(QueryTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * @return the parameters
     */
    public ArrayList<KeyValuePair> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(ArrayList<KeyValuePair> parameters) {
        this.parameters = parameters;
    }
}
