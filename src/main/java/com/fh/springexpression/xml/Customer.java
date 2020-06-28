package com.fh.springexpression.xml;

public class Customer {

    private Item item;
    private String itemName;

	@Override
	public String toString() {
		return "itemName=" +this.itemName+" "+"Item.total="+this.item.getTotal();
	}

	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    
}