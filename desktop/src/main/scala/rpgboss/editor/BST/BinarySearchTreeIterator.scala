package rpgboss.editor.BST
import scala.collection.mutable.Stack

class BinarySearchTreeIterator[T](BST: BinarySearchTree [T]) extends TtreeIterator[T]{

  val size = this.BST.numberOfNodes
  val root = this.BST.getRoot()
  var stack = new Stack [Node[T]]()

  def initStack(): Unit ={
    if(!BST.isNull_?()){
      if(stack.isEmpty) {       // can only initialize the stack when it is empty and the tree had a root => not in use
        stack.push(root)
      }else{
        sys.error("Can not initialize stack, it contains element")
      }
    }else{
      sys.error("Can not initialize stack, root = null.")
    }
  }


 override def endOfTree_?(): Boolean ={
    if(stack.isEmpty){
      return true
    }
    else false
  }

  override def getNextLeft(node: Node[T]): Node[T]={
      if(node.isLeaf_?()){
        return null
      }else if (node.hasLeftChild_?()){
        return node.leftChild
      }else{
        return null
      }
  }

  override def getNextRight(node: Node[T]): Node[T]={
      if(node.isLeaf_?()){
        return null
      }else if (node.hasRightChild_?()){
        return node.rightChild
      }else{
        return null
      }
  }



  //Going to loop over the tree, and retuns only one child at a time (breath first)
  override def next(): Node[T]={
    if(stack.isEmpty){
      return sys.error("EOF tree is reached, reinitialize the stack")
    }else if(stack.head.isLeaf_?()){
      val top = stack.head
      stack.pop()
      return top
    }else{
      val top = stack.head
      stack.pop()
      stack.push(getNextRight(top), getNextLeft(top))
      return top
    }
  }

  override def nextLeaf(): Node[T] ={

    var node = next()
    while (!node.isLeaf_?()){
      node = next()
    }
    return node
  }


}
