package cs2.adt

class DoubleLinkList[A:Manifest] extends List[A] {
  private class Node(var data:A, var prev:Node, var next:Node)
  
  private var end:Node = new Node(new Array[A](1)(0),null,null) //Sentinel typed as end
  end.prev = end
  end.next = end
  
  private var len:Int = 0
  
  private def getNodeByIndex(idx:Int):Node = {
    if(idx < 0 || idx >= len) end
    else {
      var rover = end.next
      for(i <- 1 to idx) rover = rover.next
      rover
    }
  }
  
  def get(idx:Int):A = getNodeByIndex(idx).data
  def set(idx:Int, elem:A) {
    getNodeByIndex(idx).data = elem
  }
  
  def insert(idx:Int, elem:A) {
    val rover = getNodeByIndex(idx)
    rover.prev.next = new Node(elem, rover.prev, rover)
    rover.prev = rover.prev.next
    len += 1
  }
  
  def remove(idx:Int):A = {
    val rover = getNodeByIndex(idx)
    rover.prev.next = rover.next
    rover.next.prev = rover.prev
    len -= 1
    rover.data
  }
  
  def length():Int = len

}