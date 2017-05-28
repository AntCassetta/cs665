package inventories;

public class ItemFactory {
	
	protected enum category {DAIRY, MEAT, PRODUCE, MISC};
	
	public Item getItem(String givenItemName, int givenItemQuantity, String givenItemType) {
		
		//System.out.println("Going through the factory!");
		
		for(category c: category.values()){
			if ( c.name().equals(givenItemType.toUpperCase()) ) {
				
				switch(c){
				
				case DAIRY:
					return new ItemDairy(givenItemName, givenItemQuantity, givenItemType);
					
				case MEAT:
					return new ItemMeat(givenItemName, givenItemQuantity, givenItemType);
					
				case PRODUCE:
					return new ItemProduce(givenItemName, givenItemQuantity, givenItemType);
					
				case MISC:
					return new ItemMisc(givenItemName, givenItemQuantity, givenItemType);
				
				}//end switch
				
			}//end if
		
		}//end for
		
		return null;
	
	}//end getItem

}//end ItemFactory
