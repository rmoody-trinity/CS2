package cs2.adt

import org.junit.Before

trait Stack[A] {
  def push(elem:A)
  def pop():A
  def peek():A
  def isEmpty():Boolean
}

object Stack {
  def apply[A:Manifest]():ArrayStack[A] = new ArrayStack[A]()
}

import org.junit._
import org.junit.Assert._

class StackTester {
  var s:Stack[Int] = null

  @Before def initStack() {
    s = new ArrayStack[Int]()
  }
  
  @Test def checkEmpty() {
    assertTrue(s.isEmpty)
  }
  @Test def checkManyPushPop() {
    for(i <- 0 to 100) {
      s.push(i)
    }
    for(i <- 0 to 100) {
      val tmp = s.pop()
      assertTrue(tmp == 100 - i)
    }
    assertTrue(s.isEmpty)
  }
}