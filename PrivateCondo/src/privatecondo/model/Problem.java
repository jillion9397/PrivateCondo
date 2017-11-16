/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.model;

import java.util.Date;

/**
 *
 * @author poom029
 */
public class Problem {
    public static final int TYPE_TODO=1;
    public static final int TYPE_DOING=2;
    public static final int TYPE_DONE=2;
       
    private int problemId;
    private String topic;
    private String description;
    private Date reportDate;
    private User Reporter;
    private int statusType;
    private String statusTypeStr;

    public Problem() {
    }

    public Problem(int problemId, String topic, String description, Date reportDate, User Reporter, int statusType, String statusTypeStr) {
        this.problemId = problemId;
        this.topic = topic;
        this.description = description;
        this.reportDate = reportDate;
        this.Reporter = Reporter;
        this.statusType = statusType;
        this.statusTypeStr = statusTypeStr;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public User getReporter() {
        return Reporter;
    }

    public void setReporter(User Reporter) {
        this.Reporter = Reporter;
    }

    public int getStatusType() {
        return statusType;
    }

    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }

    public String getStatusTypeStr() {
        return statusTypeStr;
    }

    public void setStatusTypeStr(String statusTypeStr) {
        this.statusTypeStr = statusTypeStr;
    }
    
    
    
}
