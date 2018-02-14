package cs2.particles

import scalafx.scene.paint.Color

trait ColorRotation {
  private var hue:Double = 0
  
  def stepColor():Color = {
    hue += 2
    if(hue > 360) hue -= 360
    Color.hsb(hue, 1, 1)
  }
}