package rpgboss.editor.randec

abstract class Decoration {
  var decorationType: DecorationType = _;

  def getCode(int1: Int, int2: Int, int3: Int): Array[Array[Array[Byte]]] =
    return Array(Array(Array(int1.asInstanceOf[Byte], int2.asInstanceOf[Byte], int3.asInstanceOf[Byte])))
}

trait DecorationType{
  val dType: String
  def display(): Unit
}

object ScaryType extends DecorationType{
  val dType = "Scary"
  def display() = print(s" [$dType] ")
}
object NatureType extends DecorationType{
  val dType = "Nature"
  def display() = print(s" [$dType] ")
}
object ResourceType extends DecorationType{
  val dType = "Resource"
  def display() = print(s" [$dType] ")
}


class ScaryDecoration extends Decoration{
  decorationType = ScaryType
}
class NatureDecoration extends Decoration{
  decorationType = NatureType
}
class ResourceDecoration extends Decoration{
  decorationType = ResourceType
}


/*
trait Decoration{
  val numberOfDecorations: Int
}

trait DecorationFactory{
 // def getCode: Array[Array[Array[Byte]]]
  def getDec: List[Int]
}

class ScaryDecorationFactory extends DecorationFactory{

  val scaryDecorationList: List[List[Int]] =
    List(
      List(1, 6, 9), List(4, 2, 3),  List(4, 5, 0), List(4, 4, 3),
      List(4, 0, 2), List(4, 2, 2),  List(4, 0, 3), List(4, 4, 2)
    )

  val numberOfDecorations: Int = scaryDecorationList.length

  def getDec(): List[Int] = {
    val rnd = new scala.util.Random
    val decorationNumber = rnd.nextInt(numberOfDecorations)
    scaryDecorationList(decorationNumber)
  }
}


class NatureDecorationFactory extends DecorationFactory{

  val natureDecorationList: List[List[Int]] =
    List(
      List(1, 4, 5),  List(1, 1, 4), List(1, 3, 6), List(1, 2, 5), List(1, 3, 5),
      List(1, 0, 4),  List(1, 2, 4), List(1, 3, 4), List(1, 4, 4), List(1, 5, 4),
      List(1, 4, 9),  List(1, 5, 13), List(1, 6, 13),List(1, 7, 13),List(1, 5, 14),
      List(1, 6, 14), List(1, 7, 14), List(1, 5, 15),List(4, 5, 1)
    )

  val numberOfDecorations: Int = natureDecorationList.length

  def getDec(): List[Int] ={
    val rnd = new scala.util.Random
    val decorationNumber = rnd.nextInt(numberOfDecorations)
    natureDecorationList(decorationNumber)
  }
}

class ResourceDecorationFactory extends DecorationFactory {

  val resourceDecorationList: List[List[Int]] =
    List(
      List(1, 4, 5), List(1, 5, 10), List(1, 5, 5), List(1, 5, 9), List(1, 6, 10),
      List(1, 7, 10), List(1, 6, 15), List(1, 7, 15), List(4, 1, 13), List(4, 1, 14), List(4, 2, 13)
    )

  val numberOfDecorations: Int = resourceDecorationList.length

  def getDec(): List[Int] ={
    val rnd = new scala.util.Random
    val decorationNumber = rnd.nextInt(numberOfDecorations)
    resourceDecorationList(decorationNumber)
  }
}

class DecorationStore(decType: String) {
  def createDecoration(decType: String) = decType match {
    case "scary" => val d = new ScaryDecorationFactory
      d.getDec()
    case "nature" => val d = new NatureDecorationFactory
      d.getDec()
    case "resource" => val d = new ResourceDecorationFactory
      d.getDec()
  }

  def getDecoration(decType: String): Decoration = {
    val d = createDecoration(decType)
    val int1 = d.head
    val int2 = d.tail.head
    val int3 = d.tail.tail.head
    Array(Array(Array(int1.asInstanceOf[Byte], int2.asInstanceOf[Byte], int3.asInstanceOf[Byte])))
  }
}
*/