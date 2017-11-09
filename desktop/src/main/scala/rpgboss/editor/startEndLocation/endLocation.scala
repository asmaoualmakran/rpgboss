package rpgboss.editor.startEndLocation

import rpgboss.editor.MapViewState
import rpgboss.model.SpriteSpec
import rpgboss.model.event.EventCmd.CommandList
import rpgboss.model.event.EventJavascript.{jsStatement, singleCall}
import rpgboss.model.event._

import scala.collection.mutable.ArrayBuffer

class endLocation(vs: MapViewState, x: Int, y: Int, totalEvents: Int) {
  /*
  Makes an end Location,
  This is an event that terminates the game
  It exists in two states,
  first one:
  If the character enters the state and presses the button:
  menu opens
  second one:
  If the character enters the state, it terminates the game

   */






  var cond: Array[Condition] = Array()
  var spriteName : String = "sys/!object.png"
  var spriteIx : Int = 2
  var sprite: SpriteSpec = SpriteSpec(name = spriteName, spriteIndex = spriteIx)
  var height: Int = EventHeight.UNDER.id
  var affixDirection: Boolean = false

  var trigger: Int = EventTrigger.BUTTON.id
  var animationType: Int = AnimationType.NONE.id
  var runOnceThenIncrementState: Boolean = false
  var evcmd = new EventCmd {
    override def sections: Array[CodeSection] = {singleCall("game.callMenu")}
  }
  var cmds: Array[EventCmd] = Array(evcmd)

  val state1 : RpgEventState = RpgEventState(conditions = cond, sprite = Some(sprite), height = height, affixDirection = affixDirection, trigger = trigger, animationType = animationType, runOnceThenIncrementState = runOnceThenIncrementState,cmds = cmds  )
  spriteIx = 0
  sprite = SpriteSpec(name = spriteName, spriteIndex = spriteIx)
  evcmd = new EventCmd {
    var conpar = new IntParameter(constant = 0, globalVariable = "finished")
    var conpar2 = new IntParameter(constant = totalEvents)
    var condition = new Condition(conditionTypeId = 1, intValue1 = conpar, intValue2 = conpar2)
    var conditions: Array[Condition] = Array()
    var elseBranch: Boolean = false
    var cmdif = new EventCmd {
      override def sections: Array[CodeSection] = Array(PlainLines(Array(jsStatement("game.gameOver"), "return;")))
    }
    var trueCmds: Array[EventCmd] = Array(cmdif)
    var elseCmds: Array[EventCmd] = Array()
    override def sections: Array[CodeSection] = {
      val buf = new ArrayBuffer[CodeSection]()

      buf += PlainLines(Array("if (%s) {".format(
        Condition.allConditionsExp(conditions).exp)))
      buf += CommandList(trueCmds, 1)

      if (elseBranch) {
        buf += PlainLines(Array("} else {"))
        buf += CommandList(elseCmds, 1)
      }

      buf += PlainLines(Array("}"))

      buf.toArray
    }
  }
  cmds = Array(evcmd)
  val state2 : RpgEventState = RpgEventState(conditions = cond, sprite = Some(sprite), height = height, affixDirection = affixDirection, trigger = trigger, animationType = animationType, runOnceThenIncrementState = runOnceThenIncrementState,cmds = cmds  )

  val id = vs.mapMeta.lastGeneratedEventId + 1
  val xloc = x + 0.5f
  val yloc = y + 0.5f
  var states : Array[RpgEventState] = Array(state1,state2)
  val event = new RpgEvent(id, "Event%05d".format(id), xloc, yloc, states)
}


