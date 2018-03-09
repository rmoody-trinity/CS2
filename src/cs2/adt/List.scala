package cs2.adt

trait List[A] {
  def get(idx:Int):A
  def set(idx:Int,elem:A)
  def insert(idx:Int,elem:A)
  def remove(idx:Int):A
  
  def length():Int
  
  def prepend(elem:A) {
    insert(0,elem)
  }
  def append(elem:A) {
    insert(length, elem)
  }
  
}