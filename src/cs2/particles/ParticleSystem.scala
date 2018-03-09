package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scala.collection.mutable

class ParticleSystem (protected var orig:Vec2) {
  protected var parts = scala.collection.mutable.Buffer[Particle]()
  
  def addParticle() {
    parts += new RainbowParticle(new Vec2(orig))
    /*if(math.random < 0.5){
      parts ::= new RoundParticle(new Vec2(orig))
    }
    else{
      parts ::= new SquareParticle(new Vec2(orig))
    }*/  
  }
  
  def display(g:GraphicsContext) {
    parts.foreach(x => x.display(g))
  }
  
  def timeStep() {
    var i = 0
    while(i < parts.length) {
      if(parts(i).timeStep()) {
        parts.remove(i)
      } else {
        i += 1
      }
    }
  }
  def applyForce(acc:Vec2) {
    parts.foreach(x => x.applyForce(acc))
  }
  
}