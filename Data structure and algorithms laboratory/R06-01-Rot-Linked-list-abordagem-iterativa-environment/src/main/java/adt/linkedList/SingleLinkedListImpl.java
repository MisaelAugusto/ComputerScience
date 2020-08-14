package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
	
		SingleLinkedListNode<T> aux = this.head;
		while (!aux.isNIL()) {
			aux = aux.next;
			size++;
		}		
		
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> result = this.head;
		
		while(!result.isNIL() && !result.data.equals(element)) {
			result = result.next;
		}
		
		return result.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if (this.head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, auxHead);
			this.head = newHead;
		} else {
			while (!auxHead.next.isNIL()) {
				auxHead = auxHead.next;
			}
			
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, auxHead.next);
			auxHead.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if (this.head.data.equals(element)) {
			this.head = this.head.next;
		} else {
			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();
			while (!aux.isNIL() && !aux.data.equals(element)) {
				previous = aux;
				aux = aux.next;
			}
			
			if (!aux.isNIL()) {
				previous.next = aux.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		
		int count = 0;
		SingleLinkedListNode<T> aux = this.head;
		
		while (!aux.isNIL()) {
			result[count] = aux.data;
			aux = aux.next;
			count++;
		}
		
		return result;
	}
	
	public void invert() {
		if (this.size() > 1) {	
			SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();
			SingleLinkedListNode<T> current = this.head;
			SingleLinkedListNode<T> next = new SingleLinkedListNode<>();
			
			while (!current.isNIL()) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			
			this.head = previous;
		}
	}
	
	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
