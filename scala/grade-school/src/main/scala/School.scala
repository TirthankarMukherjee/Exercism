// import collection._
//
// class School {
//
//   type DB = Map[Int, Seq[String]]
//
//   var studentDb =  new scala.collection.mutable.HashMap[Int , Seq[String]]
//
//   def add(name: String, g: Int) = {
//
//     val seq =   studentDb.getOrElse(g,  scala.collection.immutable.List[String]())
//     studentDb(g) =  seq :+ name
//   }
//
//   def db: DB = studentDb
//
//   def grade(g: Int): Seq[String] = {
//     return studentDb.getOrElse(g, scala.collection.immutable.List[String]())
//   }
//
//   def sorted: DB = {
//     val sortedSchoolMap = scala.collection.immutable.ListMap(studentDb.toSeq.sortWith(_._1 < _._1):_*)
//     return  sortedSchoolMap.mapValues(_.sortWith(_.compareTo(_) < 0))
//   }
// }

class School {

 type DB = Map[Int, Seq[String]]

  var schoolDB: DB = Map()

  def add(name: String, g: Int) = {
    schoolDB += (g -> (schoolDB.getOrElse(g, Seq.empty[String]) :+ name))
  }

  def db: DB = schoolDB

  def grade(g: Int): Seq[String] = schoolDB.getOrElse(g, Seq())

  def sorted: DB = schoolDB.mapValues(_.sorted).toSeq.sortBy(_._1).toMap
}
