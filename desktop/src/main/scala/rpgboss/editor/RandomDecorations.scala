package rpgboss.editor

import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.imageset.selector.TabbedTileSelector
import rpgboss.model.RpgMapData
import rpgboss.model.resource.RpgMap
import rpgboss.model.resource.RpgMap._


class RandomDecorations (projectPanel: ProjectPanel,
                         sm: StateMaster,
                         tileSelector: TabbedTileSelector,
                         vs: MapViewState)
  extends MapEditor (projectPanel, sm, tileSelector){

  val project = sm.proj
  val map = vs.map
  val mapData: RpgMapData = map.readMapData().get
  mapData.sanitizeForMetadata(map.metadata)

  val DecorationList: List[List[Int]] =
    List(
      List(1, 4, 5),  List(1, 1, 4),  List(1, 6, 9),  List(1, 5, 9),  List(1, 6, 10),
      List(1, 3, 6),  List(3, 0, 9),  List(4, 2, 3),  List(4, 5, 0),  List(4, 4, 3),
      List(4, 0, 2),  List(4, 1, 14), List(1, 2 , 5), List(1, 3 , 5), List(1, 5, 5),
      List(1, 0, 4),  List(1, 2, 4),  List(1, 3, 4),  List(1, 4, 4),  List(1, 5, 4),
      List(1, 4, 9),  List(1, 5, 10), List(1, 7, 10), List(1, 5, 13), List(1, 6, 13),
      List(1, 7, 13), List(1, 5, 14), List(1, 6, 14), List(1, 7, 14), List(1, 5, 15),
      List(1, 6, 15), List(1, 7, 15), List(4, 5, 1),  List(4, 2, 2),  List(4, 0, 3),
      List(4, 4, 2),  List(4, 1, 13), List(4, 2, 13)
    )

  val NumberOfDecorations = 30
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

    if (withinBounds(x, y) && tileOccupation(x, y) == 0 ) {
      List(x, y)
    } else {
      println("unfit location ~ retrying...")
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
      println(s"Placed decoration ($int1, $int2, $int3) at ($x, $y)")

      placeDecorations(vs)
    }
  }


  def tileOccupation(xTile: Int, yTile: Int):Int = {

    /*
    return 1 == tile occupied
    return 0 == tile free
     */

    val xIdx = xTile * bytesPerTile
    var occupied = 0

    // Test top layer first, as if the top layer provides an answer, there is
    // no need to test subsequent layers
    for (layerAry <- List(mapData.topLayer, mapData.midLayer, mapData.botLayer)) {
      val row = layerAry(yTile)
      val byte1 = row(xIdx)
      val byte2 = row(xIdx + 1)
      val byte3 = row(xIdx + 2)

      println(s"byte123: $byte1, $byte2, $byte3")

      if(byte1 != -1 && byte1 != -2){
        occupied = 1
      }
    }
    return occupied
  }

}


/* Decoration Tile Code Library
* 1 0 4  ~  2 small bushes
* 1 1 4  ~  small bush
* 1 2 4  ~  bigger bush
* 1 2 5  ~  moldy stump
* 1 3 4  ~  bush small petals
* 1 3 5  ~  wood stump
* 1 3 6  ~  flower bush
* 1 4 4  ~  white flower bush
* 1 4 5  ~  hatchet in wood stump
* 1 4 9  ~  stone
* 1 5 10 ~  logs
* 1 5 13 ~  big round cactus
* 1 5 14 ~  bush
* 1 5 15 ~  long grass
* 1 5 4  ~  yellow flower bush
* 1 5 5  ~  wood block on stump
* 1 5 9  ~  stones
* 1 6 10 ~  pile of wood
* 1 6 13 ~  cactus1
* 1 6 14 ~  small bushes
* 1 6 15 ~  turnips
* 1 6 9  ~  grave
* 1 7 10 ~  chopped wood
* 1 7 13 ~  cactus2
* 1 7 14 ~  cauliflowers
* 1 7 15 ~  berries
* 3 0 9  ~  small table
* 4 0 2  ~  stones
* 4 0 3  ~  stone
* 4 1 13 ~  gold crate
* 4 1 14 ~  gold bars
* 4 2 13 ~  mud crate
* 4 2 2  ~  big crystal
* 4 2 3  ~  crystal
* 4 4 2  ~  spiky stones
* 4 4 3  ~  skeleton
* 4 5 0  ~  mushrooms
* 4 5 1  ~  weird plant
*/