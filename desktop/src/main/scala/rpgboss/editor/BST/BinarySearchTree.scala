package rpgboss.editor.BST


/*
  Author: Asma Oualmakran
  Class: BinarySearchTree
  Parameters: size:Int
    use: Determine the size (number of nodes in the tree)
  Use: Create a unordered binary search tree
 */

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

  private def initTree(node:Node[T]): Unit={
    treeArray(rootIndex) = node
  }

  /*
    Get the root of the tree
   */

  def getRoot(): Node[T]={

    if(treeArray.nonEmpty){
      return treeArray.head
    }else{
      return null
    }
  }

  // TODO: MOVE ALL NODE PREDICATES TO NODE!!!! + methods like set parent ect

  /*
    Determine if a node is a leaf
   */

  private def isLeaf_?(node: Node[T]): Boolean={
    val left = node.leftChild
    val right = node.rightChild

    return left == null && right == null
  }

  /*
    Determine if a node has a left or a right child
   */
  private def hasLeftChild_?(node: Node[T]): Boolean={

    return node.leftChild == null
  }

  private def hasRightChild_?(node: Node[T]): Boolean={

    return node.rightChild == null
  }

  /*
    Balance the tree after adding a node
   */

  private def balanceTree(): Unit={

    println("Tree is balanced")

  }


  /*
    The node passed as pm, is not always the last node in the TreeSet
   */
  override def setChild(node:Node[T],newChildNode:Node[T]): Unit ={

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

  /*
    Find the last free index in the array, to enable to store
    a node on that location
   */
  //TODO: Check hoe dit correct moet
  private def findLastFreeIndex(): Int ={
    val lastElement = treeArray.last
    val lastIndex = treeArray.lastIndexOf(lastElement)
    return lastIndex + 1
  }

  private  def findFreeLocation(): Node[T]={
    val root = getRoot()
    if(root == null){
      return null

    }else{
      if(!hasLeftChild_?(root) || !hasRightChild_?(root)){
        return root       // if one of the 2 locations is free, the root is a possible canditate

        }else{            // if the root is not a possible parent, we are going to loop over the sub trees
          def loop(node: Node[T]): Node[T] ={
              if(!hasLeftChild_?(node) || !hasRightChild_?(node)){ //in this case one of the locations is free
                return node
              }else{
                loop(node.rightChild)   // we are always going right if we loop TODO: check this
              }
          }

          val freeNode = loop(root)
          return freeNode
          }
        }
      }




  /*
    This wil be used by addValue(newValue:T) to add an new value to the tree
    the new value must be a node to be valid
   */
  private  def addNode(newNode: Node[T]): Unit ={
    val lastNode = findFreeLocation()
    if(lastNode == null){
      initTree(newNode)
    }else {

      setChild(lastNode, newNode)
      setParent(newNode, lastNode)
      balanceTree()
    }
    println("Node added: ", newNode)
  }

  /* This wil make it possible for the user to add a value to
      the tree
   */
  def addValue(newValue:T): Unit={
    val newNode = new Node[T](newValue)
    println("Node created with value: ", newValue)
    addNode(newNode)

  }






}
