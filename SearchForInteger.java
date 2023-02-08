 /*
      Course: CS 31600
      Name: Christian Laviolette
      Email: claviole@pnw.edu
      Assignment: 1
   */
import binarytree.*;

import java.util.List;
import java.util.ArrayList;

/**
   A program that tests the searchForInteger() method.
*/
public class SearchForInteger
{
   /**
      Search a binary tree of integers for a target integer
      and return a list of all the addresses in the tree
      where the target integer is located.
      <p>
      An "address" is a string made up of the characters 'r',
      'L' and 'R'. The root of a tree has address "r". If a
      node in the tree has address adr, then that node's left
      child has address adr+"L" and that node's right child
      has address adr+"R" (notice how that is a recursive
      definition of an address).
   */
   private static List<String> searchForInteger(BTree<Integer> btree,
                                                int target)
   {
      return searchForInteger(target, btree, "r");
   }


   /**
      Search a binary tree of integers for a target integer
      and return a list of all the addresses in the tree
      where the target integer is located.
   */
   private static List<String> searchForInteger(int target,
                                                BTree<Integer> btree,
                                                String rootAddress)
   {

    List<String> result= new ArrayList<>();
    if(btree.isEmpty())
    {
        return result;
    }
    if(btree.root()== target);
    {
        result.add(rootAddress);
    }
    
      
         List<String> leftResult = searchForInteger(target,btree.left(),rootAddress +"L");
         List<String>rightResult = searchForInteger(target,btree.right(),rootAddress+"R");

         result.addAll( leftResult );
         result.addAll( rightResult );
         return result;






   }


   // Test the searchForInteger() method.
   public static void main(String[] args)
   {
      BTree<Integer> btree =
           new BTreeLinked<>(2,
               new BTreeLinked<>(0,
                   new BTreeLinked<>(0,
                       new BTreeLinked<>(0,
                           new BTreeLinked<>(0),
                           new BTreeLinked<>(0)),
                       new BTreeLinked<>(1,
                           new BTreeLinked<>(0),
                           new BTreeLinked<>(0))),
                   new BTreeLinked<>(0,
                       new BTreeLinked<>(0),
                       new BTreeLinked<>(0))),
               new BTreeLinked<>(0,
                   new BTreeLinked<>(0),
                   new BTreeLinked<>(0,
                       new BTreeLinked<>(0,
                           new BTreeLinked<>(0,
                               new BTreeLinked<>(0,
                                   new BTreeLinked<>(0),
                                   new BTreeLinked<>(0)),
                               new BTreeLinked<>(1,
                                   new BTreeLinked<>(0),
                                   new BTreeLinked<>(0))),
                           new BTreeLinked<>(0,
                               new BTreeLinked<>(0,
                                   new BTreeLinked<>(2),
                                   new BTreeLinked<>(0)),
                               new BTreeLinked<>(0,
                                   new BTreeLinked<>(0),
                                   new BTreeLinked<>(1)))),
                       new BTreeLinked<>(0))));

      System.out.println( btree );
      BTree2dot.btree2dot(btree, "btree");
      BTree2png.btree2png("btree");
      List<String> addresses = searchForInteger(btree, 1);
      System.out.println( addresses );
      List<String> addresses2 = searchForInteger(btree, 2);
      System.out.println( addresses2 );
   }
}
