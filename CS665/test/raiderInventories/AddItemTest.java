package raiderInventories;

import static org.junit.Assert.*;

import org.junit.Test;

import raiderInventories.InventoryManager;

public class AddItemTest {

	@Test
	public void test() {
		
		InventoryManager testManager = InventoryManager.getInstance();
		
		RaiderInventory testFridge = testManager.getInventory("testFridge", 1);
		
		//System.out.println(testFridge.getInventoryName());
		
		testManager.addItem(testFridge, "Milk", 2, "Dairy");
		
		
		//assert statements
		
		assertEquals(1, testFridge.itemInventory.size());
		assertEquals("Milk", testFridge.itemInventory.first().getElement().getItemName());
		assertEquals(2, testFridge.itemInventory.first().getElement().getItemQuantity());
		
		while (testFridge.itemInventory.size() > 0 ) {testFridge.itemInventory.remove(testFridge.itemInventory.first());}
	
	}

}
