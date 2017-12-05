package rpgboss.editor

import org.scalatest._
import rpgboss.editor.BST.BinarySearchTree

// Base class for writing unit tests
abstract class UnitSpec extends FlatSpec with Matchers{

  "A BinarySearchTree" should "add nodes with values" in{
    val newTree = new BinarySearchTree[Int](50)
    newTree.addValue(2)
    newTree.addValue(5)
    newTree.addValue(60)
    newTree.addValue(25)
  }

  "A BinarySearchTree" should "return null" in {
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
}