package cs2.adt

class IterableSingleLinkList[A] extends SingleLinkList[A] {
  
  def iterator():scala.collection.Iterator[A] = {
    new scala.collection.Iterator[A] {
      var curr = head
      def next():A = {
        val tmp = curr.data
        curr = curr.next
        tmp
      }
      def hasNext():Boolean = {
        curr != null
      }
    }
  }
}

import org.junit._
import org.junit.Assert._

class IterableSingleLinkListTester {
  var isll:IterableSingleLinkList[Int] = null
  
  @Before def init() {
    isll = new IterableSingleLinkList[Int]()
    for(i <- 1 to 20 by 2) isll.append(i)
  }
  
  @Test def checkIterator() {
    val it = isll.iterator()
    var expected = 1
    while(it.hasNext) {
      val data = it.next
      assertTrue(data == expected)
      expected += 2
    }
    assertTrue(it.hasNext == false)
  }
  
}