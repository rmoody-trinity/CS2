package cs2.adt

class LinkedStack[A] extends Stack[A] {
  private class Node (var data:A, var next:Node)
  private var head:Node = null
  
  def push(elem:A) {
    head = new Node(elem, head)
  }
  
  def pop():A = {
    assert(head != null)
    var ret = head.data
    head = head.next
    ret
  }
  
  def peek():A = {
    assert(head != null)
    head.data
  }
  
  def isEmpty():Boolean = head == null
}