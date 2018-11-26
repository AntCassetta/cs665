package raiderInventories;

import static org.junit.Assert.*;
import org.junit.Test;
import raiderInventories.InventoryManager;

public class decrementItemTest {

	@Test
	public void test() {
		InventoryManager testManager = InventoryManager.getInstance();
		RaiderInventory testFridge = testManager.getInventory("testFridge", 1);
		testFridge.addItem("Milk", 2, "Dairy");
		
		
		//assert the item was added properly
		assertEquals(1, testFridge.itemInventory.size());
		assertEquals("Milk", testFridge.itemInventory.first().getElement().getItemName());
		assertEquals(2, testFridge.itemInventory.first().getElement().getItemQuantity());
		
		//Perform the decrement
		testFridge.decrementItem("Milk");
		assertEquals(1, testFridge.itemInventory.first().getElement().getItemQuantity());
		
		//Clear out the inventory contents
		while (testFridge.itemInventory.size() > 0 ) {
			testFridge.itemInventory.remove(testFridge.itemInventory.first()); }	
	}
}
