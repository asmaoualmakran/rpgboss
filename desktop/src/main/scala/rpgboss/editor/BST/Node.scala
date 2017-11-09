package rpgboss.editor.BST

class Node (x1:Int, x2:Int, y1:Int, y2:Int) {

  val left_point = x1
  val right_point = x2
  val top_point = y1
  val bottom_point = y2
  val top_left_corner = Array(x1,y1)
  val top_right_corner = Array(x2,y1)
  val bottom_left_corner = Array(x1,y2)
  val bottom_right_corner = Array(x2,y2)

  /*
    Setting an index when it is placed in the tree
    default value for the index is 0
    will be adjusted when generating the tree
   */
  var index = 0

  def set_index(index:Int): Int ={
    this.index = index
    return index
  }

}
