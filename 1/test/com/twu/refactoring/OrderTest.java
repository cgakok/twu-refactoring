package com.twu.refactoring;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrderTest {
    @Test
    public void shouldPrintCustomerInformationOfMrX() {
        //Given

        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        //When
        String customerInfomation = order.printCustomerInformation();
        //Then
        assertThat(customerInfomation, is("Mr X\tChicago, 60601\n"));
    }

    @Test
    public void shouldPrintInformationOfMissY() {
        //Given
        Order order = new Order("Miss Y", "Beverly Hills, 90210", new ArrayList<LineItem>());
        //When
        String customerInformation = order.printCustomerInformation();
        //Then
        assertThat(customerInformation, is("Miss Y\tBeverly Hills, 90210\n"));
    }

    @Test
    public void shouldPrintLineItemsInformation() {
        //Given

        //When
        //Then
    }
}
