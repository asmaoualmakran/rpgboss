package rpgboss.editor.randec

abstract class Decoration {
  var decorationType: DecorationType = _;

  def getCode(int1: Int, int2: Int, int3: Int): Array[Array[Array[Byte]]] =
    return Array(Array(Array(int1.asInstanceOf[Byte], int2.asInstanceOf[Byte], int3.asInstanceOf[Byte])))

  def doDisplay(): Unit = decorationType.display()
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