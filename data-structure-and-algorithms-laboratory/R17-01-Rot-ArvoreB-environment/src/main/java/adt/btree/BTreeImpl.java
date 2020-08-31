package adt.btree;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

   protected BNode<T> root;
   protected int order;

   public BTreeImpl(int order) {
      this.order = order;
      this.root = new BNode<T>(order);
   }

   @Override
   public BNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return this.root.isEmpty();
   }

   @Override
   public int height() {
      int height = -1;

      if (!this.isEmpty()) {
         height = this.height(this.root) - 1;
      }

      return height;
   }

   private int height(BNode<T> node) {
      if (node.isLeaf()) {
         return 0;
      }

      return 1 + this.height(node.getChildren().getFirst());
   }

   @Override
   public BNode<T>[] depthLeftOrder() {
      BNode<T>[] result = new BNode[this.size()];

      this.depthLeftOrder(result, this.root, 0);

      return result;
   }

   private int depthLeftOrder(BNode<T>[] array, BNode<T> node, int index) {
      if (!node.isEmpty()) {
         array[index++] = node;
         for (int i = 0; i < node.getChildren().size(); i++) {
            index = this.depthLeftOrder(array, node.getChildren().get(i), index);
         }
      }

      return index;
   }

   @Override
   public int size() {
      int size = 0;

      if (!this.isEmpty()) {
         size = this.size(this.root);
      }

      return size;
   }

   private int size(BNode<T> node) {
      if (node.isEmpty()) {
         return 0;
      } else {
         int size = node.size();

         for (int i = 0; i < node.getChildren().size(); i++) {
            size += this.size(node.getChildren().get(i));
         }

         return size;
      }
   }

   @Override
   public BNodePosition<T> search(T element) {
      BNodePosition<T> result = new BNodePosition<>();

      if (element != null) {
         result = this.search(this.root, element);
      }

      return result;
   }

   private BNodePosition<T> search(BNode<T> node, T element) {
      int index = 0;
      while (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) > 0) {
         index++;
      }

      if (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) == 0) {
         return new BNodePosition(node, index);
      }

      if (node.isLeaf()) {
         return new BNodePosition<T>();
      }

      return this.search(node.getChildren().get(index), element);
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         this.insert(this.root, element);
      }

   }

   private void insert(BNode<T> node, T element) {
      int index = 0;
      while (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) > 0) {
         index++;
      }

      if (index >= node.size() || !node.getElementAt(index).equals(element)) {
         if (node.isLeaf()) {
            node.addElement(element);
            node.addChild(index, new BNode<T>(this.order));

         } else {
            this.insert(node.getChildren().get(index - 1), element);
         }

         if (node.size() > node.getMaxKeys()) {
            this.split(node);
         }
      }
   }

   private void split(BNode<T> node) {
      int mediana = this.size() / 2;

      BNode<T> leftNode = this.copyLeftNode(node, mediana);
      BNode<T> rightNode = this.copyRightNode(node, mediana);

      T element = node.getElementAt(mediana);

      if (node.equals(getRoot())) {
         BNode<T> newRoot = new BNode<>(node.getOrder());

         newRoot.addElement(element);
         node.setParent(newRoot);
         this.root = newRoot;

         newRoot.addChild(0, leftNode);
         newRoot.addChild(1, rightNode);
         newRoot.getChildren().get(0).setParent(newRoot);
         newRoot.getChildren().get(1).setParent(newRoot);

      } else {

         node.addChild(0, leftNode);
         node.addChild(1, rightNode);

         this.promote(node);
      }
   }

   private BNode<T> copyLeftNode(BNode<T> node, int mediana) {
      BNode<T> leftNode = new BNode<>(node.getOrder());

      for (int i = 0; i < mediana; i++) {
         leftNode.addElement(node.getElements().get(i));
      }

      for (int i = 0; i <= mediana; i++) {
         leftNode.addChild(i, node.getChildren().get(i));
      }

      return leftNode;
   }

   private BNode<T> copyRightNode(BNode<T> node, int mediana) {
      BNode<T> rightNode = new BNode<>(node.getOrder());

      for (int i = mediana + 1; i < node.getElements().size(); i++) {
         rightNode.addElement(node.getElements().get(i));
      }

      for (int i = mediana + 1; i < node.getChildren().size(); i++) {
         rightNode.addChild(i - mediana - 1, node.getChildren().get(i));
      }

      return rightNode;
   }

   protected void promote(BNode<T> node) {
      int mediana = this.size() / 2;

      T element = node.getElements().get(mediana);

      node.getElements().clear();
      node.addElement(element);

      BNode<T> parent = node.getParent();

      if (parent != null) {
         node.getChildren().get(0).setParent(parent);
         node.getChildren().get(1).setParent(parent);
      }

      int index = parent.getChildren().indexOf(node);

      parent.addElement(element);
      parent.addChild(index, node.getChildren().get(0));
      parent.addChild(index + 1, node.getChildren().get(1));

      node.getChildren().get(0).setParent(parent);
      node.getChildren().get(1).setParent(parent);

      parent.getChildren().remove(node);
   }

   // NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
   @Override
   public BNode<T> maximum(BNode<T> node) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

   @Override
   public BNode<T> minimum(BNode<T> node) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

   @Override
   public void remove(T element) {
      // NAO PRECISA IMPLEMENTAR
      throw new UnsupportedOperationException("Not Implemented yet!");
   }

}
