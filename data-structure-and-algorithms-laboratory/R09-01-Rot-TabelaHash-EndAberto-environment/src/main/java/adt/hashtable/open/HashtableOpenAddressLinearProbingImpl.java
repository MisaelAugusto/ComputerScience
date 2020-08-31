package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}
	
	private boolean isValid(T element) {
		return (element != null);
	}
	
	@Override
	public void insert(T element) {
		if (!this.isFull()) {
			if (this.isValid(element)) {
				int probe = 0;
					
				while (probe < this.capacity())	{
					int index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe++);
						
					if (this.table[index] == null || this.table[index].equals(new DELETED())) {
						this.table[index] = element;
						this.elements++;
						break;
					} else {
						this.COLLISIONS++;
					}
				}
				
			}
		} else {
			throw new HashtableOverflowException();
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.isValid(element)) {
				int probe = 0;
				int index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe++);
				
				while (probe < this.capacity() && this.table[index] != null) {
					if (this.table[index].equals(element)) {
						this.table[index] = new DELETED();
						this.elements--;
						break;
					}
					
					index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe++);
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T result = null;
		
		if (!this.isEmpty()) {
			if (this.isValid(element)) {
				int probe = 0;
				int index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe++);
				
				while (probe < this.capacity() && this.table[index] != null) {
					if (this.table[index].equals(element)) {
						result = element;
						break;
					}
					
					index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe++);
				}	
			}
		}
		
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		
		if (!this.isEmpty()) {
			if (this.isValid(element)) {
				int probe = 0;
					
				while (probe < this.capacity()) {
					int index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe++);
						
					if (this.table[index].equals(element)) {
						result = index;
						break;
					}
				}
				
			}
		}
		
		return result;
	}

}
