package utilities;

class UtilityTool {
	private StockUtility checkOOS;
	private StockUtility checkEXP;
	private DateUtility calDate;
	
	public UtilityTool() {
		checkOOS = new OutOfStockUtility();
		checkEXP = new ExperationUtility();
		calDate = new DateUtility();
	}
	
	public void checkForOOS() {
		checkOOS.checkStock();
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
