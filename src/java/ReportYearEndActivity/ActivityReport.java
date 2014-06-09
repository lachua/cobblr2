/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportYearEndActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author user
 */
public class ActivityReport {

    //Constants
    private static int AVAILABLE = 0;
    private static int PENDING = 1;
    private static int CONFIRMED = 5;
    private static int ONGOING = 2;
    private static int IMPLEMENTED = 3;
    private static int CLOSED = 4;
    private static int CANCELLED = 6;

    /**
     * @return the AVAILABLE
     */
    public static int getAVAILABLE() {
        return AVAILABLE;
    }

    /**
     * @param aAVAILABLE the AVAILABLE to set
     */
    public static void setAVAILABLE(int aAVAILABLE) {
        AVAILABLE = aAVAILABLE;
    }

    /**
     * @return the PENDING
     */
    public static int getPENDING() {
        return PENDING;
    }

    /**
     * @param aPENDING the PENDING to set
     */
    public static void setPENDING(int aPENDING) {
        PENDING = aPENDING;
    }

    /**
     * @return the CONFIRMED
     */
    public static int getCONFIRMED() {
        return CONFIRMED;
    }

    /**
     * @param aCONFIRMED the CONFIRMED to set
     */
    public static void setCONFIRMED(int aCONFIRMED) {
        CONFIRMED = aCONFIRMED;
    }

    /**
     * @return the ONGOING
     */
    public static int getONGOING() {
        return ONGOING;
    }

    /**
     * @param aONGOING the ONGOING to set
     */
    public static void setONGOING(int aONGOING) {
        ONGOING = aONGOING;
    }

    /**
     * @return the IMPLEMENTED
     */
    public static int getIMPLEMENTED() {
        return IMPLEMENTED;
    }

    /**
     * @param aIMPLEMENTED the IMPLEMENTED to set
     */
    public static void setIMPLEMENTED(int aIMPLEMENTED) {
        IMPLEMENTED = aIMPLEMENTED;
    }

    /**
     * @return the CLOSED
     */
    public static int getCLOSED() {
        return CLOSED;
    }

    /**
     * @param aCLOSED the CLOSED to set
     */
    public static void setCLOSED(int aCLOSED) {
        CLOSED = aCLOSED;
    }

    /**
     * @return the CANCELLED
     */
    public static int getCANCELLED() {
        return CANCELLED;
    }

    /**
     * @param aCANCELLED the CANCELLED to set
     */
    public static void setCANCELLED(int aCANCELLED) {
        CANCELLED = aCANCELLED;
    }
    //Period start and end
    private Calendar dateStart;
    private Calendar dateEnd;
    //project status
    private int numAvailable;   //0
    private int numPending; //1
    private int numConfirmed;   //5
    private int numOngoing;     //2
    private int numImplemented; //3
    private int numClosed;  //4
    private int numCancelled;   //6
    private int numTotaProjects;
    //project popularity by type
    private List<ReportStringIntPair> activeProjectsList;
    private List<ReportStringIntPair> inactiveProjectsList;
    //project activity
    private List<ReportStringIntPair> orgActivityList;
    private List<ReportStringIntPair> communityDistributionList;
    //cancelled projects
    private List<ReportProjectEntity> cancelledProjectsList;
    //very inactive projects
    private int numDeadProjects;
    private List<ReportProjectEntity> deadProjectsList;
    private String preparedBy;
    private Calendar datePrinted;

    public ActivityReport(Calendar dateStart, Calendar dateEnd) {

        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        //project status
        this.numAvailable = -1;
        this.numPending = -1;
        this.numConfirmed = -1;
        this.numOngoing = -1;
        this.numImplemented = -1;
        this.numClosed = -1;
        this.numCancelled = -1;
        this.numTotaProjects = 0;
        //project popularity by type
        this.activeProjectsList = new ArrayList();
        this.inactiveProjectsList = new ArrayList();
        //project activity
        this.orgActivityList = new ArrayList();
        this.communityDistributionList = new ArrayList();
        //cancelled projects
        this.cancelledProjectsList = new ArrayList();
        //very inactive projects
        this.numDeadProjects = 0;
        this.deadProjectsList = new ArrayList();
        this.preparedBy = "prepared by";
        this.datePrinted = Calendar.getInstance();

        loadResults(dateStart, dateEnd);
    }

