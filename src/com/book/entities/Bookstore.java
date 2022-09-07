package com.book.entities;

import com.book.utils.Validator;

public class Bookstore extends Book {
	private String storeType;
	private int unitsSold;
	private boolean hasDiscount;
	
	public Bookstore() {
		super();
	}

	public Bookstore(int id, String title, String author, String genre, int page, double price, String pubdate,
			String storeType, int unitsSold, boolean hasDiscount) {
		super(id, title, author, genre, page, price, pubdate);
		this.storeType = storeType;
		this.unitsSold = unitsSold;
		this.hasDiscount = hasDiscount;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		if(Validator.onlineOrBrick(storeType))
			this.storeType = storeType;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	public boolean getHasDiscount() {
		return hasDiscount;
	}

	public void setHasDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	@Override
	public String toString() {
		return super.toString() + "\nBookstore [storeType=" + storeType + 
				"\\n unitsSold=" + unitsSold + "\\n hasDiscount=" + hasDiscount
				+ "]";
	}
	
	
	

}
