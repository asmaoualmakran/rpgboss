package rpgboss.editor.BST

import scala.collection.mutable.TreeSet

/*
  This implementation extends TreeSet to implement a Binary search tree
 */
class BST [T] extends TreeSet{

object DescendingOrder{
    implicit val order = new Ordering[T]{
      override def compare(node1: T, node2: T): Int = {
      /*
      write code for comparing here
       */
      }

    }
  }

  var root = TreeSet.empty[T](DescendingOrder)

  def init_tree(value:T): TreeSet[T] ={
    root += value
    return root
  }



  def add_node (value:T): TreeSet[T] ={
    var new_node = TreeSet.empty[T]
    new_node += value
    return new_node
  }




}