package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(printHeader());
        // prints lineItems
        double totalSalesTax = 0d;
        double totalAmmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.printInformation());
            totalSalesTax += lineItem.calculateTaxPayable();
            totalAmmount += lineItem.calculateTotalAmount() + lineItem.calculateTaxPayable();
        }

        output.append("Sales Tax" + "\t" + totalSalesTax);

        output.append("Total Amount" + "\t" + totalAmmount);
        return output.toString();
    }

    public String printHeader() {

        return "======Printing Orders======\n" + order.printCustomerInformation();
    }
}