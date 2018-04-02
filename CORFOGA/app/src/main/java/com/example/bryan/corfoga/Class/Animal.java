package com.example.bryan.corfoga.Class;

/**
 * Created by Bryan on 26/02/2018.
 */

public class Animal {
    private String asocebuId;
    private String animalId;
    private String gender;
    private String birthdate;
    private int state;

    public Animal(String asocebuId, String animalId, String gender, String birthdate, int state) {
        this.asocebuId = asocebuId;
        this.animalId = animalId;
        this.gender = gender;
        this.birthdate = birthdate;
        this.state = state;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthDate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
