package rpgboss.editor.BST
import scala.collection.mutable.ListBuffer
import scala.swing.Container
/*
class BinarySearchTreeIterator[T](BST: BinarySearchTree [T]) extends TtreeIterator[T]{

  val size = this.BST.numberOfNodes
  val root = this.BST.getRoot()
  var stack = List(root)

  /*    override def hasNext_? (node:Node[_]): Boolean ={
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

    override def getLeafs(): Node[_] ={
      if(BST == null){
        sys.error("Can not iterate on an empty tree")
      }else{
        val root = BST.getRoot()
        if(root.isLeaf_?()) {
 //         leafsList += root
            return root
        }else{
          def loop(node: Node[_]): Unit ={

          }
        }
      }

    }

    /*
    override def getNode(BST: BinarySearchTree[_]): Node[_]={

    }

    */
    */
  /* Checken of de boom leeg is of niet (alle nodes overlopen)
  override def hasNext_? () : Boolean ={

  }
  */
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

  object LeafIterator{

  }

  //Going to loop over the tree, and retuns only one child at a time
  override def next(): Node[T]={
    if ()
    if (root.isLeaf_?()){
      return root               // the stack stays empty
    }else{
      def loop(): Node[T]={

      }
    }
  }
}
*/