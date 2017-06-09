package raiderInventories;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddInventoryTest {

	@Test
	public void test() {
		InventoryManager testManager = InventoryManager.getInstance();
		
		Refrigerator refrigerator = new Refrigerator(testManager, "fridge", 00);
		
		RaiderInventory testFridge = testManager.addInventory("testFridge", 01, "Refrigerator");
		
		assertEquals(testFridge.getClass(), refrigerator.getClass());
		assertEquals(0, testFridge.itemInventory.size());
		assertEquals(true, testManager.inventoryRoster.contains(testFridge));
	
	}

}
