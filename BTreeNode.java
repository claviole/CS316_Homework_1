/*

*/

package binarytree;

/**
   This concrete subclass of BTree defines a binary tree node.
   This is one case of the two cases in the algebraic data type
   for a binary tree.
*/
public class BTreeNode<T> extends BTreeAbstract<T>
{
   private T element;
   private BTreeAbstract<T> left;
   private BTreeAbstract<T> right;

   /**
      Construct a leaf node.

      @param element  reference to the data object to store in this node
   */
   public BTreeNode(T element)
   {
      this(element, new EmptyBTree<T>(), new EmptyBTree<T>());
   }


   /**
      Construct a BTree with the given binary trees
      as its left and right branches.

      @param element  reference to the data object to store in this node
      @param left     left branch tree for this node
      @param right    right branch tree for this node
   */
   public BTreeNode(T element, BTreeAbstract<T> left, BTreeAbstract<T> right)
   {
      this.element = element;
      this.left = left;
      this.right = right;
   }


   // Implement the four mthods of the BTree<T> interface.

   @Override
   public T root()
   {
      return element;
   }

   @Override
   public BTree<T> left()
   {
      return left;
   }

   @Override
   public BTree<T> right()
   {
      return right;
   }

   @Override
   public boolean isEmpty()
   {
      return false;
   }
}//BTreeNode
