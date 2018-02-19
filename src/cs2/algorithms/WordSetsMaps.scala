package cs2.algorithms

object WordSetsMaps {
  def examplesOfSetMethods() {
    //Immutable set operations
    val s1 = scala.collection.immutable.Set[Int](1,2,3)
    println("s1 = " + s1.mkString(","))
    val s2 = scala.collection.immutable.Set[Int](6,7)
    println("s2 = " + s2.mkString(","))
    val s3 = s1 + 4
    println("s3 = s1 + 4 = " + s3.mkString(","))
    val s4 = s1 ++ s2
    println("s4 = s1 ++ s2 = " + s4.mkString(","))
    println("s1.contains(2) = " + s1.contains(2))
    println("s1(4) = " + s1(4))
    
    //Additional mutable set methods
    import scala.collection.mutable
    val m1 = mutable.Set[Int](1,2,3)
    println("m1 = " + m1)
    m1 += 5
    println("m1 += 5; then m1 = " + m1)
    val m2 = mutable.Set[Int](3,8,9)
    println("m2 = " + m2)
    m1 --= m2
    println("m1 --= m2; then m1 = " + m1)
    m1.add(4)
    println("m1.add(4); then m1 = " + m1)
    m2.remove(8)
    println("m2.remove(8); then m2 = " + m2)
    m2.clear()
    println("m2.clear; then m2 = " + m2)
    m1.retain((x:Int) => x%2 == 0)
    println("m1.retain(x => x%2==0); then m1 = " + m1)
  }
  
  def examplesOfMapMethods() {
    //Immutable maps
    import scala.collection.immutable
    val imap1 = immutable.Map[String,Int](("one",1), ("two",2), ("three",3), ("twenty",20))
    println("imap1 is " + imap1)
    println("imap1(\"three\") is " + imap1("three"))
    val imap2 = imap1 + ("fifty" -> 50)
    println("imap2 is " + imap2)
    val imap3 = imap1 - "one"
    println("imap3 is " + imap3)
    val imap4 = imap1.map(x => x._1*2 -> x._2*2)
    println("imap4 is " + imap4)
    
    //Mutable maps
    import scala.collection.mutable
    val mmap1 = mutable.Map('C' -> "Coconut")
    println("mmap1 is " + mmap1)
    mmap1('C') = "Crabapple"
    println("mmap1 is " + mmap1)
    mmap1('X') = "Xenofruit"
    println("mmap1 is " + mmap1)
    mmap1.clear
    println("mmap1 is " + mmap1)
    mmap1 += ('W' -> "Watermelon")
    println("mmap1 is " + mmap1)
    val mmap2 = mutable.Map('J' -> "Jelly")
    mmap2('L') = "Lemon"
    println("mmap2 is " + mmap2)
    mmap1 ++= mmap2
    println("mmap1 is " + mmap1)
  }
  
  /**
   * Function that creates a set of all unique words appearing in a file, and prints 
   * out those words one per line along with the total number of unique words
   */
  def wordsInFile(name:String) {
    val input = Source.fromFile(name)
    val words = new scala.collection.mutable.HashSet[String]()
    for(line <- input.getLines) {
      var linewords = line.split("\\s+")
      linewords = linewords.map(_.filter(_.isLetter).toLowerCase).filter(_.length > 0)
      words ++= linewords
    }
    for(word <- words) {
      println(word)
    }
    println(words.size)
  }
  
  /**
   * Function to count how often each word occurs within a file using Maps
   * Prints out words/counts per line
   */
  def countWordsInFile(name:String) {
    val input = Source.fromFile(name)
    val words = new scala.collection.mutable.HashMap[String,Int]()
    for(line <- input.getLines) {
      var linewords = line.split("\\s+")
      linewords = linewords.map(_.filter(_.isLetter).toLowerCase).filter(_.length > 0)
      for(word <- linewords) {
        if(!words.contains(word)) words(word) = 0
        words(word) += 1
      }
    }
    for( (k,v) <- words ) {
      println(k + ": " + v)
    }
  }

  /**
   * Main method to execute portions of script.  Comment/uncomment different lines to run
   * different aspects of the program.
   */
  def main(args:Array[String]) {    
    examplesOfSetMethods
    println("-"*40)
    examplesOfMapMethods
    //wordsInFile("tempest.txt")
    countWordsInFile("tempest.txt")
  }

}