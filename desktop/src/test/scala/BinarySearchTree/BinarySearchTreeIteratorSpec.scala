package BinarySearchTree

import rpgboss.editor.UnitSpec
import rpgboss.editor.BST.BinarySearchTreeIterator
import rpgboss.editor.BST.BinarySearchTree

class BinarySearchTreeIteratorSpec extends UnitSpec{
  "A BinarySearchTreeIterator" should "Return system error" in{
    val BST = new BinarySearchTree[Int](5)
    BST.addValue(2)
    BST.addValue(30)
    BST.addValue(50)
    BST.addValue(1000359)
    BST.addValue(1000359)

 //   BST.printTree()

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)

    BSTIterator.initStack()

    val thrown = intercept[Exception] {           //catch the exception that is thrown
      BSTIterator.initStack()
    }
    assert(thrown.getMessage === "Can not initialize stack, it contains element")
  }
  it should " EOF tree exception should be thrown" in{
    val BST = new BinarySearchTree[Int](5)
    BST.addValue(2)
    BST.addValue(30)
    BST.addValue(50)
    BST.addValue(1000359)
    BST.addValue(1000359)

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)

    val thrown = intercept[Exception] {           //catch the exception that is thrown
      BSTIterator.next()
    }
    assert(thrown.getMessage === "EOF tree is reached, reinitialize the stack")

  //  print(BSTIterator.stack)
  //  print(BSTIterator.stack.head)

  }
  it should " Give the next element in the correct order" in {
    val BST = new BinarySearchTree[Int](5)
    BST.addValue(2)
    BST.addValue(30)
    BST.addValue(50)
    BST.addValue(1000359)
    BST.addValue(1000359)
    BST.addValue(700)
    BST.addValue(800)

 //   BST.printTree()

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)
    BSTIterator.initStack()

    val element = BSTIterator.next()
    println(element.getValue())
    val element2 = BSTIterator.next()
    println(element2.getValue())
    val element3 = BSTIterator.next()
    println(element3.getValue())
    val element4 = BSTIterator.next()
    println(element4.getValue())
    val element5 = BSTIterator.next()
    println(element5.getValue())
    val element6 = BSTIterator.next()
    println(element6.getValue())
    val element7 = BSTIterator.next()
    println(element7.getValue())

  }

  it should "Return the next leaf" in {
    val BST = new BinarySearchTree[Int](5)
    BST.addValue(2)
    BST.addValue(30)
    BST.addValue(50)
    BST.addValue(1000359)
    BST.addValue(1000359)
    BST.addValue(700)
    BST.addValue(800)

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)
    BSTIterator.initStack()

    val leaf = BSTIterator.nextLeaf()
    println(leaf.getValue())

    val leaf3 = BSTIterator.nextLeaf()
    println(leaf3.getValue())

    val leaf4 = BSTIterator.nextLeaf()
    println(leaf4.getValue())

    val leaf5 = BSTIterator.nextLeaf()
    println(leaf5.getValue())

  }
}
