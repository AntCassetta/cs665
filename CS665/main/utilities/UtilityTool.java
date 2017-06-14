package utilities;

import raiderInventories.RaiderInventory;
import raiderInventories.RaiderItem;

public class UtilityTool {
	private StockUtility checkEXP;
	private DateUtility calDate;
	
	public UtilityTool() {
		new OutOfStockUtility();
		checkEXP = new ExperationUtility();
		calDate = new DateUtility();
	}
	
	public void checkForOOS(RaiderInventory givenInventory) {
		
		InvIterator<RaiderItem> OOSIter = new OOSIterator(givenInventory);
		OOSIter.setToFirst();
		
		while (!OOSIter.isDone()) {
			
			RaiderItem temp = OOSIter.getCurrentElement();
			System.out.println("Item: " + temp.getItemName() + " | Qty: " + temp.getItemQuantity());
			
			OOSIter.increment();
			
		}//end while
		
		System.out.println("Total item's out of stock: " + OOSIter.getTotal());
	}
	
	public void checkForEXP() {
		checkEXP.checkStock();
	}
	
	public void getDateToday() {
		System.out.println(calDate.getDateToday());
	}
	
	public void getExpDate(){
		System.out.println("The default Experation date is: " + calDate.getDateExp());
	}
	
	public void getExpDate(String givenDate){
		System.out.println("You set the experation date too: " + calDate.getDateExp(givenDate));
	}
}
