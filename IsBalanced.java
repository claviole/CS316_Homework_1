 /*
      Course: CS 31600
      Name: Christian Laviolette
      Email: claviole@pnw.edu
      Assignment: 1
   */
import binarytree.*;

/**
   A program that tests the isBalanced() method.
*/
public class IsBalanced
{
   /**
      This method defines a balanced binary tree as one whose
      left branch has the same size as the right branch.
   */
   public static <T> boolean isBalanced(BTree<T> btree)
   {
      if(btree.isEmpty())
      {
         return false;

      }
      else
      {
         Boolean answer = btree.left().height() == btree.right().height();
          return answer;
         
      }




   }


   // A simple test case for isBalanced().
   public static void main(String[] args)
   {
      BTree<Integer> btree =
           new LinkedBTree<>(1,
               new LinkedBTree<>(12),
               new LinkedBTree<>(123));

      System.out.println( btree );
      System.out.println("isBalanced : " + isBalanced(btree) );
      BTree2dot.btree2dot(btree, "btree");
      BTree2png.btree2png("btree");
   }
}
