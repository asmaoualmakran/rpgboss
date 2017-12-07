package BinarySearchTree


import rpgboss.editor.BST.BinarySearchTree
import rpgboss.editor.UnitSpec

class BinarySearchTreeSpec extends UnitSpec{



  /*
    BinarySearchTree tests
    Author: Asma Oualmakran
   */
  /*"A BinarySearchTree" should "add nodes with values" in{
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
  }*/
  "A BinarySearchTree" should "return null" in{
    val emptyTree = new BinarySearchTree[Int](50)
    emptyTree.getRoot()
  }
  it should "add a node to the BinarySearchTree with a given value" in{
    val testTree = new BinarySearchTree[Int](50)
    testTree.addValue(2)
    testTree.addValue(30)
    testTree.addValue(50)
    testTree.addValue(1000359)




  //  testTree.addValue(3)
   // println("current tree 2",testTree)
   // testTree.addValue(5)
   // println("current tree 3",testTree)
  }


}
