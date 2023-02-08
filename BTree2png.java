/*

*/

package binarytree;

/**
   Create a png image file from a dot language file
   with the following command line.

      > dot.exe -Tpng -O tree.dot
<p>
   See
      http://www.graphviz.org/doc/info/command.html
<p>
   This program assumes that you have the Graphviz
   program installed in the C:\Graphviz directory
   on a Windows computer. If not, you can upload
   your dot file to the Graphviz Visual Editor.

      http://magjac.com/graphviz-visual-editor/
*/

import java.io.File;
import java.lang.Runtime;

public class BTree2png
{
   /**
      Use the String baseName as the base for both
      the .dot file and the .png file.

      @param baseName  the base name for the created png file
   */
   public static void btree2png(String baseName)
   {
      // Create a png file from a dot file.
      try
      {
         // Create a command line for running the dot.exe program.
         String[] cmd = {"C:\\Graphviz\\bin\\dot.exe",
                         "-Tpng",
                         baseName + ".dot",
                         "-o",
                         baseName + ".png"};

         // Check that Graphviz is installed.
         File dot = new File("C:\\Graphviz\\bin\\dot.exe");
         if(dot.exists() && !dot.isDirectory())
         {
            // Execute the command-line to create the png file.
            Runtime.getRuntime().exec(cmd);
         }
         else
         {
            System.out.println("\nPlease consider installing GraphViz:");
            System.out.println("  https://graphviz.org/download/");
            System.out.println("or upload the contents of " + baseName + ".dot to Graphviz Visual Editor:");
            System.out.println("  http://magjac.com/graphviz-visual-editor/");
            System.out.println();
         }
      }
      catch (Exception e)
      {
         System.out.println( e );
      }
   }
}
