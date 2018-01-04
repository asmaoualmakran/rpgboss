package rpgboss.editor.map_generator

trait Tcontainer {

  val leftBound: Int
  val upperBound: Int
  val lowerBound: Int
  val rightBound: Int
  val width: Int
  val height: Int

  def point(x:Int, y:Int):Tuple2[Int, Int] = ???
  def size():Int = ???
  def center():Tuple2[Int, Int] = ???

}
