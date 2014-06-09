/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao.templates;

/**
 *
 * @author Joanna Charmaine
 */
public class KeyValuePair {
    public static final String STRING="String";
    public static final String INT="Int";
    public static final String DOUBLE="Double";
    public static final String DATE="Date";
    public static final String FILE="File";
    private String key;
    private Object value;

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
}

