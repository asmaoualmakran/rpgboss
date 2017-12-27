package rpgboss.editor

import rpgboss.model.resource.RpgMap
import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.imageset.selector.TabbedTileSelector


class RandomDecorations (projectPanel: ProjectPanel,
                         sm: StateMaster,
                         tileSelector: TabbedTileSelector)
  extends MapEditor (projectPanel, sm, tileSelector){

  val DecorationList: List[List[Int]] =
    List(
      List(1, 4, 5), List(1, 1, 4), List(1, 6, 9), List(1, 5, 9), List(1, 6, 10),
      List(1, 3, 6), List(3, 0, 9), List(4, 2, 3), List(4, 5, 0), List(4, 4, 3),
      List(4, 0, 2), List(4, 1, 14)
    )

  val NumberOfDecorations = 5
  var iteration = 0


  def getRandomLocation(): List[Int] = {

    val startX = 0: Int
    val endX = RpgMap.initXSize: Int

    val startY = 0: Int
    val endY = RpgMap.initYSize: Int

    val rnd = new scala.util.Random
    val x = startX + rnd.nextInt((endX - startX) + 1)
    val y = startY + rnd.nextInt((endY - startY) + 1)

    def withinBounds(x: Int, y: Int) = {
      x < endX && y < endY && x >= 0 && y >= 0
    }

    if (withinBounds(x, y)) {
      List(x, y)
    } else {
      getRandomLocation()
    }

  }


  def placeDecorations(vs: MapViewState): Unit = {

    if (NumberOfDecorations == iteration) {
      iteration -= NumberOfDecorations
    } else {
      iteration += 1

      // Get random x and y
      val pos = getRandomLocation(): List[Int]
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

      val tCode = Array(Array(Array(
        int1.asInstanceOf[Byte], int2.asInstanceOf[Byte], int3.asInstanceOf[Byte])))

      // Decorations belong on the top layer
      val selectedLayer = MapLayers.Top

      vs.begin()

      val changedRegion =
        Pencil.onMouseDown(vs, tCode, selectedLayer, x, y)
      repaintRegion(changedRegion)

      commitVS(vs)
      println(s"Placed decoration $decoration at ($x, $y)")

      placeDecorations(vs)
    }


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