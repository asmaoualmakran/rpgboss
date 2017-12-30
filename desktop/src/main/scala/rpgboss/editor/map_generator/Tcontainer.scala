package rpgboss.editor.map_generator

trait Tcontainer {

  val left_bound = ???
  val upper_bound = ???
  val lower_bound = ???
  val right_bound = ???
  val width = ???
  val height = ???

  def point(x:Int, y:Int):List[Int] = ???
  def size():Int = ???
  def center():List[Int] = ???

}
