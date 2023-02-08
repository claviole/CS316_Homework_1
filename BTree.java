/*

*/

package binarytree;

/**
   Define an interface for binary trees and then
   use that interface to implement a number of
   methods that act on binary trees.
*/
public interface BTree<T>
{

   /**
      @return true if this is an empty tree
   */
   public boolean isEmpty();

   /**
      @return a reference to the item in the root node of this tree
   */
   public T root();

   /**
      @return a reference to the left branch of this binary tree
   */
   public BTree<T> left();

   /**
      @return a reference to the right branch of this binary tree
   */
   public BTree<T> right();


   // Use the above four interface methods to define
   // all the recursive methods we need on binary trees.
   // All the following methods are "default" (that is,
   // concrete) methods of this interface.

   /**
      Determine if a binary tree is a leaf node.

      @return true if this binary tree is just a single node
   */
   public default boolean isLeaf()
   {
      return ! isEmpty()
          && left().isEmpty()
          && right().isEmpty();
   }


   /**
      Compute the maximum degree of a BTree.

      @return the maximum degree of any node in this tree
   */
   public default int degree()
   {
      if ( isEmpty() )
      {
         return 0;
      }
      else if ( isLeaf() )
      {
         return 0;
      }
      else // a non-empty internal node
      {
         int rootDegree = 0;

         if ( ! left().isEmpty() )
         {
            ++rootDegree;
         }
         if ( ! right().isEmpty() )
         {
            ++rootDegree;
         }
         return Math.max(rootDegree, Math.max( left().degree(),  // recursion
                                              right().degree())); // recursion
      }
   }


   /**
      Calculate the height of a BTree.

      @return the height of this tree
   */
   public default int height()
   {
      if ( isEmpty() )
      {
         return -1;
      }
      else if ( isLeaf() )
      {
         return 0;
      }
      else // a non-empty internal node
      {
         return 1 + Math.max( left().height(),  // recursion
                             right().height()); // recursion
      }
   }


   /**
      Calculate the size of a BTree.

      @return the number of leaves and internal nodes in this tree
   */
   public default int size()
   {
      if ( isEmpty() )
      {
         return 0;
      }
      else if ( isLeaf() )
      {
         return 1;
      }
      else // a non-empty internal node
      {
         return 1 +  left().size()  // recursion
                  + right().size(); // recursion
      }
   }


   /**
      Determine if a BTree is a full binary tree.

      @return true if this is a full binary tree, false otherwise
   */
   public default boolean isFull()
   {
      if ( isEmpty() )
      {
         return true;
      }
      else if ( isLeaf() )
      {
         return true;
      }
      else // a non-empty internal node
      {
         return ( left().isEmpty() && right().isEmpty() )
               || ( !  left().isEmpty()
                 && ! right().isEmpty()
                 &&  left().isFull()    // recursion
                 && right().isFull() ); // recursion
      }
   }


   /**
      Do a pre-order traversal of a binary tree.

      @return a {@link String} representation of the pre-order traversal of this {@code BTree}
   */
   public default String preOrder()
   {
      if ( isEmpty() )
      {
         return "";
      }
      else if ( isLeaf() )
      {
         return root() + " ";
      }
      else // a non-empty internal node
      {
         return root() + " "
              +  left().preOrder()  // recursion
              + right().preOrder(); // recursion
      }
   }


   /**
      Do an in-order traversal of a binary tree.

      @return a {@link String} representation of the in-order traversal of this {@code BTree}
   */
   public default String inOrder()
   {
      if ( isEmpty() )
      {
         return "";
      }
      else if ( isLeaf() )
      {
         return root() + " ";
      }
      else // a non-empty internal node
      {
         return  left().inOrder()   // recursion
              + root() + " "
              + right().inOrder();  // recursion
      }
   }


   /**
      Do a post-order traversal of a binary tree.

      @return a {@link String} representation of the post-order traversal of this {@code BTree}
   */
   public default String postOrder()
   {
      if ( isEmpty() )
      {
         return "";
      }
      else if ( isLeaf() )
      {
         return root() + " ";
      }
      else // a non-empty internal node
      {
         return  left().postOrder()  // recursion
              + right().postOrder()  // recursion
              + root() + " ";
      }
   }


   // Here is an alternative way of writing the three traversal
   // methods. Look carefully at how they are written. Notice that
   // they show that these definitions are not quite accurate:
   //    pre-order means 1. visit node
   //                    2. traverse left branch
   //                    3. traverse right branch
   // while
   //   post-order means 1. traverse left branch
   //                    2. traverse right branch
   //                    3. visit node
   // All three of these implementation traverse the right branch
   // before traversing the left branch! This works because these
   // methods have no side effects. These are pure (functional)
   // methods.
   public default String preOrderV2()
   {
      if ( isEmpty() )
      {
         return "";
      }
      else if ( isLeaf() )
      {
         return root() + " ";
      }
      else // a non-empty internal node
      {
         final String s1 = root() + " ";
         final String s2 = right().preOrderV2();  // recursion
         final String s3 =  left().preOrderV2();  // recursion
         return s1 + s3 + s2;
      }
   }

   public default String inOrderV2()
   {
      if ( isEmpty() )
      {
         return "";
      }
      else if ( isLeaf() )
      {
         return root() + " ";
      }
      else // a non-empty internal node
      {
         final String s1 = root() + " ";
         final String s2 = right().inOrderV2();  // recursion
         final String s3 =  left().inOrderV2();  // recursion
         return s3 + s1 + s2;
      }
   }

   public default String postOrderV2()
   {
      if ( isEmpty() )
      {
         return "";
      }
      else if ( isLeaf() )
      {
         return root() + " ";
      }
      else // a non-empty internal node
      {
         final String s1 = root() + " ";
         final String s2 = right().postOrderV2();  // recursion
         final String s3 =  left().postOrderV2();  // recursion
         return s3 + s2 + s1;
      }
   }


   // Here is a third way of writing the three traversal methods.
   // This way explicitly uses side effects as it traverses the tree
   // (in this case, the side effect is to print something to stdout).
   // This means that this implementation really must traverse the left
   // branch before traversing the right branch. If your reverse the
   // order of those traversals, then you completely change the order
   // of what is being printed.
   public default void preOrderV3()
   {
      if ( isEmpty() )
      {
         System.out.print("");
      }
      else if ( isLeaf() )
      {
         System.out.print( root() + " " );
      }
      else // a non-empty internal node
      {
         System.out.print( root() + " " );
         left().preOrderV3();  // recursion
         right().preOrderV3(); // recursion
      }
   }

   public default void inOrderV3()
   {
      if ( isEmpty() )
      {
         System.out.print("");
      }
      else if ( isLeaf() )
      {
         System.out.print( root() + " " );
      }
      else // a non-empty internal node
      {
         left().inOrderV3();  // recursion
         System.out.print( root() + " " );
         right().inOrderV3(); // recursion
      }
   }

   public default void postOrderV3()
   {
      if ( isEmpty() )
      {
         System.out.print("");
      }
      else if ( isLeaf() )
      {
         System.out.print( root() + " " );
      }
      else // a non-empty internal node
      {
         left().postOrderV3();  // recursion
         right().postOrderV3(); // recursion
         System.out.print( root() + " " );
      }
   }

}
