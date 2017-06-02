package RefrigeratorRaider;

import java.util.Observable;

public abstract class InventoryObserver {

	public InventoryObserver(){
		super();
	}
	
	public abstract void update(Observable o, Object arg);
}
