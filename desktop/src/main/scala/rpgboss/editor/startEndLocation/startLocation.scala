package rpgboss.editor.startEndLocation
import rpgboss.editor.StateMaster
import rpgboss.editor.misc.GraphicsUtils.TileRect
import rpgboss.model._


class StartLocation(
                     sm: StateMaster,
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




