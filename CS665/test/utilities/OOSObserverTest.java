package utilities;

import static org.junit.Assert.*;
import org.junit.Test;

import raiderInventories.InventoryManager;
import raiderInventories.RaiderInventory;
import raiderInventories.RaiderItem;
import utilities.InvIterator;
import utilities.OOSIterator;
import utilities.OOSObserver;

public class OOSObserverTest {

	@Test
	public void test() {
		InventoryManager testManager = InventoryManager.getInstance();
		testManager.addObserver(OOSObserver.getOOSObserver());
		
		RaiderInventory testFridge = testManager.addInventory("testFridge", 01, "Refrigerator");
		testFridge.addItem("Baby Spinich", 2, "produce");
		testFridge.addItem("Milk", 0, "Dairy");
		testFridge.addItem("butter", 0, "Dairy");
		testFridge.addItem("beef", 2, "Meat");
		testFridge.addItem("chicken", 2, "Meat");
		testFridge.addItem("baking soda",1, "misc");
		testFridge.addItem("eggs", 0, "Meat");
		
		
		InvIterator<RaiderItem> it = new OOSIterator(testFridge);
		
		it.setToFirst();
		RaiderItem currentIt = it.getCurrentElement();
		
		//assert statements
		assertEquals(7, testFridge.getItemInv().size());
		assertEquals("Milk", currentIt.getItemName());
		
		System.out.println();
		testFridge.printOOS();
		System.out.println();
		
		testFridge.decrementItem("baking soda");
		testFridge.updateItemQuantity("beef", 0);
		
		System.out.println();
		testFridge.printOOS();
	}
}
