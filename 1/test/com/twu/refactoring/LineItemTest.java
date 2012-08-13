package com.twu.refactoring;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineItemTest {
    @Test
    public void shouldPrintOutInformationOfMilkLineItem() {
        //Given
        LineItem lineItem = new LineItem("milk", 1.5, 2);
        //When
        String result = lineItem.printInformation();
        //Then
        assertThat(result, is("milk\t1.5\t2\t3.0\n"));
    }

    @Test
    public void shouldPrintOutInformationOfCandyLineItem() {
        //Given
        LineItem lineItem = new LineItem("candy", 3.5, 4);
        //When
        String result = lineItem.printInformation();
        //Then
        assertThat(result, is("candy\t3.5\t4\t14.0\n"));
    }

    @Test
    public void shouldCalculateTaxOfLineItem() {
        //Given
        LineItem lineItem = new LineItem("milk", 1.5, 20);
        //When
        double taxOfLineItem = lineItem.calculateTaxPayable();
        //Then
        assertThat(taxOfLineItem, is(3d));
    }
}
