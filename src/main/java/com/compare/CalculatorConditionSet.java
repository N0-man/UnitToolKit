package com.compare;

import java.text.DecimalFormat;

/**
 * Created by noumanm on 7/12/17.
 */
public enum CalculatorConditionSet  implements CalculationStrategy{
    ADD_INCH_TO_CENTIMETER {
        public Unit calculate (Unit inch, Unit centimeter) {
            Unit result = new Unit(0.0, inch.getType());
            result.setValue(inch.getValue() + (centimeter.getValue()/2.5));
            return result;
        }
    },

    ADD_GALLON_TO_LITERS {
        public Unit calculate (Unit gallon, Unit liters) {
            Unit result = new Unit(0.0, liters.getType());

            DecimalFormat numberFormat = new DecimalFormat("#.00");
            String res=numberFormat.format(gallon.getValue()*3.78 + (liters.getValue()));
            result.setValue(Double.parseDouble(res));
            return result;
        }
    },

    ADD_EQUAL_UNITS {
        public Unit calculate (Unit one, Unit two) {
            Unit result = new Unit(0.0, one.getType());
            result.setValue(one.getValue()+two.getValue());
            return result;
        }
    }
}
