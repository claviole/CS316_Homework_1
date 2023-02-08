 /*
      Course: CS 31600
      Name: Christian Laviolette
      Email: claviole@pnw.edu
      Assignment: 1
   */
import binarytree.*;

/**
   A program that tests the concatenateLeaves() method.
*/
public class ConcatenateLeaves
{
   /**
      Return a string that is the concatenation of the leaves,
      from the input binary tree, going from left to right.
      <p>
      How does this compare with an in-order, or pre-order,
      or post-order traversal of the binary tree?
   */
   public static <T> String concatenateLeaves(BTree<T> btree)
   {
      String result = "";
      
      if(btree.isLeaf())
      {
         result =result + " " + btree.root();
      }

      else
      {
         result=result + concatenateLeaves(btree.left());
         result= result+concatenateLeaves(btree.right());

      }


      
      return result;
   }


   // A simple test case for concatenateLeaves().
   public static void main(String[] args)
   {
      BTree<String> btree =
           new BTreeLinked<>("#",
               new BTreeLinked<>("#",
                   new BTreeLinked<>("mary"),
                   new BTreeLinked<>("had")),
               new BTreeLinked<>("#",
                   new BTreeLinked<>("a"),
                   new BTreeLinked<>("#",
                       new BTreeLinked<>("little"),
                       new BTreeLinked<>("lamb"))));

      String result = concatenateLeaves( btree );

      System.out.println( btree );
      System.out.println( result );
      BTree2dot.btree2dot(btree, "btree");
      BTree2png.btree2png("btree");

      System.out.println( btree.preOrder() );
      System.out.println( btree.inOrder() );
      System.out.println( btree.postOrder() );
   }
}
