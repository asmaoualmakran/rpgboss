package rpgboss.editor.startEndLocation


import rpgboss.editor.{MapViewState, StateMaster}
import rpgboss.model._

class randomLocation(
                      vs: MapViewState,
                      totalEvents: Int,
                      sm: StateMaster,
                      mapname: String,
                      maxDistance: Int,
                      maxX: Int,
                      maxY: Int,
                    ) {
  def testLocation(location: MapLoc): Unit ={
    return true
  }

  def makeEndLocation(subLoc: Int): Unit ={
    val dubLocX = rnd.nextInt(2 * maxDistance)
    var loc = 1
    if((subLoc - maxDistance) > 0 ){
      loc = subLoc + (dubLocX - maxDistance)
    }
    loc


  }



  val rnd = new scala.util.Random
  var startLocX = rnd.nextInt( maxX )
  var startLocY = rnd.nextInt(maxY)
  var endLocX = makeEndLocation(startLocX)
  var endLocY = makeEndLocation(startLocY)



}

