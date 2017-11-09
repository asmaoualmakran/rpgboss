package rpgboss.editor.map_generator

import rpgboss.editor.BST.BST


class MapGenerator(iterations:Int, seed:Int, canvas_width: Int, canvas_height:Int) {

  val start_point = 1
  /*
    the root is not counted as an iterations
   */
  val tree_size = (iterations + start_point)
  var tree = new BST(tree_size)



}
