package rpgboss.editor.BST

import scala.collection.immutable.TreeSet



class BST[T]{

  var tree = TreeSet.empty[T]


  /*
    Initialize the tree, it will not contain a value
   */
  def init_tree(): Unit= {
    this.tree = new TreeSet[T]()
  }

  /*
    A node is also a tree. Initializing a node -> creating a new tree
   */

  def init_node(node: Object[T]): TreeSet[T] = {
    var new_node = new TreeSet[T]()
    return new_node
  }

  /*
    Takes a node and a value, and sets the value to a node
   */
  def set_value_node(node_value: Object[T],node: TreeSet[T]): Unit ={
      node.+(node_value[T])
  }

  /*
    Takes a node and adds it to the existing tree
   */

  def add_node(node: TreeSet[T]): Unit = {
    tree = tree.union(node)
  }

}
