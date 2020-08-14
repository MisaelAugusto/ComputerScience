package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
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
