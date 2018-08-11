import java.net.NoRouteToHostException

import Bearing.Bearing
import apple.laf.JRSUIConstants.NothingToScroll

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {

  def turnRight(): Robot = {
    bearing match {
      case Bearing.North => Robot(Bearing.East, coordinates)
      case Bearing.South => Robot(Bearing.West, coordinates)
      case Bearing.East => Robot(Bearing.South, coordinates)
      case Bearing.West => Robot(Bearing.North, coordinates)
    }
  }

  def turnLeft(): Robot = {
    bearing match {
      case Bearing.North => Robot(Bearing.West, coordinates)
      case Bearing.South => Robot(Bearing.East, coordinates)
      case Bearing.East => Robot(Bearing.North, coordinates)
      case Bearing.West => Robot(Bearing.South, coordinates)
      case _ => this
    }
  }

  def advance(): Robot = {
    bearing match {
      case Bearing.North => Robot(bearing, (coordinates._1, coordinates._2 + 1))
      case Bearing.South => Robot(bearing, (coordinates._1, coordinates._2 - 1))
      case Bearing.East => Robot(bearing, (coordinates._1 + 1, coordinates._2))
      case Bearing.West => Robot(bearing, (coordinates._1 - 1, coordinates._2))
    }
  }

  def simulate(path: String): Robot = {
    def calculate(chars: List[Char], currRobo: Robot): Robot = {
     // println(s"Current state --  $currRobo <===> $chars")
      if (chars.isEmpty) {
        currRobo
      } else {
        chars.head match {
          case 'L' => calculate(chars.tail, currRobo.turnLeft())
          case 'R' => calculate(chars.tail, currRobo.turnRight())
          case 'A' => calculate(chars.tail, currRobo.advance())
          case _ => calculate(chars.tail, currRobo)
        }
      }
    }

    calculate(path.toList, this)
  }

}

object Bearing extends Enumeration {
  type Bearing = Value
  val North, South, East, West = Value
}


//zkxs's solution

//import Bearing._
//
//case class Robot(bearing: Bearing, coordinate: Coordinate) {
//  def coordinates = (coordinate.x, coordinate.y)
//  def turnLeft: Robot = Robot(bearing.left, coordinate)
//  def turnRight: Robot = Robot(bearing.right, coordinate)
//  def advance: Robot = Robot(bearing, coordinate + bearing.transform)
//  def simulate(commands: String): Robot = simulate(commands.toList)
//  def simulate(commands: List[Char]): Robot = {
//    commands.foldLeft(this)((robot, char) => robot.charToCommand(char).apply)
//  }
//
//  def charToCommand(char: Char): () => Robot = {
//    char match {
//      case 'L' => turnLeft _
//      case 'R' => turnRight _
//      case 'A' => advance _
//    }
//  }
//}
//
//// shim to convert coordinate tuples to the actual parameters I use
//object Robot {
//  def apply(bearing: Bearing, coordinate: (Int, Int)): Robot = {
//    Robot(bearing, Coordinate(coordinate._1, coordinate._2))
//  }
//}