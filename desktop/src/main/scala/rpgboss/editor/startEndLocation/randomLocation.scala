package rpgboss.editor.startEndLocation


import rpgboss.editor.{MapViewState, StateMaster}
import rpgboss.model._
import rpgboss.editor.startEndLocation.StartLocation
import rpgboss.editor.startEndLocation.EndLocation

class RandomLocation(
                      vs: MapViewState,
                      totalEvents: Int,
                      sm: StateMaster,
                      mapname: String,
                      maxDistance: Int,
                      maxX: Int,
                      maxY: Int,
                      seed: Int
                    )
/* This is a class that makes the random start and End location,
* it will generate random numbers for the start and end location.
* test if the locations are empty and if so it will place the start and end location.
* */
{
  val rnd = new scala.util.Random(seed)

  def testLocation(location: MapLoc): Boolean ={
    true
  }

  def makeEndLocation(subLoc: Int): Int ={
    val dubLocX: Int = rnd.nextInt(maxDistance)
    if((subLoc - maxDistance) > 0 ){
      subLoc - dubLocX
    }
    else{
      subLoc + dubLocX
    }
  }

  def endLocation(X: Int, Y: Int): Unit ={
    var endLocX: Int= makeEndLocation(X)
    var endLocY: Int = makeEndLocation(Y)
    var end = MapLoc(mapname, endLocX, endLocY)
    if(testLocation(end)){
      endX = endLocX
      endY = endLocY
    }else{
      endLocation(X, Y)
    }
  }
  var startX = 1
  var startY = 1
  var endX = 1
  var endY = 1

  def makeLocations(X: Int, Y: Int): Unit ={
    var startLocX = rnd.nextInt( maxX )
    var startLocY = rnd.nextInt(maxY)
    var start =
      MapLoc(mapname, startLocX, startLocY)
    if(testLocation(start)){
      startX - startLocX
      startY = startLocY
      endLocation(startLocX,startLocY)
    }
    else{makeLocations(X, Y)}

  }

  makeLocations(maxX,maxY)
  var start= new StartLocation(sm, startX, startY, mapname)
  var end = new EndLocation(vs, endX, endY, totalEvents)

}

