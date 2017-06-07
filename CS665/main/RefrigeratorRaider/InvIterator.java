package RefrigeratorRaider;

import raiderInventories.RaiderInventory;

public abstract class InvIterator<E> {
	
	public InvIterator(RaiderInventory givenInventory) {
		super();
	}

	//iterator points to first element:
	public abstract void setToFirst();
	
	//following returns true if iterator points past the last element:
	public abstract boolean isDone();
	
	//Cause the iterator to point to the next element:
	public abstract void increment();
	
	//Return the element pointed to by the iterator:
	public abstract E getCurrentElement();
	
	//Return the total number of items
	public abstract int getTotal();
	
}//end InvIterator