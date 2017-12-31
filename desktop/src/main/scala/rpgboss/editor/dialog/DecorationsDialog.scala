package rpgboss.editor.dialog

import java.awt.Dimension

import rpgboss.editor.Internationalized._
import rpgboss.editor.StateMaster
import rpgboss.editor.uibase.{StdDialog, _}

import scala.swing._



class DecorationsDialog (owner: Window,
                         sm: StateMaster,
                         onOk: (Int) => Any)
  extends StdDialog(owner, getMessageColon("Random_Decorations")) {

  centerDialog(new Dimension(120, 50))


  val DecorationsPanel = new DecorationsPanel(
    owner,
    sm
  )

  def okFunc() = {
    val check = DecorationsPanel.exact_decorations.text
    if (check == "") {
      Dialog.showMessage(contents.head, "Please input a value.", title = "Error")
    } else {

      val nod = DecorationsPanel.exact_decorations.text.toInt
      if (nod < 0 || nod > 3000) {
        Dialog.showMessage(contents.head, "Range: 0 -> 3000", title = "Error")
      } else {
        onOk(nod)
        close()
      }
    }
  }

  contents = new BoxPanel(Orientation.Vertical) {
    contents += DecorationsPanel
    contents += new DesignGridPanel {
      addButtons(okBtn, cancelBtn)

    }}
}



