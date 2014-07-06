/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilities;

import dbentities.ProjectTargetEntity;
import java.util.List;

/**
 *
 * @author Renliw
 */
public class Compare {
    public static boolean isProjectTarget(List<ProjectTargetEntity> targets, int answer){
        for(int x = 0; x < targets.size(); x++){
            if(targets.get(x).getOfferedanswer_id() == answer){
                return true;
            }
        }
        return false;
    }
}
