
object Etl {

  def transform(scores: Map[Int, Seq[String]]): Map[String, Int] = {
    var returnMap = Map[String, Int]()
    //  scores.map(x => x.values.map(y => returnMap + (y.toLowerCase -> x.key)))
    scores map { case (key, value) => (value.map(x => (returnMap += (x.toLowerCase -> key)))) }

    return returnMap
  }
}
