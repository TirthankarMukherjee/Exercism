import scala.annotation.tailrec

object PrimeFactors {

  def of(num: Int): List[Int] = {
    @tailrec
    def loop(currentNum: Int, candidate: Int, acc: List[Int]): List[Int] = {
      if (currentNum < 2) acc
      else currentNum % candidate match {
        case 0 => loop(currentNum / candidate, candidate, candidate :: acc)
        case _ => loop(currentNum, candidate + 1, acc)
      }
    }

    loop(num, 2, Nil)
  }

}
