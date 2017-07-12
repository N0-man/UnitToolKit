package com.compare;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by noumanm on 7/11/17.
 */
public class UnitComparator {

    public static final int TWELVE = 12;
    public static final int THREE = 3;
    public static final double TWO_POINT_FIVE_FOUR = 2.54;
    public static final double THREE_POINT_SEVEN_EIGHT = 3.78;
    private static Map<String, Method> comparatorMethodMap;

    static {
        comparatorMethodMap = new HashMap<String, Method>();

        try {
            Method compareFeetEqualsInches = UnitComparator.class.getDeclaredMethod("compareFeetEqualsInches",
                    Unit.class, Unit.class);
            comparatorMethodMap.put("Feet Equals Inches", compareFeetEqualsInches);

            Method compareFeetEqualsYard = UnitComparator.class.getDeclaredMethod("compareFeetEqualsYard",
                    Unit.class, Unit.class);
            comparatorMethodMap.put("Feet Equals Yard", compareFeetEqualsYard);

            Method compareInchesEqualsCm = UnitComparator.class.getDeclaredMethod("compareInchesEqualsCm",
                    Unit.class, Unit.class);
            comparatorMethodMap.put("Inch Equals Centimeter", compareInchesEqualsCm);

            Method compareGallonsEqualsLiters = UnitComparator.class.getDeclaredMethod("compareGallonsEqualsLiters",
                    Unit.class, Unit.class);
            comparatorMethodMap.put("Gallon Equals Liters", compareGallonsEqualsLiters);

            Method compareFarenheitEqualsCelsius = UnitComparator.class.getDeclaredMethod("compareFarenheitEqualsCelsius",
                    Unit.class, Unit.class);
            comparatorMethodMap.put("Farenheit Equals Celsius", compareFarenheitEqualsCelsius);



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public boolean isEqual (Unit one, Unit two) {
        boolean response = false;
        try {
            response = (boolean) comparatorMethodMap.get(one.getType()+ " Equals " + two.getType()).invoke(this,
                    one, two);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return response;
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

    public boolean compareFarenheitEqualsCelsius(Unit f,Unit c){
        return ((f.getValue()-32)*5/9 == c.getValue());
    }
}
