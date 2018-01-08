package mapGenerator

import rpgboss.editor.UnitSpec
import rpgboss.editor.map_generator.{Container, ContainerGenerator}

class ContainerGeneratorSpec extends UnitSpec {

  "A container generator" should "be created" in{
    val container = new Container(0, 40, 0, 60)
    val gen = new ContainerGenerator(container, 4, 5)
  }
  it should "Generate a list of the next containers" in{
    val container = new Container(0, 40, 0, 60)
    val gen = new ContainerGenerator(container, 4, 5)
    gen.initStack()
    gen.next()
  }

}
