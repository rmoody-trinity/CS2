package cs2.particles

import cs2.util.Vec2
import scalafx.scene.image.Image
import scalafx.scene.canvas.GraphicsContext

class ImageParticle(initPos:Vec2, private val img:Image) extends Particle(initPos) {
  
  def display(g:GraphicsContext) {
    g.globalAlpha = 0.2
    g.drawImage(img, pos.x,pos.y)
    g.globalAlpha = 1.0
  }
  
}