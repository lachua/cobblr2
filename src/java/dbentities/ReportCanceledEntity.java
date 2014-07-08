/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbentities;

import java.util.Date;

/**
 *
 * @author Renliw
 */
public class ReportCanceledEntity {
    private Date date_cancelled;
    private String community_name;
    private String org_name;
    private String cancel_reason;

    /**
     * @return the date_cancelled
     */
    public Date getDate_cancelled() {
        return date_cancelled;
    }

    /**
     * @param date_cancelled the date_cancelled to set
     */
    public void setDate_cancelled(Date date_cancelled) {
        this.date_cancelled = date_cancelled;
    }

    /**
     * @return the community_name
     */
    public String getCommunity_name() {
        return community_name;
    }

    /**
     * @param community_name the community_name to set
     */
    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    /**
     * @return the org_name
     */
    public String getOrg_name() {
        return org_name;
    }

    /**
     * @param org_name the org_name to set
     */
    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    /**
     * @return the cancel_reason
     */
    public String getCancel_reason() {
        return cancel_reason;
    }

    /**
     * @param cancel_reason the cancel_reason to set
     */
    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }
}
