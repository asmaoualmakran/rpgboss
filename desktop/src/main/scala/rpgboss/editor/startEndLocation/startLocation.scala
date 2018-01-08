package rpgboss.editor.startEndLocation
import rpgboss.editor.{MapViewState, StateMaster}
import rpgboss.editor.misc.GraphicsUtils.TileRect
import rpgboss.model._


/* This class will create an new starting location and save it into the project data */
class StartLocation(
                     sm: StateMaster,
                     vs: MapViewState,
                     yTile: Int,
                     xTile: Int,
                     mapname: String
                   ) {

  val projData = sm.getProjData
  val oldStartingLoc = sm.getProjData.startup.startingLoc
  val newStartingLoc =
    MapLoc(mapname, xTile, yTile)

  projData.startup.startingLoc = newStartingLoc
  sm.setProjData(projData)

}




