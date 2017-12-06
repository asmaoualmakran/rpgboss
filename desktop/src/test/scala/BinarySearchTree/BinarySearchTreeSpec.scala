package BinarySearchTree


import rpgboss.editor.BST.{BinarySearchTree, Node}
import rpgboss.editor.UnitSpec

class BinarySearchTreeSpec extends UnitSpec{


  /*
    BinarySearchTree tests
    Author: Asma Oualmakran
   */
  "A BinarySearchTree" should "add nodes with values" in{
    val newTree = new BinarySearchTree[Int](50)
    newTree.addValue(2)
    newTree.addValue(5)
    newTree.addValue(60)
    newTree.addValue(25)
  }
  it should "return null" in {
    val emptyTree = new BinarySearchTree[Int](50)
    emptyTree.getRoot()
  }
  it should "return the root value" in{
    val tree = new BinarySearchTree[Int](50)
    tree.addValue(53)
    tree.addValue(555)
    tree.addValue(306)
    tree.getRoot()
  }


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
    node.parent = parentNode
    parentNode.leftChild = node
    node.getParent()
  }
  it should "return it's left child" in{
    val node = new Node[Int](5)
    val leftChild = new Node(50)
    leftChild.parent = leftChild
    node.getLeftChild()
  }
  it should "return it's right child" in{
    val node = new Node[Int](5)
    val rightChild = new Node(50)
    rightChild.parent = rightChild
    node.getRightChild()
  }

}
