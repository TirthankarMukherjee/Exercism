object PerfectNumbers {

  import NumberType._


  def classify(n : Int) : Either[String, NumberType] = {
    if(n <= 0 ) return Left("Classification is only possible for natural numbers.")

  //  val seq:Seq[Int]  = for ( f <- 1 to n/2 if(n % f) == 0 ) yield f
    (1 to n/2).filter(n % _ == 0).sum match {
      case x if x > n => Right(NumberType.Abundant)
      case x if x == n => Right(NumberType.Perfect)
      case x if x < n => Right(NumberType.Deficient)
    }
  }


}

object NumberType extends Enumeration {
        type NumberType = Value
        val Perfect, Abundant, Deficient = Value
  }