    private void loadResults(Calendar dateStart, Calendar dateEnd) {

        //Project Stats
        ReportProjectDAO rpDAO = new ReportProjectDAO();
        setNumAvailable(rpDAO.countProjectsCreated(dateStart, dateEnd));

        rpDAO = new ReportProjectDAO();
        setNumPending(rpDAO.countProjectsWithStatus(getPENDING(), dateStart, dateEnd));

        rpDAO = new ReportProjectDAO();
        setNumConfirmed(rpDAO.countProjectsWithStatus(getCONFIRMED(), dateStart, dateEnd));

        rpDAO = new ReportProjectDAO();
        setNumOngoing(rpDAO.countProjectsWithStatus(getONGOING(), dateStart, dateEnd));

        rpDAO = new ReportProjectDAO();
        setNumImplemented(rpDAO.countProjectsWithStatus(getIMPLEMENTED(), dateStart, dateEnd));

        rpDAO = new ReportProjectDAO();
        setNumClosed(rpDAO.countProjectsWithStatus(getCLOSED(), dateStart, dateEnd));

        rpDAO = new ReportProjectDAO();
        setNumCancelled(rpDAO.countProjectsWithStatus(getCANCELLED(), dateStart, dateEnd));

        rpDAO = new ReportProjectDAO();
        setNumTotaProjects(rpDAO.countProjectsTotal(dateStart, dateEnd));

        //Popularity per type
        ReportProjectTallyDAO rptDAO = new ReportProjectTallyDAO();
        setActiveProjectsList(rptDAO.getActiveProjectsPerType(dateStart, dateEnd));

        rptDAO = new ReportProjectTallyDAO();
        setInactiveProjectsList(rptDAO.getInactiveProjectsPerType(dateStart, dateEnd));

        //Project Activity
        rptDAO = new ReportProjectTallyDAO();
        setOrgActivityList(rptDAO.getActiveProjectsByOrg(dateStart, dateEnd));

        rptDAO = new ReportProjectTallyDAO();
        setCommunityDistributionList(rptDAO.getActiveProjectsByCommunity(dateStart, dateEnd));

        //Cancelled Projects
        rpDAO = new ReportProjectDAO();
        setCancelledProjectsList(rpDAO.getProjectsWithStatus(getCANCELLED(), dateStart, dateEnd));

        //Older than 1 year
        rpDAO = new ReportProjectDAO();
        setDeadProjectsList(rpDAO.getDeadProjectsList());

        if (getDeadProjectsList() != null && !deadProjectsList.isEmpty()) {
            setNumDeadProjects(getDeadProjectsList().size());
        }else{
            setNumDeadProjects(0);
        }
    }

    /**
     * @return the dateStart
     */
    public Calendar getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @return the dateEnd
     */
    public Calendar getDateEnd() {
        return dateEnd;
    }

