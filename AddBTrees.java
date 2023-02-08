 /*
      Course: CS 31600
      Name: Christian Laviolette
      Email: claviole@pnw.edu
      Assignment: 1
   */
import binarytree.*;

/**
   A program that tests the addStringBTrees() and addIntegerBTrees() methods.
*/
public class AddBTrees
{
   



   /**
      Return a binary tree that is the "sum" of the two
      input trees of type String.
      <p>
      The sum of two empty trees is the empty tree.
      <p>
      The sum of an empty tree and a tree of size 1 (a leaf tree)
      is the leaf tree.
      <p>
      The sum of two trees of size 1 (two leaf trees) is a tree
      of size 1 (a leaf tree) whose data element is the sum of
      the data elements from the two leaf trees.
      <p>
      The sum of two binary trees is defined recursively using the
      above three cases.
      <p>
      Notice that the result tree has a node at any position where
      at least one of the two input trees has a node. You might say
      that the result tree has the shape of the "union" of the two
      input trees (compare with the compareBTrees() method).
   */
   public static BTreeAbstract<String> addStringBTrees(BTree<String> btree1,
                                                       BTree<String> btree2)
   {
      if (btree1.isEmpty() && btree2.isEmpty()) {
         return new EmptyBTree<String>();
      }
      else
      {
         String sum = btree1.root() + "" + btree2.root() ;
         BTreeAbstract<String> left= addStringBTrees(btree1.left(), btree2.left());
         BTreeAbstract<String> right= addStringBTrees(btree1.right(), btree2.right());
         BTreeNode<String> sumofBTreesString = new BTreeNode<String>(sum,left,right);
         return sumofBTreesString;

      }
      

   }


   /**
      Return a binary tree that is the "sum" of the two
      input trees of type Integer.
      <p>
      This method is define similarly to addStringBTrees().
   */
   // Define addIntegerBTrees()...
   public static BTreeAbstract<Integer> addIntegerBTrees(BTree<Integer> btree1,
                                                       BTree<Integer> btree2)
 {
   if (btree1.isEmpty() && btree2.isEmpty()) {
      return new EmptyBTree<Integer>();
   }
   else
   {
      Integer sum = btree1.root() + btree2.root() ;
      BTreeAbstract<Integer> left= addIntegerBTrees(btree1.left(), btree2.left());
      BTreeAbstract<Integer> right= addIntegerBTrees(btree1.right(), btree2.right());
      BTreeNode<Integer> sumofBTreesString = new BTreeNode<Integer>(sum,left,right);
      return sumofBTreesString;

   }
   
   
   }

      
      

                                                       
                                                   



   // Simple test cases for addStringBTrees() and addIntegerBTrees().
   public static void main(String[] args)
   {
      BTree<Integer> btree1 =
           new LinkedBTree<>(1,
               new LinkedBTree<>(12),
               new LinkedBTree<>(123));

      BTree<Integer> btree2 =
           new LinkedBTree<>(4,
               new LinkedBTree<>(45),
               new LinkedBTree<>(456));

      BTree<Integer> btree3 = addIntegerBTrees(btree1, btree2);

      System.out.println( btree1 );
      System.out.println( btree2 );
      System.out.println( btree3 );
      BTree2dot.btree2dot(btree1, "btree1");
      BTree2png.btree2png("btree1");
      BTree2dot.btree2dot(btree2, "btree2");
      BTree2png.btree2png("btree2");
      BTree2dot.btree2dot(btree3, "btree3");
      BTree2png.btree2png("btree3");


      BTree<String> btree4 =
           new LinkedBTree<>("a",
               new LinkedBTree<>("ab"),
               new LinkedBTree<>("abc"));

      BTree<String> btree5 =
           new LinkedBTree<>("x",
               new LinkedBTree<>("xy"),
               new LinkedBTree<>("xyz"));

      BTree<String> btree6 = addStringBTrees(btree4, btree5);

      System.out.println( btree4 );
      System.out.println( btree5 );
      System.out.println( btree6 );
      BTree2dot.btree2dot(btree4, "btree4");
      BTree2png.btree2png("btree4");
      BTree2dot.btree2dot(btree5, "btree5");
      BTree2png.btree2png("btree5");
      BTree2dot.btree2dot(btree6, "btree6");
      BTree2png.btree2png("btree6");
   }
}
