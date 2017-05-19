package inventories;

public class ShoppingList extends Inventory{

	public ShoppingList(InventoryControl newInventoryControl) {
		super(newInventoryControl);
		
		System.out.println("Shopping list " + this.getInventoryID() + " has been created.");
	}

}//end ShoppingList
