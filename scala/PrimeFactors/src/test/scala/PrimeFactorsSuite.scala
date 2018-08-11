import org.scalatest.{FunSuite, Matchers}

class PrimeFactorsSuite extends FunSuite with Matchers {

  val testSuite: List[(Int, List[Int])] = List(
    (2, List(2)),
    (3, List(3)),
    (4, List(2, 2)),
    (6, List(2, 3)),
    (7, List(7)),
    (9, List(3, 3)),
    (42, List(7, 3, 2))
  )

  testSuite foreach {
    case (n,f) => test(s"Prime factors for $n is $f"){
      PrimeFactors.of(n) should contain theSameElementsAs f
    }
  }

}