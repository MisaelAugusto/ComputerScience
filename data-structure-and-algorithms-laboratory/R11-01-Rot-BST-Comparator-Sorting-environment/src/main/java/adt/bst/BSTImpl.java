package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		int height = -1;
		
		if (!this.isEmpty()) {
			height = this.height(this.root) - 1;
		}
		
		return height;
	}
	

	private int height(BSTNode<T> node) {
		if (node.isEmpty()) {
			return 0;
		} else {
			return 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = new BSTNode<>();
		
		if (element != null) {
			result = this.search(this.root, element);
		}
		
		return result;
	}
	
	private BSTNode<T> search(BSTNode<T> node, T element) {
		if (node.isEmpty() || node.getData().equals(element)) {
			return node;
		} else if (node.getData().compareTo(element) > 0) {
			return this.search((BSTNode<T>) node.getLeft(), element);
		} else {
			return this.search((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			this.insert(null, this.root, element);
		}
	}
	
	private void insert(BSTNode<T> parent, BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setParent(parent);
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
		} else if (node.getData().compareTo(element) > 0) {
			this.insert(node, (BSTNode<T>) node.getLeft(), element);
		} else if (node.getData().compareTo(element) < 0) {
			this.insert(node, (BSTNode<T>) node.getRight(), element);
		}
	}
	
	@Override
	public BSTNode<T> maximum() {
		return this.maximum(this.root);
	}
	

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return null;
		} else if (node.getRight().isEmpty()) {
			return node;
		} else {
			return this.maximum((BSTNode<T>) node.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		return this.minimum(this.root);
	}
	
	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return null;
		} else if (node.getLeft().isEmpty()) {
			return node;
		} else {
			return this.minimum((BSTNode<T>) node.getLeft());
		}
	}
	
	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = search(element);
		
		if (result != null) {
			result = this.sucessor(result);
		}
		
		return result;
	}


	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> sucessor = this.minimum((BSTNode<T>) node.getRight());
		
		if (sucessor != null && !sucessor.isEmpty()) {
			//Do Anything
		} else {
			sucessor = (BSTNode<T>) node.getParent();
			
			while (sucessor != null && !sucessor.isEmpty() && (sucessor.getData().compareTo(node.getData()) < 0)) {
				sucessor = (BSTNode<T>) sucessor.getParent();
			}
			
			if (sucessor != null && sucessor.isEmpty()) {
				sucessor = null;
			}
		}
		
		return sucessor;
	}
	
	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = search(element);
		
		if (result != null) {
			result = this.predecessor(result);
		}
		
		return result;
	}
	
	private BSTNode<T> predecessor(BSTNode<T> node) {
		BSTNode<T> predecessor = this.maximum((BSTNode<T>) node.getLeft());
		
		if (predecessor != null && !predecessor.isEmpty()) {
			//Do Anything
		} else {
			predecessor = (BSTNode<T>) node.getParent();
			
			while (predecessor != null && !predecessor.isEmpty()
					&& (predecessor.getData().compareTo(node.getData()) > 0)) {
				predecessor = (BSTNode<T>) predecessor.getParent();
			}
			
			if (predecessor != null && predecessor.isEmpty()) {
				predecessor = null;
			}
		}
		
		return predecessor;
	}
	
	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			
			if (node != null && !node.isEmpty()) {
				this.remove(node);
			}
		}
	}
	
	private void remove(BSTNode<T> node) {
		if (node.getData().equals(getRoot().getData())) {
			BSTNode<T> auxNode = this.sucessor(node.getData());
			
			if (auxNode == null) {
				auxNode = this.predecessor(node.getData());
			}
			
			if (auxNode == null) {
				this.root.setData(null);
			} else {
				T auxData = node.getData();
				node.setData(auxNode.getData());
				auxNode.setData(auxData);
				this.remove(auxNode);
			}
		} else if (node.isLeaf()) {
			node.setData(null);
		} else if (!node.getRight().isEmpty() && node.getLeft().isEmpty()) {
			if (!node.getParent().getRight().isEmpty() && node.getParent().getRight().equals(node)) {
				node.getParent().setRight(node.getRight());
				node.getRight().setParent(node.getParent());
			} else {
				node.getParent().setLeft(node.getRight());
				node.getRight().setParent(node.getParent());
			}
		} else if (node.getRight().isEmpty() && !node.getLeft().isEmpty()) {
			if (node.getParent().getRight() != null && node.getParent().getRight().equals(node)) {
				node.getParent().setRight(node.getLeft());
				node.getLeft().setParent(node.getParent());
			} else {
				node.getParent().setLeft(node.getLeft());
				node.getLeft().setParent(node.getParent());
			}
		} else {
			BSTNode<T> auxNode = sucessor(node.getData());
			
			T auxData = node.getData();
			node.setData(auxNode.getData());
			auxNode.setData(auxData);
			this.remove(auxNode);
		}
	}
	
	@Override
	public T[] preOrder() {
		T[] result = (T[]) new Comparable[this.size()];
		
		this.preOrder(result, this.root, 0);
		
		return result;
	}
	
	private int preOrder(T[] array, BSTNode<T> node, int index) {
		if (!node.isEmpty()) {
			array[index] = node.getData();
			index++;
			index = this.preOrder(array, (BSTNode<T>) node.getLeft(), index);
			index = this.preOrder(array, (BSTNode<T>) node.getRight(), index);
		}
		
		return index;
	}

	@Override
	public T[] order() {
		T[] result = (T[]) new Comparable[this.size()];
		
		this.order(result, this.root, 0);
		
		return result;
	}
	
	private int order(T[] array, BSTNode<T> node, int index) {
		if (!node.isEmpty()) {
			index = this.order(array, (BSTNode<T>) node.getLeft(), index);
			array[index] = node.getData();
			index++;
			index = this.order(array, (BSTNode<T>) node.getRight(), index);
		}
		
		return index;
	}

	@Override
	public T[] postOrder() {
		T[] result = (T[]) new Comparable[this.size()];
		
		this.postOrder(result, this.root, 0);
		
		return result;
	}
	
	private int postOrder(T[] array, BSTNode<T> node, int index) {
		if (!node.isEmpty()) {
			index = this.postOrder(array, (BSTNode<T>) node.getLeft(), index);
			index = this.postOrder(array, (BSTNode<T>) node.getRight(), index);
			array[index] = node.getData();
			index++;
		}
		
		return index;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
