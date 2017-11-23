package rpgboss.editor.BST

import scala.collection.mutable
import scala.collection.mutable.TreeSet
import scala.util.Sorting

/*
  This implementation extends TreeSet to implement a Binary search tree
  takes a function ordering as a pm
 */
class BST[T](order: () => Unit) extends TreeSet{

  /*
    We're sorting on the size of the value of the  elements
   */

  /* TODO: MAAK ORDERING HIGHER ORDER!!!!! */
  object DescendingOrder extends Ordering[T] {
    implicit val order = new Ordering[T]{
      override def compare(node1: T, node2: T): Int = {
      /*
      write code for comparing here
       */

      }

    }
  }

  var root = new TreeSet[T]()


  def init_tree(value:T): TreeSet[T] ={
    root.add(value)
    return root
  }



  def add_node (value:T): TreeSet[T] ={
    if (root.nonEmpty){
      var new_node = new mutable.TreeSet[T]()(DescendingOrder[T])
      root.union(new_node)
      return new_node
    }
    init_tree(value)
  }


  def get_children(): List[T] = {
    var childrenList = List()

    return childrenList
  }



}