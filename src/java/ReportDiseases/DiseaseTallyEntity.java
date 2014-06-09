/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportDiseases;

/**
 *
 * @author user
 */
public class DiseaseTallyEntity {
    private String illness;
    private int count;

    public DiseaseTallyEntity() {
        this.illness = "";
        this.count = 0;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
