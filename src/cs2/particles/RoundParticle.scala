package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class RoundParticle(initPos:Vec2) extends Particle(initPos) {
    override def display(g:GraphicsContext) {
      g.setStroke(col)
      g.strokeOval(pos.x, pos.y, 20,20)
    }
}