package adt.bst.extended;

import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		while(!this.getRoot().isEmpty()) {
			this.remove(this.getRoot().getData());
		}
		
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		
		return this.order();
	}

	@Override
	public T[] reverseOrder() {
		T[] result = (T[]) new Comparable[this.size()];
		
		this.reverseOrder(result, this.getRoot(), 0);
		
		return result;
	}
	
	private int reverseOrder(T[] array, BSTNode<T> node, int index) {
		if (!node.isEmpty()) {
			index = this.reverseOrder(array, (BSTNode<T>) node.getRight(), index);
			array[index] = node.getData();
			index++;
			index = this.reverseOrder(array, (BSTNode<T>) node.getLeft(), index);
		}
		
		return index;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
