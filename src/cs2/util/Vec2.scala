package cs2.util

class Vec2 (var x:Double, var y:Double) {
	//Default constructor creates a Vec2 of zeroes
	def this() = this(0,0)
	
	def this(toCopy:Vec2) = this(toCopy.x, toCopy.y)
	override def clone():Vec2 = new Vec2(x,y)
	 
	//Provided toString method simplifies printing, e.g. println(vec.toString) OR println(vec)
	override def toString():String = "("+x+","+y+")"

	//Methods for addition and subtraction of vectors
	def + (other:Vec2):Vec2 = { new Vec2(x + other.x, y + other.y) }
	def - (other:Vec2):Vec2 = { new Vec2(x - other.x, y - other.y) }
	
	def += (other:Vec2) { this.x += other.x; this.y += other.y }
	def -= (other:Vec2) { this.x -= other.x; this.y -= other.y }

	//Methods for multiplication and division of vectors by a scalar (non-vector)
	def * (scalar:Double):Vec2 = { new Vec2(x * scalar, y * scalar) }
	def / (scalar:Double):Vec2 = { new Vec2(x / scalar, y / scalar) }
	
	def *= (scalar:Double) { this.x *= scalar; this.y *= scalar }
	def /= (scalar:Double) { this.x /= scalar; this.y /= scalar }

	//Methods to determine the length of a vector (magnitude and length should return the same value)
	def magnitude():Double = { math.sqrt(x*x + y*y) }
	def length():Double = { magnitude }

	//Method to return a new vector that is in the same direction, but length 1
	def normalize():Vec2 = { this / magnitude }
	def unary_~():Vec2 = { normalize }

	//Methods to calculate the dot product, and determine the angle between 2 vectors
	def dot(other:Vec2):Double = { x * other.x + y * other.y }
	def **(other:Vec2):Double = this.dot(other)
	
	def angleBetween(other:Vec2):Double = { math.acos(dot(other) / (magnitude * other.magnitude)) }
	def <>(other:Vec2):Double = this.angleBetween(other)
}

object Vec2Tester {
  def main(args:Array[String]):Unit = {
    val v1 = new Vec2(1, 2)
    val v2 = new Vec2(2, 2)
    val v3 = (v1 + v2)
    val v4 = v3 * 3
    println(v3.magnitude + " " + v4.magnitude)
  }
  def apply(x:Double, y:Double) = new Vec2(x, y)
}

