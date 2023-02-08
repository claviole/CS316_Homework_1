/*

*/

package binarytree;

/**
   This class defines a binary tree where every node
   always has exactly two branches. This definition
   of a binary tree means that there is no such thing
   as an empty full tree.
<p>
   Notice that this class really is a definition of a
   binary tree node. But both cases in the algebraic
   data type definition for this binary tree can be
   implemented by a node. The "tag" that tells us
   which kind of tree we have is the combination of
   the two child references. If both of them are null,
   then this is a leaf node.
*/
public class FullBTree<T> extends BTreeA<T>
{
   private T element;
   private FullBTree<T> left;
   private FullBTree<T> right;

   /**
      Construct a leaf node.

      @param element  reference to the data object to store in this node
   */
   public FullBTree(T element)
   {
      if (null == element)
         throw new IllegalArgumentException("BTree must have a root element");

      this.element = element;
      this.left = null;
      this.right = null;
   }


   /**
      Construct a BTree with the given binary trees
      as its left and right branches.

      @param element  reference to the data object to store in this node
      @param left     left branch tree for this node
      @param right    right branch tree for this node
   */
   public FullBTree(T element, FullBTree<T> left, FullBTree<T> right)
   {
      if (null == element)
         throw new IllegalArgumentException("BTree must have a root element");
      if (null == left)
         throw new IllegalArgumentException("BTree must have a left branch");
      if (null == right)
         throw new IllegalArgumentException("BTree must have a right branch");

      this.element = element;
      this.left  = left;
      this.right = right;
   }


   /**
      This is a static factory method.

      Convert any full {@link BTree} to a {@code FullBTree}.

      @param <T>    The element type for the {@link BTree}
      @param btree  A full {@link BTree} of any type
      @return a {@code FullBTree} version of the input tree.
   */
   public static <T> FullBTree<T> convert(BTree<T> btree)
   {
      if ( btree.isEmpty() )
      {
         throw new IllegalArgumentException("FullBTree must not be empty");
      }
      else if ( btree.isLeaf() )
      {
         return new FullBTree<T>( btree.root() );
      }
      else
      {
         return new FullBTree<T>(btree.root(),
                                 convert(btree.left()),
                                 convert(btree.right()));
      }
   }


   // Implement the four methods of the BTree<T> interface.

   @Override
   public boolean isEmpty()
   {
      return false;
   }

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


   /**
      The logic of isLeaf() used in BTree.java
      does not work with FullBTree. In BTree, the
      logic for isLeaf() is that a node is a leaf
      if the node isn't empty and it has two empty
      sub trees. But a full binary tree cannot be
      empty, so we can't check for empty sub trees.
      <p>
      Another way to put this is that in the algebraic
      data type for binary trees, a leaf node is a tree
      with two empty sub trees. But in the algebraic data
      type for full binary trees, a leaf node does not have
      any sub tees. So leaf nodes are defined differently in
      the two algebraic data types.
   */
   @Override
   public boolean isLeaf()
   {
      return  left == null
          && right == null;
   }
}
