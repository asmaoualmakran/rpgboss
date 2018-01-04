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
    val decorationNumber = rnd.nextInt(DecorationList.length)
    DecorationList(decorationNumber)
  }

  def placeDecorations(nod: Int): Unit = {

    NumberOfDecorations = nod

    for (a <- 1 to NumberOfDecorations){

      val pos = getLoc()
      val x = pos.head
      val y = pos.tail.head

      val decoration = getDec()

      // Generate correct tile code
      val int1 = decoration.head
      val int2 = decoration.tail.head
      val int3 = decoration.tail.tail.head

      val dec = new Decoration(int1, int2, int3)
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
