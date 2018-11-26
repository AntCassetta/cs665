package raiderInventories;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddShoppingListTest {

	@Test
	public void test() {
		InventoryManager testManager = InventoryManager.getInstance();
		
		ShoppingList ShoppingList = new ShoppingList(testManager, "ShoppingList", 00);
		
		RaiderInventory testShoppingList = testManager.addInventory("testList", 01, "ShoppingList");
		
		assertEquals(testShoppingList.getClass(), ShoppingList.getClass());
		assertEquals(0, testShoppingList.itemInventory.size());
		assertEquals(true, testManager.inventoryRoster.contains(testShoppingList));
	
	}

}