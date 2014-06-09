/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PreactImageUpload;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class PreactUploadDAO extends QueryTemplate {

    public boolean uploadFile(int task_id, int project_id, InputStream inputstream) throws Exception, IOException, SQLException {
        String query = "INSERT INTO preact_image (task_id, project_id, image) values (?,?,?)";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + task_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.FILE);
        onePair.setValue(inputstream);
        getParameters().add(onePair);

//        InputStream tempStream = inputstream;
//        int filesize = 0;
//        int read = 0;
//
//        while ((read = tempStream.read()) != -1) {
//            filesize++;
//        }
//
//        onePair = new KeyValuePair();
//        onePair.setKey(KeyValuePair.INT);
//        onePair.setValue(filesize);
//        getParameters().add(onePair);

        return executeUpdate();
    }

    public boolean deleteFile(int task_id) {
        String query = "DELETE FROM preact_image \n"
                + "WHERE\n"
                + "    task_id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + task_id);
        getParameters().add(onePair);

        return executeUpdate();
    }

    public PreactEntity getPreact(int task_id) {

        String query = "SELECT * FROM preact_image WHERE task_id = ?";

        setQuery(query);
        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + task_id);
        getParameters().add(onePair);

        List<PreactEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }

    }

    @Override
    protected Object storeResults(ResultSet rs) {

        PreactEntity entity = new PreactEntity();
        try {
            entity.setTask_id(rs.getInt("task_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PreactUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setProject_id(rs.getInt("project_id"));
        } catch (SQLException ex) {
            Logger.getLogger(PreactUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entity.setInputStream(rs.getBinaryStream("image"));
        } catch (SQLException ex) {
            Logger.getLogger(PreactUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
