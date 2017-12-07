package rpgboss.editor.BST

/*
  Author: Asma Oualmakran
  Class: Node
  Parameters: size: value:T
    use: The value the Node must carry
  Use: Create a Node with a specified value
 */


class Node[T](value: T) extends Tnode[T] {


  var hasNext: Boolean = false
  var hasParent: Boolean = false
  var leftChild: Node[T] = null
  var rightChild: Node[T] = null
  var parent: Node[T] = null

  override def getValue(): T={
    return this.value
  }

 override def getParent(): Node[T]={
   if(hasParent_?()){
     return this.parent
   }
   sys.error("Node has no parent: getPanent()| Node")

 }

  override def getLeftChild(): Node[T]={
    if(hasLeftChild_?()){
      return this.leftChild
    }
    sys.error("Node has no left child: getLeftChild()| Node")
  }

  override def getRightChild(): Node[T]={
    if(hasRightChild_?()){
      return this.rightChild
    }
    sys.error("Node has no right child: getRightChild()| Node")
  }

  def hasParent_?(): Boolean={
    if(parent != null){
      return true
    }
    false
  }

  def hasLeftChild_?(): Boolean={
    if(getLeftChild() == null){
      return true
    }
    false
  }

  def hasRightChild_?(): Boolean={
    if(getRightChild() == null){
      return true
    }
    false
  }

  /*
  Determine if a node is a leaf
 */

  private def isLeaf_?(node: Node[T]): Boolean={
    if(getLeftChild() == null && getRightChild() == null){
      return true
    }
    false
  }


  /*
    Set a node as a child node of the node
   */
  override def setChild(childNode:Node[T]): Unit ={

    if(!hasLeftChild_?()) {  // we check if one of the children is null, if so there is a location free
      this.leftChild = childNode

    }else if(!hasRightChild_?()){
      this.rightChild = childNode

    }else{
      sys.error("This node already has a left and a right child") //if none of the locations are free
      // we throw an error
    }
  }

  /*
    Set the parent of the node to a specific node
   */

  override def setParent(parentNode: Node[T]): Unit ={
    if(!hasParent_?()) {
      this.parent = parentNode

    }else{
      sys.error("This node already has a parent: setParent")
    }
  }

}
