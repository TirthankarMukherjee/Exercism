// object Bob {
//   def response(statement: String): String = {
//
//     if(isInterrogative(statement) && isAllCaps(statement) && (lengthOfOnlyLetters(statement) > 0)) {
//       return "Calm down, I know what I'm doing!"
//     }else if(isBlank(statement)) {
//       return "Fine. Be that way!"
//     }else if(isAllCaps(statement) && (lengthOfOnlyLetters(statement) > 0))  {
//       return "Whoa, chill out!"
//     }else if(isInterrogative(statement)) {
//       return "Sure."
//     }else {
//       return "Whatever."
//     }
//   }
//
//   def isExclaimatory(statement: String): Boolean = {
//     return statement.trim.endsWith("!")
//   }
//   def isInterrogative(statement: String): Boolean = {
//     return statement.trim.endsWith("?")
//   }
//   def isAllCaps(statement: String): Boolean = {
//     return (statement == statement.toUpperCase)
//   }
//
//   def lengthOfOnlyLetters(statement : String) : Int = {
//     return statement.filter(_.isLetter).trim.length
//   }
//   def isBlank(statement: String): Boolean = {
//     return statement.trim.length == 0
//   }
// }

/*
object Bob {
  def response(statement: String): String = statement.trim match {
    case st if st.isEmpty => "Fine. Be that way!"
    case st if question(st) && shouting(st) =>
      "Calm down, I know what I'm doing!"
    case st if question(st) =>
      "Sure."
    case st if shouting(st) =>
      "Whoa, chill out!"
    case _ => "Whatever."
  }
  def question(statement: String): Boolean =
    return statement.takeRight(1) == "?"
  def shouting(statement : String): Boolean =
    return statement.exists(_.isLetter) && statement.filter(_.isLetter).forall(_.isUpper)
}
*/

/*

object Bob {
  def response(statement: String): String = statement match {
    case shoutQ if shoutQ.toUpperCase == shoutQ && shoutQ.toLowerCase != shoutQ && shoutQ.trim.endsWith("?") =>"Calm down, I know what I'm doing!"
    case shout if shout.toUpperCase == shout && shout.toLowerCase != shout => "Whoa, chill out!"
    case question if question.trim.endsWith("?") => "Sure."
    case nothing if nothing.trim.isEmpty => "Fine. Be that way!"
    case _ => "Whatever."
  }
}

*/


object Bob {
  def response(statement: String): String = statement.trim match {
    case s if s.isEmpty                                               => "Fine. Be that way!"
    case s if isUppercase(s) && containsLetters(s) && s.endsWith("?") => "Calm down, I know what I'm doing!"
    case s if isUppercase(s) && containsLetters(s)                    => "Whoa, chill out!"
    case s if s.endsWith("?")                                         => "Sure."
    case _                                                            => "Whatever."
  }

  private def isUppercase(str: String) = str.toUpperCase == str
  private def containsLetters(str: String) = str.matches(".*[A-Za-z].*")
}
