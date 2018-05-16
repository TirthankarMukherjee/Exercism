object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int) : Int = {
    val seqMultiples = factors.foldLeft(Seq.empty[Int]){ (acc, i) => acc ++ listOfMultiples(i, limit) }
    return seqMultiples.distinct.sum
  }

  def listOfMultiples(num: Int, limit: Int) : Seq[Int] = {
    val retVal = for(i <- 0 to 10000 if nextMultiple(num,i) < limit) yield nextMultiple(num,i)
    return retVal
  }

  def nextMultiple(num: Int, multiple: Int) : Int = {
    return (multiple + 1 ) * num
  }
}

/* Nice Solutions */

/*

object SumOfMultiples {

  def sum(factors: Set[Int], limit: Int): Int = {
    factors.flatMap(f => (1 until limit).filter(n => n %f == 0)).sum
  }

}

*/

/*

object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val numbers = for {
      factor <- factors
      num <- 0 until limit
      if num % factor == 0
    } yield num
    numbers.sum
  }
}

*/
