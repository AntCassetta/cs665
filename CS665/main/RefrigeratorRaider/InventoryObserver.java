package RefrigeratorRaider;

import java.util.Observable;

public abstract class InventoryObserver {

	public InventoryObserver(){
		super();
	}//end constructor
	
	public abstract void update(Observable o, Object arg);
}//end InventoryObserver
