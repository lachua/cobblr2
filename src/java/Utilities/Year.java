/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Renliw
 */
public class Year {

    public static Integer getCurrentYear() {
        Calendar cal = new GregorianCalendar();
        int x = cal.getWeekYear();
        return x;
    }

    public static Integer getPreviousYear() {
        Calendar cal = new GregorianCalendar();
        int x = cal.getWeekYear();
        return x - 1;
    }
    
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        String x = sdf.format(cal.getTime());
        return x;
    }
    
    public static Date getCurrentDateinDate() {
        Calendar cal = new GregorianCalendar();
        return Converter.toDate(cal);
    }
    
    public static String getPreviousDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.YEAR, -1);
        String x = sdf.format(cal.getTime());
        return x;
    }
    
    public static Calendar getCurrentDateinCalendar() {
        Calendar cal = Calendar.getInstance();
        return cal;
    }
    
    public static Calendar getPreviousDateinCalendar() {
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.YEAR, -1);
        return cal;
    }
    
    public static String getCurrentDatePlus(int x) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DATE, x);
        String y = sdf.format(cal.getTime());
        return y;
    }
    
    public static String getDatePlus(Calendar cal, int x) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.DATE, x);
        String y = sdf.format(cal.getTime());
        return y;
    }
    
    public static Date getDatePlusinDate(Calendar cal, int x) {
        cal.add(Calendar.DATE, x);
        return new java.sql.Date(cal.getTime().getTime());
    }
}
