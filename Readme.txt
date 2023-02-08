
The folder binarytree is a Java package containing four
implementations of the binary tree data type.

   BTree<T> ::= T BTree<T> BTree<T>
              | EmptyTree

Every file in the package has full Javadoc comments. The
   build_all_Javadocs.cmd
shell script builds all the Javadoc HTML files.

The
   build_all_classes.cmd
shell script will compile all the java files in the package.
Then the
   build_jar_file.cmd
shell script will bundle the compiled class files into a jar
file that can be distributed.

The file BTree.java is a Java interface that declares what
a BTree implementation must be able to do. This interface
file also implements several methods ("default" methods)
that are then common to all BTree implementations.

The file BTreeA.java is an abstract class that implements
BTree. The only thing BTreeA does is implement the toString()
method for all binary trees. We cannot do this in BTree. An
interface can have concrete methods (the default methods),
but an interface cannot override a concrete method (like
toString() from the Object class).

The files BTreeLinked.java and LinkedBTree.java show two
ways to implements the BTree interface as a linked data
structure.

The files BTreeAbstract.java, EmptyBTree.java, and BTreeNode.java
implement the BTree interface using an abstract base class and two
concrete sub classes.

The file FullBTree.java implements the BTree interface as a full
binary tree, which is a slightly different algebraic data type
from the other three implementations of the BTree interface. A
FullBTree can never by empty.

   FullBTree<T> ::= T FullBTree<T> FullBTree<T>
                  | T


Here is a diagram of the class hierarchy in this package.
(Notice how a "class hierarchy" is itself a tree.)

                       BTree (interface)
                         |
                         |
                       BTreeA (abstract class)
                      / | | \
                     /  | |  \--- FullBTree
        AbstractBTree   | \
           /    \       \  \--- LinkedBTree
          /      \       \
         /        \       \--- BTreeLinked
        /          \
  EmptyTree     BTreeNode


Compare this package to how Java defines the various List data types.
https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/List.html
https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/AbstractList.html
https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/ArrayList.html
https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/LinkedList.html

          Object
             |        List (interface)
             |       /
             |      /
         AbstractList
           /     \
          /       \
  ArrayList       LinkedList