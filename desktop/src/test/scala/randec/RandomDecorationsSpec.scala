package randec

import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.randec._
import rpgboss.editor._
import rpgboss.model.resource.RpgMap

import scala.collection.mutable.ListBuffer


class RandomDecorationsSpec extends UnitSpec {

  // Initialize game to get valid MapViewState
  RpgDesktop.startup(new Array[String](0))
  val mainPanel = RpgDesktop.tempPanel
  val sm = mainPanel.smOpt.get
  val mapName = "Map000001.rpgmap"
  val vs = new MapViewState(sm, mapName)


  ////////////////////////////////
  //// Decoration
  "Decorations" should "have the correct type" in {
    val sDec = new ScaryDecoration
    sDec.decorationType should be (ScaryType)

    val nDec = new NatureDecoration
    nDec.decorationType should be (NatureType)

    val rDec = new ResourceDecoration
    rDec.decorationType should be (ResourceType)
  }

  it should "return valid tile codes" in {
    val dec = new ScaryDecoration
    val tCode = dec.getCode(1, 6, 9)
    tCode.isInstanceOf[Array[Array[Array[Byte]]]] should be (true)
  }

  it should "display their correct decoration type" in {
    val sDec = new ScaryDecoration
    sDec.decorationType.dType should be ("Scary")

    val nDec = new NatureDecoration
    nDec.decorationType.dType should be ("Nature")

    val rDec = new ResourceDecoration
    rDec.decorationType.dType should be ("Resource")
  }


  ////////////////////////////////
  //// RandomDecorations

  val ranDec = new RandomDecorations()

  "RandomDecorations" should "contain a list of only lists of integers" in {
    ranDec.decorationList.isInstanceOf[List[List[Int]]] should be(true)
    ranDec.decorationList.foreach(_.isInstanceOf[List[Int]] should be (true))
  }


  it should "maintain a reasonable number of decorations" in {
    val nod = ranDec.numberOfDecorations

    nod should (be >= 0 and be <= RpgMap.maxXSize * RpgMap.maxYSize)
  }


  ////////////////////////////////
  //// RandomLocation

  val ranLoc = new RandomLocation(vs)

  "RandomLocation" should "be a list of integers with length 2" in {
    val pos = ranLoc.getLocation()
    pos should have length (2)
    pos.isInstanceOf[List[Int]] should be(true)
  }

  it should "be a location within bounds" in {
    val pos = ranLoc.getLocation()
    val x = pos.head
    val y = pos.tail.head

    x should (be >= 0 and be <= RpgMap.maxXSize)
    y should (be >= 0 and be <= RpgMap.maxYSize)
  }

  it should "be able to detect impossible locations" in {
    val x = -1
    val y = 123
    ranLoc.withinBounds(x, y) should be (false)

  }

  it should "be 'good enough'" in {
    var nge = new ListBuffer[Boolean]
    nge += ranLoc.goodEnough(-1, 4)
    nge += ranLoc.goodEnough(4, -1)
    nge += ranLoc.goodEnough(9999, 9999)
    nge should not contain (true)

    var yge = new ListBuffer[Boolean]
    yge += ranLoc.goodEnough(0, 0)
    yge += ranLoc.goodEnough(RpgMap.initXSize - 1, RpgMap.initYSize - 1)
    yge += ranLoc.goodEnough(15, 20)
    yge should not contain (false)
  }
/*
  "tileOccupation" should "return the tile occupation of a certain position" in {

    val ranLoc = new RandomLocation(vs)

    /*
    val pos = ranLoc.getLocation()
    val x = pos.head
    val y = pos.tail.head
     */
    val x = 5
    val y = 5

    val dec = new ScaryDecoration
    val tCodes = dec.getCode(1, 6, 9)

    ranLoc.tileOccupation(x, y) should be(0)
    println(ranLoc.tileOccupation(x, y))
    vs.begin()
    Pencil.onMouseDown(vs, tCodes, MapLayers.Top, x, y)
    vs.commit()
    ranLoc.tileOccupation(x, y) should be(1)
    println(ranLoc.tileOccupation(x, y))
  }
*/

  ////////////////////////////////
  //// PlaceDecoration

  val placeDec = new PlaceDecoration(vs)

  "PlaceDecorations" should "get a valid location" in {
    val pos = placeDec.getLoc()
    val x = pos.head
    val y = pos.tail.head
    ranLoc.goodEnough(x, y) should be (true)
    ranLoc.goodEnough(-1, 5) should be (false)

  }

  it should "use a valid decoration" in {
    val dec = placeDec.getDec()
    ranDec.decorationList should contain (dec)
    dec.isInstanceOf[List[Int]] should be (true)
  }

  it should "modify numberOfDecorations correctly" in {

    placeDec.numberOfDecorations should be (0)
    val thisMuch: Int = 3
    placeDec.placeDecorations(thisMuch)
    placeDec.numberOfDecorations should be (thisMuch)
  }
}
