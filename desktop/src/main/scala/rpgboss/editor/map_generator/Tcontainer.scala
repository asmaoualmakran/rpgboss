package rpgboss.editor.map_generator

trait Tcontainer {

  val left_bound: Int
  val upper_bound: Int
  val lower_bound: Int
  val right_bound: Int
  val width: Int
  val height: Int

  def point(x:Int, y:Int):Tuple2[Int, Int] = ???
  def size():Int = ???
  def center():Tuple2[Int, Int] = ???

}
