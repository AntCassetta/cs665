package inventories;

public class ItemFactory {
	
	protected enum category {DAIRY, MEAT, PRODUCE, MISC};
	
	public Item getItem(String givenItemName, int givenItemQuantity, String givenItemType) {
		
		//System.out.println("Going through the factory!");
		
		for(category c: category.values()){
			if ( c.name().equals(givenItemType.toUpperCase()) ) {
				
				switch(c){
				
				case DAIRY:
					return new DairyItem(givenItemName, givenItemQuantity, givenItemType);
					
				case MEAT:
					return new MeatItem(givenItemName, givenItemQuantity, givenItemType);
					
				case PRODUCE:
					return new ProduceItem(givenItemName, givenItemQuantity, givenItemType);
					
				case MISC:
					return new MiscItem(givenItemName, givenItemQuantity, givenItemType);
				
				}//end switch
				
			}//end if
		
		}//end for
		
		return null;
	
	}//end getItem

}//end ItemFactory
