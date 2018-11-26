package raiderInventories;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AddFridgeTest.class, AddShoppingListTest.class, AddItemTest.class, decrementItemNegativeTest.class, decrementItemTest.class,
		IncrementItemTest.class, updateItemNegativeTest.class, UpdateItemTest.class, RemoveItemTest.class,clearInventoryManagerRoster.class })
public class AllTests {

}
