package inventory;

import dataStructures.LinkedPositionalList;

public interface Inventory<E> {
	
	
	public void setInventoryID (int idNumber);
	
	
	public void setInventoryName(String givenName);
	
	
	public long getInventoryID();
	
	
	public String getInventoryName();
	
	
	public LinkedPositionalList<E> getItemInv(); 
	
	
	public void isEmpty();

	
	public void printContents();
	
	
	public void printOOS();
	
	
	public void printEXP();
	
	
	public void addItem(String givenItemName, int givenItemQuantity, String givenItemType);
	
	
	public void removeItem (String givenItemName);
	
	
	public void incrementItem(String givenItemName);
	
	
	public void decrementItem(String givenItemName);

	
	public void updateItemQuantity(String givenItemName, int givenItemQuantity);
	
	
}//end Inventory

