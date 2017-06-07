package raiderInventories;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddItemTest.class, CreateFridgeTest.class, decrementItemNegativeTest.class, decrementItemTest.class,
		IncrementItemTest.class, updateItemNegativeTest.class, UpdateItemTest.class })
public class AllTests {

}
