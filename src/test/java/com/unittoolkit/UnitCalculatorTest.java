package com.unittoolkit;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by noumanm on 7/11/17.
 */
public class UnitCalculatorTest {

    @Test
    public void Should_AddTwoUnitsOfSameType() {
        Unit twoInches = new Unit(2, "Inch");
        Unit threeInches = new Unit(3 , "Inch");

        UnitCalculator unitCalculator = new UnitCalculator();
        Unit fiveInches = unitCalculator.add(twoInches,threeInches);
        assertThat(fiveInches.getValue(), is(5.0));
    }

    @Test
    public void Should_AddTwoUnitsOfDifferentType() {
        Unit twoInches = new Unit(2, "Inch");
        Unit twoPointFiveCm = new Unit(2.5 , "Centimeter");

        UnitCalculator unitCalculator = new UnitCalculator();
        Unit threeInches = unitCalculator.add(twoInches,twoPointFiveCm);
        assertThat(threeInches.getValue(),is (3.0));
    }

    @Test
    public void Should_AddTwoVolumeOfDifferentType() {
        Unit oneGallon = new Unit(1, "Gallon");
        Unit oneLiter = new Unit(1 , "Liters");

        UnitCalculator unitCalculator = new UnitCalculator();
        Unit fourPointSevenEightGallon = unitCalculator.add(oneGallon,oneLiter);
        assertThat(fourPointSevenEightGallon.getValue(), is(4.78));
    }

    @Test
    public void Should_NotAdd_When_IncompatibleUnits_IsGiven () {
        Unit oneMile = new Unit(1, "Miles");
        Unit oneLiter = new Unit(1 , "Liters");

        UnitCalculator unitCalculator = new UnitCalculator();
        Unit incompitableUnits = unitCalculator.add(oneMile,oneLiter);
        assertThat(incompitableUnits.getValue(), is(0.0));
    }


}