package rpgboss.editor.randec

import rpgboss.editor.MapViewState
import rpgboss.model.RpgMapData
import rpgboss.model.resource.RpgMap
import rpgboss.model.resource.RpgMap._


class RandomLocation(vs: MapViewState){

  val mapData: RpgMapData = vs.sm.getMapData(vs.mapName)
  //val mapData: RpgMapData = map.readMapData().get
  mapData.sanitizeForMetadata(vs.mapMeta)

  val startX: Int = 0
  val endX: Int = RpgMap.initXSize

  val startY: Int = 0
  val endY: Int = RpgMap.initYSize

  def goodEnough(x: Int, y: Int): Boolean ={
    withinBounds(x, y) && tileOccupation(x, y) == 0
  }

  def getLocation(): List[Int] = {


    val rnd = new scala.util.Random
    val x = startX + rnd.nextInt((endX - startX) + 1)
    val y = startY + rnd.nextInt((endY - startY) + 1)


    if (goodEnough(x, y)) {
      List(x, y)
    } else {
      println(s"unfit location ($x, $y) ~ retrying...")
      getLocation()
    }

  }

  def withinBounds(x: Int, y: Int): Boolean = {
    x < endX && y < endY && x >= 0 && y >= 0
  }

  def tileOccupation(x: Int, y: Int):Int = {

    /*
    return 1 == tile occupied
    return 0 == tile free
     */

    val xIdx = x * bytesPerTile
    var occupied = 0

    // Test top layer first, as if the top layer provides an answer, there is
    // no need to test subsequent layers
    for (layerAry <- List(mapData.topLayer, mapData.midLayer, mapData.botLayer)) {
      val row = layerAry(y)
      val byte1 = row(xIdx)
      val byte2 = row(xIdx + 1)
      val byte3 = row(xIdx + 2)

     // println(s"byte123: $byte1, $byte2, $byte3")

      if(byte1 != -1 && byte1 != -2){
        occupied = 1
      }
    }
    occupied
  }


}
