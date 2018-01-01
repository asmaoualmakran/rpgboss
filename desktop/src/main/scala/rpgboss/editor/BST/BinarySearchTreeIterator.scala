package rpgboss.editor.BST
import scala.collection.mutable
import scala.collection.mutable.Stack
import scala.util.Failure


/*
  Author: Asma Oualmakran
  Class: BinarySearchTreeIterator
  Parameters:
    T: type parameter
      Use: Determine the types in the tree.
    BST: BinarySearchTree[T}
      Use: The type of the elements contained by the tree.
  Use: Iterate over a binary search tree.
 */

class BinarySearchTreeIterator[T](BST: BinarySearchTree [T]) extends TtreeIterator[T] {


  private val root = this.BST.getRoot()
  // The stack is used to keep track of which nodes are already 'visited' by the iterator.
  //  private

  private val stack = new Stack[Node[T]]()

  /*
    Function: initStack
    Parameters: n/a
    Returns: Unit
    Use: Initialize the stack if it is empty and if the binary search tree is non-empty.
   */

  def initStack(): Unit = {
    if (!BST.isNull_?()) {
      if (!stack.isEmpty) {
        sys.error("Can not initialize stack, it contains element")
      } else {
        stack.push(root)
      }

    } else {
      sys.error("Can not initialize stack, root = null.")
    }
  }

  /*
    Function: endOfTree_?
    Parameters: n/a
    Returns: Boolean
    Use: Check whether all nodes are 'visited'.
   */

  override def endOfTree_?(): Boolean = {
    if (stack.isEmpty) {
      return true
    }
    else false
  }

  /*
    Function: getNextLeft
    Parameters:
      node: Node[T]
        Use: The node where the left child is needed form.
    Returns: Node[T]
    Use: Get the left child of a node if it exists.
   */

  override def getNextLeft(node: Node[T]): Node[T] = {
    if (node.isLeaf_?()) {
      return null
    } else if (node.hasLeftChild_?()) {
      return node.leftChild
    } else {
      return null
    }
  }

  /*
    Function: getNextRight
    Parameters:
      node: Node[T]
        Use: The node where the right child is needed form.
    Returns: Node[T]
    Use: Get the right child of a node if it exists.
   */

  override def getNextRight(node: Node[T]): Node[T] = {
    if (node.isLeaf_?()) {
      return null
    } else if (node.hasRightChild_?()) {
      return node.rightChild
    } else {
      return null
    }
  }


  /*
    Function: next
    Parameters: n/a
    Returns: Node[T]
    Use: Get the node following the last node that is visited.
   */

  override def next(): Node[T] = {
    if (endOfTree_?()) {
      sys.error("EOF tree is reached, reinitialize the stack")
    } else if (stack.top == null) {

      stack.pop()

    } else if (stack.top.isLeaf_?()) {
      val topelm = stack.top

      stack.pop()
      return topelm
    } else {
      val topelm = stack.top

      stack.pop()
      if (topelm.hasRightChild_?()) {
        stack.push(getNextRight(topelm))
      }
      if (topelm.hasLeftChild_?()) {
        stack.push(getNextLeft(topelm))
      }

      return topelm
    }
  }

  /*
    Function: nextLeaf
    Parameters: n/a
    Returns: Node[T]
    Use: Get the node following the last leaf node that is visited.
   */

  override def nextLeaf(): Node[T] = {
   var node = next()
    while (!node.isLeaf_?()){
      println(node.getValue())
      node = next()
    }
    println(node.getValue(), "leaf")
    return node
  }

}