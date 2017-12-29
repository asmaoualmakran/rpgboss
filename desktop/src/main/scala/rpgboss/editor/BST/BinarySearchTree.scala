package rpgboss.editor.BST

import scala.collection.mutable.Queue

/*
  Author: Asma Oualmakran
  Class: BinarySearchTree
  Parameters:
    T: type parameter
      use: Determine the types in the tree
    size:Int
      use: Determine the size (number of nodes in the tree)
  Use: Create a unordered binary search tree
 */


class BinarySearchTree[T](size: Int) extends Tnode[T]{


  val numberOfNodes = this.size
  private var treeArray = Array.ofDim[Node[T]](size)  //The array representing the tree
  private val rootIndex = 0
  private var rootNode = treeArray(rootIndex)

  /*
    Function: printTree
    Parameters: n/a
    Return: Unit
    User: Print the tree array.
   */

  def printTree(): Unit ={
    for(i <- 0 to treeArray.length-1){
      if(treeArray(i) == null){
        print(0," ")
      }else{
        var node = treeArray(i)
        print(node.getValue()," ")
      }
    }
  }

  /*
    Function: isNull_?
    Parameter: n/a
    Return: Boolean
    User: Ask whether the tree is empty
   */

  def isNull_?(): Boolean={
    if(rootNode == null){
      return true
    }
    return false
  }

  /*
    Function: initTree
    Parameter:
      node: type:Node[T]
        Use: The node with which the tree needs to be initialized.
    Return: Unit
    Use: Initialize the tree with a given node as root.
   */

  private def initTree(node:Node[T]): Unit={
    treeArray.update(rootIndex, node)
    rootNode = node                 // update the rootnode
  }

  /*
    Function: getRoot
    Parameter: n/a
    Return: Node[T]
    Use: Get the root of the tree.
   */

  def getRoot(): Node[T]={
    val root = getNode(rootIndex)
    return root
  }


  /*
    Function: getNode
    Parameter:
      index: type; Int
        Use: The index of the node that needs to be accessed.
    Return: Node[T]
    Use: Get a node on a specific location in the array representing the tree.
   */

  private def getNode(index:Int): Node[T]={
    if(treeArray.nonEmpty){
      return treeArray(index)
    }else{
      return null
    }
  }

  /*
    Function: isFull_?
    Parameter: n/a
    Return: Boolean
    Use: Returns true when the array representing the tree is full.
   */

  private def isFull_?(): Boolean={
    for(i<-0 to treeArray.length) {
      if (getNode(i) == null) {
        return false
      }
    }
    true
  }

  /*
    Function: findTreeLocation
    Parameter: n/a
    Return: Node[T]
    Use: Search for a node where one of the child locations is free, to add a new node
         this also makes sure that the tree stays balanced.
   */

  private def findTreeLocation(): Node[T]={

    if(isFull_?()){
      sys.error("No free location to be found: findLastIndex()")
    }else if(treeArray(rootIndex) == null){
      return treeArray(rootIndex)

    }else{
      var nodeQueue = new Queue[Node[T]]()    //create the queue
      nodeQueue.enqueue(rootNode)
       def loop(): Node[T]= {

         val node = nodeQueue.dequeue()       // check if the head of the queue has left or right children

         if (treeArray.indexOf(node) < treeArray.length) {

           if (!node.hasLeftChild_?() || !node.hasRightChild_?()){ // if either of these 2 locations is free, the node is returned

             return node // we only get in the else case if both locations are taken
           } else {
             nodeQueue.enqueue(node.getLeftChild())     // enqueue the left and right children of the node, to use later if
             nodeQueue.enqueue(node.getRightChild())    // their left and right children location
             loop()                       // Recursive call of the loop
           }
         }else{
           sys.error("The node is out of range")
         }
       }
      return loop()
    }
  }

  /*
    Function: findArrayLocation
    Parameter: n/a
    Return: Int
    Use: Search for the first empty location in the array.
   */
  private def findArrayLocation(): Int={
    if(treeArray == null){
      return rootIndex
    }else{
      for(i <- 0 to treeArray.length){
        if(treeArray(i) == null){
          return i
        }
      }
      sys.error("There is no free location: findArrayLocastion()")
    }
  }

  /*
    Function: addNode
    Parameters:
      newNode: type:Node[T]
        Use: Add a node to the tree.
    Return: Unit
    Use: Add a given node to the tree.
   */

  private  def addNode(newNode: Node[T]): Unit = {
    if (rootNode == null) {
      initTree(newNode)

    }else{

    val freeLoc = findTreeLocation()
      newNode.setParent(freeLoc) //set the pointers to the nodes
      freeLoc.setChild(newNode)

    val arrayLoc = findArrayLocation()
    treeArray.update(arrayLoc, newNode)
    }
  }
  /*
    NOTE: we use the def update(index:Int, element:T) to add an element to the node
          this choice is made due to the fact that def :+(element:T) doesn't add the element
          to the array, the expected result is not produced using this function
   */


  /*
    Function: addValue
    Parameters:
      newValue: type: T
        Use: Add a value to the tree, the node where the value will be contained is created automatically.
    Return: Unit
    Use: Add a value to the tree, creation of the node and the addition to the tree, will be handled
         by the internal implementation of the tree.
   */

  def addValue(newValue:T): Unit={
    val newNode = new Node[T](newValue)
    addNode(newNode)
  //  printTree()

  }


}
