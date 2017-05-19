package inventories;

public class Refrigerator extends Inventory{

	public Refrigerator(InventoryControl newInventoryControl) {
		super(newInventoryControl);
		
		System.out.println("Refrigerator " + this.getInventoryID() + " has been created.");
	}
	
}//end refrigerator
