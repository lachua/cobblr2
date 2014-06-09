/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportDiseases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author user
 */
public class MorbidityReport {
    private Calendar periodStart;
    private Calendar periodEnd;
    private Calendar datePrinted;
    private List<DiseaseTallyEntity> diseaseList;

    public MorbidityReport(Calendar periodStart, Calendar periodEnd) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.datePrinted = Calendar.getInstance();
        this.diseaseList = new ArrayList<>();
        
        loadResults(periodStart, periodEnd);
    }

    private void loadResults(Calendar periodStart, Calendar periodEnd) {
        DiseaseTallyDAO dtDAO = new DiseaseTallyDAO();
        
        //Should already be sorted descending
        this.diseaseList = dtDAO.getTopDiseases(periodStart, periodEnd);
    }

    public Calendar getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Calendar periodStart) {
        this.periodStart = periodStart;
    }

    public Calendar getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Calendar periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Calendar getDatePrinted() {
        return datePrinted;
    }

    public void setDatePrinted(Calendar datePrinted) {
        this.datePrinted = datePrinted;
    }

    public List<DiseaseTallyEntity> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<DiseaseTallyEntity> diseaseList) {
        this.diseaseList = diseaseList;
    }
    
}
