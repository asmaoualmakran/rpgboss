package rpgboss.editor.randec

import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.{MapLayers, MapViewState}

class PlaceDecoration(vs: MapViewState) extends RandomDecorations(){

  // Get random x and y
  def getLoc(): List[Int] ={
    val ranLoc = new RandomLocation(vs)
    val pos = ranLoc.getLocation()
    pos
  }

  // Grab random decoration from list
  def getDec(): List[Int] ={
    val rnd = new scala.util.Random
    val decorationNumber = rnd.nextInt(decorationList.length)
    decorationList(decorationNumber)
  }

  def placeDecorations(nod: Int): Unit = {

    numberOfDecorations = nod

    for (a <- 1 to numberOfDecorations) {

      val pos = getLoc()
      val x = pos.head
      val y = pos.tail.head

      val decoration = getDec()

      // Generate correct tile code
      val int1 = decoration.head
      val int2 = decoration.tail.head
      val int3 = decoration.tail.tail.head

      val scary: Boolean = scaryDecorationList.contains(decoration)
      val nature: Boolean = natureDecorationList.contains(decoration)
      val resource: Boolean = resourceDecorationList.contains(decoration)
      val typeList = List(scary, nature, resource)

      val dec = typeList match {
        case List(true, false, false) => new ScaryDecoration
        case List(false, true, false) => new NatureDecoration
        case List(false, false, true) => new ResourceDecoration
      }

      val tCode = dec.getCode(int1, int2, int3)

      // Decorations belong on the top layer
      val selectedLayer = MapLayers.Top

      vs.begin()
      Pencil.onMouseDown(vs, tCode, selectedLayer, x, y)
      vs.commit()

      dec.doDisplay()
      println(s"Placed decoration#$a: ($int1, $int2, $int3) at ($x, $y)")
    }
  }
}
