package cs2.adt

class ArrayQueue[A:Manifest] extends Queue[A] {
  private var arr:Array[A] = new Array[A](10)
  private var begin:Int = 0
  private var len:Int = 0
  
  def length():Int = len
  def size():Int = len
  
  override def enqueue(elem:A) {
		if(len == arr.length) {
			val tmp = new Array[A](arr.length * 2)
			for(i <- 0 until len) tmp(i) = arr((begin + i) % arr.length)
			arr = tmp
			begin = 0
		}
		arr((begin + len) % arr.length) = elem
		len += 1
	}
	
	override def dequeue():A = {
		val retval = arr(begin)
		begin = (begin + 1) % arr.length
		len -= 1
		retval
	}
	
	override def peek():A = {
		arr(begin)
	}
	
	override def isEmpty():Boolean = {
		len == 0
	}
	
	override def toString():String = {
		var ctr = begin
		var retval = "(" + size.toString + ") ["
		for(i <- 0 until len) {
			retval += arr((begin + i) % arr.length)
			if(i < len-1) retval += ","
		}
		retval + "]"
	}
  
}