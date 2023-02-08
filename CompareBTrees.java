 /*
      Course: CS 31600
      Name: Christian Laviolette
      Email: claviole@pnw.edu
      Assignment: 1
   */
import javax.lang.model.util.ElementScanner14;

import binarytree.*;

/**
   A program that tests the addStringBTrees() and addIntegerBTrees() methods.
*/
public class CompareBTrees
{
   /**
      Return a binary tree that is the comparison of the two input trees.
      <p>
      The comparison of two empty trees is the empty tree.
      <p>
      The comparison of an empty tree and a leaf tree is the empty tree.
      <p>
      The comparison of two leaf trees, btree1 and btree2, is a leaf tree
      of type Boolean holding the result
          btree1.root().equals(btree2.root())
      <p>
      The comparison of two binary trees is defined recursively using the
      above three cases.
      <p>
      Another way to describe the result tree is that a node of the result
      tree holds true if both input trees have that node and their contents
      are equal, and a node of the result tree holds false if both input
      trees have that node and their contents are not equal. So the result
      tree has nodes only at those positions where both input trees have
      a node. You might say that the result tree has the shape of the
      "intersection" of the two input trees (compare this with the
      addStringBTrees() method).
   */
   public static <T> BTreeAbstract<Boolean> compareBTrees(BTree<T> btree1,
                                                          BTree<T> btree2)
   {
    if(btree1.isEmpty() && btree2.isEmpty())
    {
        return new EmptyBTree<Boolean>();
    }
    else if(btree1.isEmpty() || btree2.isEmpty())
    {
        return new EmptyBTree<Boolean>();
    }
    else 
    {
        Boolean value =btree1.root().equals(btree2.root()) ;
         BTreeAbstract<Boolean> left= compareBTrees(btree1.left(), btree2.left());
         BTreeAbstract<Boolean> right= compareBTrees(btree1.right(), btree2.right());
         BTreeNode<Boolean> sumofBTreesString = new BTreeNode<Boolean>(value,left,right);
         return sumofBTreesString;

    }
   }



   // Simple test case for compareBTrees().
   public static void main(String[] args)
   {
      BTree<Integer> btree1 =
           new LinkedBTree<>(10,
               new LinkedBTree<>(20,
                   new LinkedBTree<>(40),
                   new LinkedBTree<>()), // empty tree
               new LinkedBTree<>(30,
                   new LinkedBTree<>(50),
                   new LinkedBTree<>(60)));

      BTree<Integer> btree2 =
           new LinkedBTree<>(10,
               new LinkedBTree<>(30,
                   new LinkedBTree<>(),  // empty tree
                   new LinkedBTree<>(40)),
               new LinkedBTree<>(20,
                   new LinkedBTree<>(50),
                   new LinkedBTree<>())); // empty tree

      BTree<Boolean> btree3 = compareBTrees(btree1, btree2);

      System.out.println( btree1 );
      System.out.println( btree2 );
      System.out.println( btree3 );
      BTree2dot.btree2dot(btree1, "btree1");
      BTree2png.btree2png("btree1");
      BTree2dot.btree2dot(btree2, "btree2");
      BTree2png.btree2png("btree2");
      BTree2dot.btree2dot(btree3, "btree3");
      BTree2png.btree2png("btree3");
      
   }
}
