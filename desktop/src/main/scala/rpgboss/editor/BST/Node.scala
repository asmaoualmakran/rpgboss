package rpgboss.editor.BST

/*
  Author: Asma Oualmakran
  Class: Node
  Parameters: size: value:T
    use: The value the Node must carry
  Use: Create a Node with a specified value
 */


class Node[T](value: T) extends Tnode[T] {


  var hasNext = false
  var hasParent = false
  var leftChild: Node[T] = null
  var rightChild: Node[T] = null
  var parent: Node[T] = null

  override def getValue(): T={
    return this.value
  }

 override def getParent(): Node[T]={
   return parent
 }

  override def getLeftChild(): Node[T] = {
    return this.leftChild
  }

  override def getRightChild(): Node[T] = {
    return this.rightChild
  }


}
