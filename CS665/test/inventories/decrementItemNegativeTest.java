package inventories;

import static org.junit.Assert.*;

import org.junit.Test;

public class decrementItemNegativeTest {

	@Test
	public void test() {
		InventoryManager testManager = new InventoryManager();
		Refrigerator testFridge = new Refrigerator(testManager, "test Fridge");
		testFridge.addItem("Milk", 0, "Dairy");
		
		
		//assert statements
		assertEquals(1, testFridge.itemInventory.size());
		assertEquals("Milk", testFridge.itemInventory.first().getElement().getItemName());
		assertEquals(0, testFridge.itemInventory.first().getElement().getItemQuantity());
		testFridge.decrementItem("Milk");
		assertEquals(0, testFridge.itemInventory.first().getElement().getItemQuantity());
	}

}
