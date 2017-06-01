package inventories;

abstract class InvIterator<E> {
	
	public InvIterator(Inventory givenInventory) {
		super();
	}

	//iterator points to first element:
	abstract void setToFirst();
	
	//following returns true if iterator points past the last element:
	abstract boolean isDone();
	
	//Cause the iterator to point to the next element:
	abstract void increment();
	
	//Return the element pointed to by the iterator:
	abstract E getCurrentElement();
	
	abstract int getTotal();
	
}