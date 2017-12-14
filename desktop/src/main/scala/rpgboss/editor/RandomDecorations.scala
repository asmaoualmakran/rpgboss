package rpgboss.editor

import rpgboss.model.resource.RpgMap
import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.MapLayers._


class RandomDecorations {

  def getRandomLocation(): List[Int] = {

    val startX = 0
    val endX  = RpgMap.initXSize

    val startY = 0
    val endY  = RpgMap.initYSize

    val rnd = new scala.util.Random
    val x = startX + rnd.nextInt(( endX - startX) + 1);
    val y = startY + rnd.nextInt(( endY - startY) + 1);
    return List(x, y);

  }


  def placeDecorations(vs: MapViewState,
                       tCodes: Array[Array[Array[Byte]]]) = {
    val pos = getRandomLocation();
    val x = pos.head
    val y = pos.tail.head
    Pencil.onMouseDown(vs, tCodes, MapLayers.Top, x ,y)
    // tCodes specifies which tile will be drawn
    // -> Find out the tile representation and how to select a random tile

  }

}
