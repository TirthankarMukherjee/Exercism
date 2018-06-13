

object ArmstrongNumbers {

  def isArmstrongNumber(number: Integer): Boolean = {
    val armstrongNumber = number.toString.map(x => scala.math.pow(x.asDigit,number.toString.length)).sum
    return armstrongNumber == number
  }

}