package rpgboss.editor.randec

import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.{MapLayers, MapViewState}

class placeDecoration(vs: MapViewState) extends randomDecorations(){

  def placeDecorations(nod: Int): Unit = {

    NumberOfDecorations = nod

    for (a <- 1 to NumberOfDecorations){

      // Get random x and y
      val ranLoc = new randomLocation(vs)
      val pos = ranLoc.getLocation()
      val x: Int = pos.head
      val y: Int = pos.tail.head

      // Grab random decoration from list
      val rnd = new scala.util.Random
      val decorationNumber = rnd.nextInt(DecorationList.length)
      val decoration = DecorationList(decorationNumber)

      // Grab correct tile code
      val int1 = decoration.head
      val int2 = decoration.tail.head
      val int3 = decoration.tail.tail.head

      val dec = new decoration(int1, int2, int3)
      val tCode = dec.getCode

      // Decorations belong on the top layer
      val selectedLayer = MapLayers.Top

      vs.begin()
      Pencil.onMouseDown(vs, tCode, selectedLayer, x, y)
      vs.commit()

      println(s"Placed decoration#$a: ($int1, $int2, $int3) at ($x, $y)")
    }
  }
}
