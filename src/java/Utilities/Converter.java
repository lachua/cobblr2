/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class Converter {

    public static Calendar toCalendar(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = (Date) formatter.parse(date.toString());
        } catch (ParseException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static java.sql.Date toDate(Calendar cal) {
        Date date = cal.getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public static String toString(Calendar cal) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String x = sdf.format(cal.getTime());
        return x;
    }

    public static String toStringYear(Calendar cal) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String x = sdf.format(cal.getTime());
        return x;
    }

    public static String toStringFullMdy(Calendar cal) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        String x = sdf.format(cal.getTime());
        return x;
    }

    public static String toSurveyAnswer(int answerindex) {
        String answer = "";
        if (answerindex == 201) {
            answer = "Strongly Disagree";
        } else if (answerindex == 202) {
            answer = "Disagree";
        } else if (answerindex == 203) {
            answer = "Neutral";
        } else if (answerindex == 204) {
            answer = "Agree";
        } else if (answerindex == 205) {
            answer = "Strongly Agree";
        }

        return answer;
    }

    // convert InputStream to String
    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
    
    // convert String to InputStream
    public static InputStream getInputStreamFromString(String str) {

        // convert String into InputStream
	InputStream is = new ByteArrayInputStream(str.getBytes());
 
        return is;
    }
}
