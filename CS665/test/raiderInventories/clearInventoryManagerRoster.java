package raiderInventories;

import static org.junit.Assert.*;

import org.junit.Test;

public class clearInventoryManagerRoster {

	@Test
	public void test() {
		InventoryManager testManager = InventoryManager.getInstance();
		testManager.inventoryRoster.removeAll(testManager.inventoryRoster);
		testManager.nextID = 0;
		
		assertEquals(0, testManager.inventoryRoster.size());
	}

}
