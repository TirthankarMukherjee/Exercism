// object FlattenArray{
//
//   def flatten(list : List[Any]) : List[Int] = {
//
//     return flatAndAcc(list,  List[Int]())
//   }
//
//   def flatAndAcc(list : List[Any], accumulatedList : List[Int]) : List[Int] = {
//   //  println("List == " +list.mkString +"  AccList == " + accumulatedList.mkString)
//     if(list.isEmpty || list == null || list.head == null) {
//       return accumulatedList
//     }
//     else if( ! list.head.isInstanceOf[Int] ) {
//       return flatAndAcc(list.tail, flatAndAcc( list.head.asInstanceOf[List[Any]].toList, accumulatedList ) )
//     } else {
//       return flatAndAcc( list.tail, accumulatedList :+ list.head.asInstanceOf[Int].toInt)
//     }
//   }

object FlattenArray {
  def flatten(list: List[Any]): List[Any] = {
    list.flatMap {
      case value : List[_] => flatten(value)
      case value : Int => List(value)
      case _ => List()
    }
  }
}
