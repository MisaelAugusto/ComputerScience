package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@Override
	public void insert(int key, T newValue, int height) {
		if (newValue != null) {
			SkipListNode[] update = new SkipListNode[this.maxHeight];
			
			SkipListNode<T> auxListNode = this.root;
			for (int i = this.maxHeight - 1; i > -1; i--) {
				while (auxListNode.getForward(i).getKey() < key) {
					auxListNode = auxListNode.getForward(i);
				}
				
				update[i] = auxListNode;
			}
			
			auxListNode = auxListNode.getForward(0);
			
			if (auxListNode.getKey() == key) {
				auxListNode.setValue(newValue);
			} else {
				SkipListNode<T> newListNode = new SkipListNode<>(key, height, newValue);
				
				for (int i = 0; i < height; i++) {
					newListNode.getForward()[i] = update[i].getForward(i);
					update[i].getForward()[i] = newListNode;
				}
			}
		}
	}

	@Override
	public void remove(int key) {
		SkipListNode[] update = new SkipListNode[this.maxHeight];
		
		SkipListNode<T> auxListNode = this.root;
		for (int i = this.maxHeight - 1; i > -1; i--) {
			while (auxListNode.getForward(i).getKey() < key) {
				auxListNode = auxListNode.getForward(i);
			}
			
			update[i] = auxListNode;
		}
		
		auxListNode = auxListNode.getForward(0);
		
		if (auxListNode.getKey() == key) {
			for (int i = 0; i < this.maxHeight; i++) {
				if (update[i].getForward(i) != auxListNode) {
					break;
				}
				
				update[i].getForward()[i] = auxListNode.getForward(i);
			}
		}
	}
	
	@Override
	public int height() {
		int height = 0;
		
		if (!this.isEmpty()) {
			SkipListNode<T> auxListNode = this.root.getForward(0);
			for (int i = 0; i < this.size(); i++) {
				height = Math.max(height, auxListNode.height());
				auxListNode = auxListNode.getForward(0);
			}
		}
		
		return height;
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> result = null;
		SkipListNode<T> auxListNode = this.root;
		
		for (int i = this.maxHeight - 1; i > -1; i--) {
			while (auxListNode.getForward(i).getKey() < key) {
				auxListNode = auxListNode.getForward(i);
			}
		}
		
		auxListNode = auxListNode.getForward(0);
		
		if (auxListNode.getKey() == key) {
			result = auxListNode;
		}
		
		return result;
	}

	@Override
	public int size() {
		int size = 0;
		
		SkipListNode<T> auxListNode = this.root.getForward(0);
		while (auxListNode.getValue() != null) {
			size++;
			auxListNode = auxListNode.getForward(0);
		}
		
		return size;
	}
	
	private boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
	public SkipListNode<T>[] toArray() {
		SkipListNode[] result = new SkipListNode[this.size() + 2];
		
		SkipListNode<T> auxListNode = this.root;
		for (int i = 0; i < this.size() + 2; i++) {
			result[i] = auxListNode;
			auxListNode = auxListNode.getForward(0);
		}
		
		return result;
	}

}
