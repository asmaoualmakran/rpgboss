package rpgboss.editor

import rpgboss.model.resource.RpgMap
import rpgboss.editor.MapViewTools.Pencil
import rpgboss.player.MapAndAssets
import rpgboss.editor.MapLayers._
import rpgboss.model.DirectionMasks
import rpgboss.model.DirectionMasks.NONE


class RandomDecorations {

  val DecorationList: List[List[Int]] =
    List(
      List(1, 4, 5), List(1, 1, 4), List(1, 6, 9), List(1, 5, 9), List(1, 6, 10),
      List(1, 3, 6), List(3, 0, 9), List(4, 2, 3), List(4, 5, 0), List(4, 4, 3),
      List(4, 0, 2), List(4, 1, 14)
  )


  def getRandomLocation(): List[Int] = {

    val startX = 0: Int
    val endX  = RpgMap.initXSize: Int

    val startY = 0: Int
    val endY  = RpgMap.initYSize: Int

    val rnd = new scala.util.Random
    val x = startX + rnd.nextInt((endX - startX) + 1)
    val y = startY + rnd.nextInt((endY - startY) + 1)
    return List(x, y)

  }


  def placeDecorations(vs: MapViewState,
                       tCodes: Array[Array[Array[Byte]]]): Unit = {
    val pos = getRandomLocation(): List[Int]
    val x = pos.head
    val y = pos.tail.head

    // Grab random decoration from list
    val rnd = new scala.util.Random
    val decoNmbr = rnd.nextInt(DecorationList.length)
    val deco = DecorationList(decoNmbr)

    val byte_1 = deco.head
    val byte_2 = deco.tail.head
    val byte_3 = deco.tail.tail.head

    // Grab correct tile code
    val newTileCode = Array(Array(Array(
      byte_1.asInstanceOf[Byte], byte_2.asInstanceOf[Byte], byte_3.asInstanceOf[Byte])))
    Pencil.onMouseDown(vs, newTileCode, MapLayers.Top, x ,y)
    println(s"Placed decoration at ($x, $y)")
    // tCodes specifies which tile will be drawn
    // -> Find out the tile representation and how to select a random tile

  }

}

/* Decoration Tile Code Library
* 1 4 5  ~  hatchet in wood stump
* 1 1 4  ~  small bush
* 1 6 9  ~  grave
* 1 5 9  ~  stones
* 1 6 10 ~  pile of wood
* 1 3 6  ~  flower bush
* 3 0 9  ~  small table
* 4 2 3  ~  crystal
* 4 5 0  ~  mushrooms
* 4 4 3  ~  skeleton
* 4 0 2  ~  stones
* 4 1 14 ~  gold bars
*/