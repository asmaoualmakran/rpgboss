package mapGenerator

import rpgboss.editor.BST.{BinarySearchTree, BinarySearchTreeIterator}
import rpgboss.editor.UnitSpec
import rpgboss.editor.map_generator.{Container, ContainerGenerator, MapGenerator}

class MapGeneratorSpec extends UnitSpec{

  "moet een map gener" should "test" in {
    val map = new MapGenerator(2, 4, 300, 300)
    map.findFinalChambers()
  }


}
