package rpgboss.editor.map_generator

import rpgboss.editor.BST.{BinarySearchTree, BinarySearchTreeIterator}

import scala.collection.mutable.MutableList


class MapGenerator(iterations:Int, seed:Int, canvas_height: Int, canvas_width:Int) {

  val minimumSize = 4
  val start_container  = new Container(0, 0, canvas_height, canvas_width )
  val containerGen = new ContainerGenerator(this.start_container, seed, this.minimumSize)
  var bst_tree = new BinarySearchTree[Container](this.iterations)
  val bstIter = new BinarySearchTreeIterator[Container](bst_tree)

  def fillBST(containers: List[Container]): Unit={
    for(i <- 0 to this.iterations){
      var con = containerGen.next()       // generate the containers for the given number of iterations
      for(j <- con.length to 0){          // the containers are in reversed order in the list
        bst_tree.addValue(con(j))         // place the generated containers in the tree
      }
    }
  }

  def generateMap(): List[Container]={
    var result: MutableList[Container] = new MutableList[Container]()
    while(!bstIter.endOfTree_?()){

    }
    return result.toList
    // return the children of the tree --> that contains the final map
  }




}

