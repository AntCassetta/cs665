package utilities;

public class OutOfStockUtility implements StockUtility {
	
	@Override
	public void checkStock(){
		System.out.println("one day, I will check for out of stock items and report back...");
	}
}//end OutOfStockUtility
