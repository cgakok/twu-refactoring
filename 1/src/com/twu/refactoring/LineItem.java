package com.twu.refactoring;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

    double calculateTotalAmount() {
        return price * quantity;
    }

    public String printInformation() {
        return description + "\t" + price + "\t" + quantity +"\t" + this.calculateTotalAmount() + "\n";
    }

    public double calculateTaxPayable() {
        return  this.calculateTotalAmount() * 0.1d;
    }
}