package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color

class RainbowParticle(initPos:Vec2) 
          extends RoundParticle(initPos) 
          with ColorRotation {
  
  override def timeStep() {
    super.timeStep
    col = stepColor
  }
    
}