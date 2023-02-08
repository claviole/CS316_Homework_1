 /*
      Course: CS 31600
      Name: Christian Laviolette
      Email: claviole@pnw.edu
      Assignment: 1
   */
import binarytree.*;
/**
   A program that tests the ascii2int() method.
*/
public class Ascii2Integer
{
   /**
      A method that converts a binary tree of integer strings
      into a bnary tree of integers. This method assumes that
      all of the strings in the input tree contain properly
      formatted integers.
   */
   public static LinkedBTree<Integer> ascii2int(BTree<String> btree)
   {
      if (!btree.isEmpty()) {
         Integer root = Integer.parseInt(btree.root());
         LinkedBTree<Integer> left = ascii2int(btree.left());
         LinkedBTree<Integer> right = ascii2int(btree.right());
         LinkedBTree<Integer> answer = new LinkedBTree<>(root, left != null ? left : new LinkedBTree<>(), right != null ? right : new LinkedBTree<>());
         return answer;
      } else {
         return null;
      }


   }


   // A simple test case for ascii2int().
   public static void main(String[] args)
   {
      BTree<String> btree1 =
           new LinkedBTree<>("1",
               new LinkedBTree<>("12"),
               new LinkedBTree<>("123"));

      BTree<Integer> btree2 = ascii2int( btree1 );

      System.out.println( btree1 );
      BTree2dot.btree2dot(btree1, "btree1");
      BTree2png.btree2png("btree1");

      System.out.println( btree2 );
      BTree2dot.btree2dot(btree2, "btree2");
      BTree2png.btree2png("btree2");
   }
}
