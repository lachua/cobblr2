
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author user
 */
public class CompareDate {

    public static int compareDates(Date d){
        CompareDate cd = new CompareDate();
        return cd.compare(d);
    }
    
    public int compare(Date d) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d);
        stripTime(cal1);

        Calendar cal2 = Calendar.getInstance();
        stripTime(cal2);
        
        int i = cal2.compareTo(cal1);
        
        return i;
    }

    private void stripTime(Calendar c) {
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.SECOND, 0); 
    }
    
    public static long getDateDiff(Date date1, TimeUnit timeUnit) {
    long diffInMillies = date1.getTime() - Calendar.getInstance().getTime().getTime();
    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
}
}
