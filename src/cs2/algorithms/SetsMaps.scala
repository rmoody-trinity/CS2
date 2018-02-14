package cs2.algorithms

object SetsMaps {
  def setTests() {
    val s1 = scala.collection.immutable.Set[Int](1,2,3)
    println(s1)
    val s2 = scala.collection.immutable.Set[Int](3,4,5,6)
    println(s2)
    val s3 = s1 & s2  // Intersection: numbers that are in both
    println(s3)
    val s4 = s1 -- s2  // Difference: Takes away all the numbers in set 1 that are in set 2
    println(s4)
    val s5 = s1 ++ s2  // Union: Puts to the two sets together (note that they are random)
    println(s5)
    println(s1.contains(3))
    println(s5.contains(42))
    println(s1(3))
    println(s5(42))
    val s6 = scala.collection.mutable.Set[Int](1,2,3)
    s6 += 5
  }
  
  def countWords(filename:String):Int = {
    val in = scala.io.Source.fromFile(filename)
    val words = scala.collection.mutable.Set[String]()
    for(line <- in.getLines) {
      var linewords = line.split("\\s+") // \\s+ means one white space or more
      linewords = linewords.map(_.filter(_.isLetter).toLowerCase).filter(_.length > 0) //map to do it to every word, filter to filter punctuation and numbers
      words ++= linewords
    }
    words.size
  }
  
  
  def main(args:Array[String]) {
    println(countWords("tempest.txt"))
  }
}