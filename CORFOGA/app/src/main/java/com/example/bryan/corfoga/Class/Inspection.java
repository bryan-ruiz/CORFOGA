package com.example.bryan.corfoga.Class;

import com.example.bryan.corfoga.Database.DataBaseHelper;
import com.example.bryan.corfoga.Database.DataBaseContract;
/**
 * Created by Bryan on 26/02/2018.
 */

public class Inspection {
    private String idInspection;
    private String weight;
    private String scrotalCircumference;
    private String FeedSystem;
    private String comment;

    public Inspection(String idInspection, String weight, String scrotalCircumference, String feedSystem, String comment) {
        this.idInspection = idInspection;
        this.weight = weight;
        this.scrotalCircumference = scrotalCircumference;
        FeedSystem = feedSystem;
        this.comment = comment;
    }

    public String getInspectionId() {
        return this.idInspection;
    }

    public void setInspectionId(String animalId) {
        this.idInspection = animalId;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getScrotalCircumference() {
        return this.scrotalCircumference;
    }

    public void setScrotalCircumference(String scrotalCircumference) {
        this.scrotalCircumference = scrotalCircumference;
    }

    public String getFeedSystem() {
        return this.FeedSystem;
    }

    public void setFeedSystem(String feedSystem) {
        FeedSystem = feedSystem;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIdInspection() {
        return idInspection;
    }

    public void setIdInspection(String idInspection) {
        this.idInspection = idInspection;
    }
}
