package com.compare;

import java.text.DecimalFormat;

/**
 * Created by noumanm on 7/12/17.
 */
public class UnitCalculator {

    public Unit add(Unit one, Unit two){
        Unit result = new Unit(0, "");
        if(one.getType().equalsIgnoreCase(two.getType())){
            result.setValue(one.getValue()+two.getValue());
            result.setType(one.getType());
        }else {
            String inch = "Inch";
            String centimeter = "Centimeter";
            InchToCm(one, two, result, inch, centimeter, addInchToCentimeter(one, two));
            String gallon = "Gallon";
            String liters = "Liters";
            InchToCm(one, two, result, gallon, liters, addGallonToLiters(one, two));
        }

        return result;
    }

    private void InchToCm(Unit one, Unit two, Unit result, String inch, String centimeter, double value) {
        if (one.getType().equalsIgnoreCase(inch) && two.getType().equalsIgnoreCase(centimeter)) {
            result.setValue(value);
            result.setType(one.getType());
        }
    }

    private double addInchToCentimeter(Unit inch, Unit centimeter) {
        return (inch.getValue() + (centimeter.getValue()/2.5));
    }

    private double addGallonToLiters(Unit gallon, Unit liters) {

        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String res=numberFormat.format(gallon.getValue()*3.78 + (liters.getValue()));
        return Double.parseDouble(res);
    }

//    1 gallon = 3.78 liters
//    1 gallon + 1 liters = 4.78 liters
}
