package cs2.util

class Angle(private var rad: Double) {
 
  fixUpAngle
  
 def fixUpAngle() {
   while(rad > 2*math.Pi) rad -= 2*math.Pi
   while(rad < 0) rad += 2*math.Pi
 }

 override def toString():String = radians.toString 
  
 def + (other:Angle):Angle = {
   new Angle(this.rad + other.rad)
 }
 def + (other:Double):Angle = {
   new Angle(this.rad + other)
 }
 def += (other:Angle):Unit = {
   this.rad += other.rad
 }
 
 def - (other:Angle):Angle = {
   new Angle(this.rad - other.rad)
 }
 def unary_-():Angle = {
   new Angle(this.rad.unary_-)
 }
 
 def * (amt:Double):Angle = {
   new Angle(this.rad * amt)
 }
 
 def radians = rad
 def radians_=(amt:Double) = {
    rad = amt
    fixUpAngle
 }
}

object AngleTester {
  def main(args:Array[String]) {
    var a = new Angle(-5*math.Pi/2)
    println("a = " + a.radians)
    a.radians = 3*math.Pi
    println(a)
  }
}
