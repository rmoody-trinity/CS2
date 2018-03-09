package cs2.adt

trait Queue[A] {
  def enqueue(elem:A)
  def dequeue():A
  def peek():A
  def isEmpty():Boolean
}

object Queue {
  def apply[A:Manifest]() = new LinkedQueue[A]()
}

import org.junit._
import org.junit.Assert._

class QueueTester {
  var q:Queue[Int] = null
  
  @Before def initQueue() {
    q = Queue[Int]()  
  }
  
  @Test def checkEnDeQueue() {
    assertTrue(q.isEmpty)
    for(i <- 0 to 100) {
      q.enqueue(i)
      assertTrue(!q.isEmpty)
      assertTrue(q.peek == 0)
    }
    for(i <- 0 to 100) {
      assertTrue(q.peek == i)
      assertTrue(q.dequeue == i)
    }
    assertTrue(q.isEmpty)
  }
  
}