/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dbdao.OfferedAnswerDAO;
import dbentities.OfferedAnswerEntity;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class QuestionAnswerSet {
    private int questionid;
    private String questiontext;
    private HashMap<Integer, Integer> answerset;
    
    public QuestionAnswerSet(){
        this.questionid = 0;
        this.questiontext = "no question";
        this.answerset = new HashMap<Integer, Integer>(); //where Integer 1 is offeredanswer_id and Integer 2 is tally
    }

    public QuestionAnswerSet(int questionid, String questiontext) {
        this.questionid = questionid;
        this.questiontext = questiontext;
        this.answerset = new HashMap<Integer, Integer>();
    }

    public String getAnswerText(int answer_id){
        OfferedAnswerDAO ansDAO = new OfferedAnswerDAO();
        OfferedAnswerEntity answer = ansDAO.getOfferedAnswer(answer_id);
        
        return answer.getAnswertext();
    }

    public String getAnswerCategory(int answer_id){
        OfferedAnswerDAO ansDAO = new OfferedAnswerDAO();
        OfferedAnswerEntity answer = ansDAO.getOfferedAnswer(answer_id);
        
        return answer.getAnswer_category();
    }    
    
    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public HashMap<Integer, Integer> getAnswerset() {
        return answerset;
    }

    public void setAnswerset(HashMap<Integer, Integer> answerset) {
        this.answerset = answerset;
    }
}
