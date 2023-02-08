 /*
      Course: CS 31600
      Name: Christian Laviolette
      Email: claviole@pnw.edu
      Assignment: 1
   */
import binarytree.*;

/**
   A program that tests the integer2Boolean() method.
*/
public class Integer2Boolean
{
   /**
      A method that converts a binary tree of integer values
      into a bnary tree of booleans, true for even integers
      and false for odd integers.
   */
   public static BTreeLinked<Boolean> integer2Boolean(BTree<Integer> btree)
   {
      if(btree.isEmpty())
      {
         return null;
      }
      else
      {
         Boolean value;
         if( btree.root()%2==0)
         {
          value = true;

         }
         else
         {
          value = false;
            
         }
         BTreeLinked<Boolean> left = integer2Boolean(btree.left());
         BTreeLinked<Boolean> right = integer2Boolean(btree.right());
         BTreeLinked<Boolean> answer = new BTreeLinked<>(value, left != null ? left : new BTreeLinked<>(), right != null ? right : new BTreeLinked<>());

         return answer;

      }
        


   }


   // A simple test case for integer2Boolean().
   public static void main(String[] args)
   {
      BTree<Integer> btree1 =
           new LinkedBTree<>(1,
               new LinkedBTree<>(12),
               new LinkedBTree<>(123));

      BTree<Boolean> btree2 = integer2Boolean( btree1 );

      System.out.println( btree1 );
      BTree2dot.btree2dot(btree1, "btree1");
      BTree2png.btree2png("btree1");

      System.out.println( btree2 );
      BTree2dot.btree2dot(btree2, "btree2");
      BTree2png.btree2png("btree2");
   }
}
