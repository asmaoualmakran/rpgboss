package rpgboss.editor.startEndLocation
import rpgboss.editor.StateMaster
import rpgboss.model._
/**

class startLocation(
                     sm: StateMaster,
                   ) {

  def repaintMapLoc(l: MapLoc) =
            repaintRegion(TileRect(l.x - 0.5f, l.y - 0.5f, 1, 1))

          val projData = sm.getProjData
          val oldStartingLoc = sm.getProjData.startup.startingLoc
          val newStartingLoc =
            MapLoc(vs.mapName, xTile.toInt + 0.5f, yTile.toInt + 0.5f)

          projData.startup.startingLoc = newStartingLoc
          sm.setProjData(projData)

          repaintMapLoc(oldStartingLoc)
          repaintMapLoc(newStartingLoc)
        })
      }


}
  */