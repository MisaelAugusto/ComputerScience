package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

   // TODO Do not forget: you must override the methods insert and remove
   // conveniently.

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
		} else {
			if (node.getData().compareTo(element) > 0) {
				this.insert(node, (BSTNode<T>) node.getLeft(), element);
			} else {
				this.insert(node, (BSTNode<T>) node.getRight(), element);
			}
			
			this.rebalance(node);
		}
   }

   @Override
   public void remove(T element) {
	   if (element != null) {
		   BSTNode<T> node = this.search(element);
		   
		   if (node != null && !node.isEmpty()) {
			   this.remove(node);
		   }
	   }
   }
   
   private void remove(BSTNode<T> node) {
	   if (node.isLeaf()) {
		   if (this.isRoot(node)) {
			   this.root = new BSTNode<>();
		   } else {
			   if (node.getParent().getLeft().equals(node)) {
				   node.getParent().setLeft(new BSTNode<>());
			   } else {
				   node.getParent().setRight(new BSTNode<>());
			   }
		   }
		   
		   this.rebalanceUp(node);
	   } else if ((node.getRight().isEmpty() && !node.getLeft().isEmpty())) {
		   if (this.isRoot(node)) {
				this.root = new BSTNode<>();
		   } else {
		   	   if (node.getParent().getLeft().equals(node)) {
				   node.getParent().setLeft(node.getLeft());
			   } else {
				   node.getParent().setRight(node.getLeft());
			   }
			   
			   node.getLeft().setParent(node.getParent());
		   }
			
		   this.rebalance(node);
	   } else if (!node.getRight().isEmpty() && node.getLeft().isEmpty()) {
		   if (this.isRoot(node)) {
			   this.root = new BSTNode<>();
		   } else {
		   	   if (node.getParent().getLeft().equals(node)) {
				   node.getParent().setLeft(node.getRight());
			   } else {
				   node.getParent().setRight(node.getRight());
			   }
			   
			   node.getRight().setParent(node.getParent());
		   
		   }
		   this.rebalanceUp(node);
	   } else {
		   BSTNode<T> auxNode = sucessor(node.getData());
		   
		   T auxData = auxNode.getData();
		   this.remove(auxNode);
		   
		   node.setData(auxData);
	   }
   }
   
   private boolean isRoot(BSTNode<T> node) {
	   return node.getParent() == null;
   }
   
   // AUXILIARY
   protected int calculateBalance(BSTNode<T> node) {
      int result = 0;

      if (!this.isEmpty()) {
         result = this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
      }

      return result;
   }

   // AUXILIARY
   protected void rebalance(BSTNode<T> node) {
	   if (node != null && !node.isEmpty()) {
	   	  	int balance = this.calculateBalance(node);
	
	   	  if (balance > 1) {
	   	  		BSTNode<T> leftNode = (BSTNode<T>) node.getLeft();
	
	         	if (this.calculateBalance(leftNode) < 0) {
	         		this.leftRotation(leftNode);
	         	}
	
	         	this.rightRotation(node);
	      } else if (balance < -1) {
	    	  	BSTNode<T> rightNode = (BSTNode<T>) node.getRight();
	
	    	  	if (this.calculateBalance(rightNode) > 0) {
	    	  		this.rightRotation(rightNode);
	    	  	}
	
	    	  	this.leftRotation(node);
	      }
	   }
   }

   private void rightRotation(BSTNode<T> node) {
	  if (node != null) {    
	   	  BSTNode<T> balancedNode = Util.rightRotation(node);
	
	      if (balancedNode.getParent() == null) {
	         this.root = balancedNode;
	      }
	  }
   }

   private void leftRotation(BSTNode<T> node) {
	   if (node != null) {   
		  BSTNode<T> balancedNode = Util.leftRotation(node);
	
	      if (balancedNode.getParent() == null) {
	         this.root = balancedNode;
	      }
	   }
   }
   
   // AUXILIARY
   protected void rebalanceUp(BSTNode<T> node) {
	   if (node != null && !node.isEmpty()) {
	   	   	BSTNode<T> parent = (BSTNode<T>) node.getParent();
		   
		   	while(parent != null) {
		   		rebalance(parent);
			   
		   		parent = (BSTNode<T>) parent.getParent();
		   	}
	   }
   }

}
