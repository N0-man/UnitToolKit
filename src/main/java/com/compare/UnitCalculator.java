package com.compare;

import java.text.DecimalFormat;

/**
 * Created by noumanm on 7/12/17.
 */
public class UnitCalculator{

    private static final String INCH = "Inch";
    private static final String CENTIMETER = "Centimeter";
    private static final String GALLON = "Gallon";
    private static final String LITERS = "Liters";

    public Unit add(Unit one, Unit two){
        Unit result = new Unit(0, "");
        CalculationStrategy calculationStrategy = null;

        if(one.getType().equalsIgnoreCase(two.getType()))
            calculationStrategy = CalculatorConditionSet.ADD_EQUAL_UNITS;

        if (one.getType().equalsIgnoreCase(INCH) && two.getType().equalsIgnoreCase(CENTIMETER))
            calculationStrategy = CalculatorConditionSet.ADD_INCH_TO_CENTIMETER;

        if (one.getType().equalsIgnoreCase(GALLON) && two.getType().equalsIgnoreCase(LITERS))
            calculationStrategy = CalculatorConditionSet.ADD_GALLON_TO_LITERS;

        return calculationStrategy.calculate(one, two);
    }
}
