package rpgboss.editor.map_generator
import scala.collection.mutable.{MutableList, Stack}
import scala.util.Random


/*
  Author: Asma Oualmakran
  Class: ContainerGenerator
  Parameters:
    startContainer: Container
      Use: The first container, the following containers will be calculated using the startContainer.
    seed: Int
      Use: The seed for the random number, used for splitting the containers.
    minimumSize: Int
      Use: The minimum size that the container needs to be, this will prevent generation of
           of containers that are too small to be playable.
  User: Generate the following containers, calculations are based on the passed startContainer.
 */

class ContainerGenerator(startContainer: Container, seed:Int, minimumSize: Int) {

  private var stack = new Stack[Container]()
  private val random = new Random(seed)
  var W_RATIO: Double = _
  var H_RATIO: Double = _



  /*
    Function: initStack
    Parameters: n/a
    Return: n/a
    Use: Initialize the stack, used to keep the last generated containers
   */

  def initStack(): Unit = {
    if (stack.isEmpty) {
      stack.push(startContainer)
    } else {
      sys.error("Stack can not be initialized, it already contains a container")
    }
  }


  /*
    Function: clearStack
    Parameters: n/a
    Return: n/a
    Use: Clear the stack
   */

  def clearStack(): Unit = {
    if (stack.isEmpty) {
      sys.error("Stack is already empty")
    }
    stack.clear()
  }

  /*
    Function: largeEnough_?
    Parameters: container: Container
      Use: The container that needs to be checked.
    Return: Boolean
    Use: A boolean to check if the container is large enough after splitting.
   */

  private def largeEnough_?(container: Container): Boolean =
    ((container.width/2)*container.height) >= minimumSize && ((container.height/2)* container.width) >= minimumSize


  /*
   Function: splitContainer
   Parameter: container: Container
     Use: Split a container in 2, splitting direction is chosen random.
   Return: Tuple2[Container, Container]
   Use: Split a container in 2 new containers.
  */

  private def splitContainer(container: Container): Tuple2[Container, Container] = {

    if (largeEnough_?(container)) {

      if (random.nextInt(2) == 0) { // if the direction is 0 -> split the container horizontally
        val middle = container.lowerBound/2
        val c1 = new Container(container.leftBound, container.rightBound, container.upperBound,middle)
        val c2 = new Container(container.leftBound, container.rightBound,  middle, container.lowerBound)

     /*   if(c1.width/c1.height < W_RATIO || c2.width/c2.height < W_RATIO){  // these ratio's are used to make sure the containers are of a decent shape
          return splitContainer(container)                 // if they are too small, start over
        }*/
        return (c1, c2)



      } else{ // otherwise split it vertically
        val middle = container.rightBound / 2
        val c1 = new Container(container.leftBound, middle, container.upperBound, container.lowerBound)
        val c2 = new Container(middle, container.rightBound, container.upperBound, container.lowerBound)

      /*  if(c1.height/c1.width < H_RATIO || c2.height/c2.width < H_RATIO){
          return splitContainer(container)
        }*/
        return (c1,c2)
      }
    }
   return sys.error("Container is not large enough to split")
  }


  /*
    Function: next
    Parameter: n/a
    Return: List[Container]
    Use: Calculate the following set of containers.
   */

  def next(): List[Container]= {

    if (stack.isEmpty) {
      sys.error("Stack is empty no next container to be calculated, reinitialize the stack")
    } else {

      val result: MutableList[Container] = MutableList()  // use mutable list to build the result

      while(!stack.isEmpty){
       val res = splitContainer(stack.top)
        stack.pop()
        result.+=:(res._1)
        result.+=:(res._2)
      }
      result.foreach(stack.push)
      return result.toList.reverse              // return an immutable list, reverse to get it in the correct order (less performance)
    }
  }

}
