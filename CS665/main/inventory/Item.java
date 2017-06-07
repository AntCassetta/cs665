package inventory;

/**Item objects represent real world items to be tracked within inventories. 
 * @author anthonycassetta
 */
public interface Item {	

		/**returns the string name of the item
		 * @return itemName the string name of the item
		 */
		public String getItemName();
		
		/**returns the integer value of the item quantity
		 * @return itemQuantity returns the integer value of the quantity
		 */
		public int getItemQuantity();
		
		
		/**returns the string type, or category, of the item
		 * @return itemName the string name of the item
		 */
		public String getItemType();
		
		/**Sets the item quantity to the integer value given
		 * @param givenQuantity and integer value
		 */
		public void setItemQuantity(int givenQuantity);
		
	}//end Item
