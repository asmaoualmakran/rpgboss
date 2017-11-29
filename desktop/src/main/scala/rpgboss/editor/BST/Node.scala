package rpgboss.editor.BST

class Node[T](value: T) extends Tnode[T] {


  var hasNext = false
  var hasParent = false
  var child: Node[T] = null
  var parent: Node[T] = null

  override def getValue(): T={
    return this.value
  }

 override def getParent(): Node[T]={
   return parent
 }

  override def getChild(): Node[T]={
    return this.child
  }


}
