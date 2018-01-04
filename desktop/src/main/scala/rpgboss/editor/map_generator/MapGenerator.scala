package rpgboss.editor.map_generator

import rpgboss.editor.BST.{BinarySearchTree, BinarySearchTreeIterator}

import scala.collection.mutable.MutableList




class MapGenerator(iterations:Int, seed:Int, canvas_height: Int, canvas_width:Int) {

  val minimumSize = 4
  val start_container  = new Container(0, canvas_width, 0, canvas_height)
  val containerGen = new ContainerGenerator(this.start_container, seed, this.minimumSize)
  var bst_tree = new BinarySearchTree[Container](this.iterations + 1) // need to add 1, the root is not counted with the iterations, we need a extra level in the tree
  val bstIter = new BinarySearchTreeIterator[Container](bst_tree)


 private def generateChambers(): Unit={
    containerGen. initStack()
    bst_tree.addValue(start_container) // the root is the first container

    for(i <- 1 to iterations){
      val containers = containerGen.next()
     containers.foreach(bst_tree.addValue)
    }
  }

  def findFinalChambers(): List[Container]={
    generateChambers()
    bstIter.initStack()
    val result: MutableList[Container] = MutableList()
    for(_ <- 1 to bst_tree.numberOfNodes){
      result.+=(bstIter.nextLeaf().getValue())
    }
    return result.toList
  }



}

