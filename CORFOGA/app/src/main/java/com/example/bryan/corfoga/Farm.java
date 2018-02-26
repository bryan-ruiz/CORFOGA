package com.example.bryan.corfoga;

/**
 * Created by Bryan on 26/02/2018.
 */

public class Farm {
    private String name;
    private String id;

    public Farm(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
