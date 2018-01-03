package rpgboss.editor.randec

import rpgboss.editor.MapViewState
import rpgboss.model.RpgMapData
import rpgboss.model.resource.RpgMap
import rpgboss.model.resource.RpgMap._


class randomLocation(vs: MapViewState){

  val map = vs.map
  val mapData: RpgMapData = map.readMapData().get
  mapData.sanitizeForMetadata(map.metadata)

  def getLocation(): List[Int] = {

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
      println(s"unfit location ($x, $y) ~ retrying...")
      getLocation()
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

     // println(s"byte123: $byte1, $byte2, $byte3")

      if(byte1 != -1 && byte1 != -2){
        occupied = 1
      }
    }
    return occupied
  }


}
