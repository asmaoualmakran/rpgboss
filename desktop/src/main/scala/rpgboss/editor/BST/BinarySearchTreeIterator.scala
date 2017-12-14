package rpgboss.editor.BST

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer


class BSTreeIterator (BST: BinarySearchTree[_]) extends TtreeIterator[BinarySearchTree[_]] with Tnode[_]{

  var leafsList = new ListBuffer[Node[_]]()

  override def hasNext_?(node: Node[_]): Boolean ={
    return node.hasNext

  }

  override def getNext(node: Node[_]): Node[_] = {
    if(hasNext_?(node)) {
      if (node.hasLeftChild_?()) {
        return node.leftChild
      } else {
        return node.rightChild
      }
    }
    return null
  }

  /*
  It updateds the leafsList
   */

  override def getLeafs(): Unit ={
    if(BST == null){
      sys.error("Can not iterate on an empty tree")
    }else{
      val root = BST.getRoot()
      if(root.isLeaf_?()) {
        leafsList += root
      }else{
        
      }
    }

  }

  /*
  override def getNode(BST: BinarySearchTree[_]): Node[_]={

  }

  */
}