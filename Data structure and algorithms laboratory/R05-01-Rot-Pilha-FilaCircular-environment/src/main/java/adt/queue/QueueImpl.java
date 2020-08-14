package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {		
		T result = null;
		
		if (!this.isEmpty()) {
			result = this.array[0];
		}
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}
	
	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1;
	}

	private void shiftLeft() {
		for (int i = 0; i <= tail; i++) {
			this.array[i] = this.array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {	
		if (this.isFull()) {
			throw new QueueOverflowException();
		}
		
		if (element != null) {
			this.array[++this.tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		
		if (!this.isEmpty()) {
			result = this.array[0];
			shiftLeft();
			this.tail--;
		} else {
			throw new QueueUnderflowException();
		}
		
		return result;
	}

}
