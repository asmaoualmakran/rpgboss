package rpgboss.editor.BST



trait TtreeIterator[List[Node[T]]] extends BinarySearchTree[_] with Tnode[_]{

  def hasNext_?(node: Node[_]): Boolean = ???
  def getNext(node: Node[_]): Node[_] = ???
  def getLeafs() = ???
  /*
  def getNode(BST: BinarySearchTree[_]): Node[_] = ???
  */
}

