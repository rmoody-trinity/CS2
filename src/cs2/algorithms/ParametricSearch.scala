package cs2.algorithms

object ParametricSearch {
    def getMin[A <% Ordered[A]](arr:Array[A]):A = {
      arr.min
  }
  
  def getMax[A <% Ordered[A]](arr:Array[A]):A = {
    arr.max
  }
  
  def containsDuplicates[A <% Ordered[A]](arr:Array[A]):Boolean = {
    arr.distinct.size != arr.size
  }
  
  def containsDuplicates[A](arr:Array[A], lt:(A,A)=>Boolean):Boolean = {
    arr.distinct.size != arr.size
  }
  
  /* The following code does not need to be changed by you -- it is *similar* (but
   * not the same) as the code that I will be using to test your implementations.
   * As such, you are welcome to modify the following sections, but it should not
   * be required for your submission.  It's OK to leave this code in place, or 
   * to delete it in your submission.
   */
  
  class OrderedStudent (var name:String, var gpa:Double) extends Ordered[OrderedStudent] {
    override def toString():String = name + ":" + gpa.toString
    def compare(other:OrderedStudent):Int = {
      name.compare(other.name)
    }
  }
  
  class Student (var name:String, var gpa:Double) {
    override def toString():String = name + ":" + gpa.toString
  }
  
  def main (args:Array[String]) {    
    val orderStudents = Array( new OrderedStudent("Alice", 4.0), new OrderedStudent("Bob", 3.5),
                               new OrderedStudent("Cynthia", 3.0), new OrderedStudent("Alice", 3.2),
                               new OrderedStudent("Evan", 3.8), new OrderedStudent("Frances", 3.9) )
    println("OrderStudents: " + orderStudents.mkString("; "))
    
    val students = Array( new Student("Alice", 4.0), new Student("Bob", 3.5),
                          new Student("Cynthia", 3.0), new Student("Daniel", 4.0),
                          new Student("Evan", 3.8), new Student("Frances", 3.9) )
    println("Students: " + students.mkString("; "))
    
    val numsWithDupes = Array(1,2,3,4,5,6,10,2,7,1)
    println("numsWithDupes: " + numsWithDupes.mkString("; "))
    
    val numsWithNoDupes = Array(10,2,4,3,6,8,7,1,5,9)
    println("numsWithNoDupes: " + numsWithNoDupes.mkString("; "))
    
    println("min OrderStudents: " + getMin(orderStudents))
    println("max OrderStudents: " + getMax(orderStudents))
    
    println("dupe names in OrderStudents: " + containsDuplicates(orderStudents))
    println("dupe gpas in OrderStudents: " + containsDuplicates(orderStudents, (x:OrderedStudent,y:OrderedStudent) => x.gpa < y.gpa))
    
    println("dupe names in students: " + containsDuplicates(students, (x:Student,y:Student) => x.name < y.name))
    println("dupe gpas in students: " + containsDuplicates(students, (x:Student,y:Student) => x.gpa < y.gpa))
    
    println("min of dupeNums: " + getMin(numsWithDupes))
    println("max of dupeNums: " + getMax(numsWithDupes))
    println("dupe in dupeNums: " + containsDuplicates(numsWithDupes))
    
    println("min of noDupeNums: " + getMin(numsWithNoDupes))
    println("max of noDupeNums: " + getMax(numsWithNoDupes))
    println("dupe in noDupeNums: " + containsDuplicates(numsWithNoDupes))
  }
  
}
