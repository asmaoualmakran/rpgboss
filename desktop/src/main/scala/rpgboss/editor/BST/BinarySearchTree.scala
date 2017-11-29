package rpgboss.editor.BST

import scala.collection.mutable.TreeSet

/*
  Every node of the bst has type T
  Were using generic typing
 */

class BinarySearchTree[T]() extends Tnode[T]{

  var tree = new TreeSet[Node[T]]()     // the tree contains nodes of type Node[T]
  /*
    TODO: schrijf een implicit ordering
   */

  def getRoot(): Node[T]={
    /*
    check of de boom null is?
    is het leeg geef dan null terug
    ander geef je de root terug
     */
  }

  override def setChild(node:Node[T], childNode:Node[T]): Unit ={
    node.child = childNode
  }

  override def setParent(node: Node[T], parentNode: Node[T]): Unit ={
    node.parent = parentNode
  }

  def addNode(nodeValue: T): Unit ={
    val newNode = new Node[T](nodeValue)
    /*
    TODO:
    check of de boom leeg is, is die leeg, dan zet je deze node
    als root en heeft die zowel geen parent als geen child
    Get de laatste node in de boom, zet de in de huidige laatste node
    de nieuwe laatste node als child, en zet de huidige laatste dan als parent
    van de nieuwe node. laat de child naar null wijzen ==> verander daar niets aan

     */
  }



}
