package rpgboss.editor.BST

class BST (height:Int){

  val tree_height = this.height

  /*
    Construction of the array where de nodes will be saved
    number of nodes is 2^k-1, with k = height.
   */
  def construct_array (size:Int): Array[Node] = {
    val number_nodes = (math.pow(2,size)-1).toInt
    var tree_array:Array[Node] = new Array[Node](number_nodes)
    return tree_array
  }
  var tree_array:Array[Node] = construct_array(tree_height)
  /*
    Functions below are used to calculate locations of the parent and or children nodes
   */

  def l_index(index:Int): Int = {
    val l_index = ((index*2)+1)
    return l_index
  }

  def r_index(index:Int): Int = {
    val r_index = ((index*2)+2)
    return r_index
  }

  def parent_index(index:Int): Int = {
    val parent_index = ((index - 1)/2)
    return parent_index
  }


  /*
    Adding a object node to the tree
   */
  def add_node(index:Int, node:Node) = {
    tree_array(index) = node
    node.set_index(index) //setting the index afther adding it to the tree
  }

  def get_node(index:Int): Node = {
    val node = tree_array(index)
    return node
  }

  /*
    Getting the left or the right child depending on the string that is
    passed
   */

  def get_child(node:Node, dir:String): Node = {
    val current_node = node.index
    var index_child = 0
    if(current_node < tree_array.length - 2) {

      if (dir == "left") {
        index_child = l_index(current_node)
      } else if (dir == "right") {
        index_child = r_index(current_node)
      } else {
        Left("Invalid direction, only left or right are allowed, given: ")
      }

    }else{
        Left("Node is a leaf node, it has no children")
      }

      val child = get_node(index_child)
    return child
  }

    /*
    abstractions to acces the relational nodes
   */

  def get_lchild(node:Node): Node = {
    val lchild = get_child(node, "left")
    return lchild
  }

  def get_rchild(node:Node): Node = {
    val rchild = get_child(node, "right")
    return rchild
  }

  def get_parent(node:Node): Node = {
    val parent_index = parent_index(node)
    val parent = get_node(parent_index)
    return parent
  }

}
