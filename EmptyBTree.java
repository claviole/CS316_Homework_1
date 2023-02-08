/*

*/

package binarytree;

/**
   This concrete subclass of BTree defines an empty binary tree.
   This is one case of the two cases in the algebraic data type
   for a binary tree.
*/
public class EmptyBTree<T> extends BTreeAbstract<T>
{
   // Implement the four mthods of the BTree<T> interface.
   @Override
   public T root()
   {
      throw new java.util.NoSuchElementException("empty BTree");
   }

   @Override
   public BTree<T> left()
   {
      throw new java.util.NoSuchElementException("empty BTree");
   }

   @Override
   public BTree<T> right()
   {
      throw new java.util.NoSuchElementException("empty BTree");
   }

   @Override
   public boolean isEmpty()
   {
      return true;
   }
}
