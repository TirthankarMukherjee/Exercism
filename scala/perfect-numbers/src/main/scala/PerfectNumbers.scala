object PerfectNumbers {

  import NumberType._


  def classify(n : Int) : Either[String, NumberType] = {
    if(n <= 0 ) return Left("Classification is only possible for natural numbers.")

    factors(n,1, List[Int]()).sum match {
      case x if x > n => Right(NumberType.Abundant)
      case x if x == n => Right(NumberType.Perfect)
      case x if x < n => Right(NumberType.Deficient)
    }
  }

  def factors(n : Int, f: Int, list : List[Int]) : List[Int] = {
    if((f-1) >= (n / 2)) return list
    (n % f) match {
      case 0 => factors( n, f + 1, f :: list)
      case _ => factors( n, f + 1, list)
    }
  }
}

object NumberType extends Enumeration {
        type NumberType = Value
        val Perfect, Abundant, Deficient = Value
  }