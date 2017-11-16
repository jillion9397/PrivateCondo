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
public class News {
    private int NewsId;
    private String topic;
    private String description;
    private Date announceDate;

    public News() {
    }

    public News(int NewsId, String topic, String description, Date announceDate) {
        this.NewsId = NewsId;
        this.topic = topic;
        this.description = description;
        this.announceDate = announceDate;
    }

    public int getNewsId() {
        return NewsId;
    }

    public void setNewsId(int NewsId) {
        this.NewsId = NewsId;
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

    public Date getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(Date announceDate) {
        this.announceDate = announceDate;
    }
    
    
}
