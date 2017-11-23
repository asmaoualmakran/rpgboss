package rpgboss.editor.map_generator

import rpgboss.editor.BST.BST
import scala.util.Sorting

class MapGenerator(iterations:Int, seed:Int, canvas_height: Int, canvas_width:Int) {

      val start_container  = new Container(0, 0, canvas_height, canvas_width )



  object ContainerOrdering extends Ordering[Container] {
    def compare(a:Container, b:Container) = a.size() compare b.size()
  }

}
