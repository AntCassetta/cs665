package raiderInventories;

import static org.junit.Assert.*;

import org.junit.Test;
import raiderInventories.InventoryManager;

public class updateItemNegativeTest {

	@Test
	public void test() {
		InventoryManager testManager = InventoryManager.getInstance();
		RaiderInventory testFridge = testManager.getInventory("testFridge", 1);
		testFridge.addItem("Milk", 2, "Dairy");
		
		
		//assert statements
		assertEquals(1, testFridge.itemInventory.size());
		assertEquals("Milk", testFridge.itemInventory.first().getElement().getItemName());
		assertEquals(2, testFridge.itemInventory.first().getElement().getItemQuantity());
		testFridge.updateItemQuantity("Milk", -5);
		assertEquals(2, testFridge.itemInventory.first().getElement().getItemQuantity());
		
		while (testFridge.itemInventory.size() > 0 ) {testFridge.itemInventory.remove(testFridge.itemInventory.first());}
	}

}