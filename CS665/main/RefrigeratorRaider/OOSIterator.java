package RefrigeratorRaider;

import dataStructures.LinkedPositionalList;
import dataStructures.Position;
import inventories.Inventory;
import inventories.Item;

/**OOSIterator is an iterator for use with Inventory objects, its purpose is to iterate through out of stock items (Item QTY = 0) 
 * 
 * @author anthonycassetta
 *
 */
public class OOSIterator extends InvIterator<Item>{
	
	//The of the givenInventory passed in by the user
	private LinkedPositionalList<Item> InvItems;
	
	//a cursor for the givenInventory items
	Position<Item> walk;
	
	//The parsed inventory of out of stock items
	private LinkedPositionalList<Item> OOS = new LinkedPositionalList<Item>();
	
	//a cursor for the out of stock items
	private Position<Item> cursor;
	
	/**constructor for OOSiterator.
	 * 
	 * @param givenInventory the inventory to iterate over.
	 */
	public OOSIterator(Inventory givenInventory) {
			super(givenInventory);
			InvItems = givenInventory.getItemInv();	
	}

	/**Sets the iterator to the first qualifying item, the first Item with QTY = 0.*/
	@Override
	public void setToFirst() {
		
		walk = InvItems.first();
		while (walk != InvItems.after(InvItems.last())) {
			
			if(walk.getElement().getItemQuantity() == 0) {
				OOS.addLast(walk.getElement());
			}
			
			walk =  InvItems.after(walk);	
		
		}//while end
		
		System.out.println(OOS.size());
		cursor = OOS.first();
	}//end setToFirst

	/**returns true if the cursor has reached the end of the iteration and false otherwise.*/
	@Override
	public boolean isDone() {
		
		if (cursor == null){
			return true;
		
		} else {
		
			return false;
		} 
	}//end is done

	/**increments the cursor to the next Item in the iteration.*/
	@Override
	public void increment() {

			cursor = OOS.after(cursor);
		
	}//end increment

	/**returns the current Item as indicated by the cursor*/
	@Override
	public Item getCurrentElement() {
		return cursor.getElement();
	}//end getCurrentElement

	/**returns the total number of out of stock Items*/
	public int getTotal(){ return OOS.size();}
	
}//end OOSIterator
