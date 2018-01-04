package mapGenerator
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks
import rpgboss.editor.map_generator.Container

class ContainerSpec extends FlatSpec  with Matchers with TableDrivenPropertyChecks  {

  "A container with boundaries" should "be created" in{
    val container = new Container(0, 0, 20, 40)
  }
  it should "return a point as a pair" in{
    val container = new Container(0, 0, 20, 40)
    val point = container.point(5, 15)
  }
  it should "retrun a sys.error" in{
    val container = new Container(0, 0, 20, 40)


    val thrown = intercept[Exception] { //catch the exception that is thrown
      container.point(-2, 60)
      container.point(5, 60)
      container.point(6, -1)
      container.point(90, 10)

    }
    assert(thrown.getMessage === "Point is out of range of the container")
  }
}
