package rpgboss.editor.BST

trait Tnode[T] {

  def getValue(): T = ???
  def getLeftChild(): Node[T] = ???
  def getRightChild(): Node[T] = ???
  def getParent(): Node[T] = ???
  def setChild(node:Node[T],childNode: Node[T]): Unit = ???
  def setParent(node:Node[T],parentNode: Node[T]): Unit = ???


  /* The ??? makes sure that if an procedure is not overwritten, that it trows an
     not supported exception
   - Every node contains the type T, each node has type Node[T] due to the
     type parameter that the class node has.
  */
}
