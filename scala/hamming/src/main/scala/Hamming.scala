object Hamming {

  def distance(a: String, b: String): Option[Int] = {

    if(a.length != b.length){
      return None
    } else {
       return Some(a.zip(b).count(p => p._1 != p._2))
    }
  }

  // def hamming(a: String, b: String, count: Integer): Option[Int] = {
  //
  //   if (a.length != b.length)  return None
  //
  //   if (a.length > 0 && b.length > 0) {
  //     if (a.head == b.head) {
  //       return hamming(a.tail, b.tail, count)
  //     } else {
  //       return hamming(a.tail, b.tail, (count + 1))
  //     }
  //   } else {
  //     return Some(count);
  //   }
  // }
}
