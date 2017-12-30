package rpgboss.editor.map_generator
import scala.collection.mutable.Stack
import scala.util.Random


class ContainerGenerator (startContainer: Container, seed:Int) extends Tcontainer{

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

  def split_container(): List[Container] = {
    val dir = random.nextInt(1)

    if (dir == 0){            // if the direction is 0 -> split the container horizontally
      val hight = lower_bound - upper_bound
      val middle = hight / 2
      return List(new Container(left_bound, upper_bound,middle,right_bound),  // first container that starts at the original upper_bound
        new Container(left_bound,middle, lower_bound, right_bound)) // and stopts on the splitting point, second container, does the opposite

    }else{                    // otherwise split it vertically
      val width = right_bound - left_bound
      val middle = width / 2
      return List(new Container(left_bound, upper_bound, lower_bound, middle),
        new Container(middle, upper_bound, lower_bound, right_bound))
    }

  }

  def next(): Container={
    if(stack.isEmpty){
      sys.error("Stack is empty no next container to be calculated")
    }else{

    }
  }

}
