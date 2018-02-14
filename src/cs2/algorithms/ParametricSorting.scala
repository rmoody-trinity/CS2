package cs2.algorithms

import scala.util.Random

object ParametricSorting extends App{
  /**
	 * Original bubbleSort that only works on Doubles, similar to what we did
	 * last semester
	 */
	def bubbleSort(a:Array[Double]) {
		for(i <- 0 until a.length-1) {
			for(j <- 0 until a.length-i-1) {
				if(a(j+1) < a(j)) {
					val tmp = a(j+1)
					a(j+1) = a(j)
					a(j) = tmp
				}
			}
		}
	}

	/**
	 * A new version of bubbleSort that works on any type, but also requires a 
	 * second curried argument to specify the "less than" function used during 
	 * the sorting process
	 */
	def bubbleSortCurried[A] (a:Array[A])(lt:(A,A)=>Boolean) {
		for(i <- 0 until a.length-1) {
			for(j <- 0 until a.length-i-1) {
				if( lt(a(j+1),a(j)) ) {
					val tmp = a(j+1)
					a(j+1) = a(j)
					a(j) = tmp
				}
			}
		}
	}

	/**
	 * A new version of bubbleSort (with a different name to avoid name 
	 * collisions) that is parametric, but restricts the possible types that 
	 * can be sorted to those that extend or inherit from the Ordered[A] trait.
	 * 
	 * Technically, restrictions can be placed on types with the "<:" symbol or 
	 * operator. However, you'll often use the "<%" symbol instead in order to
	 * include implicit conversions as well as direct inheritance. For example,
	 * this is required in order to use types like Double, Int, or Float in the
	 * example below.
	 * 
	 * By ensuring that the type A extends the trait Ordered[A], this allows us 
	 * to know that the compare() method is defined, and consequently, the 
	 * <,>,<=,>=,==, and != operators also exist for the type A.
	 */
	def bubbleSortParametric[A <% Ordered[A]] (a:Array[A]) {
		for(i <- 0 until a.length-1) {
			for(j <- 0 until a.length-i-1) {
				if(a(j).compare(a(j+1)) > 0) {
					val tmp = a(j+1)
					a(j+1) = a(j)
					a(j) = tmp
				}
			}
		}
	}

	/**
	 * A simple class to demonstrate that the curried version of sorting 
	 * can be flexible when used with more complicated types, such as our own 
	 * classes.
	 */
	class Student (var name:String, var gpa:Double) extends Ordered[Student] {
		override def toString():String = name + ":" + gpa.toString
    def compare(other:Student):Int = {
      name.compare(other.name)
    }
	}
	
	/**
	 * A main method that calls our three sorting versions.
	 */
	override def main (args:Array[String]) {
		val a:Array[Double] = Array.fill(10)(Random.nextDouble)
		bubbleSort(a)
		println("Array[Double] sorted: " + a.mkString(","))
	
		val c = Array(new Student("Alice",3.0), new Student("Dan",3.2),
				      new Student("Cindy",2.5), new Student("Bob",3.5))
		bubbleSortCurried(c)( (x:Student,y:Student) => x.name < y.name )
		println("Array[Student] sorted by name: " + c.mkString(","))
		bubbleSortCurried(c)( (x:Student,y:Student) => x.gpa < y.gpa )
		println("Array[Student] sorted by gpa:  " + c.mkString(","))
		bubbleSortParametric(c)
        println("Array[Student] sorted by name: " + c.mkString(","))
	
		val b:Array[Char] = Array.fill(20)(Random.nextPrintableChar)
		bubbleSortParametric(b)
		println("Array[Char] sorted: " + b.mkString(" "))
	}
	
}