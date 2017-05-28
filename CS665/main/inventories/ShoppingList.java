package inventories;

public class ShoppingList extends Inventory{

	public ShoppingList(InventoryControl newInventoryControl, String nickName) {
		super(newInventoryControl, nickName);
		
		System.out.println("Shopping list " + this.getInventoryID() +  " \""+this.getInventoryName() + "\" has been created.");
	}

}//end ShoppingList
