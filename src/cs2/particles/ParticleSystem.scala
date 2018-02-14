package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem (protected var orig:Vec2) {
  protected var parts:List[Particle] = Nil
  
  def addParticle() {
    parts ::= new RainbowParticle(new Vec2(orig))
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
    parts.foreach(x => x.timeStep)
  }
  def applyForce(acc:Vec2) {
    parts.foreach(x => x.applyForce(acc))
  }
  
}