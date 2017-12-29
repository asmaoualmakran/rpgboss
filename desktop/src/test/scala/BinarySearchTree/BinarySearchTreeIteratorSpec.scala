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

    val BSTIterator = new BinarySearchTreeIterator[Int](BST)
    BSTIterator.initStack()

    val thrown = intercept[Exception] {           //catch the exception that is thrown
      BSTIterator.initStack()
    }
    assert(thrown.getMessage === "Can not initialize stack, it contains element")
  }

}
