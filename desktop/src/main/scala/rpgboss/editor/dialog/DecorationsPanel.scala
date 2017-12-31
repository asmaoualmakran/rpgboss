package rpgboss.editor.dialog

import rpgboss.editor.StateMaster
import rpgboss.editor.uibase.DesignGridPanel

import scala.swing.{Label, TextField, Window}

class DecorationsPanel (owner: Window,
                         sm: StateMaster) extends DesignGridPanel {


  def newField = new TextField {
    text = ""
    columns = 5
  }
  val exact_decorations = newField


  row().grid()
    .add(new Label("How Many?"))

  row().grid()
    .add(new Label("Exact number: ")).add(exact_decorations)


}
