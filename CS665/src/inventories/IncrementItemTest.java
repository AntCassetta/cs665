package inventories;

import static org.junit.Assert.*;

import org.junit.Test;

public class IncrementItemTest {

	@Test
	public void test() {
		InventoryManager testManager = new InventoryManager();
		Refrigerator testFridge = new Refrigerator(testManager, "test Fridge");
		testFridge.addItem("Milk", 2);
		
		
		//assert statements
		assertEquals(1, testFridge.itemInventory.size());
		assertEquals("Milk", testFridge.itemInventory.first().getElement().getItemName());
		assertEquals(2, testFridge.itemInventory.first().getElement().getItemQuantity());
		testFridge.incrementItem("Milk");
		assertEquals(3, testFridge.itemInventory.first().getElement().getItemQuantity());
	}

}
