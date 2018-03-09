package cs2.adt

class ArrayStack[A:Manifest] extends Stack[A] {
  private var arr:Array[A] = new Array[A] (10)
  private var top = 0
  
  def push(elem:A) {
    if(top >= arr.length) {
      val tmp = new Array[A](arr.length * 2)
      for (i <- 0 until arr.length) tmp(i) = arr(i)
      arr = tmp
    }
    arr(top) = elem
    top +=1
  }
  
  def pop():A = {
    top -= 1
    arr(top)
  }
  
  def peek():A = arr(top - 1)
  
  def isEmpty():Boolean = top == 0
  
}
