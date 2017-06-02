package RefrigeratorRaider;

import java.util.Observable;
import java.util.Observer;
import inventories.Item;

public class OOSObserver extends InventoryObserver implements Observer {
	
	private static OOSObserver theOOSObserver = new OOSObserver();
	 
	public static OOSObserver getOOSObserver(){
		return theOOSObserver;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if ( ((Item) arg).getItemQuantity() == 0) {
			System.out.println("You've just run out of " + ((Item) arg).getItemName() );
		}
	}

}
