package rpgboss.editor.dialog.RandomLocations


import rpgboss.editor.{MapViewState, StateMaster}
import rpgboss.editor.uibase.SwingUtils._
import rpgboss.model.MapLoc

import scala.swing.{Action, BoxPanel, Button, Dialog, FlowPanel, Label, MainFrame, SimpleSwingApplication, TabbedPane, TextField, Window}
import rpgboss.editor.uibase.DesignGridPanel
import rpgboss.model.event.RpgEventState
import rpgboss.lib.Utils

import scala.swing.TabbedPane.Page
import rpgboss.model.RpgMapData
import rpgboss.editor.Internationalized._

class StartEndLocationPanel (owner: Window,
                             vs: MapViewState,
                         sm: StateMaster) extends DesignGridPanel {

  def newField = new TextField {
    text = "0"
    columns = 5
  }
  val total_events = newField
  val MaxDistance = newField
  val Maximum_X = newField
  val Maximum_Y = newField
  val seed = newField


  row().grid()
    .add(new Label("Location_Settings"))

  row().grid()
    .add(new Label("Maximum_Distance_Between_Start_And_End")).add(MaxDistance)
  row().grid()
    .add(new Label("Maximum_X_Location")).add(Maximum_X)
  row().grid()
    .add(new Label("Maximum_Y_Location")).add(Maximum_Y)

  row().grid()
    .add(new Label("Seed"))

  row().grid()
    .add(new Label("Give_a_seed_number")).add(seed)
  row().grid()
    .add(new Label("Give_a_maximum_events")).add(total_events)


}
