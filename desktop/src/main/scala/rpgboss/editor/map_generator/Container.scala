package rpgboss.editor.map_generator
import scala.util.Random
/*
/*
  Author: Asma Oualmakran
  Class: Container; constructs a container which is a subsection
                    of a canvas / game field
        parameters:
                  x: type -> Integer, the horizontal starting point of the canvas/field
                  y: type -> Integer, the vertical starting point of the canvas/field
                  h: type -> Integer, the horizontal end point of the canvas/field
                  w: type -> Integer, the vertical end point of the canvas/field
 */


case class Container(x:Int, y:Int, h:Int, w:Int) {

  val left_bound  = this.x
  val upper_bound = this.y
  val lower_bound = this.h
  val right_bound = this.w
  val width = right_bound - left_bound
  val height = lower_bound - upper_bound
  val random = new Random()

  /*
    Function: point; constructs a coordinate returns it in a form of a list
              parameters:
                        x: type -> Integer, the x coordinate of a point
                        y: type -> Integer, the y coordinate of a point
              retrun:
                    type -> Integer list

   */
  def point(x:Int, y:Int):List[Int] = {
    val point = List(x,y)
    return point
  }

  /*
    Calculates the surface of the container, this is needed
    for sorting on size of the containers
    a container of an iterations can never be lager than the containers from the
    previous iteration
   */
  def size():Int = {
    val surface = width*height
    return surface
  }

  def center():List[Int] = {

    val hor_center = ((w - x)/2)
    val ver_center = ((h - y)/2)

    val center = point(hor_center,ver_center)
    return center
  }


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



}

*/