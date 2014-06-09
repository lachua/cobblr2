/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportProjectEval;

/**
 *
 * @author user
 */
public class EvalProjectOrgDetailsEntity {

    private int project_id;
    private int org_id;
    private int student_idno;
    private String orgname;
    private String studentname;

    public EvalProjectOrgDetailsEntity(int project_id, int org_id, int student_idno, String orgname, String studentname) {
        this.project_id = project_id;
        this.org_id = org_id;
        this.student_idno = student_idno;
        this.orgname = orgname;
        this.studentname = studentname;
    }

    public EvalProjectOrgDetailsEntity() {
        this.project_id = 0;
        this.org_id = 0;
        this.student_idno = 0;
        this.orgname = "";
        this.studentname = "";
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public int getStudent_idno() {
        return student_idno;
    }

    public void setStudent_idno(int student_idno) {
        this.student_idno = student_idno;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
}
