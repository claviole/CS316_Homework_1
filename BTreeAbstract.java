/*

*/

package binarytree;

/**
   This is an abstract base class for defining a binary
   tree data type.
<p>
   We will define two concrete subclasses of this base
   class. One subclass, {@link BTreeNode}, will define
   binary tree nodes. The other subclass, {@link EmptyBTree},
   will define the empty binary tree. The two subclasses
   give us the OR (the "sum" type) in the algebraic data
   type for a binary tree.
*/
public abstract class BTreeAbstract<T> extends BTreeA<T>
{
   /**
      This is a static factory method.

      Convert an arbitrary {@link BTree} to a {@code BTreeAbstract}.

      @param <T>    The element type for the {@link BTree}
      @param btree  A {@link BTree} of any type
      @return a {@code BTreeAbstract} version of the input tree.
   */
   public static <T> BTreeAbstract<T> convert(BTree<T> btree)
   {
      if ( btree.isEmpty() )
      {
         return new EmptyBTree<T>();
      }
      else if ( btree.isLeaf() ) // need this case for FullBTree
      {
         return new BTreeNode<T>(btree.root(),
                                 new EmptyBTree<T>(),
                                 new EmptyBTree<T>());
      }
      else
      {
         return new BTreeNode<T>(btree.root(),
                                 convert(btree.left()),
                                 convert(btree.right()));
      }
   }
}
