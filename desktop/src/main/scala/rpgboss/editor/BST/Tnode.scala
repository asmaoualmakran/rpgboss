package rpgboss.editor.BST

trait Tnode[T] {

  def getValue(): T = ???
  def getLeftChild(): Any= ???
  def getRightChild(): Any= ???
  def getParent(): Node[T] = ???
  def setChild(childNode: Node[T]): Unit = ???
  def setParent(parentNode: Node[T]): Unit = ???
  def isLeaf_?() : Boolean = ???

  /* The ??? makes sure that if an procedure is not overwritten, that it trows an
     not supported exception
   - Every node contains the type T, each node has type Node[T] due to the
     type parameter that the class node has.
  */
}
