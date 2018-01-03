package rpgboss.editor.randec

class decoration(int1: Int, int2: Int, int3: Int) {

  def display() = println(s"decoration: ($int1, $int2, $int3)")

  def getCode: Array[Array[Array[Byte]]] =
    return Array(Array(Array(int1.asInstanceOf[Byte], int2.asInstanceOf[Byte], int3.asInstanceOf[Byte])))


}
