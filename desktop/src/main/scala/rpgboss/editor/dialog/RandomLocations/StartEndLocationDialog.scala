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
                          sm: StateMaster, onOk: (Int, Int, Int, Int, Int) => Any,
                          onCancel: () => Any
                         )
  extends StdDialog(owner, getMessageColon("Random_Start_Stop_position")) {

  centerDialog(new Dimension(500, 400))

  val startEndPanel = new StartEndLocationPanel(
    owner,
    vs,
    sm
  )

  /* Function to check if some value is not empty, if it is empty it will give an error */
  def testText(txt: String, msg: String): Int ={
    if (txt == "") {
      Dialog.showMessage(contents.head, getMessage(msg), getMessage("Error"),
        Dialog.Message.Error)
      0
    }
    else {
      Integer.parseInt(txt)
    }

  }


  /* Function to check if some value is bigger than 0, if not it will give an error */
  def testbiggerthan0(nmbr: Int, msg: String): Int ={
    if (nmbr > 0) {
      nmbr
    }
    else {
      Dialog.showMessage(contents.head, getMessage(msg), getMessage("Error"),
        Dialog.Message.Error)
      0

    }

  }

  def okFunc() = {
  /* Check if seed is filled in */
    var seed = testText(startEndPanel.seed.text, "seed_mandatory")
    /* Check if see Maximum Y value is filled in and if it is bigger than zero */
    var maxY = testText(startEndPanel.Maximum_Y.text, "maxY_mandatory")
    maxY = testbiggerthan0(maxY, "maxY_bigger")
    /* Check if see Maximum X value is filled in and if it is bigger than zero */
    var maxX = testText(startEndPanel.Maximum_X.text, "maxX_mandatory")
    maxX = testbiggerthan0(maxX, "maxX_bigger")
    /* Check if see Maximum distance value is filled in and if it is bigger than zero */
    var maxdis = testText(startEndPanel.MaxDistance.text, "maxdis_mandatory\"")
    maxdis = testbiggerthan0(maxdis, "maxdis_bigger")
    /* Check if see total events value is filled in */
    var totEvents = testText(startEndPanel.total_events.text, "totev_mandatory")

      onOk(seed, maxY, maxX, maxdis, totEvents)
    close()
  }



  contents = new BoxPanel(Orientation.Vertical) {
    contents += startEndPanel
    contents += new DesignGridPanel {
      addButtons(okBtn, cancelBtn)

    }}
}

