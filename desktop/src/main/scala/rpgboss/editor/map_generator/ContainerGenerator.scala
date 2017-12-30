package rpgboss.editor.map_generator
import scala.collection.mutable.Stack
import scala.util.Random

/*
The minimum size is used to prevent the fields to become too small and unplayable
 */
class ContainerGenerator (startContainer: Container, seed:Int, minimumSize: Int) extends Tcontainer{

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

  private def largeEnoug_?(container: Container): Boolean={
    if((((container.height/2)*container.width) < this.minimumSize) || ((container.height*(container.width/2)) < this.minimumSize)){
      return false
    }
    return true
  }

  /*
  Before starting to split the container, first check whether it's large enough to split
   */
 private def split_container(container: Container): List[Container] = {

   if(largeEnoug_?(container)) {

     val dir = random.nextInt(1)

     if (dir == 0) { // if the direction is 0 -> split the container horizontally
       val middle = container.height / 2
       return List(new Container(container.left_bound, container.upper_bound, middle, container.right_bound), // first container that starts at the original upper_bound
         new Container(container.left_bound, middle, container.lower_bound, container.right_bound)) // and stopts on the splitting point, second container, does the opposite

     } else { // otherwise split it vertically

       val middle = container.width / 2
       return List(new Container(container.left_bound, container.upper_bound, container.lower_bound, middle), // return the 2 new containers in a list
         new Container(middle, container.upper_bound, container.lower_bound, container.right_bound))
     }
   }
   return sys.error("Container is not large enough to split")
  }

  
  def next(): Container={
    if(stack.isEmpty){
      sys.error("Stack is empty no next container to be calculated")
    }else{

    }
  }

}
