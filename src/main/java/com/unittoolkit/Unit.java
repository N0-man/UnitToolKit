package com.unittoolkit;

/**
 * Created by noumanm on 7/12/17.
 */
public class Unit {

    public void setValue(double value) {
        this.value = value;
    }

    double value;


    String type;

    Unit (double value, String type) {
        this.value = value;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
