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
      val int2 = decoration(1)
      val int3 = decoration(2)

      // Initiate correct decoration type (4th element in list)
      val dec = decoration(3) match {
        case 0 => new ScaryDecoration
        case 1 => new NatureDecoration
        case 2 => new ResourceDecoration
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
