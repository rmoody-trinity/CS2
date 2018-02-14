package cs2.particles

import cs2.util.Vec2
import scalafx.scene.image.Image

class ImageParticleSystem(origin:Vec2, private val img:Image) extends ParticleSystem(origin){
  override def addParticle() {
    parts ::= new ImageParticle(orig.clone, img)
  }
}