package rpgboss.editor.map_generator
import scala.collection.mutable.{MutableList, Stack}
import scala.util.Random

/*
The minimum size is used to prevent the fields to become too small and unplayable
 */
class ContainerGenerator(startContainer: Container, seed:Int, minimumSize: Int){

  private var stack = new Stack [Container]()
  val random = new Random(seed)

  private def initStack(): Unit={
    if(stack.isEmpty){
      stack.push(startContainer)
      }else{
      sys.error("Stack can not be initialized, it already contains a container")
    }
  }

  initStack()  // initialize the stack

  def clearStack(): Unit={
    if(stack.isEmpty){
      sys.error("Stack is already empty")
    }
    stack.clear()
  }

  private def largeEnough_?(container: Container): Boolean={
    if((((container.height/2)*container.width) < this.minimumSize) || ((container.height*(container.width/2)) < this.minimumSize)){
      return false
    }
    return true
  }

  /*
  Before starting to split the container, first check whether it's large enough to split
   */
 private def split_container(container: Container): Tuple2[Container, Container] = {

   if(largeEnough_?(container)) {

     val dir = random.nextInt(1)

     if (dir == 0) { // if the direction is 0 -> split the container horizontally
       val middle = container.height / 2
       val result = (new Container(container.left_bound, container.upper_bound, middle, container.right_bound), // first container that starts at the original upper_bound
       new Container(container.left_bound, middle, container.lower_bound, container.right_bound)) // and stopts on the splitting point, second container, does the opposite
       return result

     } else { // otherwise split it vertically

       val middle = container.width / 2
       val result = (new Container(container.left_bound, container.upper_bound, container.lower_bound, middle), // return the 2 new containers in a list
         new Container(middle, container.upper_bound, container.lower_bound, container.right_bound))
       return result
     }
   }
   return sys.error("Container is not large enough to split")
  }


 def next(): List[Container]={
    if(stack.isEmpty){
      sys.error("Stack is empty no next container to be calculated")
    }else{
      val result: MutableList[Container] = MutableList()
      while (!stack.isEmpty){
        val newContainers: Tuple2[Container,Container] = split_container(stack.head)
        stack.pop()
        result.+: (newContainers._1)   // add the new elements at the front of the list -> we create a reversed list
        result.+: (newContainers._2)
      }

      for(i <- 0 to result.length){   // push all the new containers back on the stack to initialize the next iteration
        stack.push(result(i))
      }
      return result.toList            // Return an immutable list as result, mutable data structure is not needed after the result is built
    }
  }

}
