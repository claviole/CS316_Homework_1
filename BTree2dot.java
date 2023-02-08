/*

*/

package binarytree;

/**
   This program converts a BTree data structure
   into a DOT language description of the tree.
   The DOT description is written to a file with
   the .dot extension. The dot file can then be
   processed by the dot.exe program to produce a
   graphical image of the tree data structure.
<p>
   See
      http://www.graphviz.org/doc/info/lang.html
   and
      http://www.graphviz.org/documentation/
*/

public class BTree2dot
{
   private static int nodeCount;

   /**
      Use the String baseName as the base for the .dot
      file that this program produces from the BTree
      data structure.

      @param <T>       The element type for the {@link BTree}
      @param btree     {@link BTree} to convert into a dot file
      @param baseName  the base name for the created dot file
   */
   public static <T> void btree2dot(BTree<T> btree, String baseName)
   {
      // Create a dot file from a BTree.
      try
      {
         // Create an empty dot file.
         java.io.PrintWriter out = new java.io.PrintWriter(
                                      new java.io.File(baseName + ".dot"));
         // Put dot commands into the dot file.
         out.println( btree2dot(btree) + "\n" );
         out.close();
      }
      catch (Exception e)
      {
         System.out.println( e );
      }
   }


   /**
      Return a String representation of the
      dot commands that describe the given BTree.

      @param <T>    The element type for the {@link BTree}
      @param btree  {@link BTree} to convert into a {@link String} of dot commands
      @return a {@link String} of dot commands representing {@code btree}
   */
   public static <T> String btree2dot(BTree<T> btree)
   {
      String result = "graph {\n";
      nodeCount = 0;
      // Traverse the BTree and convert it to appropriate dot commands.
      result += btree2dot(btree, nodeCount);
      result += "}\n";
      return result;
   }


   /**
      This method is essentially a pre-order traversal
      of the binary tree.

      @param <T>    The element type for the {@link BTree}
      @param btree  {@link BTree} to convert into a {@link String} of dot commands
      @param nodeNumber  a number that represents the current node of the binary tree
      @return a {@link String} of dot commands representing {@code btree}
   */
   public static <T> String btree2dot(BTree<T> btree, int nodeNumber)
   {
      String result = "";

      if ( 0 == btree.degree() ) // this stops the recursion
      {
         result += "node" + nodeNumber + "[label=\"" + btree.root() + "\"];\n";
      }
      else
      {
         // Process the root node.
         result += "node" + nodeNumber + "[label=\"" + btree.root() + "\"];\n";

         // Recursively traverse the left sub tree.
         if ( ! btree.left().isEmpty() )
         {
            // Create an edge to the left sub tree.
            result += "node" + nodeNumber + " -- " + "node" + (++nodeCount) + ";\n";
            // Convert the left sub tree into a dot description.
            result += btree2dot(btree.left(),  nodeCount);
         }
         else // There is no left branch.
         {
            // Create an invisible edge.
            result += "node" + nodeNumber + " -- " + "node" + (++nodeCount);
            result += " [style=\"invisible\"];\n";
            // Create an invisible node.
            result += "node" + nodeCount + " [style=\"invisible\"];\n";
         }

         // Recursively traverse the right sub tree.
         if ( ! btree.right().isEmpty() )
         {
            // Create an edge to the right sub tree.
            result += "node" + nodeNumber + " -- " + "node" + (++nodeCount) + ";\n";
            // Convert the right sub tree into a dot description.
            result += btree2dot(btree.right(), nodeCount);
         }
         else // There is no right branch.
         {
            // Create an invisible edge.
            result += "node" + nodeNumber + " -- " + "node" + (++nodeCount);
            result += " [style=\"invisible\"];\n";
            // Create an invisible node.
            result += "node" + nodeCount + " [style=\"invisible\"];\n";
         }
      }
      return result;
   }

}//BTree2dot
