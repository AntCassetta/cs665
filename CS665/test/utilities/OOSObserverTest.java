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
		
		//add items, adding a zero quantity item will trigger an alert
		testFridge.addItem("Baby Spinich", 2, "produce");
		testFridge.addItem("Milk", 0, "Dairy");
		testFridge.addItem("butter", 0, "Dairy");
		testFridge.addItem("beef", 2, "Meat");
		testFridge.addItem("chicken", 2, "Meat");
		testFridge.addItem("baking soda",1, "misc");
		testFridge.addItem("eggs", 0, "Meat");
		
		//iterator to show current out of stock.
		InvIterator<RaiderItem> it = new OOSIterator(testFridge);
		it.setToFirst();
		RaiderItem currentIt = it.getCurrentElement();
		
		//assert correct number of items and current iterator position.
		assertEquals(7, testFridge.getItemInv().size());
		assertEquals("Milk", currentIt.getItemName());
		
		//print out of stock to console
		System.out.println();
		testFridge.printOOS();
		System.out.println();
		
		//decrement Items to trigger alert
		testFridge.decrementItem("baking soda");
		testFridge.updateItemQuantity("beef", 0);
		
		//print out of stock to console
		System.out.println();
		testFridge.printOOS();
	}
}
