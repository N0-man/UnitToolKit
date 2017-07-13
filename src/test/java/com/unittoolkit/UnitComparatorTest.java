package com.unittoolkit;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by noumanm on 7/11/17.
 */
public class UnitComparatorTest {
    @Test
    public void CompareReturnsPositive_When_FeetIsTwelveTimeInch() {
        Unit oneFeet = new Unit(1, "Feet");
        Unit twelveInches = new Unit(12 , "Inches");
        UnitComparator comparator = new UnitComparator();

        boolean result = comparator.isEqual(oneFeet, twelveInches);

        assertThat(result, is(true));
    }

    @Test
    public void CompareReturnsNegative_When_FeetIsNOTTwelveTimesInch() {
        Unit twoFeet = new Unit(2 , "Feet");
        Unit fiftyInches = new Unit(50 , "Inches");
        UnitComparator unitComparator = new UnitComparator();

        boolean result = unitComparator.isEqual(twoFeet, fiftyInches);

        assertThat(result, is(false));
    }

    @Test
    public void CompareReturnsPositive_When_YardIsThreeTimesFeet () {
        Unit threeFeet = new Unit(3, "Feet");
        Unit oneYard = new Unit (1, "Yard");

        UnitComparator unitComparator = new UnitComparator();

        assertThat(unitComparator.isEqual(threeFeet, oneYard), is (true));
    }

    @Test
    public void CompareReturnsNegative_When_YardIsNOTThreeTimesFeet () {
        Unit fiveFeet = new Unit(5 , "Feet");
        Unit oneYard = new Unit (1 , "Yard");

        UnitComparator unitComparator = new UnitComparator();

        assertThat(unitComparator.isEqual(fiveFeet, oneYard), is (false));
    }

    @Test
    public void CompareReturnsPositive_When_InchIsTwoPointFiveFourCentimeter(){
        Unit twoInches = new Unit(2,"Inch");
        Unit fivePointZeroEightCm = new Unit(5.08,"Centimeter");

        UnitComparator unitComparator = new UnitComparator();

        assertThat(unitComparator.isEqual(twoInches, fivePointZeroEightCm), is (true));
    }

    @Test
    public void CompareReturnsNegative_When_InchIsNOTTwoPointFiveFourCentimeter(){
        Unit threeInches = new Unit(3,"Inch");
        Unit fivePointZeroEightCm = new Unit(5.08,"Centimeter");

        UnitComparator unitComparator = new UnitComparator();

        assertThat(unitComparator.isEqual(threeInches, fivePointZeroEightCm), is (false));
    }

    @Test
    public void CompareReturnsPositive_When_GallonIsThreePointSevenEightLiters() {
        Unit oneGallon = new Unit(1, "Gallon");
        Unit threePointSevenEightLiters = new Unit(3.78 , "Liters");
        UnitComparator comparator = new UnitComparator();

        boolean result = comparator.isEqual(oneGallon, threePointSevenEightLiters);

        assertThat(result, is(true));
    }

    @Test
    public void CompareReturnsPositive_When_FarenheitIsComapredToCelsius() {
        Unit twoOneTwoF = new Unit(212, "Farenheit");
        Unit hundredC = new Unit(100 , "Celsius");
        UnitComparator comparator = new UnitComparator();

        boolean result = comparator.isEqual(twoOneTwoF, hundredC);

        assertThat(result, is(true));
    }

    @Test
    public void CompareReturnsNegative_When_IncompatibleUnitsAreCompared() {
        Unit twoOneTwoGallon = new Unit(212, "Gallon");
        Unit hundredInch = new Unit(100 , "Inch");
        UnitComparator comparator = new UnitComparator();

        boolean result = comparator.isEqual(twoOneTwoGallon, hundredInch);

        assertThat(result, is(false));
    }
}