    /**
     * @param dateEnd the dateEnd to set
     */
    public void setDateEnd(Calendar dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * @return the numAvailable
     */
    public int getNumAvailable() {
        return numAvailable;
    }

    /**
     * @param numAvailable the numAvailable to set
     */
    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

    /**
     * @return the numPending
     */
    public int getNumPending() {
        return numPending;
    }

    /**
     * @param numPending the numPending to set
     */
    public void setNumPending(int numPending) {
        this.numPending = numPending;
    }

    /**
     * @return the numConfirmed
     */
    public int getNumConfirmed() {
        return numConfirmed;
    }

    /**
     * @param numConfirmed the numConfirmed to set
     */
    public void setNumConfirmed(int numConfirmed) {
        this.numConfirmed = numConfirmed;
    }

    /**
     * @return the numOngoing
     */
    public int getNumOngoing() {
        return numOngoing;
    }

    /**
     * @param numOngoing the numOngoing to set
     */
    public void setNumOngoing(int numOngoing) {
        this.numOngoing = numOngoing;
    }

    /**
     * @return the numImplemented
     */
    public int getNumImplemented() {
        return numImplemented;
    }

    /**
     * @param numImplemented the numImplemented to set
     */
    public void setNumImplemented(int numImplemented) {
        this.numImplemented = numImplemented;
    }

    /**
     * @return the numClosed
     */
    public int getNumClosed() {
        return numClosed;
    }

    /**
     * @param numClosed the numClosed to set
     */
    public void setNumClosed(int numClosed) {
        this.numClosed = numClosed;
    }

    /**
     * @return the numCancelled
     */
    public int getNumCancelled() {
        return numCancelled;
    }

    /**
     * @param numCancelled the numCancelled to set
     */
    public void setNumCancelled(int numCancelled) {
        this.numCancelled = numCancelled;
    }

    /**
     * @return the numTotaProjects
     */
    public int getNumTotaProjects() {
        return numTotaProjects;
    }

    /**
     * @param numTotaProjects the numTotaProjects to set
     */
    public void setNumTotaProjects(int numTotaProjects) {
        this.numTotaProjects = numTotaProjects;
    }

    /**
     * @return the activeProjectsList
     */
    public List<ReportStringIntPair> getActiveProjectsList() {
        return activeProjectsList;
    }

    /**
     * @param activeProjectsList the activeProjectsList to set
     */
    public void setActiveProjectsList(List<ReportStringIntPair> activeProjectsList) {
        this.activeProjectsList = activeProjectsList;
    }

    /**
     * @return the inactiveProjectsList
     */
    public List<ReportStringIntPair> getInactiveProjectsList() {
        return inactiveProjectsList;
    }

    /**
     * @param inactiveProjectsList the inactiveProjectsList to set
     */
    public void setInactiveProjectsList(List<ReportStringIntPair> inactiveProjectsList) {
        this.inactiveProjectsList = inactiveProjectsList;
    }

    /**
     * @return the orgActivityList
     */
    public List<ReportStringIntPair> getOrgActivityList() {
        return orgActivityList;
    }

    /**
     * @param orgActivityList the orgActivityList to set
     */
    public void setOrgActivityList(List<ReportStringIntPair> orgActivityList) {
        this.orgActivityList = orgActivityList;
    }

    /**
     * @return the communityDistributionList
     */
    public List<ReportStringIntPair> getCommunityDistributionList() {
        return communityDistributionList;
    }

    /**
     * @param communityDistributionList the communityDistributionList to set
     */
    public void setCommunityDistributionList(List<ReportStringIntPair> communityDistributionList) {
        this.communityDistributionList = communityDistributionList;
    }

    /**
     * @return the cancelledProjectsList
     */
    public List<ReportProjectEntity> getCancelledProjectsList() {
        return cancelledProjectsList;
    }

    /**
     * @param cancelledProjectsList the cancelledProjectsList to set
     */
    public void setCancelledProjectsList(List<ReportProjectEntity> cancelledProjectsList) {
        this.cancelledProjectsList = cancelledProjectsList;
    }

    /**
     * @return the numDeadProjects
     */
    public int getNumDeadProjects() {
        return numDeadProjects;
    }

    /**
     * @param numDeadProjects the numDeadProjects to set
     */
    public void setNumDeadProjects(int numDeadProjects) {
        this.numDeadProjects = numDeadProjects;
    }

    /**
     * @return the deadProjectsList
     */
    public List<ReportProjectEntity> getDeadProjectsList() {
        return deadProjectsList;
    }

    /**
     * @param deadProjectsList the deadProjectsList to set
     */
    public void setDeadProjectsList(List<ReportProjectEntity> deadProjectsList) {
        this.deadProjectsList = deadProjectsList;
    }

    /**
     * @return the preparedBy
     */
    public String getPreparedBy() {
        return preparedBy;
    }

    /**
     * @param preparedBy the preparedBy to set
     */
    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    /**
     * @return the datePrinted
     */
    public Calendar getDatePrinted() {
        return datePrinted;
    }

    /**
     * @param datePrinted the datePrinted to set
     */
    public void setDatePrinted(Calendar datePrinted) {
        this.datePrinted = datePrinted;
    }
}
