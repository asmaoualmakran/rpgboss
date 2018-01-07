package rpgboss.editor.dialog.RandomLocations

import scala.swing._
import rpgboss.editor.uibase.SwingUtils._

import scala.swing.event._
import rpgboss.model.event._
import rpgboss.editor.uibase._

import scala.collection.mutable.ArrayBuffer
import scala.swing.TabbedPane.Page
import rpgboss.model._
import rpgboss.editor.{MapViewState, StateMaster}
import java.awt.Dimension

import rpgboss.editor.uibase.StdDialog
import rpgboss.editor.resourceselector.SpriteField
import javax.swing.BorderFactory

import rpgboss.lib.Utils
import rpgboss.model.MapLoc
import rpgboss.model.event.RpgEvent
import rpgboss.editor.Internationalized._


class StartEndLocationDialog (owner: Window,
                              vs: MapViewState,
                          sm: StateMaster, onOk: () => Any,
                          onCancel: () => Any
                         )
  extends StdDialog(owner, getMessageColon("Random_Start_Stop_position")) {

  centerDialog(new Dimension(500, 400))





  def okFunc() = {
    onOk()
    close()
  }

  val startEndPanel = new StartEndLocationPanel(
    owner,
    vs,
    sm
  )

  contents = new BoxPanel(Orientation.Vertical) {
    contents += startEndPanel
    contents += new DesignGridPanel {
      addButtons(okBtn, cancelBtn)

    }}
}

