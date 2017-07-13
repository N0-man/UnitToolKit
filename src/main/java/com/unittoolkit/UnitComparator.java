package com.unittoolkit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by noumanm on 7/11/17.
 */
public class UnitComparator {

    private static final int TWELVE = 12;
    private static final int THREE = 3;
    private static final double TWO_POINT_FIVE_FOUR = 2.54;
    private static final double THREE_POINT_SEVEN_EIGHT = 3.78;
    private static final int THIRTYTWO = 32;
    private static final int FIVE = 5;
    private static final int NINE = 9;


    public boolean isEqual (Unit one, Unit two) {
        boolean response = false;
        try {
            if (ComparatorMethodKnowledgeBase.MAP.containsKey(getKey(one, two)))
                response = (boolean) ComparatorMethodKnowledgeBase.MAP.get(getKey(one, two)).invoke(this,
                    one, two);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String getKey(Unit one, Unit two) {
        return one.getType()+ " Equals " + two.getType();
    }

    public boolean compareFeetEqualsInches(Unit feet, Unit inches) {
        return ((feet.getValue() * TWELVE) == inches.getValue());
    }

    public boolean compareFeetEqualsYard(Unit feet, Unit yard) {
        return  ((yard.getValue() * THREE) == feet.getValue());
    }

    public boolean compareInchesEqualsCm(Unit inch, Unit centimeter) {
        return  ((inch.getValue() * TWO_POINT_FIVE_FOUR) == centimeter.getValue());
    }

    public boolean compareGallonsEqualsLiters(Unit gallon,Unit liters){
        return ((gallon.getValue() * THREE_POINT_SEVEN_EIGHT) == liters.getValue());
    }

    public boolean compareFahrenheitEqualsCelsius(Unit f, Unit c){
        return ((f.getValue()- THIRTYTWO)* FIVE / NINE == c.getValue());
    }
}
