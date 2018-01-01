package BinarySearchTree

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}
import rpgboss.editor.BST.BinarySearchTreeIterator
import rpgboss.editor.BST.BinarySearchTree

class BinarySearchTreeIteratorSpec extends FlatSpec  with Matchers with TableDrivenPropertyChecks {

  "A BinarySearchTreeIterator" should "Return system error" in {
    val BST = new BinarySearchTree[Int](5)
    val nodeValues =
      Table(
        ("node values"),
        ("2"),
        ("30"),
        ("50"),
        ("100")
      )
    forAll(nodeValues) { (node: String) =>
      val nodeVal = node.toInt
      BST.addValue(nodeVal)
    }

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)

    BSTIterator.initStack()

    val thrown = intercept[Exception] { //catch the exception that is thrown
      BSTIterator.initStack()
    }
    assert(thrown.getMessage === "Can not initialize stack, it contains element")
  }
  it should " EOF tree exception should be thrown" in {
    val BST = new BinarySearchTree[Int](5)
    val nodeValues =
      Table(
        ("node values"),
        ("2"),
        ("30"),
        ("50"),
        ("100"),
        ("200")
      )
    forAll(nodeValues) { (node: String) =>
      val nodeVal = node.toInt
      BST.addValue(nodeVal)
    }

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)

    val thrown = intercept[Exception] { //catch the exception that is thrown
      BSTIterator.next()
    }
    assert(thrown.getMessage === "EOF tree is reached, reinitialize the stack")


  }
  it should " Give the next element in the correct order" in {
    val BST = new BinarySearchTree[Int](5)
    val nodeValues =
      Table(
        ("node values"),
        ("2"),
        ("30"),
        ("50"),
        ("100"),
        ("70"),
        ("80"),
        ("15"),
        ("13")
      )
    forAll(nodeValues) { (node: String) =>
      val nodeVal = node.toInt
      BST.addValue(nodeVal)
    }

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)
    BSTIterator.initStack()

  }
  it should "return the next leaf" in {
    val BST = new BinarySearchTree[Int](5)
    val nodeValues =
      Table(
        ("node values"),
        ("2"),
        ("30"),
        ("50"),
        ("100"),
        ("70"),
        ("80"),
        ("15"),
        ("13")
      )
    forAll(nodeValues) { (node: String) =>
      val nodeVal = node.toInt
      BST.addValue(nodeVal)
    }

    val BSTIter = new BinarySearchTreeIterator[Int](BST)
    BSTIter.initStack()
    for(i <- 0 to 3){
      BSTIter.nextLeaf()
    }


  }
  it should "return the next element" in {
    val BST = new BinarySearchTree[Int](5)
    val nodeValues =
      Table(
        ("node values"),
        ("2"),
        ("30"),
        ("50"),
        ("100"),
        ("70"),
        ("80"),
        ("13")
      )
    forAll(nodeValues) { (node: String) =>
      val nodeVal = node.toInt
      BST.addValue(nodeVal)
    }

    val BSTIter = new BinarySearchTreeIterator[Int](BST)
    BSTIter.initStack()

    for(i <- 0 to 6){
      var node = BSTIter.next()
      println(i, node.getValue())

    }


  }

  it should "throw an error, that the tree is empty" in{
    val BST = new BinarySearchTree[Int](4)
    val BSTIter = new BinarySearchTreeIterator[Int](BST)
    val thrown = intercept[Exception]{
      BSTIter.initStack()
    }
    assert(thrown.getMessage === "Can not initialize stack, root = null.")
  }
  it should "throw an end of three error" in{
    val BST = new BinarySearchTree[Int](2)
    val nodeValues =
      Table(
        ("node values"),
        ("2"),
        ("30"),
        ("50")
      )
    forAll(nodeValues) { (node: String) =>
      val nodeVal = node.toInt
      BST.addValue(nodeVal)
    }

    val BSTIter = new BinarySearchTreeIterator[Int](BST)
    BSTIter.initStack()
    for(i <- 0 to 2){
      BSTIter.next()
    }
    val thrown = intercept[Exception]{
      BSTIter.next()
    }
    assert(thrown.getMessage === ("EOF tree is reached, reinitialize the stack"))
  }
}
