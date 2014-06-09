/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportYearEndActivity;

/**
 *
 * @author user
 */
public class ReportStringIntPair {
    private String string;
    private int integer;

    public ReportStringIntPair() {
        this.string = "string";
        this.integer = -1;
    }    
    
    public ReportStringIntPair(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    
    
}
