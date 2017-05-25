package inventories;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateFridgeTest {

	@Test
	public void test() {
		InventoryManager testManager = new InventoryManager();
		Refrigerator testFridge = new Refrigerator(testManager, "test Fridge");
		testFridge.addItem("Milk", 2, "Dairy");
		
		
		//assert statements
		assertEquals(1, testManager.inventoryRoster.size());
		assertEquals(true, testManager.inventoryRoster.contains(testFridge));
	}

}

