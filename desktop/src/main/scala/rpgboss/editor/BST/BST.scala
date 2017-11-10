package rpgboss.editor.BST
import scala.collection.immutable

class BST[T] extends Node{

  var tree = init_tree()

  /*
    Initialize the tree, it will not contain a value
   */
  def init_tree(): Unit = {
    scala.collection.immutable.TreeSet.empty[T]
  }

  /*
    Initialize a node, the node will not contain a value
    this will need to be set later
   */
  override def init_node(): Unit = {
    scala.collection.immutable.TreeSet.empty[T]
  }

  /*
    Add an node to the tree, the node needs to have a value
    --> type is needed
   */
  def add_node(node: T): Unit = {
    tree.union(node)
  }

  override def set_node_value(node_value: T): Unit = {

  }



}
