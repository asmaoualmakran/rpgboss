package rpgboss.editor.BST

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
