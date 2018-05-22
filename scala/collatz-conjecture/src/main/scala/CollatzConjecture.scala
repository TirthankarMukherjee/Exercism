object CollatzConjecture {

  def steps(number : Int) : Option[Int] = {
    collatz(number, 0)
  }

  def collatz(number : Int, stepCount : Int) : Option[Int] =  {
    number match {
      case number if number <= 0 => return None
      case 1 => return Some(stepCount)
      case number if number % 2 == 0 => collatz(number/2, stepCount + 1)
      case number if number % 2 != 0 => collatz( (number*3) + 1, stepCount + 1)
    }
  }

}
