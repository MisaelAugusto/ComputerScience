package adt.bt;

import adt.rbtree.RBNode;

public class Util {

   /**
    * A rotacao a esquerda em node deve subir e retornar seu filho a direita
    * @param node
    * @return
    */
   public static <T extends Comparable<T>> RBNode<T> leftRotation(RBNode<T> node) {
      RBNode<T> rightNode = (RBNode<T>) node.getRight();

      node.setRight(rightNode.getLeft());
      rightNode.setLeft(node);

      if (node.getParent() != null) {
         if (!node.getParent().isEmpty() && !node.getParent().getLeft().isEmpty()
               && node.getParent().getLeft().getData().equals(node.getData())) {

            node.getParent().setLeft(rightNode);
         } else {
            node.getParent().setRight(rightNode);
         }
      }

      rightNode.setParent(node.getParent());
      node.setParent(rightNode);

      return rightNode;
   }

   /**
    * A rotacao a direita em node deve subir e retornar seu filho a esquerda
    * @param node
    * @return
    */
   public static <T extends Comparable<T>> RBNode<T> rightRotation(RBNode<T> node) {
      RBNode<T> leftNode = (RBNode<T>) node.getLeft();

      node.setLeft(leftNode.getRight());
      leftNode.setRight(node);

      if (node.getParent() != null) {
         if (!(!node.getParent().isEmpty() && !node.getParent().getLeft().isEmpty() && node.getParent().getLeft()
               .getData().equals(node.getData()))) {

            node.getParent().setLeft(leftNode);
         } else {
            node.getParent().setRight(leftNode);
         }
      }

      leftNode.setParent(node.getParent());
      node.setParent(leftNode);

      return leftNode;
   }

   public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
      @SuppressWarnings("unchecked")
      T[] array = (T[]) new Comparable[size];
      return array;
   }
}
