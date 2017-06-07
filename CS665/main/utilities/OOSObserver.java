package utilities;

import java.util.Observable;
import java.util.Observer;

import raiderInventories.RaiderItem;

public class OOSObserver extends InventoryObserver implements Observer {
	
	private static OOSObserver theOOSObserver = new OOSObserver();
	 
	public static OOSObserver getOOSObserver(){
		return theOOSObserver;
	}//end getOOSObserver

	@Override
	public void update(Observable o, Object arg) {
		
		if ( ((RaiderItem) arg).getItemQuantity() == 0) {
			System.out.println("You've just run out of " + ((RaiderItem) arg).getItemName() );
		}//end if
	}//end update

}//end OOSObserver
