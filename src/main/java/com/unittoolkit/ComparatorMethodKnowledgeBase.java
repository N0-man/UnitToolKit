package com.unittoolkit;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by noumanm on 7/13/17.
 */
public class ComparatorMethodKnowledgeBase {
    public static Map<String, Method> MAP;

    static {
        MAP = new HashMap<>();

        try {
            Method compareFeetEqualsInches = UnitComparator.class.getDeclaredMethod("compareFeetEqualsInches",
                    Unit.class, Unit.class);
            MAP.put("Feet Equals Inches", compareFeetEqualsInches);

            Method compareFeetEqualsYard = UnitComparator.class.getDeclaredMethod("compareFeetEqualsYard",
                    Unit.class, Unit.class);
            MAP.put("Feet Equals Yard", compareFeetEqualsYard);

            Method compareInchesEqualsCm = UnitComparator.class.getDeclaredMethod("compareInchesEqualsCm",
                    Unit.class, Unit.class);
            MAP.put("Inch Equals Centimeter", compareInchesEqualsCm);

            Method compareGallonsEqualsLiters = UnitComparator.class.getDeclaredMethod("compareGallonsEqualsLiters",
                    Unit.class, Unit.class);
            MAP.put("Gallon Equals Liters", compareGallonsEqualsLiters);

            Method compareFarenheitEqualsCelsius = UnitComparator.class.getDeclaredMethod("compareFahrenheitEqualsCelsius",
                    Unit.class, Unit.class);
            MAP.put("Farenheit Equals Celsius", compareFarenheitEqualsCelsius);



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}
