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

  /*
    Function: getValue
    Parameters: n/a
    Return: T
    Use: Get the value of the node.
   */

  override def getValue(): T={
    return this.value
  }

  /*
    Function: getParent
    Parameters: n/a
    Return: Node[T]
    Use: Get the parent of the node, if it exists.
   */

 override def getParent(): Node[T]={
   if(hasParent_?()){
     return this.parent
   }
   sys.error("Node has no parent: getPanent()| Node")

 }

  /*
    Function: getLeftChild
    Parameters: n/a
    Return: Node[T]
    Use: Get the left child of the node, if it exists.
   */

  override def getLeftChild(): Node[T]={
    if(this.leftChild != null){
      return this.leftChild
    }
    sys.error("Node has no left child: getLeftChild()| Node")
  }

  /*
    Function: getRightChild
    Parameters: n/a
    Return: Node[T]
    Use: Get the right child of the node, if it exits.
   */

  override def getRightChild(): Node[T]={
    if(this.rightChild != null){
      return this.rightChild
    }
    sys.error("Node has no right child: getRightChild()| Node")
  }

  /*
    Function: hasParent_?
    Parameter: n/a
    Return: Boolean
    Use: Returns true when the node has a parent node.
   */

  def hasParent_?(): Boolean={
    if(parent != null){
      return true
    }
    false
  }

  /*
    Function: hasLeftChild_?
    Parameter: n/a
    Return: Boolean
    Use: Returns true when the node has a left child.
   */

  def hasLeftChild_?(): Boolean={
    if(this.leftChild == null){
      return false
    }
    true
  }

  /*
    Function: hasRightChild_?
    Parameter: n/a
    Return: Boolean
    Use: Returns true when the node has a right child.
   */

  def hasRightChild_?(): Boolean={
    if(this.rightChild == null){
      return false
    }
    true
  }

  /*
    Function: isLeaf_?
    Parameter: n/a
    Return: Boolean
    Use: Returns true when the node has no children.
   */

  def isLeaf_?(): Boolean={
    !hasLeftChild_?() && !hasRightChild_?()
  }


  /*
    Function: setChild
    Parameter:
      childNode: type; Node[T]
        Use: The node that has to be set as child of the node
    Return: Unit
    Use: Set a node as a child node of this node. When the left child position is taken
         the node will be set as a right child.
   */

  override def setChild(childNode:Node[T]): Unit ={

    if(!hasLeftChild_?()) {  // we check if one of the children is null, if so there is a location free
      this.leftChild = childNode

    }else if(!hasRightChild_?()){
      this.rightChild = childNode

    }else{
      sys.error("This node already has a left and a right child") //if none of the locations are free
    }
    this.hasNext = true
  }

  /*
    Function: setParent
    Parameter:
      parentNode: type; Node[T]
        Use: The node that must be set as parent of this node.
    Return: Unit
    Use: Set a node as a parent node of this node. When this location is already taken an error will be thrown.
   */

  override def setParent(parentNode: Node[T]): Unit ={
    if(!hasParent_?()) {
      this.parent = parentNode

    }else{
      sys.error("This node already has a parent: setParent")
    }
    this.hasParent = true
  }

}
