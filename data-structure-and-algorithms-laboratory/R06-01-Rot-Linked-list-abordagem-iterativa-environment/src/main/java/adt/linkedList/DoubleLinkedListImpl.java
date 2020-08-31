package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, ((DoubleLinkedListNode<T>) head), new DoubleLinkedListNode<>());
		
		if (this.head instanceof DoubleLinkedList<?>) {	
			((DoubleLinkedListNode<T>) head).previous = newHead;
		}
		
		if (this.head.isNIL()) {
			this.last = newHead;
		}
	}

	@Override
	public void removeFirst() {
		if (!this.head.isNIL()) {
			this.head = this.head.next;
			if (this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			}
			
			if (this.head instanceof DoubleLinkedList<?>) {	
				((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<>();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.last = this.last.previous;
			if (this.last.isNIL()) {
				this.head = this.last;
			}
			
			this.last.next = new DoubleLinkedListNode<>();
		}
	}
	
	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
