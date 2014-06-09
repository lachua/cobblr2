/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportProjectEval;

/**
 *
 * @author user
 */
public class EvalProjectEntity {

    private int project_id;
    private String title;

    public EvalProjectEntity() {
        project_id = 0;
        title = "";
    }

    public EvalProjectEntity(int project_id, String title) {
        this.project_id = project_id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
   
}
