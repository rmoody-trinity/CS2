package cs2.adt

class SingleLinkList[A] extends List[A] {
  protected class Node(var data:A, var next:Node)
  protected var head:Node = null
  protected var len:Int = 0
  
  private def getNodeByIndex(idx:Int):Node = {
    var rover:Node = head
    for(i <- 1 to idx) {
      rover = rover.next
    }
    rover
  }
  
  def get(idx:Int):A = getNodeByIndex(idx).data
  def set(idx:Int, elem:A) {
    getNodeByIndex(idx).data = elem
  }
  
  def insert(idx:Int, elem:A) {
    len += 1
    if(idx == 0) {
      head = new Node(elem, head)
    } else {
      val before = getNodeByIndex(idx -1)
      before.next = new Node(elem, before.next)
    }
  }
  
  def remove(idx:Int):A = {
    len -= 1
    if(idx == 0) {
      val tmp = head.data
      head = head.next
      tmp
    } else {
      val before = getNodeByIndex(idx -1)
      val tmp = before.next.data
      before.next = before.next.next
      tmp
    }
  }
  
  def length():Int = len
  
}