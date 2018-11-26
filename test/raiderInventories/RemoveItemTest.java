package raiderInventories;

import static org.junit.Assert.*;

import org.junit.Test;

import raiderInventories.InventoryManager;

public class RemoveItemTest {

	@Test
	public void test() {
		
		InventoryManager testManager = InventoryManager.getInstance();
		
		RaiderInventory testFridge = testManager.getInventory("testFridge", 1);
		
		
		testManager.addItem(testFridge, "Milk", 2, "Dairy");
		
		
		//assert Item was properly added.
		assertEquals(1, testFridge.itemInventory.size());
		assertEquals("Milk", testFridge.itemInventory.first().getElement().getItemName());
		assertEquals(2, testFridge.itemInventory.first().getElement().getItemQuantity());
		
		//Perform removal
		testManager.removeItem(testFridge, "Milk");
		assertEquals(0, testFridge.itemInventory.size());
		
		//clear inventoryContents
		while (testFridge.itemInventory.size() > 0 ) {testFridge.itemInventory.remove(testFridge.itemInventory.first());}
	}

}
