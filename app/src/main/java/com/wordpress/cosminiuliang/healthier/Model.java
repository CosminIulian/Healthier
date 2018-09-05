package com.wordpress.cosminiuliang.healthier;

/*
Add model class
*/


public class Model {
    private String name;
    private String calories;
    private int icon;
    private String desc;

    //constructor
    public Model(String name, String calories, int icon, String desc) {
        this.name = name;
        this.calories = calories;
        this.icon = icon;
        this.desc = desc;
    }

    //getters


    public String getName() {
        return this.name;
    }

    public String getCalories() {
        return this.calories;
    }

    public int getIcon() {
        return this.icon;
    }

    public String getDesc() {
        return desc;
    }
}
