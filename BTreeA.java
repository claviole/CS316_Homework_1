/*

*/

package binarytree;

/**
   Define an abstract class to hold the
   {@code toString()} method for binary trees.
   This overrides the {@link java.lang.Object#toString}
   method in the {@link java.lang.Object} class. We need
   this abstract class because the interface {@link BTree}
   is not allowed to override a method.
*/
public abstract class BTreeA<T> implements BTree<T>
{
   /**
      Convert a binary tree into a String.

      @return a {@link String} representation of this binary tree
   */
   @Override
   public String toString()
   {
      String result = "";
      if ( isEmpty() )
      {
         result += "()";
      }
      else if ( isLeaf() )
      {
         result += root();
      }
      else
      {
         result += "(" + root();
         result += " " + left();  // recursion
         result += " " + right(); // recursion
         result += ")";
      }
      return result;
   }
}
