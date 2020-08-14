package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		
		super(data, next);
		
		if (this.next instanceof RecursiveDoubleLinkedListImpl<?>) {
			this.next = (RecursiveDoubleLinkedListImpl<T>) next;
		}
		
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		if (element != null) {	
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
				if (this.previous == null) {
					this.previous = new RecursiveDoubleLinkedListImpl<T>();
				}
			} else {
				this.next.insert(element);
			}
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> auxPrevious = new RecursiveDoubleLinkedListImpl<>(this.data, this.next, this);
				((RecursiveDoubleLinkedListImpl<T>) next).previous = auxPrevious;
				this.data = element;
				this.setNext(auxPrevious);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.data.equals(element)) {
				if (this.previous.isEmpty() && this.next.isEmpty()) {
					this.data = null;
					this.next = null;
					this.previous = null;
				} else {
					this.data = this.next.getData();
					this.next = this.next.getNext();
					if (this.next != null) {
						((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
					}
				}			
			} else {
				this.next.remove(element);
			}
		}
	}
	
	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {	
			if (this.next.isEmpty()) {
				this.data = null;
				this.next = null;
				this.previous = null;
			} else {
				this.data = this.next.getData();
				this.next = this.next.getNext();
				if (this.next != null) {
					((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
				}
			}
		}
	}

	@Override
	public void removeLast() {
		if (this.next.isEmpty()) {
			this.data = null;
			this.next = null;
		} else {
			((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
