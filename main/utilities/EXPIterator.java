package utilities;

import raiderInventories.RaiderInventory;
import raiderInventories.RaiderItem;

public class EXPIterator extends InvIterator<RaiderItem> {

	public EXPIterator(RaiderInventory givenInventory) {
		super(givenInventory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setToFirst() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void increment() {
		// TODO Auto-generated method stub

	}

	@Override
	public RaiderItem getCurrentElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}//end InvIterator
