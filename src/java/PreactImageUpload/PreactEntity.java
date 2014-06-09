/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PreactImageUpload;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author user
 */
public class PreactEntity {
    private int task_id;
    private int project_id;
    private InputStream inputStream;
    private int filesize; 
    
    public PreactEntity() {
        this.task_id = -1;
        this.project_id = -1;
        this.inputStream = null;
        this.filesize = -1;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }
    
}
