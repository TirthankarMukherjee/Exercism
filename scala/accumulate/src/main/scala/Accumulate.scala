//for .. yeild is just cinverted to a map
// class Accumulate {
//   def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
//     for(value <- list) yield f(value)
//   }
// }


class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
    tailRecursion(f, list, List())
  }

  def tailRecursion[A, B](f: (A) => B, list : List[A], accumulatedList: List[B]) : List[B] = {
    if(list.isEmpty) return accumulatedList;
    else return tailRecursion(f, list.tail,  accumulatedList :+ f(list.head))
  }
}
