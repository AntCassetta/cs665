package inventories;

import static org.junit.Assert.*;

import org.junit.Test;

public class decrementItemTest {

	@Test
	public void test() {
		InventoryManager testManager = new InventoryManager();
		Refrigerator testFridge = new Refrigerator(testManager, "test Fridge");
		testFridge.addItem("Milk", 2, "Dairy");
		
		
		//assert statements
		assertEquals(1, testFridge.itemInventory.size());
		assertEquals("Milk", testFridge.itemInventory.first().getElement().getItemName());
		assertEquals(2, testFridge.itemInventory.first().getElement().getItemQuantity());
		testFridge.decrementItem("Milk");
		assertEquals(1, testFridge.itemInventory.first().getElement().getItemQuantity());
	}

}
