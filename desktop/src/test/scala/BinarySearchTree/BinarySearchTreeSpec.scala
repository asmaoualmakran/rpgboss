package BinarySearchTree


import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
import rpgboss.editor.BST.BinarySearchTree

/*
    BinarySearchTree tests
    Author: Asma Oualmakran
   */

class BinarySearchTreeSpec extends FlatSpec with Matchers with TableDrivenPropertyChecks with BeforeAndAfter{


  "A BinarySearchTree" should "return null" in{
    val emptyTree = new BinarySearchTree[Int](5)
    emptyTree.getRoot()
  }
  it should "add a node to the BinarySearchTree with a given value" in{
    val testTree = new BinarySearchTree[Int](5)
    val nodeValues =
      Table(
        ("node values"),
        ("2"),
        ("30"),
        ("50"),
        ("100")
      )
    forAll(nodeValues){(node: String) =>
      val nodeVal = node.toInt
      testTree.addValue(nodeVal)
    }
  }

  it should " should return true when the root node is empty" in{
    val emptyTree = new BinarySearchTree[Int](5)
    emptyTree.isNull_?
  }

  it should "return the root value" in{
    val tree = new BinarySearchTree[Int](5)
    val nodeValues =
      Table(
        ("node values"),
        ("53"),
        ("555"),
        ("306"),
        ("100"),
        ("50")
      )
    forAll(nodeValues){(node: String) =>
      val nodeVal = node.toInt
      tree.addValue(nodeVal)
    }
    tree.getRoot()
  }


}
