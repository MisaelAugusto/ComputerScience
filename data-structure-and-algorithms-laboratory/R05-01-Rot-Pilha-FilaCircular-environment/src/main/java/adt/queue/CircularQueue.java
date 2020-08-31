package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		}
		
		if (element != null) {
			if (this.tail == this.array.length - 1)	{
				this.tail = -1;
			}
			
			this.array[++this.tail] = element;
						
			this.elements++;
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		
		if (!this.isEmpty()) {
			result = this.array[this.head];
			
			if (this.head == this.array.length - 1)	{
				this.head = -1;
			} else {
				this.head++;
			}
						
			this.elements--;
		} else {
			throw new QueueUnderflowException();
		}
		
		return result;
	}

	@Override
	public T head() {
		T result = null;
		
		if (!this.isEmpty()) {
			result = this.array[this.head];
		}
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}

}
