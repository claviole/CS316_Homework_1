/*

*/

package binarytree;

/**
   This class defines a binary tree data structure
   as an object that has a reference to a binary
   tree node.
<p>
   This class gives us a well defined empty binary tree
   that is not represented by a null value. The empty
   tree is internally denoted by a null reference, but
   that reference is hidden inside of a {@code LinkedBTree}
   object, so the null reference is not part of the public
   interface. The internal reference to a node acts as a
   "tag" (in a "tagged union") to distinguish between the
   two cases of the binary tree algebraic data type.
<p>
   See <a href="https://en.wikipedia.org/wiki/Tagged_union" target="_top">
                https://en.wikipedia.org/wiki/Tagged_union</a>
<p>
   Compared to the {@link BTreeLinked} implementation of the
   {@link BTree} interface, this implementation "has a" node,
   whereas {@link BTreeLinked} "is a" node.
<p>
   The {@link binarytree.LinkedBTree.BTreeNode} data structure
   is defines as a private, nested class inside of this
   {@code LinkedBTree} class.
*/
public class LinkedBTree<T> extends BTreeA<T>
{
   private BTreeNode<T> btreeNode;

   /**
      Construct an empty binary tree.
   */
   public LinkedBTree()
   {
      btreeNode = null;
   }


   /**
      Construct a leaf node.

      Notice that if this constructor didn't exist, you could
      still construct a leaf node, it would just be cumbersome.
      For example,
      <pre>{@code
         BTree<String> leaf = new BTree<>("a", new BTree<>(), new BTree<>());
      }</pre>
      So this is really a "convenience" constructor. It doesn't
      need to be defined, but it sure is convenient for it to be
      here.

      @param element  reference to the data object to store in this node
   */
   public LinkedBTree(T element)
   {
      if (null == element)
         throw new IllegalArgumentException("BTree must have a root element");

      btreeNode = new BTreeNode<T>(element, null, null);
   }


   /**
      Construct a BTree with the given binary trees
      as its left and right branches.

      @param element  reference to the data object to store in this node
      @param left     left branch tree for this node
      @param right    right branch tree for this node
   */
   public LinkedBTree(T element, LinkedBTree<T> left, LinkedBTree<T> right)
   {
      if (null == element)
         throw new IllegalArgumentException("BTree must have a root element");
      if (null == left)
         throw new IllegalArgumentException("BTree must have a left branch");
      if (null == right)
         throw new IllegalArgumentException("BTree must have a right branch");

      // We need to "unwrap" the nodes from the left and right branches.
      btreeNode = new BTreeNode<T>(element, left.btreeNode, right.btreeNode);
   }


   /**
      This is a static factory method.

      Convert an arbitrary {@link BTree} to a {@code LinkedBTree}.

      @param <T>    The element type for the {@link BTree}
      @param btree  A {@link BTree} of any type
      @return a {@code LinkedBTree} version of the input tree.
   */
   public static <T> LinkedBTree<T> convert(BTree<T> btree)
   {
      if ( btree.isEmpty() )
      {
         return new LinkedBTree<T>();
      }
      else if ( btree.isLeaf() ) // need this case for FullBTree
      {
         return new LinkedBTree<T>(btree.root(),
                                   new LinkedBTree<T>(),
                                   new LinkedBTree<T>());
      }
      else
      {
         return new LinkedBTree<T>(btree.root(),
                                   convert(btree.left()),
                                   convert(btree.right()));
      }
   }


   // Implement the four methods of the BTree<T> interface.

   @Override
   public boolean isEmpty()
   {
      return null == btreeNode;
   }


   @Override
   public T root()
   {
      if (null == btreeNode)
         throw new java.util.NoSuchElementException("empty BTree");

      return btreeNode.element;
   }


   @Override
   public LinkedBTree<T> left()
   {
      if (null == btreeNode)
         throw new java.util.NoSuchElementException("empty BTree");

      // We need to "wrap" the node for the
      // left branch in a BTree object.
      LinkedBTree<T> temp = new LinkedBTree<T>();
      temp.btreeNode = this.btreeNode.left;
      return temp;
   }


   @Override
   public LinkedBTree<T> right()
   {
      if (null == btreeNode)
         throw new java.util.NoSuchElementException("empty BTree");

      // We need to "wrap" the node for the
      // right branch in a BTree object.
      LinkedBTree<T> temp = new LinkedBTree<T>();
      temp.btreeNode = this.btreeNode.right;
      return temp;
   }


   // A private nested class definition.
   private class BTreeNode<T>
   {
      public T element;
      public BTreeNode<T> left;
      public BTreeNode<T> right;

      public BTreeNode(T data)
      {
         this(data, null, null);
      }

      public BTreeNode(T element, BTreeNode<T> left, BTreeNode<T> right)
      {
         this.element = element;
         this.left = left;
         this.right = right;
      }

      public String toString()
      {
         if (null == left && null == right)
         {
            return element.toString();
         }
         else
         {
            String result = "(" + element;
            result += " ";
            result += (null == left) ? "()" : left;  // recursion
            result += " ";
            result += (null == right) ? "()" : right; // recursion
            result += ")";
            return result;
         }
      }
   }//BTreeNode
}
