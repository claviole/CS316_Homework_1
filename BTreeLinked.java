/*

*/

package binarytree;

/**
   This class defines a binary tree data structure as
   an object that has three references, a reference to
   an element, a reference to a left binary tree, and
   a reference to a right binary tree.
<p>
   This class essentially defines a binary tree as a
   binary tree node. This class solves the algebraic data
   type problem of defining the OR type by defining the
   empty tree as a node with all three references equal
   to null. So we are once again using a "tagged union"
   but now the "tag" is all three references combined.
<p>
   See <a href="https://en.wikipedia.org/wiki/Tagged_union" target="_top">
                https://en.wikipedia.org/wiki/Tagged_union</a>
<p>
   This class gives us a well defined empty binary tree.
   The empty tree is internally denoted by three null
   references, but those references are hidden inside of
   a {@code BTreeLinked} object, so the null references
   are not part of the public interface.
*/
public class BTreeLinked<T> extends BTreeA<T>
{
   private T element;
   private BTreeLinked<T> left;
   private BTreeLinked<T> right;

   /**
      Construct an empty binary tree.
   */
   public BTreeLinked()
   {
      this.element = null;
      this.left = null;
      this.right = null;
   }


   /**
      Construct a leaf node.

      @param element  reference to the data object to store in this node
   */
   public BTreeLinked(T element)
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
   public BTreeLinked(T element, BTreeLinked<T> left, BTreeLinked<T> right)
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

      Convert an arbitrary {@link BTree} to a {@code BTreeLinked}.

      @param <T>    The element type for the {@link BTree}
      @param btree  A {@link BTree} of any type
      @return a {@code BTreeLinked} version of the input tree.
   */
   public static <T> BTreeLinked<T> convert(BTree<T> btree)
   {
      if ( btree.isEmpty() )
      {
         return new BTreeLinked<T>();
      }
      else if ( btree.isLeaf() ) // need this case for FullBTree
      {
         return new BTreeLinked<T>(btree.root(),
                                   new BTreeLinked<T>(),
                                   new BTreeLinked<T>());
      }
      else
      {
         return new BTreeLinked<T>(btree.root(),
                                   convert(btree.left()),
                                   convert(btree.right()));
      }
   }


   // Implement the four methods of the BTree<T> interface.

   @Override
   public boolean isEmpty()
   {
      return null == element
          && null == left
          && null == right;
   }


   @Override
   public T root()
   {
      if ( isEmpty() )
         throw new java.util.NoSuchElementException("empty BTree");

      return element;
   }


   @Override
   public BTreeLinked<T> left()
   {
      if ( isEmpty() )
      {
         throw new java.util.NoSuchElementException("empty BTree");
      }
      else if ( null == left )
      {
         return new BTreeLinked<T>(); // return an empty tree
      }
      else
      {
         return left;
      }
   }


   @Override
   public BTreeLinked<T> right()
   {
      if ( isEmpty() )
      {
         throw new java.util.NoSuchElementException("empty BTree");
      }
      else if ( null == right )
      {
         return new BTreeLinked<T>(); // return an empty tree
      }
      else
      {
         return right;
      }
   }
}
