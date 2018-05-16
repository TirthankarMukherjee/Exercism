object Leap {
  def leapYear(year: Int): Boolean =  {
      return ((isDivisibleBy4(year) && !isDivisibleBy100(year)) || (isDivisibleBy4(year) && (isDivisibleBy100(year) && isDivisibleBy400(year))))
  }

  def isDivisibleBy4(year: Int): Boolean = {
    return (year % 4) == 0
  }

  def isDivisibleBy100(year: Int): Boolean = {
    return (year % 100) == 0
  }

  def isDivisibleBy400(year: Int): Boolean = {
    return (year % 400) == 0
  }
}
