package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}
	
	@Override
	protected void rebalance(BSTNode<T> node) {
		   if (node != null && !node.isEmpty()) {
		   	  	int balance = this.calculateBalance(node);
		
		   	  	if (balance > 1) {
		   	  		BSTNode<T> leftNode = (BSTNode<T>) node.getLeft();
		
		         	if (this.calculateBalance(leftNode) < 0) {
		         		this.leftRotation(leftNode);
		         	}
		
		         	this.rightRotation(node);
		         	
		         	this.LRcounter++;
		   	  	} else if (balance < -1) {
		    	  	BSTNode<T> rightNode = (BSTNode<T>) node.getRight();
		
		    	  	if (this.calculateBalance(rightNode) > 0) {
		    	  		this.rightRotation(rightNode);
		    	  	}
		
		    	  	this.leftRotation(node);
		    	  	this.RLcounter++;
		   	  	}
		   }
	   }
	
	@Override
	public void fillWithoutRebalance(T[] array) {
		int middle;
		Arrays.sort(array);
		
	}

}
