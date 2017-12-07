package rpgboss.editor.BST


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

/*
  BinarySearchTree with type parameter
 */

class BinarySearchTree[T](size: Int) extends Tnode[T]{

  /*
    TODO: bekijk of er een array bestaat die resizable is, een boom kan in principe nooit vol zijn
   */
  private var treeArray = Array.ofDim[Node[T]](size)     // the tree contains nodes of type Node[T]
  private val rootIndex = 0
  private val rootNode = treeArray(rootIndex)

  def printTree(): Unit ={
    for(i <- 0 to treeArray.length-1){
      val node = treeArray(i)
      if(node == null){
        print(0, ", ")
      }
      print(node.getValue(),", ")
    }
  }


  /*
    Initialize the tree, this will happen automatically when the
    first node is added
   */

  private def initTree(node:Node[T]): Unit={
    treeArray(rootIndex) = node
  }

  /*
    Get the root of the tree
   */

  def getRoot(): Node[T]={
    val root = getNode(rootIndex)
    return root
  }

  /*
    Get a node form the tree useing an index
   */

  private def getNode(index:Int): Node[T]={
    if(treeArray.nonEmpty){
      return treeArray(index)
    }else{
      return null
    }
  }

  // TODO: MOVE ALL NODE PREDICATES TO NODE!!!! + methods like set parent ect




  /*
    Balance the tree after adding a node
   */

  private def balanceTree(): Unit={

    println("Tree is balanced")

  }



  private def isFull_?(): Boolean={
    for(i<-0 to treeArray.length){
      println("start looping locations")
      if(getNode(i) == null){
        println("there is place in the array")
        return false
      }
      /*else{
      //  sys.error("Tree is full, no node can be added: isFull?")
        return false
      }*/
    }
    println("no place trow error")
    sys.error("Tree is full, no node can be added: isFull_?")
  }
  /*
    Find the last free index in the array, to enable to store
    a node on that location
   */


  /*
    This function determines a free location for the node in the tree
   */

  private def findTreeLocation(): Node[T]={

    if(isFull_?()){
      println("We can't add this node tree is full")
      sys.error("No free location to be found: findLastIndex()")
    }else if(treeArray(rootIndex) == null){
      println("the root is empty this is our location")
      return treeArray(rootIndex)

    }else{
       println("we make our loop function")
       def loop(node: Node[T]): Node[T]= {
         println("check index")
         if (treeArray.indexOf(node) < treeArray.length) {
           println("node is in range")

           if (!node.hasLeftChild_?() || !node.hasRightChild_?()){ // if either of these 2 locations is free, the node is returned
             println("one of the child locations is free")
             return node // we only get in the else case if both locations are taken
           } else {
             println("start recursive call")
             loop(node.getLeftChild())
             loop(node.getRightChild())
           }
         }else{
           sys.error("The node is out of range")
         }
       }
      return loop(rootNode)
    }

  }

  /*
    This function determines the first free location in the
    array representing the tree
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
    This wil be used by addValue(newValue:T) to add an new value to the tree
    the new value must be a node to be valid
   */
  private  def addNode(newNode: Node[T]): Unit ={
    val freeLoc = findTreeLocation()
  //  newNode.setParent(newNode, freeLoc) //set the pointers to the nodes right
  //  freeLoc.setChild(freeLoc,newNode)
    val arrayLoc = findArrayLocation()
    treeArray.update(arrayLoc,newNode)  //TODO: moet update gebruiken om nodes toe te voegen
    // append the element to the array
  }
  /*
    NOTE: we use the def update(index:Int, element:T) to add an element to the node
          this choice is made due to the fact that def :+(element:T) doesn't add the element
          to the array, the expected result is not produced using this function
   */

  /* This wil make it possible for the user to add a value to
      the tree
   */
  def addValue(newValue:T): Unit={
    val newNode = new Node[T](newValue)
  //  println("Node created with value: ", newValue)
    addNode(newNode)


  }



}
