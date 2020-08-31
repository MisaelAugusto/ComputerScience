package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBTree<T> {

   public RBTreeImpl() {
      this.root = new RBNode<T>();
   }

   protected int blackHeight() {
      int blackHeight = 0;

      if (!this.isEmpty()) {
         blackHeight = this.blackHeight((RBNode<T>) this.root);
      }

      return blackHeight;
   }

   private int blackHeight(RBNode<T> node) {
      if (!node.isEmpty()) {
         if (node.getColour() == Colour.BLACK) {
            return 1 + Math.max(this.blackHeight((RBNode<T>) node.getLeft()),
                  this.blackHeight((RBNode<T>) node.getRight()));
         } else {
            return Math
                  .max(this.blackHeight((RBNode<T>) node.getLeft()), this.blackHeight((RBNode<T>) node.getRight()));
         }
      }

      return 0;
   }

   protected boolean verifyProperties() {
      boolean resp = verifyNodesColour() && verifyNILNodeColour() && verifyRootColour() && verifyChildrenOfRedNodes()
            && verifyBlackHeight();

      return resp;
   }

   /**
    * The colour of each node of a RB tree is black or red. This is guaranteed
    * by the type Colour.
    */
   private boolean verifyNodesColour() {
      return true; // already implemented
   }

   /**
    * The colour of the root must be black.
    */
   private boolean verifyRootColour() {
      return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
      // implemented
   }

   /**
    * This is guaranteed by the constructor.
    */
   private boolean verifyNILNodeColour() {
      return true; // already implemented
   }

   /**
    * Verifies the property for all RED nodes: the children of a red node must
    * be BLACK.
    */
   private boolean verifyChildrenOfRedNodes() {
      boolean result = true;

      if (!this.isEmpty()) {
         result = this.verifyChildrenOfRedNodes((RBNode<T>) this.root.getLeft())
               && this.verifyChildrenOfRedNodes((RBNode<T>) this.root.getRight());
      }

      return result;
   }

   private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
      if (node != null && !node.isEmpty()) {
         if (node.getColour() == Colour.RED) {
            if (!auxVerifyChildrenOfRedNodes((RBNode<T>) node.getLeft(), (RBNode<T>) node.getRight())) {
               return false;
            }
         }

         return this.verifyChildrenOfRedNodes((RBNode<T>) node.getLeft())
               && this.verifyChildrenOfRedNodes((RBNode<T>) node.getRight());
      }

      return true;
   }

   private boolean auxVerifyChildrenOfRedNodes(RBNode<T> left, RBNode<T> right) {
      return (left.getColour() == Colour.BLACK && right.getColour() == Colour.BLACK);
   }

   /**
    * Verifies the black-height property from the root. The method blackHeight
    * returns an exception if the black heights are different.
    */
   private boolean verifyBlackHeight() {
      boolean result = true;

      if (!this.isEmpty()) {
         int leftBlackHeight = this.blackHeight((RBNode<T>) this.root.getLeft());
         int rightBlackHeight = this.blackHeight((RBNode<T>) this.root.getRight());

         result = (leftBlackHeight == rightBlackHeight);
      }

      return result;
   }

   @Override
   public void insert(T value) {
      if (value != null) {
         RBNode<T> NIL = new RBNode<>();
         this.insert(NIL, (RBNode<T>) this.root, value);
      }
   }

   private void insert(RBNode<T> parent, RBNode<T> node, T element) {
      if (node.isEmpty()) {
         node.setData(element);

         node.setLeft(new RBNode<T>());
         node.setRight(new RBNode<T>());

         node.getLeft().setParent(node);
         node.getRight().setParent(node);

         if (!node.equals(this.root)) {
            node.setParent(parent);
         }

         node.setColour(Colour.RED);
         this.fixUpCase1(node);
      } else if (node.getData().compareTo(element) > 0) {
         this.insert(node, (RBNode<T>) node.getLeft(), element);
      } else if (node.getData().compareTo(element) < 0) {
         this.insert(node, (RBNode<T>) node.getRight(), element);
      }
   }

   @Override
   public RBNode<T>[] rbPreOrder() {
      RBNode<T>[] result = new RBNode[this.size()];

      this.preOrder(result, (RBNode<T>) this.root, 0);

      return result;
   }

   private int preOrder(RBNode<T>[] array, RBNode<T> node, int index) {
      if (!node.isEmpty()) {
         array[index++] = node;

         index = this.preOrder(array, (RBNode<T>) node.getLeft(), index);
         index = this.preOrder(array, (RBNode<T>) node.getRight(), index);
      }

      return index;
   }

   // FIXUP methods
   protected void fixUpCase1(RBNode<T> node) {
      if (node.equals(this.root)) {
         node.setColour(Colour.BLACK);
      } else {
         this.fixUpCase2(node);
      }
   }

   protected void fixUpCase2(RBNode<T> node) {
      if (((RBNode<T>) node.getParent()).getColour() != Colour.BLACK) {
         this.fixUpCase3(node);
      }
   }

   protected void fixUpCase3(RBNode<T> node) {
      RBNode<T> uncle = this.getUncleNode(node);
      RBNode<T> parent = (RBNode<T>) node.getParent();
      RBNode<T> grandpa = (RBNode<T>) node.getParent().getParent();

      if (uncle.getColour() == Colour.RED) {
         parent.setColour(Colour.BLACK);
         uncle.setColour(Colour.BLACK);
         grandpa.setColour(Colour.RED);

         this.fixUpCase1(grandpa);
      } else {
         this.fixUpCase4(node);
      }
   }

   private RBNode<T> getUncleNode(RBNode<T> node) {
      if (node.getParent().equals(node.getParent().getParent().getRight())) {
         return (RBNode<T>) node.getParent().getParent().getLeft();
      } else {
         return (RBNode<T>) node.getParent().getParent().getRight();
      }
   }

   protected void fixUpCase4(RBNode<T> node) {
      RBNode<T> next = node;

      if (node.getParent().getRight().equals(node) && node.getParent().getParent().getLeft().equals(node.getParent())) {
         Util.leftRotation(node);
         next = (RBNode<T>) node.getLeft();
      } else if (node.getParent().getLeft().equals(node)
            && node.getParent().getParent().getRight().equals(node.getParent())) {
         Util.rightRotation(node);
         next = (RBNode<T>) node.getRight();
      }

      this.fixUpCase5(next);
   }

   protected void fixUpCase5(RBNode<T> node) {
      RBNode<T> parent = (RBNode<T>) node.getParent();
      RBNode<T> grandpa = (RBNode<T>) node.getParent().getParent();

      parent.setColour(Colour.BLACK);
      grandpa.setColour(Colour.RED);

      if (node.getParent().getLeft().equals(node)) {
         Util.rightRotation(node);
      } else {
         Util.leftRotation(node);
      }
   }
}
