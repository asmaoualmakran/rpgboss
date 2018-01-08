package rpgboss.editor.BST
import scala.collection.mutable.Stack


trait TtreeIterator[T] {
  def endOfTree_? () : Boolean = ???
  def getNextLeft (node: Node[T]): Node[T] = ???
  def getNextRight (node: Node[T]): Node[T] = ???
  def next() : Node[T] = ???
  def nextLeaf(): Node[T] = ???
  /*
  def getNode(BST: BinarySearchTree[_]): Node[_] = ???
  */
}

