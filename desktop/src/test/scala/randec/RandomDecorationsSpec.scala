package randec

import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.randec._
import rpgboss.editor.{MapLayers, MapViewState, UnitSpec}
import rpgboss.model.resource.RpgMap

import scala.collection.mutable.ListBuffer

class RandomDecorationsSpec extends UnitSpec{

 // val vs = mock[MapViewState]

////////////////////////////////
//// randomDecorations

  val ranDec = new RandomDecorations()

  "DecorationList" should "contain a list of lists of integers" in{
    ranDec.DecorationList shouldBe a [List[List[Int]]]
  }


  "randomDecorations" should "maintain a reasonable number of decorations" in{
    val nod = ranDec.NumberOfDecorations  // nod -> number of decorations

    nod should (be >= 0 and be <=  RpgMap.maxXSize * RpgMap.maxYSize)
  }
/*
////////////////////////////////
//// randomLocation

  val ranLoc = new randomLocation(vs)

  "a location" should "be a list of integers with length 2" in {
    val pos = ranLoc.getLocation()
    pos should have length (2)
    pos shouldBe a [List[Int]]
  }

  it should "be a list of integers with length 2" in {
    val pos = ranLoc.getLocation()
    val x = pos.head
    val y = pos.tail.head

    x should (be >= 0 and be <= RpgMap.maxXSize)
    y should (be >= 0 and be <= RpgMap.maxYSize)
  }

  it should "be good enough" in{
    var ge = new ListBuffer[Boolean]()
    ge += ranLoc.goodEnough(-1, 4)
    ge += ranLoc.goodEnough(4, -1)
    ge += ranLoc.goodEnough(9999, 9999)
    ge should not contain (true)
  }

  "tileOccupation" should "return the tile occupation of a certain position" in{

    val ranLoc = new randomLocation(vs)

    val pos = ranLoc.getLocation()
    val x = pos.head
    val y = pos.tail.head

    val tCodes = new decoration(1, 1, 4).getCode  //small bush for testing purposes

    ranLoc.tileOccupation(x, y) should be (0)
    Pencil.onMouseDown(vs, tCodes, MapLayers.Top, x, y)
    ranLoc.tileOccupation(x, y) should be (1)
  }



////////////////////////////////
//// placeDecorations

  val placeDec = new placeDecoration(vs)

  "placeDecorations" should "get a valid location" in {
    val pos = placeDec.getLoc()
    val x = pos.head
    val y = pos.tail.head
    ranLoc.goodEnough(x, y) should be (true)

  }

  it should "use a valid decoration" in {
    val dec = placeDec.getDec()
    ranDec.DecorationList should contain (dec)
  }



*/
}
