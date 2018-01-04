package rpgboss.editor.map_generator

import rpgboss.editor.BST.{BinarySearchTree, BinarySearchTreeIterator}

import scala.collection.mutable.MutableList




class MapGenerator(iterations:Int, seed:Int, canvas_height: Int, canvas_width:Int) {

  val W_RATIO = 0.45
  val H_RATIO = 0.45
  val minimumSize = 4
  val start_container  = new Container(0, canvas_width, 0, canvas_height)
  val containerGen = new ContainerGenerator(this.start_container, seed, this.minimumSize)
  containerGen.H_RATIO = this.H_RATIO
  containerGen.W_RATIO = this.W_RATIO
  var bst_tree = new BinarySearchTree[Container](this.iterations + 1) // need to add 1, the root is not counted with the iterations, we need a extra level in the tree
  var bstIter: BinarySearchTreeIterator[Container] = _


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
    bstIter = new BinarySearchTreeIterator[Container](this.bst_tree)
    bstIter.initStack()

    val result: MutableList[Container] = MutableList()
    for(_<- 1 to bst_tree.numberOfLeafs){

      result.+=(bstIter.nextLeaf().getValue())
    }
    return result.toList

  }



}

