package utilities;

import java.util.Observable;
import java.util.Observer;

public class EXPObserver extends InventoryObserver implements Observer {
	
	private static EXPObserver theEXPObserver = new EXPObserver();
	 
	public static EXPObserver getEXPObserver(){
		return theEXPObserver;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
