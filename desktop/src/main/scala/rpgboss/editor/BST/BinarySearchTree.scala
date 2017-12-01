package rpgboss.editor.BST


/*
  Every node of the bst has type T
  Were using generic typing
 */

class BinarySearchTree[T](size: Int) extends Tnode[T]{

  val treeArray = Array.ofDim[Node[T]](size)     // the tree contains nodes of type Node[T]
  val rootIndex = 0

  /*
    Initialize the tree, this will happen automatically when the
    first node is added
   */

  private def initTree(node:Node[T]): Unit ={
    treeArray(rootIndex) = node
  }

  def getRoot(): Node[T]={

    if(treeArray.nonEmpty){
      return treeArray.head
    }else{
      return null

    }
  }


  /*
    The node passed as pm, is not always the last node in the TreeSet
   */
  override def setChild(node:Node[T],newChildNode:Node[T]): Unit ={

  /*  val newParentNode = findFreeLocation()

    if(newParentNode == null){
      addNode(childNode)   // if the tree is empty

    }else if(newParentNode.leftChild == null){
      newParentNode.leftChild = childNode
      childNode.parent = newParentNode

    }else if(newParentNode.rightChild == null){
      newParentNode.rightChild = childNode
      childNode.parent = newParentNode

    } */
    if(getRoot() == null){
      initTree(newChildNode)     // in this case the tree has not been initialized yet with a root
                              // we add te new node, and set is as root
    }else if(node.leftChild == null) {  // we check if one of the children is null, if so there is a location free
      node.leftChild = newChildNode

    }else if(node.rightChild == null){
      node.rightChild = newChildNode

    }else{
     sys.error("This node already has a left and a right child") //if none of the locations are free
                                                                  // we throw an error
    }
  }

  /*
    Set the parent of the node to a specific node
   */

  override def setParent(node:Node[T],newParentNode: Node[T]): Unit ={
    if(node.parent == null) {
      node.parent = newParentNode

    }else{
     sys.error("This node already has a parent")
    }
  }


  private  def findFreeLocation(): Node[T]={
    if(getRoot() == null){
      return null
    }else{
      //TODO: loop over de array en check alle linker en rechter $
      // kinderen van de nodes
    }

  }


  private  def addNode(newNode: Node[T]): Unit ={
    val lastNode = findFreeLocation()
    setChild(lastNode, newNode)
    setParent(newNode, lastNode)
    println("Node added: ", newNode)
  }

  def addValue(newValue:T): Unit={
    val newNode = new Node[T](newValue)
    println("Node created with value: ", newValue)
    addNode(newNode)

  }






}
