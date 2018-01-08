package BinarySearchTree

import rpgboss.editor.BST.Node
import rpgboss.editor.UnitSpec

class NodeSpec extends UnitSpec{

  /*
    Node tests
    Author: Asma Oualmakran
   */

  "A Node" should "return it's value" in{
    val node = new Node[Int](5)
    node.getValue()
  }
  it should "return it's parent node" in{
    val node = new Node[Int](55)
    val parentNode = new Node[Int](60)
    node.setParent(parentNode)
  }
  it should "return it's left child" in{
    val node = new Node[Int](5)
    val leftChild = new Node[Int](50)
    node.setChild(leftChild)
    node.getLeftChild()
  }
  it should "return it's right child" in{
    val node = new Node[Int](5)
    val leftChild = new Node[Int](30)
    val rightChild = new Node(50)
    node.setChild(leftChild)
    node.setChild(rightChild)
    node.getRightChild()
  }

}
