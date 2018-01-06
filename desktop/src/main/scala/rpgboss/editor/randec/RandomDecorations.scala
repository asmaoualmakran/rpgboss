package rpgboss.editor.randec


class RandomDecorations(){

  val decorationList: List[List[Int]] =
    List(
      List(1, 4, 5),  List(1, 1, 4),  List(1, 6, 9),  List(1, 5, 9),  List(1, 6, 10),
      List(1, 3, 6),  List(3, 0, 9),  List(4, 2, 3),  List(4, 5, 0),  List(4, 4, 3),
      List(4, 0, 2),  List(4, 1, 14), List(1, 2 , 5), List(1, 3 , 5), List(1, 5, 5),
      List(1, 0, 4),  List(1, 2, 4),  List(1, 3, 4),  List(1, 4, 4),  List(1, 5, 4),
      List(1, 4, 9),  List(1, 5, 10), List(1, 7, 10), List(1, 5, 13), List(1, 6, 13),
      List(1, 7, 13), List(1, 5, 14), List(1, 6, 14), List(1, 7, 14), List(1, 5, 15),
      List(1, 6, 15), List(1, 7, 15), List(4, 5, 1),  List(4, 2, 2),  List(4, 0, 3),
      List(4, 4, 2),  List(4, 1, 13), List(4, 2, 13)
    )

  val scaryDecorationList: List[List[Int]] =
    List(
      List(1, 6, 9), List(4, 2, 3),  List(4, 5, 0), List(4, 4, 3),
      List(4, 0, 2), List(4, 2, 2),  List(4, 0, 3), List(4, 4, 2)
    )

  val natureDecorationList: List[List[Int]] =
    List(
      List(1, 1, 4), List(1, 3, 6), List(1, 2, 5), List(1, 3, 5),
      List(1, 0, 4),  List(1, 2, 4), List(1, 3, 4), List(1, 4, 4), List(1, 5, 4),
      List(1, 4, 9),  List(1, 5, 13), List(1, 6, 13),List(1, 7, 13),List(1, 5, 14),
      List(1, 6, 14), List(1, 7, 14), List(1, 5, 15),List(4, 5, 1), List(3, 0, 9)
    )

  val resourceDecorationList: List[List[Int]] =
    List(
      List(1, 4, 5), List(1, 5, 10), List(1, 5, 5), List(1, 5, 9), List(1, 6, 10),
      List(1, 7, 10), List(1, 6, 15), List(1, 7, 15), List(4, 1, 13), List(4, 1, 14), List(4, 2, 13)
    )

  var numberOfDecorations: Int = 0


}


/* Decoration Tile Code Library

Nature:
* 1 0 4  ~  2 small bushes
* 1 1 4  ~  small bush
* 1 2 4  ~  bigger bush
* 1 2 5  ~  moldy stump
* 1 3 4  ~  bush small petals
* 1 3 5  ~  wood stump
* 1 3 6  ~  flower bush
* 1 4 4  ~  white flower bush
* 1 4 9  ~  stone
* 1 5 13 ~  big round cactus
* 1 5 14 ~  bush
* 1 5 15 ~  long grass
* 1 5 4  ~  yellow flower bush
* 1 6 13 ~  cactus1
* 1 6 14 ~  small bushes
* 1 7 13 ~  cactus2
* 1 7 14 ~  cauliflowers
* 3 0 9  ~  small table
* 4 5 1  ~  weird plant
*
* Scary:
*
* 1 6 9  ~  grave
* 4 0 2  ~  stones
* 4 0 3  ~  stone
* 4 2 2  ~  big crystal
* 4 2 3  ~  crystal
* 4 4 2  ~  spiky stones
* 4 4 3  ~  skeleton
* 4 5 0  ~  mushrooms
*
* Resources:
*
* 1 4 5  ~  hatchet in wood stump
* 1 5 10 ~  logs
* 1 5 5  ~  wood block on stump
* 1 5 9  ~  stones
* 1 6 10 ~  pile of wood
* 1 7 10 ~  chopped wood
* 1 6 15 ~  turnips
* 1 7 15 ~  berries
* 4 1 13 ~  gold crate
* 4 1 14 ~  gold bars
* 4 2 13 ~  mud crate
*
*/