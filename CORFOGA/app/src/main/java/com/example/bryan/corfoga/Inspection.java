package com.example.bryan.corfoga;

/**
 * Created by Bryan on 26/02/2018.
 */

public class Inspection {
    private String asocebuId;
    private String animalId;
    private String weight;
    private String scrotalCircumference;
    private String FeedSystem;
    private String comment;

    public Inspection(String asocebuId, String animalId, String weight, String scrotalCircumference, String feedSystem, String comment) {
        this.asocebuId = asocebuId;
        this.animalId = animalId;
        this.weight = weight;
        this.scrotalCircumference = scrotalCircumference;
        FeedSystem = feedSystem;
        this.comment = comment;
    }

    public String getAsocebuId() {
        return asocebuId;
    }

    public void setAsocebuId(String asocebuId) {
        this.asocebuId = asocebuId;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getScrotalCircumference() {
        return scrotalCircumference;
    }

    public void setScrotalCircumference(String scrotalCircumference) {
        this.scrotalCircumference = scrotalCircumference;
    }

    public String getFeedSystem() {
        return FeedSystem;
    }

    public void setFeedSystem(String feedSystem) {
        FeedSystem = feedSystem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
